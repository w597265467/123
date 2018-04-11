package test;

import java.io.UnsupportedEncodingException;

public class TestLuanMa {
	public static void main(String[] arg) throws UnsupportedEncodingException {
	    String s = " * 鐗堟潈鎵€鏈?2005-2009 涓婃捣鍟嗘淳缃戠粶绉戞妧鏈夐檺鍏\uE100徃锛屽苟淇濈暀鎵€鏈夋潈鍒┿€?\n" +
			    " * 缃戠珯鍦板潃: http://www.ecshop.com锛?\n" +
			    " * ----------------------------------------------------------------------------\n" +
			    " * 杩欎笉鏄\uE219竴涓\uE047嚜鐢辫蒋浠讹紒鎮ㄥ彧鑳藉湪涓嶇敤浜庡晢涓氱洰鐨勭殑鍓嶆彁涓嬪\uE1EE绋嬪簭浠ｇ爜杩涜\uE511淇\uE1BD敼鍜?\n" +
			    " * 浣跨敤锛涗笉鍏佽\uE18F瀵圭▼搴忎唬鐮佷互浠讳綍褰㈠紡浠讳綍鐩\uE1BE殑鐨勫啀鍙戝竷銆?";
		String sss = new String(s.getBytes("GBK"),"utf-8");
		System.out.println(sss);
	}

}
