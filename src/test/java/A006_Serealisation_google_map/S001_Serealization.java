package A006_Serealisation_google_map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import A006_Serealisation_google_map.S002_pojo_class;
import A006_Serealisation_google_map.S002_pojo_class.pojo_location;
import A006_Serealisation_google_map.S002_pojo_class.pojo_types;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class S001_Serealization {
	
	
	@Test 
	public static void gmap() {
		
		//Serealisation java object to json 
		
		S002_pojo_class addBody = new S002_pojo_class();
		
		pojo_location l = new pojo_location();
		pojo_types typ = new pojo_types();
		ArrayList <String> t = new ArrayList<String> () ; 
		t.add("shoe park");
		t.add("shop");
		typ.setTypes(t);
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addBody.setAccuracy(50);
		addBody.setName("Frontline house");
		addBody.setPhone_number("89894756");
		addBody.setAddress("29, side layout, cohen 09");
		addBody.setWebsite("https://rahulshettyacademy.com");
		addBody.setLanguage("French-IN");
		addBody.setLocation(l);
		addBody.setTypes(typ);
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(addBody)
		.when().post("/maps/api/place/add/json")
		.then().log().all().statusCode(200).extract().response().asString();
	}
}
