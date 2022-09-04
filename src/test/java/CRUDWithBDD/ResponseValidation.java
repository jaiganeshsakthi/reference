package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;


import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseValidation {
	@Test
	public void getPatient() {
		String expData="generated";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Patient?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].resource.text.status");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}

	
	@Test
	public void getOrganisation() {
		String expData="XYZ Lab Pvt.Ltd.";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Organization?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].resource.name");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}
	
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
	
	@Test
	public void getImmunization() {
		String expData="match";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Immunization?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].search.mode");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}

}
