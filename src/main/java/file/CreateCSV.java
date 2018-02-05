package file;

import com.mysql.jdbc.SQLError;
import org.apache.poi.hssf.record.pivottable.StreamIDRecord;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateCSV {
    public static void main(String[] arg) throws IOException {
//        String filePath = "C:\\Users\\Administrator\\Desktop\\dxt_order_refund_"+DateUtil.getNowTime()+".csv";
//        String filePath = "C:\\Users\\Administrator\\Desktop\\dxt_order_buyer_confirm"+DateUtil.getNowTime()+".csv";
        String filePath = "C:\\Users\\Administrator\\Desktop\\已处理完成的订单.csv";
        OutputStream os = new FileOutputStream(filePath);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        String orderId = null;
        String tmallOrderId = null;
        String desc = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.2.7:3306/finance?characterEncoding=utf-8",
                    "jft",
                    "3edcvBHU8");
            String sql = "SELECT\n" +
                    "\ttmall_order_id,\n" +
                    "\torder_id,\n" +
                    "\tprocessing_result_desc\n" +
                    "FROM\n" +
                    "\tcredit_order\n" +
                    "WHERE\n" +
                    "\ttmall_order_id IS NOT NULL\n" +
                    "AND tmall_order_id != \"\"\n" +
                    "AND processing_result_status IN (\n" +
                    "\t\"30\",\n" +
                    "\t\"31\",\n" +
                    "\t\"201\",\n" +
                    "\t\"20\",\n" +
                    "\t\"200\",\n" +
                    "\t\"29\"\n" +
                    ")\n" +
                    "ORDER BY\n" +
                    "\tcreate_time DESC;";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                tmallOrderId = resultSet.getString(1);
                orderId = resultSet.getString(2);
                desc = resultSet.getString(3);
                String line = tmallOrderId +"," +orderId+ "," +desc;
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.close();
    }
}
