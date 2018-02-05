package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestReadLine {

    public static void main(String[] arg) throws IOException {
        List<String> orderFailCause = getOrderFailCause("6229912017122617114580274239");
        for (String s : orderFailCause) {
            System.out.println(s);
        }
    }
    private static List<String> getOrderFailCause(String orderId) {
        try {
            InputStream is = new FileInputStream("E:\\aliyun\\logs\\consumer-finance-7308_2017-12-26.log");
            Reader reader = new InputStreamReader(is);
            BufferedReader strReader = new BufferedReader(reader);
            List<String> list = new ArrayList<>();
            while (true){
                String data;
                if ((data = strReader.readLine())==null) break;
                if ((data.contains("fail")||data.contains("失败")||data.contains("不是"))&&data.contains(orderId)){
                    list.add(data);
                }
            }
            return list;
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return null;
    }

}
