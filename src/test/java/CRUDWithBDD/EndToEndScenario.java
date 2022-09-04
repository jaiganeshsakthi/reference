package CRUDWithBDD;

import static io.restassured.RestAssured.when;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.FileNotFoundException;

import org.json.XML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class EndToEndScenario {
	@Test
	public void readFromJson() throws Exception {
       //convert xml to json file
		File xmlfile = new File("C:\\Users\\admin\\Desktop\\insurance\\XmlFile1.xml");
		byte[] b = Files.readAllBytes(xmlfile.toPath());
		String xml = new String(b);
		org.json.JSONObject json = XML.toJSONObject(xml);
		String j = json.toString();
		System.out.println(json);
        //store json data into json file
		FileWriter filewriter = new FileWriter(new File("C:\\Users\\admin\\Desktop\\insurance\\Json.json"));
		filewriter.write(j);
		filewriter.close();
       //Read the data from json file
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\admin\\Desktop\\insurance\\Json.json");
		Object obj = jsonparser.parse(reader);
		JSONObject emp = (JSONObject) obj;
		JSONObject object = (JSONObject) emp.get("item");
		JSONObject record= (JSONObject) object.get("Records");
		JSONObject item = (JSONObject) record.get("item");
		JSONObject PRCP = (JSONObject) item.get("PRCP_ID");
		Object type = PRCP.get("type");
		Object expData = PRCP.get("content");
		System.out.println(expData);
		Response res = when().get("http://hapi.fhir.org/baseR4/Practitioner?_pretty=true");
		String actData = res.jsonPath().get("entry[12].resource.id");
		System.out.println(actData);
		Assert.assertEquals(actData, expData);

	}

}
