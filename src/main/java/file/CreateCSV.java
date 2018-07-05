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
import java.util.Date;

public class CreateCSV {
    public static void main(String[] arg) throws IOException {
//        String filePath = "C:\\Users\\Administrator\\Desktop\\dxt_order_refund_"+DateUtil.getNowTime()+".csv";
//        String filePath = "C:\\Users\\Administrator\\Desktop\\dxt_order_buyer_confirm"+DateUtil.getNowTime()+".csv";
//        String filePath = "C:\\Users\\Administrator\\Desktop\\已处理完成的订单.csv";
//        OutputStream os = new FileOutputStream(filePath);
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
//        String orderId = null;
//        String tmallOrderId = null;
//        String desc = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xygj_mall?characterEncoding=utf-8",
                    "root",
                    "123123123");
            String sql = "select * from credit_order_gift_history";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String orderId = resultSet.getString(2);
                Date desc = resultSet.getDate(3);
//                String line = tmallOrderId +"," +orderId+ "," +desc;
//                writer.write(line);
//                writer.newLine();
                System.out.println(id+orderId+desc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        writer.close();
    }
}
