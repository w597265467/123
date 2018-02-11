package file.log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CountLog {
	public static void main(String[] arg) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("g:/countFile.txt"));
		Set<String> set = new HashSet<>();
		String line = null;
		while ((line = reader.readLine())!=null){
			set.add(line.substring(line.lastIndexOf(":"),line.length()).replace("\"",""));
		}
		for (String s : set) {
			System.out.println(s);
		}
		System.out.println(set.size());
	}
}
