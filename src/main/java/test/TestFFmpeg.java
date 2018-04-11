package test;

import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 * @author Administrator

 * @create 2018-03-20 10:22

 * @desc TestFFmpeg

 **/
public class TestFFmpeg {
	public static void main(String[] arg) throws IOException, InterruptedException {
//		"-loglevel quiet " +
//		String cmd ="ffmpeg -help";
		String cmd = "ffmpeg -i C:\\Users\\Administrator\\Desktop\\video\\1.mp4 -y  -b 1000000  C:\\Users\\Administrator\\Desktop\\video\\1234.mp4";
		long l2 = System.nanoTime();
		Runtime runtime = Runtime.getRuntime();
		Process exec = runtime.exec(cmd);
		new StreamThread(exec.getErrorStream()).start();
		new StreamThread(exec.getInputStream()).start();
//		new Thread(){
//			InputStream is = exec.getErrorStream();
//			InputStreamReader inputStreamReader = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(inputStreamReader);
//			String line;
//
//			@Override
//			public void run() {
//				try {
//					while ((line = br.readLine()) != null) {
////						System.out.println(line);
//					}
//				} catch (IOException e) {
//
//				}finally {
//					try {
//						br.close();
//					} catch (IOException e) {
//
//					}
//				}
//			}
//		}.start();
////
//		new Thread(){
//			InputStream is1 = exec.getInputStream();
//			InputStreamReader inputStreamReader1 = new InputStreamReader(is1);
//			BufferedReader br = new BufferedReader(inputStreamReader1);
//			String l;
//			@Override
//			public void run() {
//				try {
//					while ((l = br.readLine()) != null) {
//						System.out.println(l);
//					}
//				} catch (IOException e) {
//
//				}finally {
//					try {
//						br.close();
//					} catch (IOException e) {
//
//					}
//				}
//			}
//		}.start();


		exec.waitFor();
		exec.destroy();
		File file = new File("C:\\Users\\Administrator\\Desktop\\video\\1234.mp4");
		InputStream i = new FileInputStream(file);
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(file);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		encoder.encode(data);
		long l3 = System.nanoTime();
		System.out.println(l3-l2);

//		long l1 = System.nanoTime();
//		String cmd = "ffmpeg -i C:\\Users\\Administrator\\Desktop\\video\\1.mp4 -y  -loglevel quiet -b 1000000  C:\\Users\\Administrator\\Desktop\\video\\1123.mp4";
////			    "-f image2 -t 1.001 C:\\Users\\Administrator\\Desktop\\ab.jpg";
////		String cmd = "ffmpeg -help";
////		String cmd = "ipconfig";
//		String[] split = cmd.split(" ");
//		List<String> list = new ArrayList<>();
//		//			list.add(" ");
//		list.addAll(Arrays.asList(split));
////		list.remove(list.size()-1);
//		for (String s : list) {
//			System.out.println(s);
//		}
//		ProcessBuilder processBuilder = new ProcessBuilder();
////		processBuilder.redirectErrorStream(true);
////		processBuilder.redirectError(new File("C:\\Users\\Administrator\\Desktop\\1.txt"));
////		processBuilder.redirectInput(new File("C:\\Users\\Administrator\\Desktop\\1.txt"));
//		processBuilder.redirectOutput(new File("C:\\Users\\Administrator\\Desktop\\1.txt"));
//		processBuilder.redirectErrorStream(true);
//		processBuilder.command(list);
//		List<String> command = processBuilder.command();
//		System.out.println(command.toString());
//		Process exec =
////				Runtime.getRuntime().exec(cmd);
//				processBuilder.start();
////
//		exec.waitFor();
//		exec.destroy();
//		long l2 = System.nanoTime();
//		System.out.println(l2-l1);
//		System.out.println(1111);
//
//
////		OutputStream outputStream = exec.getOutputStream();
////		outputStream.flush();
	}
	static class StreamThread extends Thread{
		InputStream inputStream;
		StreamThread(InputStream inputStream){
			this.inputStream = inputStream;
		}
		@Override
		public void run() {
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(isr);
			try {
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				//
			}finally {
				try {
					br.close();
				} catch (IOException e) {
					//
				}
			}
		}
	}
}

