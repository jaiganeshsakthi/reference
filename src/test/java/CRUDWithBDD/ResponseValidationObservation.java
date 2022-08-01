package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseValidationObservation {
	@Test
	public void getObservation() {
		String expData="final";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Observation?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].resource.status");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}

}
