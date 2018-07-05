package file;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RE3 {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("/Users/wangluyao/jf/用户选的手机777.xlsx");
		Workbook wb = new XSSFWorkbook(fis);

		Map<String, Row> map = new HashMap<>();
		String phones = "'18225918609'\n" +
				"'13823794686'\n" +
				"'18301655891'\n" +
				"'13910897107'\n" +
				"'15387205356'\n" +
				"'18011876088'\n" +
				"'18874898789'\n" +
				"'15726670199'\n" +
				"'15910541635'\n" +
				"'13910897104'\n" +
				"'13723899841'\n" +
				"'13520443807'\n" +
				"'13450489996'\n" +
				"'18231303412'\n" +
				"'15133326866'\n" +
				"'18713387077'\n" +
				"'18231331312'\n" +
				"'15030651025'\n" +
				"'15231381117'\n" +
				"'15081385858'\n" +
				"'15132324455'\n" +
				"'13810585811'\n" +
				"'13810582811'\n" +
				"'15132324456'\n" +
				"'13663236868'\n" +
				"'18231316663'\n" +
				"'13831336804'\n" +
				"'13831336807'\n" +
				"'15932358220'\n" +
				"'13552100216'\n" +
				"'15124514897'\n" +
				"'13601213158'\n" +
				"'15103338882'\n" +
				"'18210006971'\n" +
				"'15011462103'\n" +
				"'18002587777'\n" +
				"'13623136628'\n" +
				"'15031322658'\n" +
				"'13793265900'\n" +
				"'13975532176'\n" +
				"'13911887640'\n" +
				"'13633238192'\n" +
				"'13633238192'\n" +
				"'18713371544'\n" +
				"'18713371544'\n" +
				"'13730307376'\n" +
				"'15931354585'\n" +
				"'18732313536'\n" +
				"'15833238444'\n" +
				"'13785304999'\n" +
				"'13582410998'\n" +
				"'13833337812'\n" +
				"'15030304790'\n" +
				"'15030359346'\n" +
				"'15033607771'\n" +
				"'15132342016'\n" +
				"'15230344053'\n" +
				"'15803338881'\n" +
				"'15028353735'\n" +
				"'13785330884'\n" +
				"'15203230368'\n" +
				"'18831362525'\n" +
				"'18831362525'\n" +
				"'15003330555'\n" +
				"'15031325395'\n" +
				"'18331394417'\n" +
				"'13403337427'\n" +
				"'13722303337'\n" +
				"'15830338000'\n" +
				"'13722314817'\n" +
				"'15231377032'\n" +
				"'15297342584'\n" +
				"'18715957130'\n" +
				"'13810056313'\n" +
				"'13833336140'\n" +
				"'15830334044'\n" +
				"'13582431199'\n" +
				"'15030327705'\n" +
				"'15964770065'\n" +
				"'15964770035'\n" +
				"'13582630607'\n" +
				"'13780888288'\n" +
				"'13760888208'\n" +
				"'18731342046'\n" +
				"'18713323484'\n" +
				"'15028361676'\n" +
				"'18813674545'\n" +
				"'13831336434'\n" +
				"'15930315925'\n" +
				"'15803131672'\n" +
				"'15830376888'\n" +
				"'18831315577'\n" +
				"'13722309754'\n" +
				"'15932339620'\n" +
				"'13643238222'\n" +
				"'13473366000'\n" +
				"'15030382228'\n" +
				"'15233020333'\n" +
				"'18732371677'\n" +
				"'15932358988'\n" +
				"'15931358058'\n" +
				"'13663336864'\n" +
				"'15133313804'\n" +
				"'15930368157'\n" +
				"'15832302327'\n" +
				"'13630878988'\n" +
				"'15932393258'\n" +
				"'13472374579'\n" +
				"'13722300088'\n" +
				"'13831369753'\n" +
				"'15028415988'\n" +
				"'13463334855'\n" +
				"'13722350361'\n" +
				"'18214939840'\n" +
				"'15833239777'\n" +
				"'18231353949'\n" +
				"'13808480098'\n" +
				"'13785354880'\n" +
				"'15030353602'\n";

		for (Sheet rows : wb) {
			for (Row row : rows) {
				Cell cell = row.getCell(0);//trade_token
				String phone = getValue(cell);
				map.put(phone,row);
			}
		}

		String[] split = phones.replace("'","").split("\n");
		List<Row> list = new ArrayList<>();
		for (String s : split) {
			Row remove = map.remove(s);
			if (remove !=null) list.add(remove);
		}

		XSSFWorkbook sheets;
		{
			sheets = new XSSFWorkbook();
			XSSFSheet sheet = sheets.createSheet();
			XSSFRow row1 = sheet.createRow(0);
			row1.createCell(0).setCellValue("手机号");
			row1.createCell(1).setCellValue("机型");
			row1.createCell(2).setCellValue("套餐范围");
			int i = 1;
			for (Map.Entry<String, Row> entry : map.entrySet()) {
				Row value = entry.getValue();
				XSSFRow row = sheet.createRow(i++);
				row.createCell(0).setCellValue(getValue(value.getCell(0)));
				row.createCell(1).setCellValue(getValue(value.getCell(1)));
				row.createCell(2).setCellValue(getValue(value.getCell(2)));
			}
			sheets.write(new FileOutputStream("/Users/wangluyao/jf/用户选的手机四月.xlsx"));
		}
		{
			sheets = new XSSFWorkbook();
			XSSFSheet sheet = sheets.createSheet();
			XSSFRow row1 = sheet.createRow(0);
			row1.createCell(0).setCellValue("手机号");
			row1.createCell(1).setCellValue("机型");
			row1.createCell(2).setCellValue("套餐范围");
			int i = 1;
			for (Row value : list) {
				XSSFRow row = sheet.createRow(i++);
				if (value == null) continue;
				row.createCell(0).setCellValue(getValue(value.getCell(0)));
				row.createCell(1).setCellValue(getValue(value.getCell(1)));
				row.createCell(2).setCellValue(getValue(value.getCell(2)));
			}
			sheets.write(new FileOutputStream("/Users/wangluyao/jf/用户选的手机五月.xlsx"));
		}




	}


	public static String getValue(Cell cell){
		if(cell == null){
			return null;
		}
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


	private static class VoPhone {
		String token;
		String ip;
		String mobile;
		String phone;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			if (StringUtils.isEmpty(token)){
				return;
			}
			this.token = token;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			if (StringUtils.isEmpty(ip)){
				return;
			}
			this.ip = ip;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			if (StringUtils.isEmpty(mobile)){
				return;
			}
			this.mobile = mobile;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			if (StringUtils.isEmpty(phone)){
				return;
			}
			this.phone = phone;
		}
	}
}

class  Vo3 {
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
