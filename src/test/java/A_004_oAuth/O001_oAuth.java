package A_004_oAuth;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class O001_oAuth {

	public static String token;
	
	@Test (priority =1)
	public static void token() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		String tokenResponse = given().log().all().header("Connection","keep-alive")
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "scope").when().post("oauthapi/oauth2/resourceOwner/token")
		.then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(tokenResponse);
		token = 	js.get("access_token");
		System.out.println(token);
		
	}
	
	@Test (priority =2)
	public static void getCourses () {
		//RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response =given().queryParam("access_token", token).log().all()
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.then().log().all().statusCode(401).extract().response().asString();
		
		System.out.println(response);
	}
}
