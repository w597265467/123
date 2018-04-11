package test;

import java.io.UnsupportedEncodingException;

public class TestUnreadableCode {
	public static void main(String[] arg) throws UnsupportedEncodingException {
	    String s = "订单无效";
	    String sss = new String(s.getBytes("utf-8"),"GBK");
		System.out.println("s:\t"+s);
		System.out.println("String sss = new String(s.getBytes(\"utf-8\"),\"GBK\");");
		System.out.println("sss:\t"+sss);
	}

}
