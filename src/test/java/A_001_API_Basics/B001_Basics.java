package A_001_API_Basics;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.ReusableMethods;
import Files.payload;
public class B001_Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// validate if Add Place API is working as expected 
				//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
				
				//given - all input details 
				//when - Submit the API -resource,http method
				//Then - validate the response
		//Add place >- update place with new address > get place to validate if new address is present in response 
		
		//Basic 
		/*
		 * RestAssured.baseURI = "https://rahulshettyacademy.com";
		 * given().log().all().queryParam("key","qaclick123").header("Content-Type",
		 * "application/json") .body(payload.addbody())
		 * .when().post("/maps/api/place/add/json")
		 * .then().log().all().assertThat().statusCode(200) .body("status",
		 * equalTo("OK")) .header("Server", equalTo("Apache/2.4.52 (Ubuntu)"));
		 */
		
		//Passing the response in string 
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
				.body(payload.addbody())
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200)
				.body("status", equalTo("OK"))
				.header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response().asString();
		
		System.out.println(response);
		
		//Parsing json response body using JsonPath 
		//JsonPath js = new JsonPath(response);  //it string as an input and convert that to json 
	JsonPath js=	ReusableMethods.rawToJson(response);
		String placeID = js.getString("place_id");
		
		System.out.println(placeID);
		
		//Update addrress 
		String address = "Summer walk USA california";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//get address 
		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, address); //passed one 
		//random 
		Assert.assertEquals(actualAddress, "dsds"); //passed one 
	}

}
