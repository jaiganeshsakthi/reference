package CRUDWithBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetLocationRes {
	@Test
	public void getLocation() {
		when()
		.get("http://hapi.fhir.org/baseR4/Location?_pretty=true")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
