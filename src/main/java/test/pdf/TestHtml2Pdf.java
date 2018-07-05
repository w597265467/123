package test.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.BaseFont;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextOutputDevice;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.ITextUserAgent;
import org.xhtmlrenderer.resource.XMLResource;
import org.xml.sax.InputSource;


import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;


@Slf4j
public class TestHtml2Pdf {


	@Test
	public void test1() {
//		Document document = new Document();
//		PdfWriter writer = PdfWriter.getInstance(document,
//				new FileOutputStream(outfile));
//		document.open();
//		XMLWorkerDemo.MyFontsProvider fontProvider = new XMLWorkerDemo.MyFontsProvider();
//		fontProvider.addFontSubstitute("lowagie", "garamond");
//		fontProvider.setUseUnicode(true);
//		//使用我们的字体提供器，并将其设置为unicode字体样式
//		CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
//		HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
//		htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
//		CSSResolver cssResolver = XMLWorkerHelper.getInstance()
//				.getDefaultCssResolver(true);
//		Pipeline<?> pipeline = new CssResolverPipeline(cssResolver,
//				new HtmlPipeline(htmlContext, new PdfWriterPipeline(document,
//						writer)));
//		XMLWorker worker = new XMLWorker(pipeline, true);
//		XMLParser p = new XMLParser(worker);
//		File input = new File(infile);
//		p.parse(new InputStreamReader(new FileInputStream(input), "UTF-8"));
//		document.close();
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

	@Test
	public void htmlToPDFTest() throws IOException {
		String url = "src/main/html/已解密_5、手机分期业务贷款协议 - 积分时代 v3.html";


		BufferedReader reader = new BufferedReader(new FileReader(url));
		String line = null;
		String a = "";
		while ((line = reader.readLine()) != null) {
			a += line + "\n";
		}


		System.out.println(a);


		String pdf = "/Users/wangluyao/jf/3.pdf";
		htmlToPDF(a, pdf);
	}

	public static void htmlToPDF(String htmlString, String pdfPath) {
		try {
			Document document = new Document(PageSize.A4, 30, 30, 30, 30);
//			Document document = new Document(PageSize.A4);
			PdfWriter pdfWriter = PdfWriter.getInstance(document,
					new FileOutputStream(pdfPath));
			document.setMargins(30, 30, 30, 30);
			document.open();
			document.addAuthor("pdf作者");
			document.addCreator("pdf创建者");
			document.addSubject("pdf主题");
			document.addCreationDate();
			document.addTitle("pdf标题,可在html中指定title");
			XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
			InputStream inputStream = null;
			worker.parseXHtml(pdfWriter, document, new ByteArrayInputStream(htmlString.getBytes("UTF-8")), inputStream, Charset.forName("UTF-8"), new MyFontsProvider());
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Before
	public void Init() {
	}


	/**
	 * 指定 xhtml 路径形式
	 */
	@Test
	public void craetePdf() {
		String url = "src/main/html/1.html";
		String pdf = "/Users/wangluyao/jf/2.pdf";


		OutputStream os = null;
		try {
			if (url.indexOf("://") == -1) {
				// maybe it's a file
				File f = new File(url);
				if (f.exists()) {
					url = f.toURI().toURL().toString();
				}
			}
			System.err.println("xhtml 地址：" + url);
			System.err.println("pdf 地址：" + url);

			os = new FileOutputStream(pdf);


			/*
			 * standard approach ITextRenderer renderer = new ITextRenderer();
			 *
			 * renderer.setDocument(url); renderer.layout();
			 * renderer.createPDF(os);
			 */


			ITextRenderer renderer = new ITextRenderer();
			ResourceLoaderUserAgent callback = new ResourceLoaderUserAgent(renderer.getOutputDevice());
			callback.setSharedContext(renderer.getSharedContext());
			renderer.getSharedContext().setUserAgentCallback(callback);


			org.w3c.dom.Document doc = XMLResource.load(new InputSource(url)).getDocument();

			renderer.setDocument(doc, url);

			renderer.layout();
			renderer.createPDF(os);


			os.close();
			os = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}
//18301655891

	@Test
	public void testCHP() throws Exception {
		Html2Pdf.html2Pdf("/Users/wangluyao/jf/123/1.html", "4.pdf");

	}


	public boolean convertHtmlToPdf(String inputFile, String outputFile)
			throws Exception {

		OutputStream os = new FileOutputStream(outputFile);
		ITextRenderer renderer = new ITextRenderer();
		String url = new File(inputFile).toURI().toURL().toString();
		System.out.println(url);
		renderer.setDocument(url);


		// 解决中文支持问题
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("/Users/wangluyao/jf/123/font/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		fontResolver.addFont("/Users/wangluyao/jf/123/font/msyhl.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		//解决图片的相对路径问题
//		renderer.getSharedContext().setBaseURL("file:/D:/");
		renderer.layout();
		renderer.createPDF(os);

		os.flush();
		os.close();
		return true;
	}

	/**
	 * 将 xhtml 转为 string 形式
	 */
	@Test
	public void craetePdfByHtmlStr() {
		String url = "/Users/wangluyao/jf/123/src/main/html/4/2.html";
		String pdf = "craetePdfByHtmlStr.pdf";
		String font1 = "/Users/wangluyao/jf/123/font/msyhl.ttc";//宋体（对应css中的 属性 font-family: SimSun; /*宋体*/）


		String html = readFile(url);
		System.out.println(html);

		OutputStream os = null;
		try {
			if (url.indexOf("://") == -1) {
				File f = new File(url);
				if (f.exists()) {
					url = f.toURI().toURL().toString();
				}
			}
			System.err.println("xhtml 地址：" + url);
			System.err.println("pdf 地址：" + pdf);

			os = new FileOutputStream(pdf);


			ITextRenderer renderer = new ITextRenderer();
			ResourceLoaderUserAgent callback = new ResourceLoaderUserAgent(renderer.getOutputDevice());
			renderer.getSharedContext().setUserAgentCallback(callback);
			callback.setSharedContext(renderer.getSharedContext());
			//添加中文字体
			String yaHeiFontName = "/Users/wangluyao/jf/123/font/simsun.ttc";

			yaHeiFontName += ",1";
			com.lowagie.text.Font yaHeiFont = new com.lowagie.text.Font(BaseFont.createFont(yaHeiFontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED));//中文简体


			renderer.getFontResolver().addFont(yaHeiFontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);


			renderer.setDocumentFromString(html, url);

			renderer.layout();
			renderer.createPDF(os);


			os.close();
			os = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * 资源加载代理
	 */
	private static class ResourceLoaderUserAgent extends ITextUserAgent {
		public ResourceLoaderUserAgent(ITextOutputDevice outputDevice) {
			super(outputDevice);
		}


		protected InputStream resolveAndOpenStream(String uri) {
			InputStream is = super.resolveAndOpenStream(uri);
			System.out.println("加载资源文件： " + uri);
			return is;
		}
	}

	/**
	 * 将文件转为 字符串
	 *
	 * @param fileName
	 * @return
	 */
	public static String readFile(String fileName) {
		FileInputStream file = null;
		BufferedReader reader = null;
		InputStreamReader inputFileReader = null;
		String content = "";
		String tempString = null;
		try {
			file = new FileInputStream(fileName);
			inputFileReader = new InputStreamReader(file, "utf-8");
			reader = new BufferedReader(inputFileReader);
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				content += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return content;
	}
}