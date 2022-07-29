package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseValidationOrganisation {
	@Test
	public void getOrganisation() {
		String expData="Test Organization";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Organization?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].resource.name");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}

}
