package CRUDWithBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseValidationImmunization {
	@Test
	public void getImmunization() {
		String expData="completed";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Immunization?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].resource.status");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}
}
