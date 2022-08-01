package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseValidationPractitioner {
	@Test
	public void getPractitioner() {
		String expData="next";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Practitioner?_pretty=true");
		 String actData=res.jsonPath().get("link[1].relation");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		}
}
