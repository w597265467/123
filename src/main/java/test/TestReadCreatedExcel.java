package test;

import model.Table;
import model.TableColumn;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.apache.poi.ss.usermodel.CellType.*;

public class TestReadCreatedExcel {

    public static void main(String[] args) throws IOException {
        ArrayList<Table> tables = readExcelx("D:\\project\\123\\src\\main\\resources\\1.xlsx");
        XWPFDocument xwpfDocument = new XWPFDocument();
        wordTable(tables,xwpfDocument);



    }

    public static void wordTable(ArrayList<Table> tables, XWPFDocument xwpfDocument) throws IOException {
        for (Table table : tables) {
            XWPFParagraph paragraph = xwpfDocument.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(table.tableName);
            XWPFTable xwpfTable = xwpfDocument.createTable(table.columnList.size()+1,7);
            XWPFTableRow rowHeader = xwpfTable.getRow(0);
            XWPFTableCell xwpfTableCell0 = rowHeader.getCell(0);
            XWPFTableCell xwpfTableCell1 = rowHeader.getCell(1);
            XWPFTableCell xwpfTableCell2 = rowHeader.getCell(2);
            XWPFTableCell xwpfTableCell3 = rowHeader.getCell(3);
            XWPFTableCell xwpfTableCell4 = rowHeader.getCell(4);
            XWPFTableCell xwpfTableCell5 = rowHeader.getCell(5);
            XWPFTableCell xwpfTableCell6 = rowHeader.getCell(6);
            //columnName;
            //columnType;
            //dataType;
            //characterMaximumLength;
            //isNullable;
            //columnDefault;
            //columnComment;
            xwpfTableCell0.setText("列名");
            xwpfTableCell1.setText("类型");
            xwpfTableCell2.setText("数据类型");
            xwpfTableCell3.setText("数据长度");
            xwpfTableCell4.setText("可为空");
            xwpfTableCell5.setText("默认值");
            xwpfTableCell6.setText("注释");
            int i = 1;
            for (TableColumn tableColumn : table.columnList) {
                XWPFTableRow row = xwpfTable.getRow(i++);
                row.setHeight(20);
                XWPFTableCell cell0 = row.getCell(0);;
                XWPFTableCell cell1 = row.getCell(1);;
                XWPFTableCell cell2 = row.getCell(2);;
                XWPFTableCell cell3 = row.getCell(3);;
                XWPFTableCell cell4 = row.getCell(4);;
                XWPFTableCell cell5 = row.getCell(5);;
                XWPFTableCell cell6 = row.getCell(6);;
                //columnName;
                //columnType;
                //dataType;
                //characterMaximumLength;
                //isNullable;
                //columnDefault;
                //columnComment;
                cell0.setText(tableColumn.columnName);
                cell1.setText(tableColumn.columnType);
                cell2.setText(tableColumn.dataType);
                cell3.setText(tableColumn.characterMaximumLength);
                cell4.setText(tableColumn.isNullable);
                cell5.setText(tableColumn.columnDefault);
                cell6.setText(tableColumn.columnComment);
            }
        }
        xwpfDocument.write(new FileOutputStream("D:\\project\\123\\src\\main\\resources\\"+System.currentTimeMillis()+".doc"));
    }


    public static ArrayList<Table> readExcel(String filePath) throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
        Sheet sheet0 = workbook.getSheet("sheet0");
        ArrayList<Table> tables = new ArrayList<>();
        String tableName = "";
        Table table = null;
        for (int i = 1; i < sheet0.getPhysicalNumberOfRows(); i++) {
            Row row = sheet0.getRow(i);
            //0 tableName;
            //1 columnName;
            //2 columnType;
            //3 dataType;
            //4 characterMaximumLength;
            //5 isNullable;
            //6 columnDefault;
            //7 columnComment;
            Cell cell0 = row.getCell(0);
            String tableNameExcl = cell0.getStringCellValue();
            if (!tableNameExcl.equals(tableName) || table == null){
                if (table != null){
                    tables.add(table);
                }
                tableName = tableNameExcl;
                table = new Table();
            }
            Cell cell1 = row.getCell(1);
            Cell cell2 = row.getCell(2);
            Cell cell3 = row.getCell(3);
            Cell cell4 = row.getCell(4);
            Cell cell5 = row.getCell(5);
            Cell cell6 = row.getCell(6);
            Cell cell7 = row.getCell(7);
            table.columnList.add(new TableColumn(
                    cell1 == null ? null:cell1.getStringCellValue(),
                    cell2 == null ? null:cell2.getStringCellValue(),
                    cell3 == null ? null:cell3.getStringCellValue(),
                    cell4 == null ? null:cell4.getStringCellValue(),
                    cell5 == null ? null:cell5.getStringCellValue(),
                    cell6 == null ? null:cell6.getStringCellValue(),
                    cell7 == null ? null:cell7.getStringCellValue()
            ));
        }
        return tables;
    }
    public static ArrayList<Table> readExcelx(String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        Sheet sheet0 = workbook.getSheet("sheet2");
        ArrayList<Table> tables = new ArrayList<>();
        String tableName = "";
        Table table = null;
        for (int i = 1; i < sheet0.getPhysicalNumberOfRows(); i++) {
            Row row = sheet0.getRow(i);
            //0 tableName;
            //1 columnName;
            //2 columnType;
            //3 dataType;
            //4 characterMaximumLength;
            //5 isNullable;
            //6 columnDefault;
            //7 columnComment;
            Cell cell0 = row.getCell(0);
            String tableNameExcl = cell0.getStringCellValue();
            if (!tableNameExcl.equals(tableName) || table == null){
                if (table != null){
                    tables.add(table);
                }
                tableName = tableNameExcl;
                table = new Table();
                table.tableName = tableName;
            }
            Cell cell1 = row.getCell(1);
            Cell cell2 = row.getCell(2);
            Cell cell3 = row.getCell(3);
            Cell cell4 = row.getCell(4);
            String length = getString(cell4);


            Cell cell5 = row.getCell(5);
            Cell cell6 = row.getCell(6);
            String columnDefault = getString(cell6);
            Cell cell7 = row.getCell(7);
            table.columnList.add(new TableColumn(
                    cell1 == null ? null:cell1.getStringCellValue(),
                    cell2 == null ? null:cell2.getStringCellValue(),
                    cell3 == null ? null:cell3.getStringCellValue(),
                    length,
                    cell5 == null ? null:cell5.getStringCellValue(),
                    columnDefault,
                    cell7 == null ? null:cell7.getStringCellValue()));
        }
        return tables;
    }

    private static String getString(Cell cell4) {
        String value = "";
        if (cell4 != null){
            CellType cellTypeEnum = cell4.getCellTypeEnum();
            if (cellTypeEnum == STRING){
                value = cell4.getStringCellValue();
            }
            if (cellTypeEnum == NUMERIC){
                value = String.valueOf(cell4.getNumericCellValue());
            }
        }
        return value;
    }
}
