package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 * @author Administrator

 * @create 2018-03-16 17:50

 * @desc TestString

 **/
public class TestString {
	public static void main(String[] arg){

		long l = System.nanoTime();
		String userPhone = "13693642762";
		String staPhone = userPhone.substring(0, 3);
		String endPhone = userPhone.substring(7);
		userPhone = staPhone + "****" + endPhone;
		System.out.println(userPhone);
		long l1 = System.nanoTime();
		System.out.println(l1 -l);
//		char c = '*';
//		System.out.println(((byte)c));
		long l2 = System.nanoTime();
		String phone = "13693642762";
		byte[] bytes = phone.getBytes();
		for (int i = 3; i < 7; i++) {
			bytes[i] = '*';
		}
		System.out.println(new String(bytes));
		long l3 = System.nanoTime();
		System.out.println(l3-l2);
		System.out.println(phone);
		Pattern pattern = Pattern.compile("(\\d{3,3})(.*)(\\d{4,4})");
//		Pattern pattern = Pattern.compile(".*");
		System.out.println(pattern.toString());
		Matcher matcher = pattern.matcher(phone);
		if (matcher.find()){
			System.out.println(matcher.group(1)+"****"+matcher.group(3));
//			System.out.println(matcher.group(4));
		}
		System.out.println(System.nanoTime()-l3);
	}

}
