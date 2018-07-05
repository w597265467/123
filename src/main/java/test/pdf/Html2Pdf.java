package test.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.lowagie.text.pdf.BaseFont;
import lombok.extern.slf4j.Slf4j;
import sun.jvm.hotspot.opto.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;


@Slf4j
public class Html2Pdf {


	public static void main(String[] args){
	  html2Pdf("/Users/wangluyao/jf/consumer-finance/api/src/main/flt/bgd.html","/Users/wangluyao/jf/111.pdf");
	}

	public static void html2Pdf (String HTML,String filePath){
		try {
			File file = new File(filePath);
			if (file.exists()) {
				boolean delete = file.delete();
				if (!delete) return;
			}
			Document document = new Document();

//			URL url = new File("/Users/wangluyao/jf/1.png").toURI().toURL();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			Image cm = Image.getInstance("/Users/wangluyao/jf/123/file/1.png");
			cm.scaleAbsolute(107,34);
			document.add(cm);
			//加载字体
			XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider() {
				@Override
				public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, BaseColor color) {
					//log.debug("fontname:{},size:{},encoding:{},embedded:{},style:{},color:{}",fontname,size,encoding,embedded,style,color == null ? null : color.toString());
					String yaHeiFontName ="/Users/wangluyao/jf/123/font/simsun.ttc";
					yaHeiFontName += ",1";
					com.lowagie.text.Font yaHeiFont;
					Font font = null;
					try {
						font = new Font(com.itextpdf.text.pdf.BaseFont.createFont(yaHeiFontName, BaseFont.IDENTITY_H, embedded));
						font.setStyle(style);
						font.setColor(color);
						if (size>0){
							font.setSize(size);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return font;

				}
			};
			XMLWorkerHelper.getInstance().parseXHtml(writer, document,
					new FileInputStream(HTML), Charset.forName("UTF-8"),fontProvider);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
