package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetPractitionerRes {
	@Test
	public void getPractitioner() {
		when()
		.get("http://hapi.fhir.org/baseR4/Practitioner?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
