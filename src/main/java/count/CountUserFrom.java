package count;

import file.ReadExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class CountUserFrom {

	public static void main(String[] args) throws IOException {
		String str = "'13126623966'\n" +
				"'13294150211'\n" +
				"'13310477758'\n" +
				"'13376637997'\n" +
				"'13400135691'\n" +
				"'13400467886'\n" +
				"'13400468527'\n" +
				"'13403337427'\n" +
				"'13463132368'\n" +
				"'13463464026'\n" +
				"'13473134254'\n" +
				"'13483328343'\n" +
				"'13503130560'\n" +
				"'13563215869'\n" +
				"'13582630873'\n" +
				"'13582973537'\n" +
				"'13623234146'\n" +
				"'13623234148'\n" +
				"'13623362012'\n" +
				"'13633132599'\n" +
				"'13643235386'\n" +
				"'13653133250'\n" +
				"'13653135802'\n" +
				"'13677908557'\n" +
				"'13681076740'\n" +
				"'13693642763'\n" +
				"'13693642764'\n" +
				"'13693642765'\n" +
				"'13693642766'\n" +
				"'13693642767'\n" +
				"'13693642768'\n" +
				"'13700336826'\n" +
				"'13703133684'\n" +
				"'13716327099'\n" +
				"'13722331839'\n" +
				"'13730307376'\n" +
				"'13731327722'\n" +
				"'13731330871'\n" +
				"'13784087423'\n" +
				"'13785333550'\n" +
				"'13803131132'\n" +
				"'13831302440'\n" +
				"'13831336434'\n" +
				"'13831341277'\n" +
				"'13831353252'\n" +
				"'13831375730'\n" +
				"'13831390649'\n" +
				"'13831392360'\n" +
				"'13831398577'\n" +
				"'13833306155'\n" +
				"'13833313960'\n" +
				"'13833314143'\n" +
				"'13833314347'\n" +
				"'13833318588'\n" +
				"'13833321144'\n" +
				"'13833323027'\n" +
				"'13833330103'\n" +
				"'13833342055'\n" +
				"'13833343074'\n" +
				"'13833363899'\n" +
				"'13833369752'\n" +
				"'13910126919'\n" +
				"'13910477758'\n" +
				"'13910723765'\n" +
				"'13910897107'\n" +
				"'13931324234'\n" +
				"'13932335160'\n" +
				"'13932344257'\n" +
				"'13932358802'\n" +
				"'13932360258'\n" +
				"'13932360769'\n" +
				"'13932364225'\n" +
				"'13932384429'\n" +
				"'13933789721'\n" +
				"'13933789854'\n" +
				"'15014501690'\n" +
				"'15028360910'\n" +
				"'15028361818'\n" +
				"'15028380315'\n" +
				"'15028383535'\n" +
				"'15030300075'\n" +
				"'15030301919'\n" +
				"'15030309125'\n" +
				"'15030312879'\n" +
				"'15030318593'\n" +
				"'15030342245'\n" +
				"'15030382228'\n" +
				"'15031373757'\n" +
				"'15031376800'\n" +
				"'15031384456'\n" +
				"'15033405922'\n" +
				"'15033607771'\n" +
				"'15033609655'\n" +
				"'15033609656'\n" +
				"'15075350988'\n" +
				"'15081345446'\n" +
				"'15081380448'\n" +
				"'15100331616'\n" +
				"'15100335971'\n" +
				"'15110263493'\n" +
				"'15124514897'\n" +
				"'15128312083'\n" +
				"'15132324455'\n" +
				"'15132343833'\n" +
				"'15132376984'\n" +
				"'15132378825'\n" +
				"'15133315757'\n" +
				"'15133321553'\n" +
				"'15133350066'\n" +
				"'15133360206'\n" +
				"'15133362263'\n" +
				"'15133362973'\n" +
				"'15133370345'\n" +
				"'15133399029'\n" +
				"'15230389211'\n" +
				"'15253633526'\n" +
				"'15726670199'\n" +
				"'15802681378'\n" +
				"'15803131391'\n" +
				"'15803236961'\n" +
				"'15803335656'\n" +
				"'15803336603'\n" +
				"'15830339151'\n" +
				"'15830395052'\n" +
				"'15830422147'\n" +
				"'15831347950'\n" +
				"'15831389674'\n" +
				"'15831390038'\n" +
				"'15832368911'\n" +
				"'15833132777'\n" +
				"'15833133773'\n" +
				"'15833239995'\n" +
				"'15930315925'\n" +
				"'15930363881'\n" +
				"'15931305925'\n" +
				"'15931358058'\n" +
				"'15932323282'\n" +
				"'15932355688'\n" +
				"'15932358988'\n" +
				"'15932365621'\n" +
				"'15932365624'\n" +
				"'15933333500'\n" +
				"'17375323914'\n" +
				"'18073195010'\n" +
				"'18229498443'\n" +
				"'18230030231'\n" +
				"'18230134717'\n" +
				"'18230387808'\n" +
				"'18231316663'\n" +
				"'18301655891'\n" +
				"'18331335539'\n" +
				"'18331370077'\n" +
				"'18511529116'\n" +
				"'18713302594'\n" +
				"'18713355699'\n" +
				"'18715977965'\n" +
				"'18730325012'\n" +
				"'18730325812'\n" +
				"'18730343571'\n" +
				"'18731312027'\n" +
				"'18731314047'\n" +
				"'18731318961'\n" +
				"'18731385866'\n" +
				"'18732388185'\n" +
				"'18732396582'\n" +
				"'18831313141'\n" +
				"'18831356303'\n";


		String white = "13657498933\n" +
				"13975532176\n" +
				"15116388715\n" +
				"15811070023\n" +
				"13601213158\n" +
				"13910863755\n" +
				"13921675237\n" +
				"15974130420\n" +
				"15973125292\n" +
				"13640944902\n" +
				"18011928188\n" +
				"13823794686\n" +
				"18233289782\n" +
				"18673371607\n" +
				"18229704864\n" +
				"13930562377\n" +
				"18011876088\n" +
				"13718919792\n" +
				"13787002310\n" +
				"13574116399\n" +
				"15103338882\n" +
				"13810582811\n" +
				"13917560653\n" +
				"13718880820\n" +
				"18823738758\n" +
				"13875892981\n" +
				"13910416083\n" +
				"13723899841\n" +
				"13811502317\n" +
				"18873041823\n" +
				"15124514897\n" +
				"13787003210\n" +
				"18271265712\n" +
				"13681076740\n" +
				"13693642762\n" +
				"13632877984\n" +
				"15910541635\n" +
				"13910477758\n" +
				"13810056313\n" +
				"18231316663\n" +
				"13811236600\n" +
				"18911097275\n" +
				"15874051322\n" +
				"15074993731\n" +
				"15979212331\n" +
				"15111401446\n" +
				"13910723765\n" +
				"15097399868\n" +
				"18573037097\n" +
				"13450489996\n" +
				"18898566899\n" +
				"15367311162\n" +
				"13677350045\n" +
				"18974941335\n" +
				"13668306563\n" +
				"13511021286\n" +
				"18073195010\n" +
				"15111401445\n" +
				"13466390123\n" +
				"13622342322\n" +
				"13701164402\n" +
				"18301655891\n" +
				"13508485680\n" +
				"13911887649\n" +
				"13601376363\n" +
				"13520443807\n" +
				"13974875548\n" +
				"18711019805\n" +
				"15116323273\n" +
				"15811335592\n" +
				"13693673642\n" +
				"18618462333\n" +
				"13787139810\n" +
				"13911383010\n" +
				"13636035190\n" +
				"15110263493\n" +
				"15388950103\n" +
				"15132324455\n" +
				"18874891388\n" +
				"18574398617\n" +
				"13716327099\n" +
				"15111197300\n" +
				"13875893681\n" +
				"15073138350\n" +
				"15726670199\n" +
				"13910897107\n" +
				"15815838019\n" +
				"18874898789\n" +
				"15901297064\n" +
				"13911887640\n" +
				"13552607952\n" +
				"13808480098";
		String[] whites = white.split("\n");
		String[] replace = str.replace("'", "").split("\n");
		List<String> list = new ArrayList<>();
		for (String s : replace) {
			list.add(s);
		}
		FileInputStream fis = new FileInputStream("/Users/wangluyao/jf/用户外呼数据.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);

		Set<String> waihu = new HashSet<>();
		Set<String> wenjuan = new HashSet<>();

		for (Row cells : sheetAt) {
			String value = ReadExcel.getValue(cells.getCell(0));
			Cell cell = cells.getCell(1);
			if (cell != null) {
				String value1 = ReadExcel.getValue(cell);
				wenjuan.add(value1);
			}
			waihu.add(value);
		}
		int waihuCount = 0;
		int wenjuanCount = 0;
		int notIn = 0;
		ArrayList<String> whlist = new ArrayList<>();
		ArrayList<String> wjlist = new ArrayList<>();
		ArrayList<String> nlist = new ArrayList<>();
		for (String s : replace) {
			if (waihu.contains(s)) {
				waihuCount++;
				whlist.add(s);
				continue;
			}
			if (wenjuan.contains(s)) {
				wjlist.add(s);
				wenjuanCount++;
				continue;
			}
			nlist.add(s);
			notIn++;

		}
		//log.debug("外呼中:{},问卷中:{},都不在:{}", waihuCount, wenjuanCount, notIn);
		//log.debug("\n外呼:{},\n问卷:{},\n不在:{}", whlist, wjlist, nlist);

		Workbook wb2 = new XSSFWorkbook();
		Sheet sheet = wb2.createSheet();
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("外呼中数据");
		row.createCell(1).setCellValue("问卷中数据");
		row.createCell(2).setCellValue("都不在数据");
		row.createCell(3).setCellValue("四合一留下手机号");
		for (String s : whites) {
			whlist.remove(s);
			wjlist.remove(s);
			nlist.remove(s);
			list.remove(s);
		}
		Row row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue(whlist.size());
		row2.createCell(1).setCellValue(wjlist.size());
		row2.createCell(2).setCellValue(nlist.size());
		row2.createCell(3).setCellValue(list.size());
		int max = list.size();
//		if (wenjuanCount > max) {
//			max = wenjuanCount;
//		}
//		if (notIn > max) {
//			max = notIn;
//		}
		for (int i = 0; i < max; i++) {
			Row row3 = sheet.createRow(i+2);
			if (i<whlist.size()){
				row3.createCell(0).setCellValue(whlist.get(i));
			}
			if (i<wjlist.size()){
				row3.createCell(1).setCellValue(wjlist.get(i));
			}
			if (i<nlist.size()){
				row3.createCell(2).setCellValue(nlist.get(i));
			}
			row3.createCell(3).setCellValue(list.get(i));

		}
		wb2.write(new FileOutputStream("/Users/wangluyao/jf/用户从哪来10.xlsx"));
	}
}
