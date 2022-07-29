package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetOrganisationRes {
	@Test
	public void getOrganization() {
		when()
		.get("http://hapi.fhir.org/baseR4/Organization?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
