package test2;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import utils.FileReadLine;
import utils.XWPFHelperTable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TestCreatDoc {
    public static void main(String[] args) throws IOException {
        List<String> strings = FileReadLine.readLine("D:\\project\\123\\src\\main\\resources\\json2.txt");
        List<RequestToMethodItem> requests = new ArrayList<>();
        for (String string : strings) {
            requests.add(JSONObject.parseObject(string,RequestToMethodItem.class));
        }
        XWPFDocument xwpfDocument = new XWPFDocument();
        for (RequestToMethodItem request : requests) {
            System.out.println(request);
            creatDoc(request,xwpfDocument);
        }
        xwpfDocument.write(new FileOutputStream("C:\\Users\\wly\\Desktop\\logs\\new"+System.currentTimeMillis()+".doc"));
    }

    private static void creatDoc(RequestToMethodItem request, XWPFDocument xwpfDocument) throws IOException {
        Class<?>[] methodParamTypes = request.methodParamTypes;
        XWPFTable table = xwpfDocument.createTable(15+methodParamTypes.length,6);
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        tblPr.getTblW().setType(STTblWidth.DXA);
        tblPr.getTblW().setW(new BigInteger("7000"));
        XWPFHelperTable xwpfHelperTable = new XWPFHelperTable();
        xwpfHelperTable.mergeCellsHorizontal(table,0,2,5);
        xwpfHelperTable.mergeCellsHorizontal(table,1,2,5);
        xwpfHelperTable.mergeCellsHorizontal(table,2,2,5);
        xwpfHelperTable.mergeCellsHorizontal(table,3,2,5);
        xwpfHelperTable.mergeCellsHorizontal(table,4,0,5);

        docTabelSetCell(table,0,0,"D9D9D9","接口方式");
        docTabelSetCell(table,1,0,"D9D9D9","数据流向");
        docTabelSetCell(table,2,0,"D9D9D9","数据频率");
        docTabelSetCell(table,3,0,"D9D9D9","接口描述");
        docTabelSetCell(table,4,0,"D9D9D9","参数定义");
        docTabelSetCell(table,5,0,"D9D9D9","接口地址");
        docTabelSetCell(table,6,0,"D9D9D9","请求方式");

        docTabelSetCell(table,0,1,"FFFFFF","TCP/IP");
        docTabelSetCell(table,1,1,"FFFFFF","运维服务器->前端");
        docTabelSetCell(table,2,1,"FFFFFF","用户操作时");
        docTabelSetCell(table,3,1,"FFFFFF","");
        docTabelSetCell(table,4,1,"FFFFFF","");
        docTabelSetCell(table,5,1,"FFFFFF",request.requestUrl);
        docTabelSetCell(table,6,1,"FFFFFF",request.requestType==null?"GET":request.requestType);

        docTabelSetCell(table,7,0,"D9D9D9","发送参数");
        docTabelSetCell(table,7,1,"D9D9D9","中文名称");
        docTabelSetCell(table,7,2,"D9D9D9","字段名称");
        docTabelSetCell(table,7,3,"D9D9D9","字段类型");
        docTabelSetCell(table,7,4,"D9D9D9","类型");
        docTabelSetCell(table,7,5,"D9D9D9","参数说明");
        int j = 8;
        String[] parameterNames = request.parameterNames;
        for (int i = 0; i < methodParamTypes.length; i++) {
            docTabelSetCell(table,j,1,"FFFFFF","");
            docTabelSetCell(table,j,2,"FFFFFF",parameterNames[i]);
            Class<?> methodParamType = methodParamTypes[i];
            String s = methodParamType == null ? "" : methodParamType.toString();
            docTabelSetCell(table,j,3,"FFFFFF", s);
            docTabelSetCell(table,j,4,"FFFFFF","must");
            docTabelSetCell(table,j,5,"FFFFFF","");
            j++;
        }
        xwpfHelperTable.mergeCellsHorizontal(table,j,3,4);
        docTabelSetCell(table,j,0,"D9D9D9","返回参数");
        docTabelSetCell(table,j,1,"D9D9D9","中文名称");
        docTabelSetCell(table,j,2,"D9D9D9","字段名称");
        docTabelSetCell(table,j,3,"D9D9D9","字段类型");
        docTabelSetCell(table,j,4,"D9D9D9","参数说明");

        docTabelSetCell(table,++j,1,"FFFFFF","");
        docTabelSetCell(table,++j,2,"FFFFFF","");
        docTabelSetCell(table,++j,3,"FFFFFF","");


        xwpfHelperTable.mergeCellsHorizontal(table,j,0,5);
        docTabelSetCell(table,++j,0,"D9D9D9","Json格式参考");
        xwpfHelperTable.mergeCellsHorizontal(table,j,1,5);
        docTabelSetCell(table,++j,0,"D9D9D9","发送参数");
        xwpfHelperTable.mergeCellsHorizontal(table,j,1,5);
        docTabelSetCell(table,++j,0,"D9D9D9","返回采纳数");
    }

    private static void docTabelSetCell(XWPFTable table, int rowIndx, int cellIndex, String colorRgb, String text) {
        XWPFTableRow row = table.getRow(rowIndx);
//        System.out.println(rowIndx);
        XWPFTableCell cell = row.getCell(cellIndex);
        cell.setColor(colorRgb);
        CTTcPr tcpr = cell.getCTTc().addNewTcPr();

        CTTblWidth cellw = tcpr.addNewTcW();

        cellw.setType(STTblWidth.DXA);

        cellw.setW(BigInteger.valueOf(360*5));
        cell.setText(text);
    }

}
