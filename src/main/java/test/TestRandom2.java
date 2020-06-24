package test;

import org.apache.poi.ss.formula.functions.Roman;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestRandom2 {
    public static void main(String[] arg) throws Exception {
        Random r = new Random();
        for (int i = 0; i < 16; i++) {
            boolean j = r.nextBoolean();
            if (j){
                System.out.println(3);
            }else {
                System.out.println(2);
            }
        }
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
