package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRex {
	public static void main(String[] arg){
		// 创建一个正则表达式模式，用以匹配一个单词（\b=单词边界）
		String patt = "\\b商品价格和订单金额不一致,通知人工干预:orderId:(.*),extOrderId:(.*),goodsPrice:(.*),orderMoney:(.*)\\b";
		// 用于测试的输入字符串
		String input = "商品价格和订单金额不一致,通知人工干预:orderId:6229912018012517375726414693,extOrderId:yo118303931445,goodsPrice:2999.0,orderMoney:1233.0";
		System.out.println("Input:" + input);
		// 从正则表达式实例中运行方法并查看其如何运行
		Pattern r = Pattern.compile(patt);
		Matcher m = r.matcher(input);
		System.out.println("ReplaceAll:" + m.replaceAll("$1"));
		// appendReplacement方法
		m.reset();
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			// 将匹配之前的字符串复制到sb,再将匹配结果替换为："favour"，并追加到sb
			m.appendReplacement(sb, "favour");
		}
		System.out.println(sb.toString());
		m.appendTail(sb);
		System.out.println(sb.toString());
	}

}
