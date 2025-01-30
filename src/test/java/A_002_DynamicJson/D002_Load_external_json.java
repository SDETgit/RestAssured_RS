package A_002_DynamicJson;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Files.payload;
import io.restassured.RestAssured;

public class D002_Load_external_json {
	
	//Content of file to string -> content of file to bytes > bytes to string 

	@Test 
	public static void loadJson() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
				.body(GenerateStringFromResource("D:\\Rahul_Shetty\\API\\External_json.json"))
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200)
				.body("status", equalTo("OK"))
				.header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response().asString();
		
		System.out.println(response);
	}
	
	public static String GenerateStringFromResource(String path) throws IOException {



	    return new String(Files.readAllBytes(Paths.get(path)));



	}
}
