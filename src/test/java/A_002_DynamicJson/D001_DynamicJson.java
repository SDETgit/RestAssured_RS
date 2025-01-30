package A_002_DynamicJson;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.ReusableMethods;
import Files.payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class D001_DynamicJson {
	
	//Dynamic data hardcoded 
	/*
	 * @Test public static void addBook () { RestAssured.baseURI =
	 * "https://rahulshettyacademy.com";
	 * 
	 * String response =given().log().all().header("Content-type","text/plain").
	 * body(payload.addBook("fhsks","39828")). when().post("Library/Addbook.php").
	 * then().log().all().statusCode(200) .extract().response().asString();
	 * 
	 * JsonPath js = new JsonPath(response); JsonPath js2 =
	 * ReusableMethods.rawToJson(response);
	 * 
	 * String id = js.get("ID");
	 * 
	 * System.out.println(id);
	 * 
	 * }
	 */
	
	//dynamic data with data providers 
	
	@Test (dataProvider = "BooksData" )
	public static void addBook2 (String isbn,String aisle ) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	
		String response =given().log().all().header("Content-type","text/plain").
		body(payload.addBook(isbn,aisle)).
		when().post("Library/Addbook.php").
		then().log().all().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		JsonPath js2 = ReusableMethods.rawToJson(response);
		
	String id = 	js.get("ID");
		
		System.out.println(id);
		
	}
	
	@Test (dataProvider = "BooksData" )
	public static void deleteBook(String isbn,String aisle ) {
		
		
	String delRes= 	given().log().all().header("Content-type","text/plain").
		body("{\r\n"
				+ "    \"ID\": \""+isbn+aisle+"\"\r\n"
				+ "}").when().delete("/Library/DeleteBook.php").
		then().log().all().statusCode(200).extract().response().asString();
	}
	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		
		//Array = collection of elements 
		//multidimensional array = collection of arrays 
		return new Object[][] {{"abc23","1234"},{"abc232","12345"},{"abc233","123456"}};
	}

}
