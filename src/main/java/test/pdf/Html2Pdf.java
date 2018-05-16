package test.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.lowagie.text.pdf.BaseFont;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;


@Slf4j
public class Html2Pdf {

	public static void html2Pdf (String HTML,String file){
		try {
			File file1 = new File(file);
			if (file1.exists()) file1.delete();


			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			//加载字体
			XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider() {

				@Override
				public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, BaseColor color) {
					log.debug("fontname:{},size:{},encoding:{},embedded:{},style:{},color:{}",fontname,size,encoding,embedded,style,color == null ? null : color.toString());


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


					} catch (DocumentException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					return font;

				}
			};
//			fontProvider.addFontSubstitute("lowagie", "garamond");
//			fontProvider.setUseUnicode(true);
//			CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
//			HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
//			htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
//			htmlContext.autoBookmark(false);
//			XMLWorkerHelper.getInstance().getDefaultCssResolver(true);

			// step 4
			XMLWorkerHelper.getInstance().parseXHtml(writer, document,
					new FileInputStream(HTML), Charset.forName("UTF-8"),fontProvider);
			// step 5
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
