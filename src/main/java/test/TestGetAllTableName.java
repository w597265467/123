package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestGetAllTableName {
	public static void main(String[] arg)  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql?characterEncoding=utf-8",
					"root",
					"123");
			String sql = "SELECT\n" +
					"\tTABLE_NAME\n" +
					"FROM\n" +
					"\tinformation_schema. TABLES\n" +
					"WHERE\n" +
					"\tTABLE_SCHEMA = \"mysql\"";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()){
				String string = resultSet.getString(1);
				string = "<table tableName=\""+string+"\"/>";
				System.out.println(string);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
