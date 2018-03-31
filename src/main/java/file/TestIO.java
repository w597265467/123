package file;

import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.apache.poi.ss.formula.functions.MinaMaxa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**

 * @author Administrator

 * @create 2018-03-19 15:31

 * @desc TestIO

 **/
public class TestIO {
	public static int bufferSize = 1024;
	public static String src = "C:\\Users\\Administrator\\Desktop\\video\\1.mp4";
	public static String dest ="C:\\Users\\Administrator\\Desktop\\video\\10010.mp4" ;


	public static void main(String[] args) throws Exception{
		InputStream inputStream = new FileInputStream(src);
		OutputStream outputStream = new FileOutputStream(dest);
		byte[] buffer = new byte[bufferSize];
		int len;
		while ((len = inputStream.read(buffer,0,bufferSize))!=-1){
			outputStream.write(buffer,0,len);
		}
//		while (inputStream.read(buffer)>0){
//			outputStream.write(buffer);
//		}

	}
}
