package test;

import java.io.*;
import java.sql.*;

public class TestReadLine2 {

	public static void main(String[] arg) {
		try {
			InputStream is = new FileInputStream("D:\\project\\123\\src\\main\\resources\\iot-cloud1586848344191.txt");
			Reader reader = new InputStreamReader(is);
			BufferedReader strReader = new BufferedReader(reader);
			int i = 1;
			while (true) {
				String data;
				if ((data = strReader.readLine()) == null) break;
				String[] s = data.split(" ");
				alterTableComment(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	private static void alterTableComment(String[] s) {
		try {
			String sql = "ALTER TABLE "+s[1]+" COMMENT '"+s[0]+"'; ";
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
