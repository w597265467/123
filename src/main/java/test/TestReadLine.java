package test;

import sun.rmi.runtime.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestReadLine {

	public static void main(String[] arg) {
		try {
			InputStream is = new FileInputStream("D:\\project\\123\\src\\main\\resources\\iot-cloud.html");
			Reader reader = new InputStreamReader(is);
			BufferedReader strReader = new BufferedReader(reader);
			File file = new File("D:\\project\\123\\src\\main\\resources\\iot-cloud"
					+System.currentTimeMillis()+".txt");
			file.createNewFile();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			while (true) {
				String data;
				if ((data = strReader.readLine()) == null) break;
				if (data.contains("<h3>")){
					bufferedWriter.write(data.replace("<h3>","").replace("<h3/>",""));
					bufferedWriter.write("\n");
				}
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
