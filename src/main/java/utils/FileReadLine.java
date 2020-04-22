package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadLine {
    public static List<String> readLine(String fileName) throws IOException {
        InputStream is = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(is);
        BufferedReader strReader = new BufferedReader(reader);
        ArrayList<String> strings = new ArrayList<>();
        while (true) {
            String data;
            if ((data = strReader.readLine()) == null) break;
            strings.add(data);
        }
        return strings;
    }
    public static String readString(String fileName) throws IOException {
        InputStream is = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(is);
        BufferedReader strReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String data;
            if ((data = strReader.readLine()) == null) break;
            sb.append(data);
        }
        return sb.toString();
    }
}
