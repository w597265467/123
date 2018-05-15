package file;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CheckedOutputStream;

public class ReadExcelEnum {

	static int count = 0;
	static String step;
	static int count2 = 1;

	public static void main(String[] args) throws IOException {
		FileInputStream fs = new FileInputStream("/Users/wangluyao/用户action.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheetAt = wb.getSheetAt(0);//获取到工作表，因为一个excel可能有多个工作表
		int lastRowNum = sheetAt.getLastRowNum();
		List<ActionVo> list = new ArrayList<>();
		for (int i = 0; i <= lastRowNum; i++) {
			XSSFRow row = sheetAt.getRow(i);
			ActionVo actionVo = new ActionVo();

			actionVo.actionUrl = row.getCell(0).getStringCellValue();
			actionVo.actionName = row.getCell(1).getStringCellValue();
			actionVo.acitonStep = row.getCell(2).getStringCellValue();
			actionVo.id = (int) row.getCell(3).getNumericCellValue();
			list.add(actionVo);
		}
		Collections.sort(list);
		for (ActionVo actionVo : list) {
			printEnum(actionVo);
		}

	}

	/*
	public int id;
	public int stepId;
	public String stepDesc;
	public String action;
	public String actionDesc;
	 */
	public static void printEnum(ActionVo vo){
		String actionUrl = vo.actionUrl;
		int setpId = vo.id*100;
		setpId(vo.acitonStep);
		int id = setpId+count2++;
		String stepDesc = vo.acitonStep;
		String action = actionUrl;
		String actionDesc = vo.actionName;
		if (!chainese(actionUrl)){
			actionUrl = actionUrl.substring(1, actionUrl.length()).replace("/", "_").toUpperCase();
		}else {
			if (actionUrl.equals("授信-绑卡")){
				actionUrl =  "CFIN_BANK";
			}else if (actionUrl.equals("订单详情")){
				actionUrl = "ORDER_DETAIL";
			}else if (actionUrl.equals("授信-关联亲属")){
				actionUrl = "CREDIT_PRE_FAMILY";
			}else if (actionUrl.equals("授信-实人")){
				actionUrl = "CFIN_CREDIT_FACE";
			}
		}

		StringBuffer e = new StringBuffer();
		e.append(actionUrl).append("(").append(id).append(",").append(setpId).append(",\"").append(stepDesc).append("\",\"").append(action).append("\",\"").append(actionDesc).append("\"),");
		System.out.println(e);


	}

	private static boolean chainese(String actionUrl) {
		Pattern compile = Pattern.compile("[\\u4e00-\\u9fa5]");
		Matcher matcher = compile.matcher(actionUrl);
		return matcher.find();
	}

	public static void setpId(String step){
		if (!StringUtils.equals(step,ReadExcelEnum.step)){
			ReadExcelEnum.step = step;
			count2 = 1;
		}
	}


}
class ActionVo implements Comparable{
	public String actionUrl;
	public String actionName;
	public String acitonStep;
	public int id;


//	@Override
//	public int compareTo(Object o) {
//		ActionVo vo = (ActionVo) o;
//
//
//		return vo.code()-code();
//	}
	@Override
	public int compareTo(Object o) {
		ActionVo vo = (ActionVo) o;


		return id-vo.id;
	}

//	private int code(){
//		int i = acitonStep.charAt(0);
//		return i;
//	}
}
