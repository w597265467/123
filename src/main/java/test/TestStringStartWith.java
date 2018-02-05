package test;

public class TestStringStartWith {
	public static void main(String[] arg){
		boolean b = "积分时代-迪信通订单同步-用户确认收货成功订单列表-20180106153513\n"
				.startsWith("积分时代-迪信通订单同步-用户确认收货成功订单列表");
		System.out.println("-".startsWith("-"));
		System.out.println(b);
	}

}
