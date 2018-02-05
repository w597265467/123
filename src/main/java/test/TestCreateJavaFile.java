package test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCreateJavaFile {
	public static void main(String[] arg) throws IOException {
		TestCreateJavaFile testCreateJavaFile = new TestCreateJavaFile();
		testCreateJavaFile.doSomething("data dictionary.xlsx");

	}

	public void doSomething(String fileName) throws IOException {
//		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\city.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\" + fileName);
		Workbook wb = new XSSFWorkbook(fis);
		List<Data> list = new ArrayList<>();
		for (Sheet sheet : wb) {
			for (Row row : sheet) {
				Data data = new Data();
				for (int i = 0; i < 4; i++) {
					Cell cell = row.getCell(i);
					int cellType = cell.getCellType();
					String s = null;
					switch (cellType) {
						case XSSFCell.CELL_TYPE_BLANK:
							System.out.println("null");
							break;
						case XSSFCell.CELL_TYPE_BOOLEAN:
							s = String.valueOf(cell.getBooleanCellValue());
							System.out.print("\"" + cell.getBooleanCellValue() + "\",");
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							s = String.valueOf(cell.getNumericCellValue());
							System.out.print("\"" + cell.getNumericCellValue() + "\",");
							break;
						case XSSFCell.CELL_TYPE_STRING:
							s = String.valueOf(cell.getStringCellValue());
							System.out.print("\"" + cell.getStringCellValue() + "\",");
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							s = String.valueOf(cell.getErrorCellValue());
							System.out.print("\"" + cell.getErrorCellValue() + "\",");
							break;
						case XSSFCell.CELL_TYPE_FORMULA:
							s = String.valueOf(cell.getCellFormula());
							System.out.print("\"" + cell.getCellFormula() + "\",");
							break;
					}
					switch (i) {
						case 0:
							data.type = s;
							break;
						case 1:
							data.typrDesc = s;
							break;
						case 2:
							data.name = s;
							break;
						case 3:
							data.nameDesc = s;
							break;
					}
				}
				list.add(data);
				System.out.println();
			}
		}
		Map<String, Integer> countMap = new HashMap<>();
		for (Data data : list) {
//			System.out.println(data.type);
			Integer integer = countMap.get(data.type);
			if (integer == null) {
				countMap.put(data.type, 1);
			} else {
				countMap.put(data.type, integer + 1);
			}
		}
		List<Enum> enums = new ArrayList<>();
		for (String s : countMap.keySet()) {
			if (countMap.get(s) > 1) {
				Enum anEnum = new Enum();
				anEnum.name = s;
				anEnum.datas.addAll(getAllData(list, s));
				enums.add(anEnum);
			}
		}
		System.out.println(enums.size());
		for (Enum anEnum : enums) {
//			System.out.println(anEnum.name);
//			for (Data data : anEnum.datas) {
//				System.out.println(data);
//			}
			String path = "C:\\Users\\Administrator\\Desktop\\file\\";
			String enumFile = anEnum.getEnum();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path + anEnum.filName));
			writer.write(enumFile);
			writer.flush();
			writer.close();
		}


	}

	private List<Data> getAllData(List<Data> list, String s) {
		List<Data> dataList = new ArrayList<>();
		for (Data data : list) {
			if (data.type.equals(s))
				dataList.add(data);
		}
		return dataList;
	}
}

class Enum {
	String name;
	List<Data> datas = new ArrayList<Data>();
	String filName;

	public String getEnum() {
		StringBuffer a = new StringBuffer();
		for (Data data : datas) {
			//SMS_SEND("sendMessage", "发送短信")
			a.append(data.name.toUpperCase().replace("\'",""));
			a.append("(");
			a.append("\"");
			a.append(data.name.toUpperCase());
			a.append("\",\"");
			a.append(data.nameDesc);
			a.append("\"");
			a.append("),\n\t");
		}
		a.append(";\n");
		String dataString = new String(a);
		String enumName = null;
		String[] split = name.toLowerCase().split("_");
		if (split.length > 1) {
			enumName = firstUperCase(split[0]) + firstUperCase(split[1]);
		} else {
			enumName = firstUperCase(split[0]);
		}
		enumName = "BqxdData" + enumName + "Enum";
		filName = enumName + ".java";
		String comment = datas.get(0).typrDesc;
		String result = "//" + comment
				+ "\npublic enum " +
				enumName +
				" {\n\t" + dataString +
				"\tpublic String name;\n" +
				"\tpublic String desc;\n" +
				"\n" +
				"\tprivate "+enumName+"(String name, String desc) {\n" +
				"\t\tthis.name = name;\n" +
				"\t\tthis.desc = desc;\n" +
				"\t}\n}";
		System.out.println(result);
		return result;
	}

	private String firstUperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}

class Data {
	//	"字段类型","类型描述","代码项","代码项描述",
	String type;
	String typrDesc;
	String name;
	String nameDesc;

	@Override
	public String toString() {
		return "Data{" +
				"type='" + type + '\'' +
				", typrDesc='" + typrDesc + '\'' +
				", name='" + name + '\'' +
				", nameDesc='" + nameDesc + '\'' +
				'}';
	}
}
