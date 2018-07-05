package test;

import com.oracle.tools.packager.Log;
import com.sun.xml.internal.ws.api.pipe.ServerPipeAssemblerContext;
import file.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TestJsoup {

	public static String url = "http://detail.zol.com.cn";

	public static ConcurrentHashMap<String, phoneVo> map = new ConcurrentHashMap<>();

	public static Map<String, String> nameAndHrefMap = new ConcurrentHashMap<>();

	public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


	public static Document doc(String href) {
		Connection connect = Jsoup.connect(href);
		connect.header("user-agent", "Mozilla/5.0 (Linux; Android 7.0; LON-AL00 Build/HUAWEILON-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044028 Mobile Safari/537.36 MicroMessenger/6.6.6.1300(0x26060634) NetType/WIFI Language/zh_CN");
		/*
		headers.set("x-forwarded-for", "47.95.32.39");
		headers.set("X-real-ip", "47.95.32.39");
		headers.set("X-Forwarded-For", "47.95.32.39");
		headers.set("Proxy-Client-IP", "47.95.32.39");
		headers.set("WL-Proxy-Client-IP", "47.95.32.39");
		headers.set("HTTP_CLIENT_IP", "47.95.32.39");
		headers.set("HTTP_X_FORWARDED_FOR", "47.95.32.39");
		 */
		String s = "47.95.32.39";
		connect.header("x-forwarded-for", s);
		connect.header("X-real-ip", s);
		connect.header("X-Forwarded-For", s);
		connect.header("Proxy-Client-IP", s);
		connect.header("WL-Proxy-Client-IP", s);
		connect.header("HTTP_CLIENT_IP", s);
		connect.header("HTTP_X_FORWARDED_FOR", s);
		Document doc = null;
		try {
			doc = connect.get();
		} catch (IOException e) {
			//log.error("error:{},href:{}", e, href);
		}
		return doc;
	}

	public static void a() {
		try {
			Document doc = doc("http://detail.zol.com.cn/cell_phone_index/subcate57_0_list_1_0_1_2_0_1.html");
			Element brandAll = doc.getElementById("J_BrandAll");
			Elements allElements = brandAll.getAllElements();
			for (Element element : allElements) {
				String text = element.text();

				Attributes attributes = element.attributes();
				String href = attributes.get("href");
				if (!StringUtils.isEmpty(text)) {
					//log.debug("text:{}", text);
				}
				if (!StringUtils.isEmpty(href)) {
					//log.debug("href:{}", href);
				}
				nameAndHrefMap.put(text, "http://detail.zol.com.cn" + href);
			}
		} catch (Exception e) {
			//log.error("error", e);
		}
		Set<Map.Entry<String, String>> entries = nameAndHrefMap.entrySet();

		for (Map.Entry<String, String> entry : entries) {
			// 开启一个线程
			cachedThreadPool.execute(new JsoupThred(entry.getKey(), entry.getValue()));

		}
		//以下是等线程池的全部线程执行结束后，会自动执行。
//		cachedThreadPool.shutdown();
		while (true) {
			if (cachedThreadPool.isTerminated()) {
				createExcel(map, null);
				break;
			}
		}
	}

	public static void createExcel(Map<String, phoneVo> voMap, String excelName) {
		if (StringUtils.isEmpty(excelName)) {
			excelName = "最新爬下来的手机信息XXXX";
		}
		String path = "/Users/wangluyao/jf/phoneInfo/" + excelName + ".xls";
		File file = new File(path);
		int add = 0;
		Sheet sheet = null;

		if (file.exists()) {

			try {
				FileInputStream fs = new FileInputStream(path);  //获取d://test.xls
				POIFSFileSystem ps = new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
				HSSFWorkbook wb = new HSSFWorkbook(ps);
				sheet = wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
				add = sheet.getLastRowNum() + 1;

			} catch (IOException e) {
				//log.error("error:{}", e);
			}
		}
		Workbook wb = null;
		if (sheet == null) {
			wb = new HSSFWorkbook();
			sheet = wb.createSheet();
		}
		int i = 0;
		int j = 0;
		List<String> list = new ArrayList<>();
		if (add == 0) {
			Row row = sheet.createRow(i++);
			row.createCell(0).setCellValue("名字");
			row.createCell(1).setCellValue("手机名称");
			row.createCell(2).setCellValue("手机别名");
			row.createCell(3).setCellValue("手机价格");
			Set<Map.Entry<String, phoneVo>> entries = voMap.entrySet();
			Map.Entry<String, phoneVo> next = entries.iterator().next();
			phoneVo value = next.getValue();
			Map<String, String> detail = value.detail;
			Set<String> strings = detail.keySet();
			int i4 = 1;
			for (String string : strings) {
				list.add(string);
				row.createCell(3 + i4++).setCellValue(string);
			}
		}
		for (Map.Entry<String, phoneVo> entry : voMap.entrySet()) {
			Row row1 = sheet.createRow(add + i++);
			row1.createCell(0).setCellValue(entry.getKey());
			row1.createCell(1).setCellValue(entry.getValue().phoneName);
			row1.createCell(2).setCellValue(entry.getValue().phoneAlias);
			row1.createCell(3).setCellValue(entry.getValue().price);
			for (Map.Entry<String, String> stringStringEntry : entry.getValue().detail.entrySet()) {
				int i1 = list.indexOf(stringStringEntry.getKey());
				if (i1!=-1)
				row1.createCell(3 + i1).setCellValue(stringStringEntry.getValue());
			}
		}
		try {
			OutputStream os = new FileOutputStream(path);
			wb.write(os);
			os.close();
			wb.close();
		} catch (IOException e) {
			//log.debug("error:{}", e);
		}
	}


	public static void main(String[] args) {
		//									http://detail.zol.com.cn/cell_phone_index/subcate57_1795_list_1.html

		a();
	}

}
@Slf4j
class JsoupThred2 extends Thread {
	public String phoneName;
	public String href;

