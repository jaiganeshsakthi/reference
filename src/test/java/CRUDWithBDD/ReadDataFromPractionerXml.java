package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ReadDataFromPractionerXml {
	@Test
	public void reading() throws ParserConfigurationException, SAXException, IOException {
		String filepath = "C:\\Users\\admin\\Desktop\\insurance\\XmlFile.xml";
		File file = new File(filepath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbf.newDocumentBuilder();
		Document doc = dbuilder.parse(file);
		doc.getDocumentElement().normalize();
		String nod = doc.getDocumentElement().getNodeName();
		
		NodeList nodelist = doc.getElementsByTagName("id");
		int tlength = nodelist.getLength();
		System.out.println(tlength);
        Node node = nodelist.item(1);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
		    String	expData = element.getAttribute("value");
            Response res = when().get("http://hapi.fhir.org/baseR4/Practitioner?_pretty=true");
			String actData = res.jsonPath().get("entry[15].resource.id");
			System.out.println(actData);
			Assert.assertEquals(actData, expData);
		}
	}
}
