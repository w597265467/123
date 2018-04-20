package test;

import com.oracle.tools.packager.Log;
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
			log.error("error:{},href:{}", e,href);
		}
		return doc;
	}

	public static void a() {
		Map<String, String> nameAndHrefMap = new HashMap<>();

		try {
			Document doc = doc("http://detail.zol.com.cn/cell_phone_index/subcate57_0_list_1_0_1_2_0_1.html");
			Element brandAll = doc.getElementById("J_BrandAll");
			Elements allElements = brandAll.getAllElements();
			for (Element element : allElements) {
				String text = element.text();

				Attributes attributes = element.attributes();
				String href = attributes.get("href");
				if (!StringUtils.isEmpty(text)) {
					log.debug("text:{}", text);
				}
				if (!StringUtils.isEmpty(href)) {
					log.debug("href:{}", href);
				}
				nameAndHrefMap.put(text, "http://detail.zol.com.cn" + href);
			}
		} catch (Exception e) {
			log.error("error", e);
		}
		Set<Map.Entry<String, String>> entries = nameAndHrefMap.entrySet();

		for (Map.Entry<String, String> entry : entries) {
			// 开启一个线程
			cachedThreadPool.execute(new JsoupThred(entry.getKey(), entry.getValue()));
		}
		//以下是等线程池的全部线程执行结束后，会自动执行。
		cachedThreadPool.shutdown();
		while (true) {
			if (cachedThreadPool.isTerminated()) {
				createExcel(map,null);
				break;
			}
		}
	}

	public static void createExcel(Map<String,phoneVo> voMap,String excelName){
		if (StringUtils.isEmpty(excelName)){
			excelName = "最新爬下来的手机信息XXXX";
		}
		String path = "/Users/wangluyao/jf/phoneInfo/"+excelName+".xls";
		File file = new File(path);
		int add = 0;
		Sheet sheet = null;

		if (file.exists()){

			try {
				FileInputStream fs=new FileInputStream("d://test.xls");  //获取d://test.xls
				POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
				HSSFWorkbook wb=new HSSFWorkbook(ps);
				sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
				add = sheet.getLastRowNum()+1;

			} catch (IOException e) {
				log.error("error:{}",e);
			}
		}
		Workbook wb = null;
		if (sheet == null) {
			wb = new HSSFWorkbook();
			sheet =  wb.createSheet();
		}
		int i=0;
		int j=0;
		if (add != 0) {
			Row row = sheet.createRow(i++);
			Cell cell = row.createCell(0);
			cell.setCellValue("名字");
			Cell cell1 = row.createCell(1);
			cell1.setCellValue("手机名称");
			Cell cell2= row.createCell(2);
			cell2.setCellValue("手机别名");
		}
		for (Map.Entry<String, phoneVo> entry : voMap.entrySet()) {
			Row row1 = sheet.createRow(add + i++);
			Cell cell3 = row1.createCell(0);
			cell3.setCellValue(entry.getKey());
			Cell cell4 = row1.createCell(1);
			cell4.setCellValue(entry.getValue().phoneName);
			Cell cell5 = row1.createCell(2);
			cell5.setCellValue(entry.getValue().phoneAlias);
		}
		try {
			OutputStream os = new FileOutputStream(path);
			wb.write(os);
			os.close();
			wb.close();
		} catch (IOException e) {
			log.debug("error:{}",e);
		}
	}


	public static void main(String[] args) {
		//									http://detail.zol.com.cn/cell_phone_index/subcate57_1795_list_1.html

		a();
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
			try {
				Elements page = doc.getElementsByClass("small-page-next");
				for (Element element : page) {
					Attributes attributes = element.attributes();
					String href = attributes.get("href");
					TestJsoup.cachedThreadPool.execute(new JsoupThred(this.phoneName,href));
				}
			} catch (Exception e) {
				log.debug("error:{},href:{}",e,href);
			}
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
							log.debug("text:{}", text);
						}
						if (!StringUtils.isEmpty(href)) {
							log.debug("href:{}", href);
						}
						map.put(text, TestJsoup.url + href);
					}
				}
				if (StringUtils.isEmpty(h3.toString())) {
					log.debug(h3.toString());
				}
			}
			Map<String,phoneVo> voMap = new HashMap<>();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				phoneVo phoneVo = new phoneVo();
				phoneVo.name = entry.getKey();
				//product-model page-title clearfix
				Document doc1 = TestJsoup.doc(entry.getValue());
				Elements name = doc1.getElementsByClass("product-model__name");
				for (Element element : name) {
					String text = element.text();
					phoneVo.phoneName = text;
					if (!StringUtils.isEmpty(text)) {
						log.debug("全名:{}", text);
					}
				}
				Elements alias = doc1.getElementsByClass("product-model__alias");
				for (Element element : alias) {
					String aliasName = element.text();
					phoneVo.phoneAlias = aliasName;
					if (!StringUtils.isEmpty(aliasName)) {
						log.debug("别名:{}", aliasName);
					}

				}
				voMap.put(phoneVo.name, phoneVo);
			}
			TestJsoup.createExcel(voMap,phoneName);
		} catch (Exception e) {
			log.debug("error:{}",e);
		}
	}
}


class phoneVo {
	public String name;
	public String phoneName;
	public String phoneAlias;
}