	public JsoupThred2(String phoneName, String href) {
		this.phoneName = phoneName;
		this.href = href;
	}

	@Override
	public void run() {
		Document doc = TestJsoup.doc(href);
		try {
			Elements page = doc.getElementsByClass("small-page-next");
			for (Element element : page) {
				Attributes attributes = element.attributes();
				String href = attributes.get("href");
				if (StringUtils.isEmpty(href)){
					return;
				}
				TestJsoup.nameAndHrefMap.put(this.phoneName,href);
			}
		} catch (Exception e) {
			//log.debug("error:{},href:{}",e,href);
		}
	}
}


@Slf4j
class JsoupThred extends Thread {

	public String phoneName;
	public String href;

	public JsoupThred(String phoneName, String href) {
		this.phoneName = phoneName;
		this.href = href;
	}

	///cell_phone/index1116998.shtml
	@Override
	public void run() {
		try {
			Document doc = TestJsoup.doc(href);
			Element picMode = doc.getElementById("J_PicMode");
			Elements allElements = picMode.getAllElements();
			Map<String, String> map = new HashMap<>();
			for (Element element : allElements) {
				Elements h3 = element.getElementsByTag("h3");
				for (Element eh3 : h3) {
					Elements elementsByTag = eh3.getElementsByTag("a");
					for (Element a : elementsByTag) {
						String text = a.text();
						String href = a.attributes().get("href");
						if (!StringUtils.isEmpty(text)) {
							//log.debug("text:{}", text);
						}
						if (!StringUtils.isEmpty(href)) {
							//log.debug("href:{}", href);
						}
						map.put(text, TestJsoup.url + href);
					}
				}
				if (StringUtils.isEmpty(h3.toString())) {
					//log.debug(h3.toString());
				}
			}
			Map<String, phoneVo> voMap = new HashMap<>();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				phoneVo phoneVo = new phoneVo();
				phoneVo.name = entry.getKey();
				//product-model page-title clearfix
				Document doc1 = TestJsoup.doc(entry.getValue());
				Elements name = doc1.getElementsByClass("product-model__name");
				for (Element element : name) {
					String text = element.text();
					phoneVo.phoneName = text;
				}
				Elements alias = doc1.getElementsByClass("product-model__alias");
				for (Element element : alias) {
					String aliasName = element.text();
					phoneVo.phoneAlias = aliasName;
				}
				Elements price = doc1.getElementsByClass("price-type");
				for (Element element : price) {
					String aliasName = element.text();
					phoneVo.price = aliasName;
				}

				Elements elementsByClass = doc1.getElementsByClass("_j_MP_more section-more");
				Element first = elementsByClass.first();
				String href = first.attributes().get("href");
				Document doc2 = TestJsoup.doc(TestJsoup.url+href);
				Elements list = doc2.getElementsByClass("category-param-list");
				int i = 0;
				phoneVo.detail = new HashMap<>();
				for (Element element : list) {
					Elements lis = element.getElementsByTag("li");
					for (Element li : lis) {
						Elements span = li.getElementsByTag("span");
						String n = span.get(0).text().replace("纠错", " ").replace(" ", "");
						String v = span.get(1).text().replace("纠错", " ").replace(" ", "");
						phoneVo.detail.put(n, v);
					}
				}
				//log.debug(phoneVo.toString());
				voMap.put(phoneVo.name, phoneVo);
			}
			//category-param-list
			TestJsoup.createExcel(voMap, phoneName);
		} catch (Exception e) {
			//log.debug("error:{}", e);
		}
	}
}


class phoneVo {
	public String name;
	public String phoneName;
	public String phoneAlias;
	public String price;

	public Map<String, String> detail;

	@Override
	public String toString() {
		return "phoneVo{" +
				"name='" + name + '\'' +
				", phoneName='" + phoneName + '\'' +
				", phoneAlias='" + phoneAlias + '\'' +
				", price='" + price + '\'' +
				", detail=" + detail +
				'}';
	}
}































