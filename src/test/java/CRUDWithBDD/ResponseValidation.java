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
/*	
	@Test
	public void getPractitioner() {
		String expData="Bachelor of Science";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Practitioner?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].resource.qualification[0].code.text");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}
	*/
	
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
		String expData="completed";
		Response res = when()
		.get("http://hapi.fhir.org/baseR4/Immunization?_pretty=true");
		 String actData=res.jsonPath().get("entry[0].resource.status");
	     System.out.println(actData);
	     Assert.assertEquals(actData,expData);
		 res.then().log().all();
		
	}

}
