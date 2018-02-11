package file;

import org.apache.poi.xwpf.usermodel.XWPFComment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateJava {
	public static void main(String[] arg) {
		try {
			FileInputStream in = new FileInputStream("g:/test2.docx");//载入文档
			XWPFDocument document = new XWPFDocument(in);
			List<XWPFTable> tables = document.getTables();
			for (XWPFComment xwpfComment : document.getComments()) {
				System.out.println(xwpfComment.getText());
			}
			int size = tables.size();
			System.out.println(size);
			List<JavaClass> list = new ArrayList<>();
			for (XWPFTable table : tables) {
				JavaClass javaClass = new JavaClass();
				list.add(javaClass);
				for (int i = 0; i < table.getNumberOfRows(); i++) {
					XWPFTableRow row = table.getRow(i);
					List<XWPFTableCell> cells = row.getTableCells();
					abc:
					for (int j = 0; j < cells.size(); j++) {
						// 0     1     2     3          4
						//字段 | 中文 | 类型 | 是否必填 | 说明 |
						String text = cells.get(j).getText();
						switch (j) {
							case 0:
								if (JavaClass.isContainChinese(text)) {
									String[] split = text.split(",");
									if (split.length == 2) {
										if (text.contains("1")) {
											javaClass.name = "FinBqxd" + split[1] + "Req";
										} else if (text.contains("2")) {
											javaClass.name = "FinBqxd" + split[1] + "Resp";
										}
										javaClass.coreName = "Bqxd" + split[1];
									}
									break abc;
								}
								javaClass.fields.add(text);
								System.out.print(text + "|" + j + "|");
								break;
							case 1:
								javaClass.fieldsDesc.add(text);
								System.out.print(text + "|" + j + "|");
								break;
							case 2:
								javaClass.fieldsType.add(text);
								System.out.print(text + "|" + j + "|");
								break;
							case 3:
								javaClass.isMust.add(String2Boolean(text));
								System.out.print(text + "|" + j + "|");
								break;
							case 4:
								javaClass.content.add(text);
								System.out.print(text + "|" + j + "|");
								break;
						}
					}
					System.out.println();
				}
				System.out.println("=========================");
			}
			for (JavaClass javaClass : list) {
				javaClass.fieldsTypeToJavaType();
				System.out.println("fieldsType:");
				for (String s : javaClass.fieldsType) {
					System.out.print(s + "|");
				}
				System.out.println();
				System.out.println("field:");
				for (String field : javaClass.fields) {
					System.out.print(field + "|");
				}
				System.out.println();
				System.out.println("isMust:");
				for (Boolean field : javaClass.isMust) {
					System.out.print(field + "|");
				}
				System.out.println();
				System.out.println("content:");
				for (String field : javaClass.content) {
					System.out.print(field + "|");
				}
				System.out.println();
				System.out.println("fieldsDesc:");
				for (String field : javaClass.fieldsDesc) {
					System.out.print(field + "|");
				}

				System.out.println("\n==============================" +
						javaClass.isOk() + "\n===================");

				javaClass.wirteJavaVo();
				javaClass.writeJavaService();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean String2Boolean(String str) {
		if (str == null || str.length() == 0 || str.equals("否")) {
			return false;
		} else if (str.contains("是")) {
			return true;
		}
		return false;
	}
}

class JavaClass {
	List<String> fields = new ArrayList<>();
	List<String> fieldsType = new ArrayList<>();
	List<String> content = new ArrayList<>();
	List<Boolean> isMust = new ArrayList<>();
	List<String> fieldsDesc = new ArrayList<>();
	String name = null;
	String coreName = null;

	public static boolean isContainChinese(String str) {

		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	public boolean isOk() {
		return fields.size() == fieldsDesc.size();
	}


	public void wirteJavaVo() throws IOException {
		/*
		"\tpublic String mobile;\n" +
				"\tpublic String name;\n" +
				"\tpublic String idCardNum;\n" +
				"\tpublic String bankCardNum;\n" +
				"\tpublic String reservedPhone;\n" +
				"\tpublic String smsCode;\n" +
		 */
		StringBuffer data = new StringBuffer();
		for (int i = 0; i < fields.size(); i++) {
			data.append("\t//");
			data.append(content.get(i));
			data.append("\n");
			data.append("\tpublic ");
			data.append(fieldsType.get(i));
			data.append(" ");
			data.append(fields.get(i));
			data.append(";//");
			data.append(fieldsDesc.get(i));
			data.append("\n");
		}
		String extendsClass = null;
		if (name == null) {
			return;
		}
		if (name.endsWith("Req")) {
			extendsClass = "BaseFinReq";
		} else if (name.endsWith("Resp")) {
			extendsClass = "BaseFinResp";
		}
		String javaStr = "public class  " + name + " extends " + extendsClass + " {\n" +
				"\t\n" +
				data +
				"}";
		System.out.println(javaStr);
		String path = "C:\\Users\\Administrator\\Desktop\\java2\\";
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + name + ".java"));
		writer.write(javaStr);
		writer.flush();
		writer.close();
	}

	public void writeJavaService() throws IOException {
		if (name == null || name.endsWith("Resp")){
			return;
		}
		String resp = name.replace("Req", "Resp");

		StringBuffer data = new StringBuffer();
		/*
		"\t\t\tString mobile = req.mobile;\n" +
		"\t\t\tString smsCode = req.smsCode;\n" +
		"\t\t\tString captchaId = captchaId(mobile);\n" +
		"\t\t\tif (StringUtils.isEmpty(captchaId)) {\n" +
		"\t\t\t\treturn respObj;\n" +
		"\t\t\t}\n" +
		"\t\t\tString bizParams = \"mobile=\" + mobile +
		\"&smsCode=\" + smsCode + \"&captchaId=\" + captchaId;\n" +
		 */
		for (int i = 0; i < fields.size(); i++) {
			data.append("\t\t\t");
			data.append(fieldsType.get(i));
			data.append(" ");
			data.append(fields.get(i));
			data.append(" = ");
			data.append("req.");
			data.append(fields.get(i));
			data.append(";");
			data.append("\n");
		}
		StringBuffer bizParams = new StringBuffer();
		data.append("\t\t\tString bizParams = ");
		for (int i = 0; i < fields.size(); i++) {
//			bizParams.append("\t\t\t");
			if (i==0) {
				data.append("\"");
			} else {
				data.append("\"");
				data.append("&");
			}
			data.append(fields.get(i));
			data.append("=\"");
			data.append("+");
			data.append(fields.get(i));
			if (i == fields.size()-1){
				data.append(";");
				data.append("\n");
			}else {
				data.append("+");
			}
		}
		String bizStr = new String(bizParams);
		String dataStr = new String(data);
		String serviceStr =
				"@Slf4j\n" +
						"@Component(\"api" + coreName + "Service\")\n" +
						"public class Api" + coreName + "Service extends BaseBqxdService implements ApiFin" + coreName + "Service {\n" +
						"\n" +
						"\t@Override\n" +
						"\tpublic " + resp + " " + coreName + "(" + name + " req) {\n" +
						"\t\t" + resp + " respObj = new " + resp + "();\n" +
						"\t\ttry {\n" +dataStr+
						"\t\t\t"+bizStr+
						"String urlParams = paramsWithSign(BqxdMethodEnum.SMS_VERIFY.method);\n" +
						"\t\t\tString url = reqUrl + \"/apis/jifen/verifyMessage?\" + urlParams;\n" +
						"\t\t\tlog.debug(\"----->BqxdApi**url:{}\", url);\n" +
						"\t\t\t//\n" +
						"\t\t\tString resp = httpPost(url, bizParams);\n" +
						"\t\t\tlog.debug(\"----->BqxdApi**url:{},resp:{}\", url, resp);\n" +
						"\t\t\tJSONObject json = JSONObject.parseObject(resp);\n" +
						"\t\t\tString code = json.getString(\"errorCode\");\n" +
						"\t\t\tif (apiSuccessCode.equals(code)) {\n" +
						"\t\t\t\trespObj.respCode = FinRespCodeEnum.SUCCESS;\n" +
						"\t\t\t\treturn respObj;\n" +
						"\t\t\t}\n" +
						"\t\t} catch (Exception e) {\n" +
						"\t\t\tlog.error(\"----->BqxdApi**fail,error:\", e);\n" +
						"\t\t}\n" +
						"\t\treturn respObj;\n" +
						"\t}\n" +
						"\n";
		System.out.println(bizStr+"================================================");
		System.out.println(serviceStr);
		String path = "C:\\Users\\Administrator\\Desktop\\service2\\";
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "Api" + coreName + "Service" + ".java"));
		writer.write(serviceStr);
		writer.flush();
		writer.close();

	}

	public void fieldsTypeToJavaType() {
		List<String> flieldsType = new ArrayList<>();
		for (String field : fieldsType) {
			/*varchar(4)
			varchar(200)
			varchar(64)
			varchar(64)
			varchar(40)
			varchar(80)
			varchar(64)
			Number(24,2)
			Number(24,2)
			varchar(32)
			varchar(32)
			varchar(32)
			array
			Varchar2(4)
			Number(24,2)
			*/
			if (field.toLowerCase().contains("varchar")) {
				flieldsType.add("String");
			} else if (field.toLowerCase().contains("number")) {
				flieldsType.add("float");
			} else {
				flieldsType.add(field);
			}
			this.fieldsType = flieldsType;
		}
	}
	//http://sit.baoqianxd.com:8010/apis/jifen/creditApply
	// ?timestamp=20180201155756300&guid=BQJFSD0001&serialNo=20180201155756116121&method=creditApply
	// &signature=CC5209BE34D68C4674892C897C27E7C7
	//http://sit.baoqianxd.com:8010/apis/jifen/creditApply
	// ?timestamp=20190123104623386&guid=BQJFSD0001&serialNo=20180123104623987658&method=creditApply
	// &signature=9A191C7C96FCF4CDB9975EC2A717B446
	@Override
	public String toString() {
		return "JavaClass{" +
				"fields=" + fields.toString() +
				", fieldsType=" + fieldsType.toString() +
				", fieldsDesc=" + fieldsDesc.toString() +
				'}';
	}
}
