package test.ftl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import test.pdf.Html2Pdf;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestFreemaker {

	public static void main(String[] args) throws IOException, TemplateException {
		new TestFreemaker().test();

	}


	public void test() throws IOException, TemplateException {
		Map root = new HashMap();
		User user = new User("111");
		root.put("user",user);
		root.put("date",new Date());
		String dir = "/Users/wangluyao/jf/123/src/main/ftl/";
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDirectoryForTemplateLoading(new File(dir));
//		configuration.setDirectoryForTemplateLoading(dir);


		Template template = configuration.getTemplate("1.ftl");
		File file = new File("file/test.html");
		template.process(root, new PrintWriter(file));


		if (file.exists()){
			Html2Pdf.html2Pdf(file.getAbsolutePath(),"file/test.pdf");

		}



	}

}
