package file;

import org.mockito.Mock;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class CreateCSV2 {
	public static void main(String[] arg) throws IOException {


	}



	public boolean createCSV() throws IOException {
		try {
			String filePath = "C:\\Users\\Administrator\\Desktop\\success\\dxt_confirm_order_" + DateUtil.getNowTime() + ".csv";
			OutputStream os = new FileOutputStream(filePath);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
			String orderId = "6229912018013116401249601993";
			String tmallOrderId = "114778022207170256";
			String line = tmallOrderId + "," + orderId;
			writer.write(line);
			writer.close();
			return true;
		} catch (IOException e) {

		}
		return false;
	}
}
