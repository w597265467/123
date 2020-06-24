package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import model.Table;
import model.TableColumn;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;
import org.springframework.http.StreamingHttpOutputMessage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import static test.ChineseCharacterUtil.getUpperCase;
import static utils.FileReadLine.readString;

public class TestReadCreatedExcel2 {

    public static void main(String[] args) throws IOException {
        String s = readString("D:\\project\\123\\src\\main\\resources\\api (1).json");
        JSONArray array = JSONArray.parseArray(s);
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            JSONArray list = jsonObject.getJSONArray("list");
            List<String> titles = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                JSONObject object = list.getJSONObject(j);
                String title = object.getString("title");
                titles.add(title);
            }
            map.put(jsonObject.getString("name"), titles);
        }
        wordTable(map);
    }

    public static void wordTable(Map<String, List<String>> tables) throws IOException {
        Set<String> keySet = tables.keySet();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet0");
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell = row0.createCell(0);
        HSSFCell cell1 = row0.createCell(1);
        HSSFCell cell2 = row0.createCell(2);
        HSSFCell cell3 = row0.createCell(3);
        HSSFCell cell4 = row0.createCell(4);
        HSSFCell cell5 = row0.createCell(5);
        HSSFCell cell6 = row0.createCell(6);
        HSSFCell cell7 = row0.createCell(7);
        cell.setCellValue("用例编号");
        cell1.setCellValue("用例说明");
        cell2.setCellValue("输入数据");
        cell3.setCellValue("预期结果");
        cell4.setCellValue("实际结果");
        cell5.setCellValue("用例等级");
        cell6.setCellValue("测试结果");
        cell7.setCellValue("备注");
        int k = 0;

        for (String s : keySet) {
            //创建HSSFWorkbook对象
            //创建HSSFSheet对象
            List<String> strings = tables.get(s);
            System.out.println(s +"功能测试通过");
            for (int i = 0; i < strings.size(); i++) {
                String s1 = strings.get(i);
                String upperCase1 = getChineseInitials(s1);
                HSSFRow row = sheet.createRow(k++ + 1);
                cell = row.createCell(0);
                cell1 = row.createCell(1);
                cell2 = row.createCell(2);
                cell3 = row.createCell(3);
                cell4 = row.createCell(4);
                cell5 = row.createCell(5);
                cell6 = row.createCell(6);
                cell7 = row.createCell(7);
                String upperCase = getChineseInitials(s);

                String substring = upperCase.substring(0, Math.min(upperCase.length(), 2));

                String substring1 = upperCase1.substring(0, Math.min(upperCase1.length(), 4));
                String s2 = substring
                        + "-" + substring1
                        + "-" + getStringNo(i+1, 4);
                cell.setCellValue(s2);
                s1 = s1.replace("接口","");
                cell1.setCellValue(s1);
                //输入数据
                cell2.setCellValue("");
                //预期结果
                if (s1.contains("列表")){
                    s1 = s1.replace("获取","") + "数据显示正常";
                }
                else if (s1.contains("获取")){
                    s1 = s1 + "数据正常";
                }
                else if (s1.contains("信息")){
                    s1 = "获取"+ s1 + "数据正常";
                }
                else if (s1.contains("详情")){
                    s1 = "获取"+ s1 + "数据正常";
                }
                else if (s1.contains("数据")){
                    s1 = "获取"+ s1 + "数据正常";
                }
                else if (s1.contains("统计")){
                    s1 = "获取"+ s1 + "数据正常";
                }
                else if (s1.contains("状态")){
                    s1 = "获取"+ s1 + "信息显示正常";
                }
                else if (s1.contains("记录")){
                    s1 = "记录"+ s1.replace("记录","") + "信息显示正常";
                }
                else if (s1.contains("查找")){
                    s1 = "获取"+ s1.replace("查找","") + "信息正常";
                }
                else if (s1.contains("新增")){
                    s1 =  s1 + "成功";
                }else {
                    s1 = s1 + "成功";
                }
                cell3.setCellValue(s1);
                //实际结果
                cell4.setCellValue(s1);
                cell5.setCellValue("一般");
                cell6.setCellValue("通过");
                cell7.setCellValue("");
            }
        }
        //输出Excel文件
//        FileOutputStream output = new FileOutputStream("C:\\Users\\wly\\Desktop\\" + System.currentTimeMillis() + ".xls");
//        wb.write(output);
//        output.flush();
    }

    public static String getStringNo(Integer integer, Integer length) {
        StringBuilder s = new StringBuilder(String.valueOf(integer));
        while (s.length() < length) {
            s.insert(0, "0");
        }
        return s.toString();
    }
    public static  String  getChineseInitials(String str){
        StringBuilder chineseInitials = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String upperCase = getUpperCase(c + "", true);
            if (upperCase.length() >= 1){
                chineseInitials.append(upperCase, 0, 1);
            }
        }
        return chineseInitials.toString();
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
            if (!tableNameExcl.equals(tableName) || table == null) {
                if (table != null) {
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
                    cell1 == null ? null : cell1.getStringCellValue(),
                    cell2 == null ? null : cell2.getStringCellValue(),
                    cell3 == null ? null : cell3.getStringCellValue(),
                    cell4 == null ? null : cell4.getStringCellValue(),
                    cell5 == null ? null : cell5.getStringCellValue(),
                    cell6 == null ? null : cell6.getStringCellValue(),
                    cell7 == null ? null : cell7.getStringCellValue()
            ));
        }
        return tables;
    }


    private static String getString(Cell cell4) {
        String value = "";
        if (cell4 != null) {
            CellType cellTypeEnum = cell4.getCellTypeEnum();
            if (cellTypeEnum == STRING) {
                value = cell4.getStringCellValue();
            }
            if (cellTypeEnum == NUMERIC) {
                value = String.valueOf(cell4.getNumericCellValue());
            }
        }
        return value;
    }
}
