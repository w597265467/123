package test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;

public class TestRandom {
    public static void main(String[] arg) throws Exception {
        long time = 0;
        String filePath = "C:\\Users\\Administrator\\Desktop\\time.txt";
        OutputStream os = new FileOutputStream(filePath);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        double reTime = 1000000;
        for (int i = 0; i < reTime; i++) {
            int times = getTimes();
            time += times;
            writer.write(String.valueOf(times));
            writer.newLine();
        }
        System.out.println(time/reTime);
        writer.flush();
        writer.close();

    }
    private static Set<String> set = new HashSet<String>();
    private static int getTimes(){
        set.clear();
        int i = 0;
        for (; i < 10000; i++) {
            String rondom = getRondom();
            boolean add = set.add(rondom);
            if (!add) {
                //System.out.println(rondom);
                break;
            }
        }
        //System.out.println(i);
        return i;
    }

    public static String getRondom(){
        String randomNum = null;
        int i = (int) (Math.random()*100000);
        randomNum = String.valueOf(i);
        while (randomNum.length()<5){
            randomNum = "0" + randomNum;
        }
        return randomNum;
    }
}
