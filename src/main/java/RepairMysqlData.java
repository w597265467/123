import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class RepairMysqlData {

    private static Map<Strategy, Set<Integer>> strategyEbIdMap = new HashMap<>();
    private static Map<Strategy, Set<Integer>> strategyOutIdMap = new HashMap<>();
    private static int startStrategyId = 0;
    private static int startStrategyOutId = 0;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        String s = RepairMysqlData.class.getClassLoader().getResource("").toURI().getPath() + "jdbc.properties";
        InputStream inputStream = new FileInputStream(s);
        Properties prop = new Properties();
        prop.load(inputStream);
        Class.forName(prop.getProperty("driver"));
        Connection connection = DriverManager.getConnection(prop.getProperty("url"),
                prop.getProperty("username"),
                prop.getProperty("password"));
        StringBuilder sql = new StringBuilder("SELECT\n\teb_id,\n\tstrategy_id,\n\tout_id,\n\ttype,\n\tstart_date,\n\tend_date,\n\tstart_time,\n\tend_time,\n\t`week`\nFROM\n\tiot_electric_box_switch_strategy_out_rel out_rel\nLEFT JOIN iot_electric_box_line_out line_out ON out_rel.out_id = line_out.id\nLEFT JOIN iot_electric_box_switch_strategy bss ON out_rel.strategy_id = bss.id\nWHERE\n\tout_rel.`status` != 9\nAND bss.`status` != 9\nAND line_out.`status` != 9");
        PreparedStatement pstm = connection.prepareStatement(sql.toString());
        ResultSet resultSet = pstm.executeQuery();
        Map<Strategy, List<EbStrategyRel>> strategyListMap = new HashMap<>();
        Map<StrategyType, Integer> ebIdSiteMap = new HashMap<>();
        while (resultSet.next()) {
            Integer eb_id = resultSet.getInt(1);
            Integer strategy_id = resultSet.getInt(2);
            Integer out_id = resultSet.getInt(3);
            Integer type = resultSet.getInt(4);
            Date start_date = resultSet.getTimestamp(5);
            Date end_date = resultSet.getTimestamp(6);
            Date start_time = resultSet.getTimestamp(7);
            Date end_time = resultSet.getTimestamp(8);
            String week = resultSet.getString(9);
            Strategy strategy = new Strategy(type, start_date, end_date, start_time, end_time, week);
            MapPutIfNullCreate(strategyListMap, eb_id, strategy_id, out_id, strategy);
        }
        sql = new StringBuilder("select max(id) from iot_electric_box_switch_strategy_out_rel");
        pstm = connection.prepareStatement(sql.toString());
        ResultSet executeQuery = pstm.executeQuery();
        executeQuery.next();
        startStrategyOutId = executeQuery.getInt(1) + 1;
        System.out.println(startStrategyId);
        int status = 9;
        sql = new StringBuilder("update iot_electric_box_switch_strategy set `status` = ? ; \n");
        pstm = connection.prepareStatement(sql.toString());
        pstm.setInt(1, status);
        pstm.execute();
        System.out.println(pstm.toString());
        sql = new StringBuilder("update iot_electric_box_switch_strategy_out_rel set `status` = ? ; \n");
        pstm = connection.prepareStatement(sql.toString());
        pstm.setInt(1, status);
        pstm.execute();
        System.out.println(pstm.toString());
        sql = new StringBuilder("update iot_electric_box_switch_strategy_rel set `status` = ? ; ");
        pstm = connection.prepareStatement(sql.toString());
        pstm.setInt(1, status);
        pstm.execute();
        System.out.println(pstm.toString());
        Set<Strategy> strategies = strategyListMap.keySet();
        int i = 1;
        for (Strategy strategy : strategies) {
            System.out.println(strategy);
            System.out.println(strategyListMap.get(strategy));
            sql = new StringBuilder("INSERT INTO `iot_electric_box_switch_strategy` VALUES (?,?,?,?,?,?,?,?,?,?,?);");
            pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, startStrategyId);
            pstm.setString(2, "合并策略" + startStrategyId);
            pstm.setInt(3, strategy.type);
            pstm.setDate(4, strategy.start_date == null ? null : new java.sql.Date(strategy.start_date.getTime()));
            pstm.setDate(5, strategy.end_date == null ? null : new java.sql.Date(strategy.end_date.getTime()));
            pstm.setString(6, strategy.week);
            pstm.setTimestamp(7, strategy.start_time == null ? null : new Timestamp(strategy.start_time.getTime()));
            pstm.setTimestamp(8, strategy.end_time == null ? null : new Timestamp(strategy.end_time.getTime()));
            pstm.setInt(9, 1);
            pstm.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
            pstm.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
            System.out.println(pstm.toString());
            pstm.execute();
            sql = new StringBuilder("INSERT INTO `iot_electric_box_switch_strategy_out_rel` VALUES ");
            int k = 0;
            Set<Integer> outIds = strategyOutIdMap.get(strategy);
            for (Integer integer : outIds) {
                if (k++ == 0){
                    sql.append("(")
                            .append(startStrategyOutId++)
                            .append(", ")
                            .append(integer)
                            .append(", ")
                            .append(startStrategyId)
                            .append(", ")
                            .append(1)
                            .append(", '")
                            .append(new Timestamp(System.currentTimeMillis()))
                            .append("', '").append(new Timestamp(System.currentTimeMillis())).append("')");
                }else {
                    sql.append(",(").append(startStrategyOutId++).append(", ").append(integer).append(", ").
                            append(startStrategyId).append(", ").append(1).append(", '").
                            append(new Timestamp(System.currentTimeMillis())).append("', '").
                            append(new Timestamp(System.currentTimeMillis())).append("')");
                }
            }
            pstm = connection.prepareStatement(sql.toString());
            System.out.println(pstm.toString());
            pstm.execute();
            Set<Integer> ebIds = strategyEbIdMap.get(strategy);
            for (Integer integer : ebIds) {
                sql = new StringBuilder("INSERT INTO `iot_electric_box_switch_strategy_rel` VALUES (?, ?, ?, ?, ?, ?, ?);");
                pstm = connection.prepareStatement(sql.toString());
                StrategyType strategyType = new StrategyType(integer, strategy.type);
                Integer site = ebIdSiteMap.get(strategyType);
                if (site == null) {
                    site = 1;
                }
                pstm.setInt(1, i);
                pstm.setInt(2, integer);
                pstm.setInt(3, startStrategyId);
                pstm.setInt(4, site++);
                pstm.setInt(5, 1);
                pstm.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                pstm.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                System.out.println(pstm.toString());
                pstm.execute();
                ebIdSiteMap.put(strategyType, site);
                sql = new StringBuilder("INSERT INTO `iot_electric_box_strategy_publish_rel` VALUES (?, ?, ?, ?, ?, ?);");
                pstm = connection.prepareStatement(sql.toString());
                pstm.setInt(1, i++);
                pstm.setInt(2, startStrategyId);
                pstm.setInt(3, integer);
                pstm.setInt(4, 100);
                pstm.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                pstm.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                System.out.println(pstm.toString());
                pstm.execute();
            }
            startStrategyId++;
        }


