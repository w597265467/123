package test;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class TestUnReadable {


	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		String s = "æ‚¨çš„è®¿é—®è¿‡äºŽé¢‘ç¹\u0081ï¼Œè¯·ç¨\u008Då\u0090Žé‡\u008Dè¯•";
//		String s = "æ‚!!!!!¨çš„!!!!!!!!!!è®¿é—!!!!!®è¿‡!!!!!äºŽ!!!!!é¢!!!!!‘ç¹\u0081ï¼Œ!!!!!è¯·ç¨\u008Då\u0090Ž!!!!!é‡!!!!!\u008Dè¯•";
//	  	String s = "æ\u0082¨ç\u009A\u0084è®¿é\u0097®è¿\u0087äº\u008Eé¢\u0091ç¹\u0081ï¼\u008Cè¯·ç¨\u008Då\u0090\u008Eé\u0087\u008Dè¯\u0095...";
		String u = "utf-8";
		String g = "gbk";
		String i = "iso-8859-1";
		String[] ss = new String[]{u, g, i};
		System.out.println(code("您的访问过于频繁，请稍后重试...", u, i));
		System.out.println(code("您的访问过于频繁，请稍后重试...", g, i));
		String c = code(s, u, g);
		String code1 = code(c, i, u);
		System.out.println(code1);

		Random r = new Random();
		while (true) {
			Thread.sleep(1000);
			int i1 = r.nextInt(3);
			int i2 = r.nextInt(3);
			while (i1==i2){
				i2 = r.nextInt(3);
			}
			String code = code(s, ss[i1], ss[i2]);
			System.out.println(ss[i1] + "---to---" + ss[i2] + ">>>>" + code);

			i1 = r.nextInt(3);
			i2 = r.nextInt(3);
			while (i1==i2){
				i2 = r.nextInt(3);
			}
			code = code(code, ss[i1], ss[i2]);
			System.out.println(ss[i1] + "---to---" + ss[i2] + ">>>>" + code);

			i1 = r.nextInt(3);
			i2 = r.nextInt(3);
			while (i1==i2){
				i2 = r.nextInt(3);
			}
			code = code(code, ss[i1], ss[i2]);
			System.out.println(ss[i1] + "---to---" + ss[i2] + ">>>>" + code);

			i1 = r.nextInt(3);
			i2 = r.nextInt(3);
			while (i1==i2){
				i2 = r.nextInt(3);
			}
			code = code(code, ss[i1], ss[i2]);
			System.out.println(ss[i1] + "---to---" + ss[i2] + ">>>>" + code);

			i1 = r.nextInt(3);
			i2 = r.nextInt(3);
			while (i1==i2){
				i2 = r.nextInt(3);
			}
			code = code(code, ss[i1], ss[i2]);
			System.out.println(ss[i1] + "---to---" + ss[i2] + ">>>>" + code);
			System.out.println("==================================================");
		}
	}

	public static String code(String a, String b, String c) throws UnsupportedEncodingException {


		return new String(a.getBytes(b), c);
	}


}
