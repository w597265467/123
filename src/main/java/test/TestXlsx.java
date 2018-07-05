package test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class TestXlsx {
	public static void main(String[] args) {
		//16
		//   /Users/wangluyao/jf/17、张家口信用购机问卷6.xlsx
		try {
			long l = Runtime.getRuntime().totalMemory();
			FileInputStream fis = new FileInputStream("/Users/wangluyao/jf/wenjuan.xlsx");
			long l2 = Runtime.getRuntime().totalMemory();
			Workbook wb = new XSSFWorkbook(fis);
			long l3 = Runtime.getRuntime().totalMemory();
			Sheet sheetAt = wb.getSheetAt(0);
			for (Row cells : sheetAt) {
				Cell cell = cells.getCell(16);
				int cellType = cell.getCellType();
				String s = null;
				switch (cellType) {
					case XSSFCell.CELL_TYPE_BLANK:
						System.out.println("null");
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						s = String.valueOf(cell.getBooleanCellValue());
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						s = String.valueOf(cell.getNumericCellValue());
						break;
					case XSSFCell.CELL_TYPE_STRING:
						s = String.valueOf(cell.getStringCellValue());
						break;
					case XSSFCell.CELL_TYPE_ERROR:
						s = String.valueOf(cell.getErrorCellValue());
						break;
					case XSSFCell.CELL_TYPE_FORMULA:
						s = String.valueOf(cell.getCellFormula());
						break;
				}
			}
			System.out.println("l2-l = "+(l2-l));
			System.out.println("l3-l2 = "+(l3-l2));

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}


