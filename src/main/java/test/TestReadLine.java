package test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestReadLine {

	public static void main(String[] arg) {
		try {
			InputStream is = new FileInputStream("/Users/wangluyao/jf/123/src/main/resources/5.txt");
			Reader reader = new InputStreamReader(is);
			BufferedReader strReader = new BufferedReader(reader);
			Set<String> set = new HashSet<>();
			while (true) {
				String data;
				if ((data = strReader.readLine()) == null) break;
				set.add(data);
			}
			for (String s : set) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
