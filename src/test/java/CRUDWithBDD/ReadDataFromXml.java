package CRUDWithBDD;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadDataFromXml {
	@Test
	public void reading() throws ParserConfigurationException, SAXException, IOException {

		String filepath = "C:\\Users\\admin\\Desktop\\insurance\\XmlFile1.xml";
		File file = new File(filepath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbf.newDocumentBuilder();
		Document doc = dbuilder.parse(file);
		doc.getDocumentElement().normalize();
		String nod = doc.getDocumentElement().getNodeName();
		NodeList nodelist = doc.getElementsByTagName("item");
        int tlength = nodelist.getLength();
		System.out.println(tlength);
		for (int i = 0; i < tlength; i++) {
			Node node = nodelist.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String expData = element.getElementsByTagName("PRCP_ID").item(0).getTextContent();
				System.out.println(expData);
				Response res = when().get("http://hapi.fhir.org/baseR4/Practitioner?_pretty=true");
				String actData = res.jsonPath().get("link[1].relation");
				System.out.println(actData);
				Assert.assertEquals(actData, expData);
				res.then().log().all();
			}
		}
	}
}
