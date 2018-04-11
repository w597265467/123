package test;

import com.alibaba.fastjson.JSONObject;

public class TestParseJson {
	public static void main(String[] arg){
		OpPackageInfo info = new OpPackageInfo();
		info.monthlyFee = 1;
		info.contractPeriod = 24;
		info.packageDetails ="这是套餐详细信息";
		info.packageName = "这是套餐名字";
		String string = JSONObject.toJSONString(info);
		System.out.println(string);
	}

}

class OpPackageInfo {
	public int monthlyFee; // 套餐月费，可支持两位小数，单位（元）
	public int contractPeriod; // 合约期 单位月
	public String packageName;
	public String packageDetails; // 套餐详情

	public float giveMonthlyFee;//赠送话费
	public int domesticTimeLength;
	public int flowSum;//总流量
	public int buyMonthlyFee;//实际月消(自己掏钱买)
	public int giveFlowSum;//在赠流量(M)
	public int mgGiveMonthlyFee;//其他平台给的
}