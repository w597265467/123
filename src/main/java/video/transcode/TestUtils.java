package video.transcode;

public class TestUtils {
	public static void main(String[] arg){
		TranscodeUtils utils = new TranscodeUtils("5230");
		String format = "asx,asf,mpg,wmv,3gp,mp4,mov,avi,flv,wmv9,rm,rmvb";
		String[] split = format.split(",");
		for (String s : split) {
			System.out.println("==="+s);
			utils.setPATH("C:\\Users\\Administrator\\Desktop\\video\\5230.mp4");
			utils.beginConver(s,false);
		}
//			utils.setPATH("C:\\Users\\Administrator\\Desktop\\video\\3987.mp4");
//			utils.beginConver("rm",false);
	}

}