//        sql = "INSERT INTO iot_electric_box_strategy_publish_rel (\n" +
//                "\tstrategy_id,\n" +
//                "\tbox_id,\n" +
//                "\tpublish_status\n" +
//                ")\n" +
//                "VALUES\n";
//        int i = 0;
//        for (EbStrategyRel ebStrategyRel : ebStrategyRels) {
//            if (i == 0) {
//                sql += ebStrategyRel.toString();
//            } else {
//                sql += "," + ebStrategyRel.toString();
//            }
//            i++;
//        }
//        System.out.println(sql);
//        pstm = connection.prepareStatement(sql);
//        pstm.execute();
        System.out.println(pstm.toString());
//
//        Map<EbStrategyRel, Integer> map = new HashMap<>();
//        for (EbStrategyRel ebStrategyRel : ebStrategyRels) {
//            Integer site = map.get(ebStrategyRel);
//            if (site == null) {
//                site = 0;
//            }
//            sql = "INSERT INTO iot_electric_box_switch_strategy_rel (eb_id, strategy_id, site)\n" +
//                    "VALUES\n" +
//                    "\t(" + ebStrategyRel.eb_id + ", " + ebStrategyRel.strategy_id + ", " + ++site + ")";
//            System.out.println(sql);
//            pstm = connection.prepareStatement(sql);
//            pstm.execute();
        System.out.println(pstm.toString());
