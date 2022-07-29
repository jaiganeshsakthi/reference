package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetImmunizationRes {
	@Test
	public void getImmunization() {
		when()
		.get("http://hapi.fhir.org/baseR4/Immunization?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
