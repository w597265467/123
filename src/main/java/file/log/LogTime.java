package file.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class LogTime {
	public static String[] parseString(String str) {
		if (str.indexOf(" ") > 0) {
			str = str.split(" ")[0];
		}
		if (str.indexOf(":") > 0) {
			return str.split(":");
		}
		return null;
	}

	public static void parseString(String[] str) {
		for (String s : str) {
			System.out.print(s + ":");
		}
		System.out.println();
	}

	public static void main(String[] arg) {
		File dir = new File("C:\\Users\\Administrator\\Desktop\\logs\\backup");
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files == null) {
				System.out.println("文件不存在");
				return;
			}
			for (File file : files) {
				System.out.println(file.getName());
			}
			List<String> list = new ArrayList<>(files.length);
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				try {
					InputStream is = new FileInputStream(file);
					Reader r = new InputStreamReader(is);
					BufferedReader reader = new BufferedReader(r);
					String line = null;
					HashMap<Integer, Integer> map = new HashMap();
					int size = 0;
					int outSize = 0;
					while ((line = reader.readLine()) != null) {
						list.add(line);
						System.out.println(list.size() > 2 && i > 1);
						if (list.size() > 2 && i > 1) {
							String s = list.get(i - 1);
							String s2 = list.get(i);
							String[] before = parseString(s);
							String[] after = parseString(s2);
							parseString(before);
							parseString(after);
							assert after != null;
							assert before != null;
							if (Integer.valueOf(after[0]) - Integer.valueOf(before[0]) > 1
									|| Integer.valueOf(after[1]) - Integer.valueOf(before[1]) > 1) {
								size = list.size();
								outSize = size + 20;
								map.put(size, outSize);
							}
							if (map.size() != 0) {
								Set<Integer> integers = map.keySet();
								for (Integer integer : integers) {
									size = integer;
									outSize = map.get(integer);
									if (list.size() == outSize) {
										FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\errorlog\\" + file.getName(), true);
										Writer w = new OutputStreamWriter(fileOutputStream);
										BufferedWriter writer = new BufferedWriter(w);
										for (int j = 20; j > 0; j--) {
											int size1 = list.size();
											writer.write(list.get(size1 - j));
											writer.newLine();
										}
										writer.close();
										w.close();
										fileOutputStream.close();
										map.remove(size);
									}
								}
							}
						}else {
							continue;
						}
					}
					reader.close();
					r.close();
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
}
