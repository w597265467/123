package file;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {
	public static void main(String[] args) throws IOException {

//		/Users/wangluyao/Downloads
		FileInputStream fis = new FileInputStream("/Users/wangluyao/Downloads/积分时代员工通讯录0417.xls");
		POIFSFileSystem ps = new POIFSFileSystem(fis);  //使用POI提供的方法得到excel的信息
		HSSFWorkbook wb = new HSSFWorkbook(ps);
		HSSFSheet sheetAt = wb.getSheetAt(0);//获取到工作表，因为一个excel可能有多个工作表
		int lastRowNum = sheetAt.getLastRowNum();
		Map<String,Vo> map = new HashMap<>();
		for (int i = 1; i < lastRowNum; i++) {
			Vo vo = new Vo();
			HSSFRow row = sheetAt.getRow(i);
			vo.id = getValue(row.getCell(0));
			vo.department = getValue(row.getCell(1));
			vo.position = getValue(row.getCell(2));
			vo.name = getValue(row.getCell(3));
			vo.phone = getValue(row.getCell(4));
			vo.email = getValue(row.getCell(5));
			map.put(vo.phone,vo);
		}
		String phone = "18711019805,13911383010,18011876088,18673371607,15811070023,15388950103,15973125292,15116388715,13910416083,13636035190,13810056313,13808480098,18618462333,13787139810,13511021286,13921675237,13875893681,13823794686,15097399868,18874891388,15074993731,15110263493,13917560653,13681076740,15901297064,13657498933,13466390123,18873041823,13910897107,15111401446,15815838019,18574398617,15111197300,13811236600,18301655891,13787002310,13974875548,18233289782,18898566899,13701164402,13875892981,15073138350,15367311162,15874051322,13574116399,13450489996,13718880820,18073195010,18911097275,15811335592,15011462103,15910541635,13911887649,18271265712,13693673642,13716327099,13811502317,15979212331,13723899841,15111401445,18229704864,13718919792,13910723765,13520443807,18823738758,13810582811,13677350045,15726670199,13693642762,13975532176,15116323273,13632877984,13640944902,13601213158,13552607952,13787003210,13930562377,18573037097,15974130420,13601376363,18011928188,13910477758,13910863755,13508485680,18974941335";
		String[] phones = phone.split(",");
		for (String s : JdbcUtils.userPhones()) {
			Vo remove = map.remove(s);
			System.out.println("已测试:phone="+s+"===="+remove);
		}


		for (String s : phones) {
			Vo vo = map.get(s);
			if (vo != null)
			System.out.println("未测试:phone="+s+"==="+ vo);
		}
	}


	public static String getValue(Cell cell){
		CellType cellTypeEnum = cell.getCellTypeEnum();
		switch (cellTypeEnum){
			case STRING:return cell.getStringCellValue();
			case BLANK:return null;
			case BOOLEAN:return String.valueOf(cell.getBooleanCellValue());
			case _NONE:return null;
			case NUMERIC:{
				BigDecimal bigDecimal = new BigDecimal(String.valueOf(cell.getNumericCellValue()));
				long l = bigDecimal.longValue();

				return String.valueOf(l);
			}
			case FORMULA:return String.valueOf(cell.getCellFormula());
			case ERROR:return String.valueOf(cell.getErrorCellValue());
			
		}
		return null;
	}
	
	
}
class  Vo {
	//序号	部门	职位	姓名	手机	邮箱
	public String id;
	public String department;
	public String position;
	public String name ;
	public String phone;
	public String email;

	@Override
	public String toString() {
		return "Vo{" +
				"id='" + id + '\'' +
				", department='" + department + '\'' +
				", position='" + position + '\'' +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
