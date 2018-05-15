package test.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class TestPdf {

	public static void main(String[] args) throws IOException, DocumentException {


//		BaseFont baseFont = BaseFont.createFont("/Users/wangluyao/jf/123/font/simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//		String outPath = "test.pdf";//DataUtil.createTempPath(".pdf");
//
//		Font font = new Font(baseFont);
//
//		//设置纸张
//		Rectangle rect = new Rectangle(PageSize.A4);
//
//		//创建文档实例
//		Document doc=new Document(rect);
//
//		File file = new File(outPath);
//
//		System.out.println(file.getAbsolutePath());
//
//		PdfWriter.getInstance(doc, new FileOutputStream(file));
//
//		doc.open();
//		doc.newPage();
//
//		//段落
//		Paragraph p1 = new Paragraph();
//		//短语
//		Phrase ph1 = new Phrase();
//		//块
//		Chunk c1 = new Chunk("*********", font) ;
//		Chunk c11 = new Chunk("（信用报告提供机构l ogo）", font) ;
//		//将块添加到短语
//		ph1.add(c1);
//		ph1.add(c11);
//		//将短语添加到段落
//		p1.add(ph1);
//		//将段落添加到短语
//		doc.add(p1);
		createPDF("1.pdf");

	}

	public static void createPDF(String path) {
		try {
			Rectangle rectPageSize = new Rectangle(PageSize.A4);// A4纸张
			Document document = new Document(rectPageSize, 40, 40, 40, 40);// 上、下、左、右间距

			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			OutputStream outputStream = new FileOutputStream(file);

			PdfWriter.getInstance(document, outputStream);
			document.open();

			// 字体
			Font font = new Font();
			font.setFamily("STSongStd-Light");
			//font.setFamily("Droid Sans");
//			font.setColor(BaseColor.BLUE);// 颜色
			font.setSize(40);

			Paragraph content = new Paragraph("PDF", font);
			content.setAlignment(Paragraph.ALIGN_MIDDLE);
			document.add(content);

			// 使用微软雅黑字体显示中文
			String yaHeiFontName ="/Users/wangluyao/jf/123/font/msyhl.ttc";
			yaHeiFontName += ",1";
			Font yaHeiFont = new Font(BaseFont.createFont(yaHeiFontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED));//中文简体

			// 添加一行包含中文的信息到PDF测试
			String info = "默认的iText字体设置不支持中文字体，需要下载远东字体包iTextAsian.jar，否则不能往PDF文档中输出中文字体。\n　iText的安装非常方便，在http://www.lowagie.com/iText/download.html - download 网站上下载iText.jar文件后，只需要在系统的CLASSPATH中加入iText.jar的路径，在程序中就可以使用iText类库了。\n 本地化测试包括繁体\n本地化測試包括繁體";
			Paragraph content1=null;
				content1 = new Paragraph(info, yaHeiFont);// 使用微软雅黑字体


			content1.setAlignment(Paragraph.ALIGN_MIDDLE);
			document.add(content1);

			for (int i=0; i<100; i++) {// 随意加一些内容
				document.add(new Paragraph("Hello World, iText"));
				document.add(new Paragraph(new Date().toString()));
			}
			document.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
