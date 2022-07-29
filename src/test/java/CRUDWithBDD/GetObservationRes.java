package CRUDWithBDD;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class GetObservationRes {
	@Test
	public void getObservation() {
		when()
		.get("http://hapi.fhir.org/baseR4/Observation?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
