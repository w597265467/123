package test;

import java.io.UnsupportedEncodingException;

public class TestGBK {
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			String s1 = new String(str.getBytes(encode), encode);
			System.out.println(s1 + ":" + encode);
			if (str.equals(new String(str.getBytes(encode), encode))) {     //判断是不是GB2312
//				String s = encode;
//				return s;      //是的话，返回“GB2312“，以下代码同理
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			String s1 = new String(str.getBytes(encode), encode);
			System.out.println(s1 + ":" + encode);
			if (str.equals(new String(str.getBytes(encode), encode))) {     //判断是不是ISO-8859-1
//				String s1 = encode;
//				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			String s1 = new String(str.getBytes(encode), encode);
			System.out.println(s1 + ":" + encode);
			if (str.equals(new String(str.getBytes(encode), encode))) {  //判断是不是UTF-8
//				String s2 = encode;
//				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			String s1 = new String(str.getBytes(encode), encode);
			System.out.println(s1 + ":" + encode);
			if (str.equals(new String(str.getBytes(encode), encode))) {     //判断是不是GBK
//				String s3 = encode;
//				return s3;
			}
		} catch (Exception exception3) {
		}
		return encode;        //如果都不是，说明输入的内容不属于常见的编码格式。
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "娴嬭瘯鍟嗘埛";
		System.out.println("================");
		syso(s, "utf-8", "gbk");
		System.out.println("================");
		syso(s, "gbk", "utf-8");

	}

	public static void syso(String s, String e1, String e2) throws UnsupportedEncodingException {
		String s1 = new String(s.getBytes(e1), e2);
		System.out.println(s1);
		System.out.println(getEncoding(s1));
	}


}
