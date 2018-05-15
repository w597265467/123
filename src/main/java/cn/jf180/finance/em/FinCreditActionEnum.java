package cn.jf180.finance.em;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户到了哪一步的哪一个流程
 */
public enum FinCreditActionEnum {
	/*
	100 购买
	200 实名认证
	300 绑卡
	400 人脸识别
	500 个人资料
	600 授信申请
	700 订单查询
	 */
	CFIN_TRADE_START(101,100,"购买","/cfin/trade/start","进入四合一页面,解析迪信通传来的商品信息"),
	CFIN_TRADE_4IN1_INFO(102,100,"购买","/cfin/trade/4in1/info","四合一用户输入手机号获取分期信息"),
	CFIN_TRADE_SMS_SEND(103,100,"购买","/cfin/trade/sms/send","四合一发送短信"),
	CFIN_TRADE_PLACE_ORDER(104,100,"购买","/cfin/trade/place/order","四合一下单"),
	CFIN_TRADE_LOGIN_DO(105,100,"购买","/cfin/trade/login/do","四合一登陆"),

	CFIN_CREDIT_APPLY_ID(201,200,"身份证上传","/cfin/credit/apply/id","进入授信流程的申请id"),
	CFIN_CREDIT_FACE_IDCARD_INFO(202,200,"身份证上传","/cfin/credit/face/idcard/info","上传身份证正面"),
	CFIN_CREDIT_BACK_IDCARD_INFO(203,200,"身份证上传","/cfin/credit/back/idcard/info","上传身份证背面"),
	CFIN_CREDIT_REALNAME_VERIFY(204,200,"身份证上传","/cfin/credit/realname/verify","身份证上传实名认证"),

	CFIN_BANK(301,300,"绑卡","授信-绑卡","用户到达绑卡页面"),
	CFIN_CREDIT_PRE_INFO(302,300,"绑卡","/cfin/credit/pre/info","绑卡页面给用户展示的信息"),
	CFIN_BANK_NUMBER_QUERY_BANK(303,300,"绑卡","/cfin/bank/number/query/bank","绑卡-用户输入银行卡号所属银行查询"),
	CFIN_CREDIT_BANKCARD_SEND_SMS(304,300,"绑卡","/cfin/credit/bankcard/send/sms","绑卡发送短信"),
	CFIN_CREDIT_BANKCARD_VERIFY(305,300,"绑卡","/cfin/credit/bankcard/verify","绑卡四要素验证"),
	CFIN_CREDIT_BQXD_PROTOCOL(306,300,"绑卡","/cfin/credit/bqxd/protocol","宝乾合约信息"),
	CFIN_APPLY_PAY_AGREEMENT(307,300,"绑卡","/cfin/apply/pay/agreement","合约信息"),


	CFIN_CREDIT_FACE(401,400,"人脸识别","授信-实人","到达人脸识别页面"),
	CFIN_CREDIT_FACE_BIZNO(402,400,"人脸识别","/cfin/credit/face/bizno","人脸识别-获取随机数"),
	CFIN_CREDIT_FACE_UPLOAD(403,400,"人脸识别","/cfin/credit/face/upload","人脸识别-视频上传"),
	CFIN_CREDIT_FACE_RESULT(404,400,"人脸识别","/cfin/credit/face/result","人脸识别-查询结果"),


	CREDIT_PRE_FAMILY(501,500,"个人资料","授信-关联亲属","用户到达个人资料页面"),
	CFIN_CREDIT_PRE_FAMILY(502,500,"个人资料","/cfin/credit/pre/family","个人资料页面信息"),
	CFIN_CREDIT_FAMILY_VERIFY(503,500,"个人资料","/cfin/credit/family/verify","个人资料上传"),

	CFIN_CREDIT_APPLY(601,600,"授信申请","/cfin/credit/apply","授信申请"),

	CFIN_ORDER_DETAIL(701,700,"查询","/cfin/order/detail","订单详情"),
	ORDER_DETAIL(702,700,"查询","订单详情","订单详情"),

	CFIN_API_CLEAN_USER(801,800,"其他","/cfin/api/clean/user","清除用户信息"),
	CFIN_TEST_TEST_22(802,800,"其他","/cfin/test/test/22","未知"),
	;

	public int id; //这个一步的id
	public int stepId;//这一步所属流程的id
	public String stepDesc;
	public String action;//这一步的action
	public String actionDesc;

	FinCreditActionEnum(int id, int stepId, String stepDesc, String action, String actionDesc) {
		this.id = id;
		this.stepId = stepId;
		this.stepDesc = stepDesc;
		this.action = action;
		this.actionDesc = actionDesc;
	}


	public FinCreditActionEnum value(String action){
		for (FinCreditActionEnum actionEnum : FinCreditActionEnum.values()) {
			if (StringUtils.equals(action,actionEnum.action)){
				return actionEnum;
			}
		}

		return null;
	}

}