//            map.put(ebStrategyRel, site);
//        }


    }


    private static void MapPutIfNullCreate(Map<Strategy, List<EbStrategyRel>> strategyListMap, Integer eb_id, Integer strategy_id, Integer out_id, Strategy strategy) {
        List<EbStrategyRel> ebStrategyRels = strategyListMap.get(strategy);
        if (ebStrategyRels == null) {
            ebStrategyRels = new ArrayList<>();
        }
        EbStrategyRel ebStrategyRel = new EbStrategyRel(strategy_id, eb_id, out_id);
        ebStrategyRels.add(ebStrategyRel);
        strategyListMap.put(strategy, ebStrategyRels);
        if (strategy_id >= startStrategyId) {
            startStrategyId = strategy_id + 1;
        }
        mapPutDate(eb_id, strategy, strategyEbIdMap);
        mapPutDate(out_id, strategy, strategyOutIdMap);


    }
    private static void mapPutDate(Integer data, Strategy strategy, Map<Strategy, Set<Integer>> map) {
        Set<Integer> integers = map.get(strategy);
        if (integers == null) {
            integers = new TreeSet<>();
        }
        integers.add(data);
        map.put(strategy, integers);
    }
    private static class StrategyType {
        Integer eb_id;
        Integer type;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StrategyType)) return false;
            StrategyType that = (StrategyType) o;
            return
                    Objects.equals(eb_id, that.eb_id) &&
                    Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash( eb_id, type);
        }

        public StrategyType(Integer eb_id, Integer type) {
            this.eb_id = eb_id;
            this.type = type;
        }
    }
    private static class Strategy {
        Integer type;
        Date start_date;
        Date end_date;
        Date start_time;
        Date end_time;
        String week;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Strategy)) return false;
            Strategy strategy = (Strategy) o;
            return Objects.equals(type, strategy.type) &&
                    Objects.equals(start_date, strategy.start_date) &&
                    Objects.equals(end_date, strategy.end_date) &&
                    Objects.equals(start_time, strategy.start_time) &&
                    Objects.equals(end_time, strategy.end_time) &&
                    Objects.equals(week, strategy.week);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, start_date, end_date, start_time, end_time, week);
        }

        public Strategy(Integer type, Date start_date, Date end_date, Date start_time, Date end_time, String week) {
            this.type = type;
            this.start_date = start_date;
            this.end_date = end_date;
            this.start_time = start_time;
            this.end_time = end_time;
            this.week = week;
        }

        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            return "Strategy{type=" + type +
                    ", start_date=" + getFormat(sdf, start_date) +
                    ", end_date=" + getFormat(sdf, end_date) +
                    ", start_time=" + getFormat(sdf, start_time) +
                    ", end_time=" + getFormat(sdf, end_time) +
                    ", week='" + week + '\'' +
                    '}';
        }

        private String getFormat(SimpleDateFormat sdf, Date date) {
            if (date == null) {
                return null;
            }
            return sdf.format(date);
        }
    }

    private static class EbStrategyRel {
        Integer strategy_id;
        Integer eb_id;
        Integer out_id;

        public EbStrategyRel(Integer strategy_id, Integer eb_id, Integer out_id) {
            this.strategy_id = strategy_id;
            this.eb_id = eb_id;
            this.out_id = out_id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof EbStrategyRel)) return false;
            EbStrategyRel that = (EbStrategyRel) o;
            return
                    Objects.equals(eb_id, that.eb_id) &&
                            Objects.equals(out_id, that.out_id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(eb_id, out_id);
        }

        @Override
        public String toString() {
            return "\t(" + strategy_id + ", " + eb_id + "," + out_id + ")";
        }
    }
}
