package test;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.plugin.dom.core.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestDOM {
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
	  String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><" +
			  "returnsms>" +
			  " </returnsms>";
//		StringReader stringReader = new StringReader(xml);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(xml.getBytes());
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		org.w3c.dom.Document parse = documentBuilder.parse(byteInputStream);
		NodeList statusbox = parse.getElementsByTagName("statusbox");

		for (int i = 0; i < statusbox.getLength(); i++) {
			System.out.println(i);
			Node item = statusbox.item(i);
			NodeList childNodes = item.getChildNodes();
			Class<SendMassageReport> sendMassageReportClass = SendMassageReport.class;
			SendMassageReport sendMassageReport = sendMassageReportClass.newInstance();
			for (int j = 0; j < childNodes.getLength(); j++) {
				Node item1 = childNodes.item(j);
				if (item1!=null){
					String nodeValue = item1.getTextContent();
					String nodeName = item1.getNodeName();
					if ("mobiletaskidstatus".indexOf(nodeName)>-1){
						nodeName = nodeName.substring(0,1).toUpperCase() + nodeName.substring(1,nodeName.length());
						Method method = sendMassageReportClass.getMethod("set" + nodeName, String.class);
						method.invoke(sendMassageReport, nodeValue);
						System.out.println(nodeName+"===="+nodeValue);
					}
				}
			}
			System.out.println(sendMassageReport);
			System.out.println(item.toString());
			System.out.println("=============r");
		}
	}
}


class SendMassageReport {
	public String mobile;
	public String taskid;
	public String status;

	@Override
	public String toString() {
		return "SendMassageReport{" +
				"moblie='" + mobile + '\'' +
				", taskId='" + taskid + '\'' +
				", status='" + status + '\'' +
				'}';
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskId) {
		this.taskid = taskId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
