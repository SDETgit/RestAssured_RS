package Z001_others;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import A005_Deserialization_pojo_classes.S001_courses;
import A005_Deserialization_pojo_classes.S003_Webautomation;
import A005_Deserialization_pojo_classes.S004_Api;
import A005_Deserialization_pojo_classes.S005_mobile;
import Z001_others.Z003_pojo_classes2.Webaotumation;
import Z001_others.Z003_pojo_classes2.api;
import Z001_others.Z003_pojo_classes2.mobile;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class S001_deserealisation2 {
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
		Z003_pojo_classes2 response =given().queryParam("access_token", token).log().all()
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.then().log().all().statusCode(401).extract().response().as(Z001_others.Z003_pojo_classes2.class);
		
		System.out.println(response.getLinkedIn());
		
		System.out.println(response.getExpertise());
		
		System.out.println(response.getCourses().getApi().get(1).getCourseTitle());
		
		//iterating via loop 
		List<mobile> gMobile = response.getCourses().getMobile();
		List<api> gApi = response.getCourses().getApi();
		List<Webaotumation> gWebautomation = response.getCourses().getWebaotumation();
		
		String [] titles = {"Selenium Webdriver Java","Cypress","Protractor"};
		
		for(int i=0;i<gApi.size();i++)
		{
			System.out.println("Title is "+gApi.get(i).getCourseTitle()+" Price is "+gApi.get(i).getPrice());
		}
		
		ArrayList<String> titles2= new ArrayList<String>();
		
		//Iterating the sum 
		int sum = 0;
		for(int j=0;j<gApi.size();j++)
		{
			if (gApi.get(j).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
				System.out.println(" SoapUI Webservices testing and price is 40 check "+gApi.get(j).getPrice());
			sum = sum + Integer.parseInt(gApi.get(j).getPrice());
			
		}
		
		for(int i=0;i<gMobile.size();i++)
		{
			sum = sum + Integer.parseInt(gMobile.get(i).getPrice());
		}
		for(int k=0;k<gWebautomation.size();k++)
		{
			titles2.add(gWebautomation.get(k).getCourseTitle());
			sum = sum + Integer.parseInt(gWebautomation.get(k).getPrice());
		}
		System.out.println(sum);
		
		List<String> inputTitles = Arrays.asList(titles);
		
		System.out.println(inputTitles +"   "+titles2);
		Assert.assertTrue(titles2.equals(inputTitles)) ;
		
	}

}
