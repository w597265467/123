package test;
import gui.ava.html.image.generator.HtmlImageGenerator;

/**
 *
 */
public class Html2ImageTest {

	public static void main(String[] args){
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
//		String htmlstr = "<table width='654' cellpadding='0' cellspacing='0' bordercolor='#FFFFFF'><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr></table>";
//		imageGenerator.loadHtml(htmlstr);
		imageGenerator.loadUrl("http://blog.csdn.net/luohaobubu/article/details/7414554");
		imageGenerator.getBufferedImage();
		imageGenerator.saveAsImage("C:\\Users\\Administrator\\Desktop\\img.png");
		imageGenerator.saveAsHtmlWithMap("C:\\Users\\Administrator\\Desktop\\img.html", "C:\\Users\\Administrator\\Desktop\\img.png");
	}
}
