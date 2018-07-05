package file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

public class CreateXlsFromJsonFile2 {

	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("/Users/wangluyao/导出数据.json");
		Reader reader = new InputStreamReader(is);
		BufferedReader strReader = new BufferedReader(reader);
		StringBuilder stringBuilder = new StringBuilder();
		while (true) {
			String data;
			if ((data = strReader.readLine()) == null) break;
			stringBuilder.append(data);
		}
		String s = stringBuilder.toString();
		JSONArray jsonArray = JSONObject.parseArray(s);

		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(0);
		createRowNo1(row);
		int size = jsonArray.size();
		for (int i = 0; i < size; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			row = sheet.createRow(i + 1);
			int j = 0;

			row.createCell(j++).setCellValue(jsonObject.getString("手机号"));
			row.createCell(j++).setCellValue(jsonObject.getString("姓名"));
			row.createCell(j++).setCellValue(jsonObject.getString("身份证号"));
//			row.createCell(j++).setCellValue(jsonObject.getString("银行卡号"));
//			row.createCell(j++).setCellValue(jsonObject.getString("邮箱"));
//			row.createCell(j++).setCellValue(jsonObject.getString("额度"));
//			row.createCell(j++).setCellValue(jsonObject.getString("贷款期数"));
//			row.createCell(j++).setCellValue(jsonObject.getString("学历").replace("高中","高中及以下"));
//			row.createCell(j++).setCellValue(jsonObject.getString("婚姻状况"));
////			row.createCell(j++).setCellValue(jsonObject.getString("年收入"));
//			row.createCell(j++).setCellValue("");
//			row.createCell(j++).setCellValue(jsonObject.getString("公司名称"));
////			row.createCell(j++).setCellValue(jsonObject.getString("家庭住址"));
//			row.createCell(j++).setCellValue("");
//			row.createCell(j++).setCellValue(jsonObject.getString("公司地址"));
//			row.createCell(j++).setCellValue(jsonObject.getString("户籍地址"));
//			row.createCell(j++).setCellValue(jsonObject.getString("申请地址"));
//			String string = jsonObject.getString("公司座机");
//			if (StringUtils.isEmpty(string) || string.startsWith("1")){
//				string = "";
//			}
//			row.createCell(j++).setCellValue(string);
////			row.createCell(j++).setCellValue(jsonObject.getString("家庭座机"));
//			row.createCell(j++).setCellValue(jsonObject.getString(""));
//			String fn = jsonObject.getString("联系人1姓名");
//			if(StringUtils.isEmpty(fn)){
//				row.createCell(j++).setCellValue("");
//				row.createCell(j++).setCellValue("");
//				row.createCell(j).setCellValue("");
//			}else {
//				row.createCell(j++).setCellValue(jsonObject.getString("联系人1姓名"));
//				row.createCell(j++).setCellValue(jsonObject.getString("联系人1手机"));
//				row.createCell(j).setCellValue(jsonObject.getString("联系人1关系").replace("夫妻","配偶"));
//			}
		}
		String dateStr = DateUtil.getNowTime();
		String filePath = "/Users/wangluyao/Desktop/导出用户数据" + dateStr + ".xls";
		OutputStream os = new FileOutputStream(filePath);
		wb.write(os);
		os.close();
		wb.close();

	}

	private static void createRowNo1(Row row) {
		//{
		int i = 0;
//		"姓名" : null,
		row.createCell(i++).setCellValue("手机号");
//		"手机号" : "i++5030353602",
		row.createCell(i++).setCellValue("姓名");
//		"身份证号" : null,
		row.createCell(i++).setCellValue("身份证号");
//		"银行卡号" : null,
//		row.createCell(i++).setCellValue("银行卡号");
////		"邮箱" : null,
//		row.createCell(i++).setCellValue("邮箱");
////		"额度" : null,
//		row.createCell(i++).setCellValue("额度");
////		"贷款期数" : null,
//		row.createCell(i++).setCellValue("贷款期数");
////		"学历" : null,
//		row.createCell(i++).setCellValue("学历");
////		"婚姻状况" : null,
//		row.createCell(i++).setCellValue("婚姻状况");
////		"年收入" : i++00000,
//		row.createCell(i++).setCellValue("年收入");
////		"公司名称" : null,
//		row.createCell(i++).setCellValue("公司名称");
////		"家庭住址" : null,
//		row.createCell(i++).setCellValue("家庭住址");
////		"公司地址" : null,
//		row.createCell(i++).setCellValue("公司地址");
////		"户籍地址" : null,
//		row.createCell(i++).setCellValue("户籍地址");
////		"申请地址" : null,
//		row.createCell(i++).setCellValue("申请地址");
////		"公司座机" : null,
//		row.createCell(i++).setCellValue("公司座机");
////		"家庭座机" : "家庭座机",
//		row.createCell(i++).setCellValue("家庭座机");
////		"联系人1姓名" : null,
//		row.createCell(i++).setCellValue("联系人1姓名");
////		"联系人1手机" : null,
//		row.createCell(i++).setCellValue("联系人1手机");
////		"联系人1关系" : "其他"
//		row.createCell(i).setCellValue("联系人1关系");
//	}
	}


}
