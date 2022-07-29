package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseValidationLocation {
	@Test
	public void getLocation() {
		String expData="self";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Location?_pretty=true");
		 String actData=res.jsonPath().get("link[0].relation");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}

}
