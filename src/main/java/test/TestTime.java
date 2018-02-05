package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {
	public static void main(String[] arg) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		//            yyyyMMddHHmmss
		String str = "20180124104018";
		Date date = sdf.parse(str);
		long orderStatusTime = date.getTime();
		while (true){
			long currentTime = System.currentTimeMillis();
			boolean b = currentTime - orderStatusTime > 600000;
			if (b){
				String format = sdf.format(currentTime);
				System.out.println("当前时间:"+format);
				System.out.println("比对时间:"+str);
				break;
			}
		}
	}
}
