package file;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;
import file.entity.OrderMassage;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateExcel2 {
	public static void main(String[] arg) throws Exception {
//		OrderMassage massage = new OrderMassage();
//		CreateExcel2 creatExcal = new CreateExcel2();
//		List<OrderMassage> list = creatExcal.getOrder();
//		creatExcal.createExcel(list);
		getOrder();
	}

	public static List<OrderMassage> getOrder() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://120.0.0.1:3308",
				"jft",
				"3edcvBHU8");
		String sql = "SELECT\n" +
				"\ttmall_order_id,\n" +
				"\torder_id,\n" +
				"\tphone,\n" +
				"\ttmall_user_nick\n" +
				"FROM\n" +
				"\tcredit_order\n" +
				"WHERE\n" +
				"\ttmall_order_id IS NOT NULL\n" +
				"AND tmall_order_id != \"\"\n" +
				"ORDER BY\n" +
				"\tcreate_time DESC";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet resultSet = pstm.executeQuery();
		List<OrderMassage> list = new ArrayList<>();
		while (resultSet.next()) {
			OrderMassage massage = new OrderMassage();
			massage.tmallOrderId=resultSet.getString(1);
			massage.orderId = resultSet.getString(2);
			massage.username = resultSet.getString(4);
			massage.phone = resultSet.getString(3);
			list.add(massage);
		}
		return list;
	}

	public void createExcel(List<OrderMassage> orderMassages) throws IOException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(0);
		createRowNo1(row);
		int size = orderMassages.size();
		for (int i = 0; i < size; i++) {
			int rowNum = i+1;
			OrderMassage massage = orderMassages.get(i);
			row = sheet.createRow(rowNum);
			createRowOther(row,massage.tmallOrderId,massage.orderId,massage.phone,massage.username);
		}
		String dateStr = DateUtil.getNowTime();
		String filePath = "C:\\Users\\Administrator\\Desktop\\dxt_order_pay_success_" + dateStr + ".xls";
		OutputStream os = new FileOutputStream(filePath);
		wb.write(os);
		os.close();
		wb.close();
	}


	public void createRowOther(Row row, String tmallOrderId, String orderId, String phone, String userName) {
		Cell cell0 = row.createCell(0, CellType.STRING);
		cell0.setCellValue(tmallOrderId);
		Cell cell21 = row.createCell(21, CellType.STRING);
		cell21.setCellValue(phone);
		Cell cell1 = row.createCell(1, CellType.STRING);
		cell1.setCellValue(orderId);
		Cell cell2 = row.createCell(2, CellType.STRING);
		cell2.setCellValue(userName);
		Cell cell3 = row.createCell(3, CellType.STRING);
		cell3.setCellValue("1.0");
		Cell cell4 = row.createCell(4, CellType.STRING);
		cell4.setCellValue("1.0");
		Cell cell5 = row.createCell(5, CellType.STRING);
		cell5.setCellValue("558141749787");
		Cell cell6 = row.createCell(6, CellType.STRING);
		cell6.setCellValue("3632191954865");
		Cell cell7 = row.createCell(7, CellType.STRING);
		cell7.setCellValue("测试商品-不要拍-不发货-Xiaomi/小米 小米Note 全网通双卡");
		Cell cell8 = row.createCell(8, CellType.STRING);
		cell8.setCellValue("Xiaomi/小米");
		Cell cell9 = row.createCell(9, CellType.STRING);
		cell9.setCellValue("小米Note全网通");
		Cell cell10 = row.createCell(10, CellType.STRING);
		cell10.setCellValue("小米Note全网通");
		Cell cell11 = row.createCell(11, CellType.STRING);
		cell11.setCellValue("移动4G");
		Cell cell12 = row.createCell(12, CellType.STRING);
		cell12.setCellValue("高通-骁龙810");
		Cell cell13 = row.createCell(13, CellType.STRING);
		cell13.setCellValue("32GB");
		Cell cell14 = row.createCell(14, CellType.STRING);
		cell14.setCellValue("直板");
		Cell cell15 = row.createCell(15, CellType.STRING);
		cell15.setCellValue("官方标配");
		Cell cell16 = row.createCell(16, CellType.STRING);
		cell16.setCellValue("全国联保");
		Cell cell17 = row.createCell(17, CellType.STRING);
		cell17.setCellValue("中国大陆");
		Cell cell18 = row.createCell(18, CellType.STRING);
		cell18.setCellValue("中国移动");
		Cell cell19 = row.createCell(19, CellType.STRING);
		cell19.setCellValue("金融购机");
		Cell cell20 = row.createCell(20, CellType.STRING);
		cell20.setCellValue("文童鞋");
		Cell cell22 = row.createCell(22, CellType.STRING);
		cell22.setCellValue("北京朝阳");
	}

	public void createRowNo1(Row row) {
		Cell cell0 = row.createCell(0, CellType.STRING);
		cell0.setCellValue("天猫订单id");
		Cell cell1 = row.createCell(1, CellType.STRING);
		cell1.setCellValue("运营商外部订单号");
		Cell cell2 = row.createCell(2, CellType.STRING);
		cell2.setCellValue("买家昵称");
		Cell cell3 = row.createCell(3, CellType.STRING);
		cell3.setCellValue("订单金额");
		Cell cell4 = row.createCell(4, CellType.STRING);
		cell4.setCellValue("订单状态");
		Cell cell5 = row.createCell(5, CellType.STRING);
		cell5.setCellValue("item_id");
		Cell cell6 = row.createCell(6, CellType.STRING);
		cell6.setCellValue("sku_id");
		Cell cell7 = row.createCell(7, CellType.STRING);
		cell7.setCellValue("商品名称");
		Cell cell8 = row.createCell(8, CellType.STRING);
		cell8.setCellValue("品牌");
		Cell cell9 = row.createCell(9, CellType.STRING);
		cell9.setCellValue("类型");
		Cell cell10 = row.createCell(10, CellType.STRING);
		cell10.setCellValue("型号");
		Cell cell11 = row.createCell(11, CellType.STRING);
		cell11.setCellValue("网络类型");
		Cell cell12 = row.createCell(12, CellType.STRING);
		cell12.setCellValue("cpu信息");
		Cell cell13 = row.createCell(13, CellType.STRING);
		cell13.setCellValue("内存大小");
		Cell cell14 = row.createCell(14, CellType.STRING);
		cell14.setCellValue("手机款式");
		Cell cell15 = row.createCell(15, CellType.STRING);
		cell15.setCellValue("套餐类型");
		Cell cell16 = row.createCell(16, CellType.STRING);
		cell16.setCellValue("售后服务");
		Cell cell17 = row.createCell(17, CellType.STRING);
		cell17.setCellValue("版本类型");
		Cell cell18 = row.createCell(18, CellType.STRING);
		cell18.setCellValue("运营商");
		Cell cell19 = row.createCell(19, CellType.STRING);
		cell19.setCellValue("购机类型");
		Cell cell20 = row.createCell(20, CellType.STRING);
		cell20.setCellValue("收货人姓名");
		Cell cell21 = row.createCell(21, CellType.STRING);
		cell21.setCellValue("收货人电话");
		Cell cell22 = row.createCell(22, CellType.STRING);
		cell22.setCellValue("收货地址");
	}
}
