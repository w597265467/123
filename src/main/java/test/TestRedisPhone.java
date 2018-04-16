package test;

import org.apache.poi.util.SystemOutLogger;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRedisPhone {
	public static void main(String[] arg) {
		String a = "cfin_cmcredit_time_";
		String b = "cfin_cm_credit_white_";
		Jedis jedis = new Jedis("192.168.2.5", 6379);

//		String s1 = jedis.get("jft_trade_677ad877-0de4-4633-b86d-1c4eef0e2d84");
//		System.out.println(s1);

		SimpleDateFormat spf = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = spf.format(new Date());
//		String phone = "13450489996";
		String phones = "18573037097\n" +
				"18229704864\n" +
				"13917560653";
//		String[] split = phones.split("\n");
//		for (String s : split) {
//		String s = "13723899841";
//			System.out.println("\""+s+"\",");
//			jedis.set(a + s, "\""+format+"\"");
//			jedis.set(b + s, "\""+format+"\"");
//		}
		TestRedisPhone phone = new TestRedisPhone();
		List<String> phone1 = phone.findPhone("@王路遥 帮忙加一下3个测试号码：\n" +
				"13875893681；\n" +
				"13787139810；\n" +
				"13875892981");
		for (String s : phone1) {
			System.out.println("======="+s);
			jedis.set(a + s, "\""+format+"\"");
			jedis.set(b + s, "\""+format+"\"");
			Set<String> keys = jedis.keys("*" + s);
			for (String key : keys) {
				System.out.println(key);
			}
		}
	}
	public boolean addPhone(String phone){
		try {
			String a = "cfin_cmcredit_time_";
			String b = "cfin_cm_credit_white_";
			Jedis jedis = new Jedis("192.168.2.5", 6379);
			SimpleDateFormat spf = new SimpleDateFormat("yyyyMMddHHmmss");
			String format = spf.format(new Date());
			jedis.set(a + phone, "\""+format+"\"");
			jedis.set(b + phone, "\""+format+"\"");
			System.out.println("\""+phone+"\",");
			Set<String> keys = jedis.keys("*" + phone);
			for (String key : keys) {
				System.out.println(key+":"+jedis.get(key));
			}
			return true;
		} catch (Exception e) {

		}
		return false;
	}


	public List<String> findPhone(String str){
//		String patt = "(((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8})";
		String replace = str.replace("\n", "").replace(" ","");
		System.out.println(replace);
		Pattern r = Pattern.compile("\\d{11}");
		Matcher m = r.matcher(replace);
		List<String> list = new ArrayList();
		while (m.find()){
			for (int i = 0; i <= m.groupCount(); i++) {
//				System.out.println(m.group(i));
				list.add(m.group(i));
			}
//			System.out.println(replace.substring(m.end()));
			replace = replace.substring(m.end());
			m = r.matcher(replace);
		}
		return list;
	}
}
