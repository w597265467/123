//package test;
//
//import cn.jf180.finance.dao.fin.dao.CmEmpowerRecordMapper;
//import cn.jf180.finance.dao.fin.dao.OpPackageMapper;
//import cn.jf180.finance.dao.fin.model.CmEmpowerRecord;
//import cn.jf180.finance.dao.fin.model.OpPackage;
//import cn.jf180.finance.init.ApplicationContext;
//import cn.jf180.finance.service.BaseService;
//import cn.jf180.finance.service.vo.CmUserCreditInfo;
//import cn.jf180.finance.trd.em.PackageTypeEnum;
//import cn.jf180.finance.trd.op.vo.OpPackageVo;
//import cn.jf180.finance.util.MD5Utils;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.Resource;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@Slf4j
//@Component
//public class ApiOpService extends BaseService {
//
//
//	@Resource(name = "opHttpRestTemplate")
//	private RestTemplate opRestTemplate;
//
//
//	@Resource
//	private CmEmpowerRecordMapper cmEmpowerRecordMapper;
//
//	@Resource
//	private OpPackageMapper opPackageMapper;
//
//
//	private static final String CFIN_UP_OP_PACKAGE_ = "cfin_up_op_package_";
//
//
//	@Value("${spring.profiles.active}")
//	private String env;
//
//	public CmUserCreditInfo cmUserCreditInfo(String phone) {
//		CmUserCreditInfo cmUserCreditInfo = new CmUserCreditInfo();
//		try {
//			CmEmpowerRecord cmEmpowerRecord = new CmEmpowerRecord();
//			String empowerNo = UUID.randomUUID().toString().replaceAll("-", "");
//			String reqId = UUID.randomUUID().toString().replaceAll("-", "");
//			String resp = httpOpCmAndCredit(phone, empowerNo, reqId);
//			cmEmpowerRecord.setCreateTime(new Date());
//			cmEmpowerRecord.setEmpowerNo(empowerNo);
//			cmEmpowerRecord.setPhone(phone);
//			cmEmpowerRecord.setReqId(reqId);
//			cmEmpowerRecordMapper.insertSelective(cmEmpowerRecord);
//			JSONObject apiResp = JSONObject.parseObject(resp);
//			if (apiResp.getIntValue("code") != 0) {
//				return cmUserCreditInfo;
//			}
//			JSONObject bizData = apiResp.getJSONObject("data");
//			String js_user_type = bizData.getString("js_user_type");
//			if (!StringUtils.isEmpty(js_user_type)) {
//				return cmUserCreditInfo;
//			}
//
//			JSONObject andCredit = bizData.getJSONObject("andCredit");
//			if (andCredit == null) {
//				return cmUserCreditInfo;
//			}
//			cmUserCreditInfo(andCredit, cmUserCreditInfo);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return cmUserCreditInfo;
//	}
//
//	private void cmUserCreditInfo(JSONObject json, CmUserCreditInfo cmUserCreditInfo) {
//		try {
//			JSONObject userInfo = json.getJSONObject("response").getJSONArray("userInfos").getJSONObject(0);
//			int creditSumSco = userInfo.getIntValue("credit_sum_sco");
//			int creditNotesSco = userInfo.getIntValue("credit_notes_sco");
//			int actionPreSco = userInfo.getIntValue("action_pre_sco");
//			int identitySco = userInfo.getIntValue("identity_sco");
//			int consumeSco = userInfo.getIntValue("consume_sco");
//			int personRelSco = userInfo.getIntValue("person_rel_sco");
//			cmUserCreditInfo.creditSumSco = creditSumSco;
//			cmUserCreditInfo.creditNotesSco = creditNotesSco;
//			cmUserCreditInfo.actionPreSco = actionPreSco;
//			cmUserCreditInfo.identitySco = identitySco;
//			cmUserCreditInfo.consumeSco = consumeSco;
//			cmUserCreditInfo.personRelSco = personRelSco;
//			cmUserCreditInfo.getCreditScoStatus = true;
//		} catch (Exception e) {
//
//		}
//	}
//
//	/**
//	 * 移动信用评分,获取移动信用评分
//	 *
//	 * @param phone        手机号
//	 * @param empowerNo    授权记录号码
//	 * @param requestRefId 服务请求流水号
//	 * @return {"head":{"requestRefId":"T7b6c0cfdceae41b698f69a8d16db4004","responseRefId":"VGRESP_1504954047831","serviceCode":"100078","responseCode":"0000","responseMsg":"æ¥è¯¢æå"},"response":{"userInfos":[{"credit_sum_sco":584,"credit_notes_sco":643,"action_pre_sco":575,"serv_num":"15110263493","identity_sco":573,"consume_sco":617,"person_rel_sco":529}]}}
//	 */
//	public String httpOpCmAndCredit(String phone, String empowerNo, String reqId) {
//		String url = "http://and-credit.jf180.cn/op/cm/and/credit";
//		try {
//			String params = "?phone=" + phone + "&empowerNo=" + empowerNo + "&reqId=" + reqId + "&sig=123456";
//			url = url + params;
//			HttpHeaders headers = new HttpHeaders();
//			HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
//			//log.info("----->httpOpCmAndCredit url:" + url);
//			ResponseEntity<String> response = opRestTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
//			org.springframework.http.HttpStatus statusCode = response.getStatusCode();
//			if (statusCode.value() != org.springframework.http.HttpStatus.OK.value()) {
//				//log.debug("httpOpCmAndCredit fail,code:" + statusCode.value());
//				return null;
//			}
//			String body = response.getBody();
//			//log.info("<-----httpOpCmAndCredit success,mobile:" + phone + ",resp:" + body);
//			return body;
//		} catch (Exception e) {
//			//log.error("httpOpCmAndCredit fail,error:", e);
//		}
//		return null;
//
//	}
//
//	/**
//	 * @param phone,判断手机号归属地
//	 * @return
//	 */
//	public String catName(String phone) {
//		String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + phone;
//		try {
//			HttpHeaders headers = new HttpHeaders();
//			HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
//			//log.info("----->手机号归属地 url:" + url);
//			ResponseEntity<String> response = opRestTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
//			org.springframework.http.HttpStatus statusCode = response.getStatusCode();
//			if (statusCode.value() != org.springframework.http.HttpStatus.OK.value()) {
//				//log.debug("手机号归属地,code:" + statusCode.value());
//				return "移动";
//			}
//			String body = response.getBody();
//			//log.info("<-----手机号归属地 success,resp:" + body);
//			if (body.indexOf("移动") > 0) {
//				return "移动";
//			}
//			return "非移动";
//		} catch (Exception e) {
//			//log.error("手机号归属地 fail,error:", e);
//		}
//		return "移动";
//
//	}
//
//	public CmUserCreditInfo cmUserCreditInfoZjk(String mobile) {
//		CmUserCreditInfo cmUserCreditInfo = new CmUserCreditInfo();
//		{
//			if (1 == 1) {
//				int opSumSco = (int) (Math.random() * 150 + 550);
//				if (opSumSco < 550) {
//					opSumSco = 550;
//				}
//				if (opSumSco > 700) {
//					opSumSco = 700;
//				}
//				cmUserCreditInfo.creditSumSco = opSumSco;
//				cmUserCreditInfo.creditNotesSco = opSumSco;
//				cmUserCreditInfo.actionPreSco = opSumSco;
//				cmUserCreditInfo.identitySco = opSumSco;
//				cmUserCreditInfo.consumeSco = opSumSco;
//				cmUserCreditInfo.personRelSco = opSumSco;
//				cmUserCreditInfo.getCreditScoStatus = true;
//				return cmUserCreditInfo;
//			}
//		}
//
//		try {
//			boolean inWhite = inWhite(mobile);
//			if (inWhite == true) {
//				return cmUserCreditInfo(mobile);
//			}
//			String params = null;
//			{
//				StringBuffer paramsBuf = new StringBuffer("");
//				paramsBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//				paramsBuf.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.finance.hbmcc.alx.com/\"> ");
//				paramsBuf.append("<soapenv:Header/>");
//				paramsBuf.append("<soapenv:Body>");
//				paramsBuf.append("<ser:getBankZjkService>");
//				paramsBuf.append("<userNo>03112222222</userNo>");
//				paramsBuf.append("<userPwd>CE5E71412FAF67FC41D5C54ECDEDA398</userPwd>");
//				// paramsBuf.append("<phoneNo>AEC3C94D61F3E8331550F49CC138518F</phoneNo>");
//				paramsBuf.append("<phoneNo>" + MD5Utils.md5ToUpperCase(mobile) + "</phoneNo>");
//				paramsBuf.append("</ser:getBankZjkService>");
//				paramsBuf.append("</soapenv:Body>");
//				paramsBuf.append("</soapenv:Envelope>");
//				params = paramsBuf.toString();
//			}
//			{
//				String url = "http://218.207.75.11/HBMCC_INFO/BankZjkService?wsdl";
//				HttpHeaders headers = new HttpHeaders();
//				headers.set("SOAPAction", "");
//				headers.setContentType(MediaType.TEXT_XML);
//				HttpEntity<String> requestEntity = new HttpEntity<String>(params, headers);
//				//log.debug("---------->河北移动和信用分:mobile:,params:" + params);
//				ResponseEntity<String> response = opRestTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//				org.springframework.http.HttpStatus statusCode = response.getStatusCode();
//				if (statusCode.value() != org.springframework.http.HttpStatus.OK.value()) {
//					//log.debug("---------->河北移动和信用分fail:mobile:" + mobile + ",status:" + statusCode.value());
//					return cmUserCreditInfo;
//				}
//				String resp = response.getBody();
//				//log.debug("---------->河北移动和信用分:mobile:" + mobile + ",resp:" + resp);
//				String returnStr = idxStr(resp, "<return>", "</return>");
//				returnStr = returnStr.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
//				// <yesOrNo>Y</yesOrNo><score>655</score><errorMsg>成功</errorMsg><errorde>200</errorde>
//				String yesOrNo = idxStr(returnStr, "<yesOrNo>", "</yesOrNo>");
//				if (yesOrNo != null && "Y".equals(yesOrNo.trim())) {
//					Integer score = Integer.valueOf(idxStr(returnStr, "<score>", "</score>"));
//					//Float _score = score * 0.75f;
//					Float _score = score * 1f;
//					score = _score.intValue();
//					cmUserCreditInfo.creditSumSco = score;
//					cmUserCreditInfo.creditNotesSco = score;
//					cmUserCreditInfo.actionPreSco = score;
//					cmUserCreditInfo.identitySco = score;
//					cmUserCreditInfo.consumeSco = score;
//					cmUserCreditInfo.personRelSco = score;
//					cmUserCreditInfo.getCreditScoStatus = true;
//					return cmUserCreditInfo;
//				} else {
//					//log.debug("---------->河北移动和信用分fail:mobile:" + mobile + ",returnStr:" + returnStr);
//				}
//			}
//		} catch (Exception e) {
//			//log.error("---------->河北移动和信用分fail:mobile:" + mobile + ",error:" + e);
//		}
//		return cmUserCreditInfo;
//	}
//
//	// <?xml version="1.0" ?><S:Envelope
//	// xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"><S:Body><ns2:getBankZjkServiceResponse
//	// xmlns:ns2="http://service.finance.hbmcc.alx.com/"><return>&lt;yesOrNo&gt;&lt;/yesOrNo&gt;&lt;errorMsg&gt;手机号码不存在&lt;/errorMsg&gt;&lt;errorCode&gt;209&lt;/errorCode&gt;</return></ns2:getBankZjkServiceResponse></S:Body></S:Envelope>
//
//	public boolean _3ElesVerifyZjk(String mobile, String name, String idCardNo) {
//		if (1 == 1) {
//			return true;
//		}
//		try {
//			boolean inWhite = inWhite(mobile);
//			if (inWhite == true) {
//				return true;
//			}
//			String params = null;
//			{
//				StringBuffer paramsBuf = new StringBuffer("");
//				paramsBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//				paramsBuf.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.finance.hbmcc.huawei.com/\"> ");
//				paramsBuf.append("<soapenv:Header/>");
//				paramsBuf.append("<soapenv:Body>");
//				paramsBuf.append("<ser:validatePhoneNoIdCardCustNameSame>");
//				{
//					paramsBuf.append("<userNo>031120180129</userNo>");
//					paramsBuf.append("<userPwd>0629E1E8E40BB97F8332D79518084AAE</userPwd>");
//					paramsBuf.append("<phoneNo>" + MD5Utils.md5ToUpperCase(mobile) + "</phoneNo>");
//					paramsBuf.append("<custName>" + MD5Utils.md5ToUpperCase(name) + "</custName>");
//					paramsBuf.append("<idCard>" + MD5Utils.md5ToUpperCase(idCardNo) + "</idCard>");
//				}
//				paramsBuf.append("</ser:validatePhoneNoIdCardCustNameSame>");
//				paramsBuf.append("</soapenv:Body>");
//				paramsBuf.append("</soapenv:Envelope>");
//				params = paramsBuf.toString();
//			}
//			{
//				String url = "http://218.207.75.11/HBMCC_INF/webservice/validateElements";
//				HttpHeaders headers = new HttpHeaders();
//				headers.set("SOAPAction", "");
//				headers.setContentType(MediaType.TEXT_XML);
//				HttpEntity<String> requestEntity = new HttpEntity<String>(params, headers);
//				//log.debug("---------->【张家口移动3要素验证】 params,mobile:" + mobile + ", name:" + name + ", idcardno:" + idCardNo);
//				ResponseEntity<String> response = opRestTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//				org.springframework.http.HttpStatus statusCode = response.getStatusCode();
//				if (statusCode.value() != org.springframework.http.HttpStatus.OK.value()) {
//					//log.debug("---------->【张家口移动3要素验证】 fail,mobile:" + mobile + ", status:" + statusCode.value());
//					return false;
//				}
//				String resp = response.getBody();
//				//log.debug("---------->【张家口移动3要素验证】 params,mobile:" + mobile + ", name:" + name + ", idcardno:" + idCardNo + ", resp:" + resp);
//				String result = idxStr(resp, "<return>", "</return>");
//				return "Y".equals(result);
//			}
//		} catch (Exception e) {
//			//log.debug("---------->【张家口移动3要素验证】 fail,mobile:" + mobile + ", name:" + name + ", idcardno:" + idCardNo + ", error:", e);
//		}
//		return false;
//	}
//
//	private String idxStr(String str, String startStr, String endStr) {
//		int startIdx = str.indexOf(startStr) + startStr.length();
//		int endIdx = str.indexOf(endStr, startIdx);
//		String _str = str.substring(startIdx, endIdx);
//		return _str;
//	}
//
//	private boolean inWhite(String mobile) {
//		try {
//			String key = "cfin_cm_credit_white_" + mobile;
//			String val = serviceRedisClient.get(key);
//			if (!StringUtils.isEmpty(val)) {
//				return true;
//			}
//		} catch (Exception e) {
//			//log.debug("error:{}", e);
//		}
//		return false;
//	}
//
//
//	public static void main(String[] args)  {
//		//16
//		//   /Users/wangluyao/jf/17、张家口信用购机问卷6.xlsx
//		try {
//			ApiOpService apiOpService = new ApiOpService();
//			apiOpService.opRestTemplate = new ApplicationContext().opRestTemplate();
//			long l = Runtime.getRuntime().totalMemory();
//			FileInputStream fis = new FileInputStream("/Users/wangluyao/jf/wenjuan.xlsx");
//			long l2 = Runtime.getRuntime().totalMemory();
//			Workbook wb = new XSSFWorkbook(fis);
//			long l3 = Runtime.getRuntime().totalMemory();
//			Sheet sheetAt = wb.getSheetAt(0);
//			XSSFWorkbook sheets = new XSSFWorkbook();
//			XSSFSheet sheet = sheets.createSheet();
//			XSSFRow row1 = sheet.createRow(0);
//			row1.createCell(0).setCellValue("手机号");
//			row1.createCell(1).setCellValue("所在档位");
//			int i = 1;
//			for (Row cells : sheetAt) {
//				Cell cell = cells.getCell(16);
//				int cellType = cell.getCellType();
//				String s = null;
//				switch (cellType) {
//					case XSSFCell.CELL_TYPE_BLANK:
//						System.out.println("null");
//						break;
//					case XSSFCell.CELL_TYPE_BOOLEAN:
//						s = String.valueOf(cell.getBooleanCellValue());
//						break;
//					case XSSFCell.CELL_TYPE_NUMERIC:
//						s = String.valueOf(cell.getNumericCellValue());
//						break;
//					case XSSFCell.CELL_TYPE_STRING:
//						s = String.valueOf(cell.getStringCellValue());
//						break;
//					case XSSFCell.CELL_TYPE_ERROR:
//						s = String.valueOf(cell.getErrorCellValue());
//						break;
//					case XSSFCell.CELL_TYPE_FORMULA:
//						s = String.valueOf(cell.getCellFormula());
//						break;
//				}
//				int fee = apiOpService.opFee(s);
//				XSSFRow row = sheet.createRow(i++);
//				row.createCell(0).setCellValue(s);
//				String str = "";
//				if (fee<=50){
//					str = "0~50";
//				}else if (fee<=100){
//					str = "50~100";
//				}else if (fee<=200){
//					str = "100~200";
//				}else{
//					str = "200以上";
//				}
//				if (fee<0){
//					str = "未知";
//				}
//				row.createCell(1).setCellValue(str);
//			}
//			sheets.write(new FileOutputStream("/Users/wangluyao/jf/用户套餐.xlsx"));
//
//			System.out.println("l2-l"+(l2-l));
//			System.out.println("l3-l2"+(l3-l2));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//
//	}
//
//	public int opFee(String mobile) {
//		StringBuffer paramsBuf = new StringBuffer("");
//		paramsBuf.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.finance.hbmcc.alx.com/\">\n");
//		paramsBuf.append("   <soapenv:Header/>\n");
//		paramsBuf.append("   <soapenv:Body>\n");
//		paramsBuf.append("      <ser:getBankZjkService>\n");
//		paramsBuf.append("         <userNo>03112222222</userNo>\n");
//		paramsBuf.append("         <userPwd>CE5E71412FAF67FC41D5C54ECDEDA398</userPwd>\n");
//		paramsBuf.append("         <phoneNo>").append(MD5Utils.md5ToUpperCase(mobile)).append("</phoneNo>\n");
//		paramsBuf.append("      </ser:getBankZjkService>\n");
//		paramsBuf.append("   </soapenv:Body>\n");
//		paramsBuf.append("</soapenv:Envelope>");
//		String params = paramsBuf.toString();
//		String url = "http://218.207.75.11/HBMCC_INFO/BankZjkService";
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("SOAPAction", "");
//		headers.setContentType(MediaType.TEXT_XML);
//		HttpEntity<String> requestEntity = new HttpEntity<String>(params, headers);
//		/*
//		返回值,正常用户
//		<return>
//			<yesOrNo>Y</yesOrNo>
//			<score>850</score>
//			<isFxUser>0</isFxUser>
//			<isFluxUser>1</isFluxUser>
//			<userType>Q</userType>
//			<errorMsg>成功</errorMsg>
//			<errorCode>200</errorCode>
//		</return>
//		 */
//		//log.debug("---------->【张家口移动用户向上营销】:mobile:" + mobile + ",params:" + params);
//		ResponseEntity<String> response = opRestTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//		HttpStatus statusCode = response.getStatusCode();
//		if (statusCode.value() != HttpStatus.OK.value()) {
//			//log.debug("---------->【张家口移动用户向上营销】 fail,mobile:" + mobile + ", status:" + statusCode.value());
//		}
//		String resp = response.getBody();
//		String returnStr = idxStr(resp, "<return>", "</return>");
//		returnStr = returnStr.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
//		//log.debug("---------->【张家口移动用户向上营销】:resp:" + returnStr);
//		//			<yesOrNo>Y</yesOrNo>
//		//			<score>850</score>
//		//			<isFxUser>0</isFxUser>
//		//			<isFluxUser>1</isFluxUser>
//		//			<userType>Q</userType>
//		//			<errorMsg>成功</errorMsg>
//		//			<errorCode>200</errorCode>
//		String yesOrNo = idxStr(returnStr, "<yesOrNo>", "</yesOrNo>");
//		if (yesOrNo != null && "Y".equals(yesOrNo.trim())) {
//			Integer isFxUser = Integer.valueOf(idxStr(returnStr, "<isFxUser>", "</isFxUser>"));
//			Integer isFluxUser = Integer.valueOf(idxStr(returnStr, "<isFluxUser>", "</isFluxUser>"));
//			String userType = idxStr(returnStr, "<userType>", "</userType>");
//			//标签3  isFxUser
//			//标签4  isFluxUser
//			//当标签3输出为是，默认推荐4G飞享套餐，返费50%（4G新飞享套餐）
//			int minFee = 0;
//			int maxFee = -1;
//			boolean isMatching = false;
//			if (1 == isFxUser) {
//				//X＜38		U	38		38、58、88、128
//				//38≤X＜58	V	58		58、88、128
//				//58≤X＜88	W	88		88、128
//				//88≤X＜128	X	128		128
//				switch (userType) {
//					case "U":
//						minFee = 0;
//						maxFee = 38;
//						isMatching = true;
//						break;
//					case "V":
//						minFee = 38;
//						maxFee = 58;
//						isMatching = true;
//						break;
//					case "W":
//						minFee = 58;
//						maxFee = 88;
//						isMatching = true;
//						break;
//					case "X":
//						minFee = 88;
//						maxFee = 128;
//						isMatching = true;
//						break;
//					default:
//						break;
//				}
//
//
//				//当标签4输出为是，默认推荐4G飞享流量王套餐，返费40%
//			}
//
//			if (1 == isFluxUser) {
//				//N＜48		O	48		48、68、98、138
//				//48≤N＜68	P	68		68、98、138
//				//68≤N＜98	Q	98		98、138
//				//98≤N＜138	R	138		138
//
//				switch (userType) {
//					case "O":
//						minFee = 0;
//						maxFee = 48;
//						isMatching = true;
//						break;
//					case "P":
//						minFee = 48;
//						maxFee = 68;
//						isMatching = true;
//						break;
//					case "Q":
//						minFee = 68;
//						maxFee = 98;
//						isMatching = true;
//						break;
//					case "R":
//						minFee = 98;
//						maxFee = 138;
//						isMatching = true;
//						break;
//					default:
//						break;
//				}
//
//
//				//当标签3、4输出为否或标签3、标签4输出无指向套餐档次，默认推荐4G飞享套餐，返费40%
//			}
//
//
//			if (isMatching == false) {
//				//N＜38		   A	0	   38、58、88、138、158、188、238、288
//				//38≤N＜58	   B	38	   58、88、138、158、188、238、288
//				//58≤N＜88	   C	58	   88、138、158、188、238、288
//				//88≤N＜138	   D	88	   138、158、188、238、288
//				//138≤N＜158	   E	138	   158、188、238、288
//				//158≤N＜188	   F	158	   188、238、288
//				//188≤N＜238	   G	188	   238、288
//				//238≤N		   H	238	   288
//
//				switch (userType) {
//					case "A":
//						minFee = 0;
//						maxFee = 38;
//						break;
//					case "B":
//						minFee = 38;
//						maxFee = 58;
//						break;
//					case "C":
//						minFee = 58;
//						maxFee = 88;
//						break;
//					case "D":
//						minFee = 88;
//						maxFee = 138;
//						break;
//					case "E":
//						minFee = 138;
//						maxFee = 158;
//						break;
//					case "F":
//						minFee = 158;
//						maxFee = 188;
//						break;
//					case "G":
//						minFee = 188;
//						maxFee = 238;
//						break;
//					case "H":
//						minFee = 238;
//						maxFee = 99999;
//						break;
//					default:
//						break;
//				}
//			}
//			return maxFee;
//		}
//		return -1;
//	}
//
//
//	public OpPackageVo opPackage(String mobile, List<OpPackage> opPackageList) {
//		/*
//		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.finance.hbmcc.alx.com/">
//		   <soapenv:Header/>
//		   <soapenv:Body>
//			  <ser:getBankZjkService>
//				 <!—用户名-->
//				 <userNo>03112222222</userNo>
//				 <!—密码md5-->
//				 <userPwd>CE5E71412FAF67FC41D5C54ECDEDA398</userPwd>
//				 <!—手机号码md5-->
//				 <phoneNo>AEC3C94D61F3E8331550F49CC138518F</phoneNo>
//			  </ser:getBankZjkService>
//		   </soapenv:Body>
//		</soapenv:Envelope>
//		 */
//
//		String key = CFIN_UP_OP_PACKAGE_ + mobile;
//
//		String returnStr = serviceRedisClient.get(key);
//		if (StringUtils.isEmpty(returnStr)) {
//			StringBuffer paramsBuf = new StringBuffer("");
//			paramsBuf.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.finance.hbmcc.alx.com/\">\n");
//			paramsBuf.append("   <soapenv:Header/>\n");
//			paramsBuf.append("   <soapenv:Body>\n");
//			paramsBuf.append("      <ser:getBankZjkService>\n");
//			paramsBuf.append("         <userNo>03112222222</userNo>\n");
//			paramsBuf.append("         <userPwd>CE5E71412FAF67FC41D5C54ECDEDA398</userPwd>\n");
//			paramsBuf.append("         <phoneNo>").append(MD5Utils.md5ToUpperCase(mobile)).append("</phoneNo>\n");
//			paramsBuf.append("      </ser:getBankZjkService>\n");
//			paramsBuf.append("   </soapenv:Body>\n");
//			paramsBuf.append("</soapenv:Envelope>");
//			String params = paramsBuf.toString();
//			String url = "http://218.207.75.11/HBMCC_INFO/BankZjkService";
//			HttpHeaders headers = new HttpHeaders();
//			headers.set("SOAPAction", "");
//			headers.setContentType(MediaType.TEXT_XML);
//			HttpEntity<String> requestEntity = new HttpEntity<String>(params, headers);
//		/*
//		返回值,正常用户
//		<return>
//			<yesOrNo>Y</yesOrNo>
//			<score>850</score>
//			<isFxUser>0</isFxUser>
//			<isFluxUser>1</isFluxUser>
//			<userType>Q</userType>
//			<errorMsg>成功</errorMsg>
//			<errorCode>200</errorCode>
//		</return>
//		 */
//			//log.debug("---------->【张家口移动用户向上营销】:mobile:" + mobile + ",params:" + params);
//			ResponseEntity<String> response = opRestTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//			HttpStatus statusCode = response.getStatusCode();
//			if (statusCode.value() != HttpStatus.OK.value()) {
//				//log.debug("---------->【张家口移动用户向上营销】 fail,mobile:" + mobile + ", status:" + statusCode.value());
//			}
//			String resp = response.getBody();
//			returnStr = idxStr(resp, "<return>", "</return>");
//			returnStr = returnStr.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
//			serviceRedisClient.set(key, returnStr);
//			//log.debug("---------->【张家口移动用户向上营销】:resp:" + returnStr);
//		}
//		//			<yesOrNo>Y</yesOrNo>
//		//			<score>850</score>
//		//			<isFxUser>0</isFxUser>
//		//			<isFluxUser>1</isFluxUser>
//		//			<userType>Q</userType>
//		//			<errorMsg>成功</errorMsg>
//		//			<errorCode>200</errorCode>
//		String yesOrNo = idxStr(returnStr, "<yesOrNo>", "</yesOrNo>");
//		//log.debug(returnStr);
//		OpPackageVo opPackages = null;
//		if (yesOrNo != null && "Y".equals(yesOrNo.trim())) {
//			Integer score = Integer.valueOf(idxStr(returnStr, "<score>", "</score>"));
//			Integer isFxUser = Integer.valueOf(idxStr(returnStr, "<isFxUser>", "</isFxUser>"));
//			Integer isFluxUser = Integer.valueOf(idxStr(returnStr, "<isFluxUser>", "</isFluxUser>"));
//			String userType = idxStr(returnStr, "<userType>", "</userType>");
//			//标签3  isFxUser
//			//标签4  isFluxUser
//			//当标签3输出为是，默认推荐4G飞享套餐，返费50%（4G新飞享套餐）
//
//			boolean isMatching = false;
//			if (1 == isFxUser) {
//				//X＜38		U	38		38、58、88、128
//				//38≤X＜58	V	58		58、88、128
//				//58≤X＜88	W	88		88、128
//				//88≤X＜128	X	128		128
//				switch (userType) {
//					case "U":
//						opPackages = opPackageFilter(0, opPackageList, PackageTypeEnum.NEW_FLY_4G);
//						isMatching = true;
//						break;
//					case "V":
//						opPackages = opPackageFilter(38, opPackageList, PackageTypeEnum.NEW_FLY_4G);
//						isMatching = true;
//						break;
//					case "W":
//						opPackages = opPackageFilter(58, opPackageList, PackageTypeEnum.NEW_FLY_4G);
//						isMatching = true;
//						break;
//					case "X":
//						opPackages = opPackageFilter(88, opPackageList, PackageTypeEnum.NEW_FLY_4G);
//						isMatching = true;
//						break;
//					default:
//						opPackages = null;
//						break;
//				}
//
//
//				//当标签4输出为是，默认推荐4G飞享流量王套餐，返费40%
//			}
//
//			if (1 == isFluxUser) {
//				//N＜48		O	48		48、68、98、138
//				//48≤N＜68	P	68		68、98、138
//				//68≤N＜98	Q	98		98、138
//				//98≤N＜138	R	138		138
//
//				switch (userType) {
//					case "O":
//						opPackages = opPackageFilter(0, opPackageList, PackageTypeEnum.FLY_4G_KING);
//						isMatching = true;
//						break;
//					case "P":
//						opPackages = opPackageFilter(48, opPackageList, PackageTypeEnum.FLY_4G_KING);
//						isMatching = true;
//						break;
//					case "Q":
//						opPackages = opPackageFilter(68, opPackageList, PackageTypeEnum.FLY_4G_KING);
//						isMatching = true;
//						break;
//					case "R":
//						opPackages = opPackageFilter(98, opPackageList, PackageTypeEnum.FLY_4G_KING);
//						isMatching = true;
//						break;
//					default:
//						opPackages = null;
//						break;
//				}
//
//
//				//当标签3、4输出为否或标签3、标签4输出无指向套餐档次，默认推荐4G飞享套餐，返费40%
//			}
//
//
//			if (isMatching == false) {
//				//N＜38		   A	0	   38、58、88、138、158、188、238、288
//				//38≤N＜58	   B	38	   58、88、138、158、188、238、288
//				//58≤N＜88	   C	58	   88、138、158、188、238、288
//				//88≤N＜138	   D	88	   138、158、188、238、288
//				//138≤N＜158	   E	138	   158、188、238、288
//				//158≤N＜188	   F	158	   188、238、288
//				//188≤N＜238	   G	188	   238、288
//				//238≤N		   H	238	   288
//
//				switch (userType) {
//					case "A":
//						opPackages = opPackageFilter(0, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					case "B":
//						opPackages = opPackageFilter(38, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					case "C":
//						opPackages = opPackageFilter(58, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					case "D":
//						opPackages = opPackageFilter(88, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					case "E":
//						opPackages = opPackageFilter(138, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					case "F":
//						opPackages = opPackageFilter(158, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					case "G":
//						opPackages = opPackageFilter(188, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					case "H":
//						opPackages = opPackageFilter(238, opPackageList, PackageTypeEnum.FLY_4G);
//						break;
//					default:
//						break;
//				}
//
//			}
//			//log.debug("score:{},isFxUser:{},isFluxUser:{},userType:{}", score, isFxUser, isFluxUser, userType);
//			//Float _score = score * 0.75f;
//		} else {
//			//log.debug("---------->河北移动向上营销失败fail:mobile:" + mobile + ",returnStr:" + returnStr);
//		}
//		return opPackages;
//
//	}
//
//
//	private OpPackageVo opPackageFilter(int min, List<OpPackage> opPackageList, PackageTypeEnum packageTypeEnum) {
//
//		OpPackageVo vo = new OpPackageVo();
//		vo.opPackages = opPackageList;
//		int type = packageTypeEnum.type;
//		if (opPackageList == null || opPackageList.isEmpty()) {
//			return vo;
//		}
//		int size = opPackageList.size();
//		for (int j = 0; j < size; j++) {
//			OpPackage opPackage = opPackageList.get(j);
//			if (opPackage.getMonthlyFee() < min || opPackage.getOpType() != type) {
//				opPackageList.remove(opPackage);
//				j--;
//				size--;
//			}
//		}
//		vo.minFee = min;
//		vo.type = type;
//		return vo;
//	}
//
//
//	// String mobile = "15130113111";
//	// String name = "光晶1";
//	// public static void main(String[] args) {
//	// String idCardNo = "140311198509211517";
//	// HttpOpServiceHelper test = new HttpOpServiceHelper();
//	// test.opRestTemplate = new ApplicationContext().restTemplate();
//	// boolean tttt = test._3ElesVerifyZjk(mobile, name, idCardNo);
//	// System.out.println(tttt);
//	// // 光晶，15130113111， 140311198509211517
//	// }
//
//}