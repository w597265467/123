package test;

import org.apache.poi.ss.formula.functions.T;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class TestEncode {
    public static void main(String[] arg) throws UnsupportedEncodingException {
//        TestEncode testEncode = new TestEncode();
//        for (int i = 0; i < 10000; i++) {
//            String s = UUID.randomUUID().toString()+"啊";
//            byte[] bytes = s.getBytes();
//            String s2 = new String(bytes, "ascii");
//            System.out.println("src:"+s2);
//            String s1 = testEncode.AsciiToChineseString(s2, "utf-8");
//            System.out.println("dest:"+s1);
////            String encoding = getEncoding(s1);
////            System.out.println(encoding);
//            if (!s2.equals(s1)){
//                throw new RuntimeException("什么情况");
//            }
//        }
//        Properties properties = System.getProperties();
//        Set<Object> objects = properties.keySet();
//        for (Object object : objects) {
//            System.out.println("key:"+object.toString()+",\t\t\tvalue:"+properties.get(object));
//        }
//        System.out.println(getEncoding("啊"));
        System.out.println("啊");
    }


    public String AsciiToChineseString(String s, String encoding) {
        if (s == null)
            return null;
        char[] orig = s.toCharArray();
        byte[] dest = new byte[orig.length];
        for (int i = 0; i < orig.length; i++)
            dest[i] = (byte) (orig[i] & 0xFF);
        try {
            Charset charSet = Charset.forName(encoding);
            ByteBuffer byteBuffer = ByteBuffer.allocate(dest.length);
            byteBuffer.put(dest);
            byteBuffer.flip();
            CharBuffer charBuffer = charSet.decode(byteBuffer);
            return charBuffer.toString();
        } catch (Exception e) {
            return s;
        }
    }
    public static String getEncoding(String str) {
        String encode = "GB2312";
//        try {
//            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GB2312
//                return encode;      //是的话，返回“GB2312“，以下代码同理
//            }
//        } catch (Exception exception) {
//        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是ISO-8859-1
                return encode;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {   //判断是不是UTF-8
                return encode;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GBK
                return encode;
            }
        } catch (Exception exception3) {
        }
        return "未知";        //如果都不是，说明输入的内容不属于常见的编码格式。
    }
}
