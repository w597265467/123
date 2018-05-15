package test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import java.io.IOException;

public class myFontProvider implements FontProvider {
	@Override
	public boolean isRegistered(String fontname) {
		return false;
	}

	@Override
	public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, BaseColor color) {
		return null;
	}

	public static class MyFontsProvider extends XMLWorkerFontProvider {
			public MyFontsProvider() {
				super(null, null);
			}

			@Override
			public Font getFont(final String fontname, String encoding, float size, final int style) {

				String fntname = fontname;
				if (fntname == null) {
					fntname = "宋体";
				}
				return super.getFont(fntname, encoding, size, style);
			}
		}
	}
