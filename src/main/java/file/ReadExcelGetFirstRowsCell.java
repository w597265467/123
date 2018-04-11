package file;

import jdk.internal.util.xml.impl.Input;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ReadExcelGetFirstRowsCell {
    public static void main(String[] arg) throws IOException {
        InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\success\\迪信通_积分时代_天猫订单信息_20171214165200.xls");
        Workbook wb = new HSSFWorkbook(is);
        Sheet sheet = wb.getSheet("工作表1");
        Row row = sheet.getRow(1);
        int i = 0;
//        Iterator<Cell> iterator = row.iterator();
        for (Cell cell : row) {
            String strCell = null;
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_STRING:
                    strCell = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    strCell = String.valueOf(cell.getNumericCellValue());
                    if (strCell.contains("E")){
                        strCell = strCell.replace("E", "")
                                .replace(".", "");
                    }
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    strCell = String.valueOf(cell.getBooleanCellValue());
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    strCell = "";
                    break;
                default:
                    strCell = "";
                    break;
            }

            String str = new StringBuilder()
                    .append("Cell cell")
                    .append(i)
                    .append(" = row.createCell(")
                    .append(i)
                    .append(", CellType.STRING);\n")
                    .append("cell")
                    .append(i++)
                    .append(".setCellValue(\"")
                    .append(strCell)
                    .append("\");")
                    .toString();
            System.out.println(str);
        }
    }
}
