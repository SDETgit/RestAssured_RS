package A007_SpecBuilders;
import static io.restassured.RestAssured.given;



import java.util.ArrayList;

import org.testng.annotations.Test;

import A006_Serealisation_google_map.S002_pojo_class;
import A006_Serealisation_google_map.S002_pojo_class.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class S001_SpecBuilders {
	
	
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
		
		System.out.println(l+" dff"+typ+" "+t);
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Spec builder - Request  
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		//Spec builder -Response 
		ResponseSpecification resp = new	ResponseSpecBuilder().expectStatusCode(200).build();
		
		//to separate request and response  
		RequestSpecification res = 	given().log().all().spec(req).body(addBody);
		
		Response response = 	res.when().post("/maps/api/place/add/json")
								.then().log().all().spec(resp).extract().response();
		
		
		String resString = response.asString();
		
		JsonPath js = new JsonPath(resString);
		String fd = js.getString("status");
		String fd1 = js.getString("scope");
		System.out.println(fd+" "+fd1);
		System.out.println(resString +" "+response.prettyPrint());
		System.out.println("Printed ");
	}
}
