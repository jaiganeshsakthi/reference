package OAUTH;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Aouth {
	@Test
	public void ouath2test() {
		
		 baseURI = "http://coop.apps.symfonycasts.com/";
		Response resp = given()
		 .formParam("client_id","insurance")
		 .formParam("client_secret","402ee8787f3205ef7d073ee9364516fc")
		 .formParam("grant_type","client_credentials")
		 .formParam("code","authorization_code")
		 .when()
		 .post("/token");
		 String token=resp.jsonPath().get("access_token");
		 System.out.println(token);
		 
		 
		 given()
		 .auth()
		 .oauth2(token)
		 .pathParam("USER_ID",3451)
		 .when()
		 .post("/api/{USER_ID}/chickens-feed")
		 .then()
		 .log().all();
	}

}
