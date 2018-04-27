package file;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtils {
	public static void main(String[] args) {
		for (String s : userPhones()) {
			System.out.println(s);
		}

	}
	public static List<String> userPhones() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://rm-2ze8cs14z57x7jtoto.mysql.rds.aliyuncs.com:3306/jft_cfin?characterEncoding=utf-8",
						"jft_cfin",
						"4B6WlaYaPbW3eeHS");
				String sql = "SELECT * from `user` WHERE fin_id LIKE \"3%\"";
				PreparedStatement pstm = connection.prepareStatement(sql);
				ResultSet resultSet = pstm.executeQuery();
				List<String> list = new ArrayList<>();
				while (resultSet.next()){
					String phone = resultSet.getString("phone");
					String name = resultSet.getString("name");
					list.add(phone);
				}
				return list;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
}
