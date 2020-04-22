package test2;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import utils.XWPFHelperTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class TestChangeDocTableStyle {
    public static void main(String[] args) throws IOException {
        XWPFDocument xwpf =
                new XWPFDocument(
                        new FileInputStream("C:\\Users\\wly\\Desktop\\2020-1-15智慧照明平台接口规范.docx")
                );//得到word文档的信息
//             List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();//得到段落信息
        Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格
        XWPFTable srcTable = null;
        int i = 0;
        while(it.hasNext()){
            i++;
            if (i == 2){
                srcTable = it.next();
            }
            if (srcTable != null){
                it.next().getCTTbl().setTblPr(srcTable.getCTTbl().getTblPr());
            }
        }
        xwpf.write(new FileOutputStream("C:\\Users\\wly\\Desktop\\112233.docx"));
    }
}
