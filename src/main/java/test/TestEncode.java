package test;

import org.apache.poi.ss.formula.functions.T;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestEncode {
    public static void main(String[] arg) throws UnsupportedEncodingException {

        String a = "黄山市菱同旅游电子商务有限责任公司";

        System.out.println(new String(a.getBytes("gbk"),"utf-8"));

        String b = "榛勫北甯傝彵鍚屾梾娓哥數瀛愬晢鍔℃湁闄愯矗浠诲叕鍙�";

        System.out.println(new String(b.getBytes("gbk"),"utf-8"));



        //https://112.26.198.149:1000/pmobilenew/samples/Pay/PayCenter/index.html?Page=Pay&merName=%BB%C6%C9%BD%CA%D0%C1%E2%CD%AC%C2%C3%D3%CE%B5%E7%D7%D3%C9%CC%CE%F1%D3%D0%CF%DE%D4%F0%C8%CE%B9%AB%CB%BE&data=transId%253DIPER%257E%257C%257EmerchantId%253D042503540264%257E%257C%257EorderId%253D201807041146360%257E%257C%257EtransAmt%253D7.89%257E%257C%257EtransDateTime%253D20180704114636%257E%257C%257EcurrencyType%253D156%257E%257C%257EcustomerName%253D%257E%257C%257EproductInfo%253D%257E%257C%257EcustomerEMail%253D%257E%257C%257EmerURL%253Dhttp%253A%252F%252Ftest.jf180.cn%252Fstatic%252Fportal%252Fmall%252Fhsbank%252Fproxy.html%257E%257C%257EclientType%253D02%257E%257C%257EmsgExt%253D

        //https://112.26.198.149:1000/pmobilenew/samples/Pay/PayCenter/index.html?Page=Pay&merName=%E9%BB%84%E5%B1%B1%E5%B8%82%E8%8F%B1%E5%90%8C%E6%97%85%E6%B8%B8%E7%94%B5%E5%AD%90%E5%95%86%E5%8A%A1%E6%9C%89%E9%99%90%E8%B4%A3%E4%BB%BB%E5%85%AC%E5%8F%B8&data=transId%253DIPER%257E%257C%257EmerchantId%253D042503540264%257E%257C%257EorderId%253D1531728635147%257E%257C%257EtransAmt%253D647.40%257E%257C%257EtransDateTime%253D20180716161035%257E%257C%257EcurrencyType%253D156%257E%257C%257EcustomerName%253D%257E%257C%257EproductInfo%253D%257E%257C%257EcustomerEMail%253D%257E%257C%257EmerURL%253Dhttp%253A%252F%252Ftest.jf180.cn%252Foutlet%252Fpay%252Fcallback%252Fhsbank%257E%257C%257EclientType%253D02%257E%257C%257EmsgExt%253D#/PayCenter


        String s = "<html><head>\t<META http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\">\t<title></title>\t<script language=\"javascript\">\t\t\tfunction skip(){\t\t\tdocument.form1.action = \"https://112.26.198.149:1000/pmobilenew/samples/Pay/PayCenter/index.html\";\t\t\tif(document.getElementsByName(\"data\")[0].value.indexOf(\"011267034147\") > 0 ){\t\t\t\tdocument.form1.action = \"http://38.62.64.192:9004/pmobilenew/samples/Pay/PayCenter/index.html\";\t\t\t}\t\t\t\t\t\t\tdocument.form1.submit();\t\t}\t\t</script></head><body onload=\"skip()\">\t<form action=\"https://112.26.198.149:1000/pmobilenew/samples/Pay/PayCenter/index.html\" name=\"form1\" method=\"get\">\t\t\t<input type=\"hidden\" name=\"Page\" value=\"Pay\" />\t\t<input type=\"hidden\" name=\"merName\" value=\"黄山市菱同旅游电子商务有限责任公司\" />\t\t<input type=\"hidden\" name=\"data\" value=\"transId%3DIPER%7E%7C%7EmerchantId%3D042503540264%7E%7C%7EorderId%3D201807041146360%7E%7C%7EtransAmt%3D7.89%7E%7C%7EtransDateTime%3D20180704114636%7E%7C%7EcurrencyType%3D156%7E%7C%7EcustomerName%3D%7E%7C%7EproductInfo%3D%7E%7C%7EcustomerEMail%3D%7E%7C%7EmerURL%3Dhttp%3A%2F%2Ftest.jf180.cn%2Fstatic%2Fportal%2Fmall%2Fhsbank%2Fproxy.html%7E%7C%7EclientType%3D02%7E%7C%7EmsgExt%3D\" />\t</form></body></html>\n";
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
//            matcher.appendReplacement()
            int i = matcher.groupCount();
            if (i>=0){
                for (int j = 0; j <= i; j++) {
                    String group = matcher.group(j);
                    s = s.replace(group, URLEncoder.encode(group,"gbk"));
                }
            }
        }
        System.out.println(s);
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
