package test;

import file.DateUtil;
import file.entity.OrderMassage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPhone {
	public static void main(String[] args) throws IOException {
		String filePath = "/Users/wangluyao/jf/123/src/main/java/test/mobile.txt";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
		String line = null;
		List<List<String>> lists = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			/*
			") "
			" ("
			 */
			line = line.replace("\"", "").replace(",", "");
			List<String> list = new ArrayList<>();
			String[] split = line.split(" \\(");
			for (String s : split) {
				String[] strings = s.split("\\) ");
				Collections.addAll(list, strings);
			}
			lists.add(list);
			System.out.println(line);
		}
		int size = lists.size();
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
//		for (int i = 0; i < size; i++) {
//			Row row = sheet.createRow(i);
//			int size1 = lists.get(i).size();
//			for (int j = 0; j < size1; j++) {
//				Cell cell = row.createCell(j, CellType.STRING);
//				cell.setCellValue(lists.get(i).get(j));
//			}
//		}
//		int iii = 0;
//		for (List<String> list : lists) {
//			for (int i = 0; i < list.size(); i++) {
//				if (i != 1) {
//					continue;
//				}
//				Row row = sheet.createRow(iii++);
//				String s = list.get(1);
//				String[] split = s.split(";");
//				for (int ii = 0; ii < split.length; ii++) {
//					Cell cell = row.createCell(ii);
//					cell.setCellValue(split[ii]);
//					String[] split1 = split[ii].split("/");
//					for (int j = 0; j < split1.length; j++) {
//						Cell cell2 = row.createCell(j + ii);
//						cell2.setCellValue(split1[j]);
//					}
//
//				}
//			}
//		}
//		String path = "/Users/wangluyao/aaa手机型号" + DateUtil.getNowTime() + ".xls";
//		OutputStream os = new FileOutputStream(path);
//		wb.write(os);
//		os.close();
//		wb.close();
	}

}

