package CRUDWithBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetResponse {
	@Test
	public void getPatient() {
		when()
		.get("http://hapi.fhir.org/baseR4/Patient?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	@Test
	public void getOrganization() {
		when()
		.get("http://hapi.fhir.org/baseR4/Immunization?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void getPractitioner() {
		when()
		.get("http://hapi.fhir.org/baseR4/Practitioner?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	public void getObservation() {
		when()
		.get("http://hapi.fhir.org/baseR4/Observation?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	public void getImmunization() {
		when()
		.get("http://hapi.fhir.org/baseR4/Immunization?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	public void getLocation() {
		when()
		.get("http://hapi.fhir.org/baseR4/Location?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	
	

}
