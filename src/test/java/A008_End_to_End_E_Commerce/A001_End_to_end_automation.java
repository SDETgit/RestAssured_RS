package A008_End_to_End_E_Commerce;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class A001_End_to_end_automation {
	public static String token;
	public static String userID;
	public static String productID;
	public static String OrderID;
	
	@Test (priority =1 )
	public  static void login () {
		//Serealisation Java object to json Done using pojo classes 
				A002_Login_pojo lg = new A002_Login_pojo();
					lg.setUserEmail("API_JAVA@gmail.com");
					lg.setUserPassword("IamKing@123");
				
	RequestSpecification req =	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
		.setContentType(ContentType.JSON).build();
	
	     //Separating the body and request 
			RequestSpecification Reqbo = given().relaxedHTTPSValidation().spec(req).body(lg);
	
		//Deserealisation Json to Java Object 
			A003_LoginResponse response = 	Reqbo.when().post("api/ecom/auth/login")
									.then().statusCode(200).extract().response().as(A003_LoginResponse.class);
	
			token = response.getToken();
			userID =response.getUserId();
		System.out.println(response.getToken());
		System.out.println(response.getUserId());
		System.out.println(response.getMessage());		
		
	}
	
	@Test (priority =2 )
	
	public static void create_product() {
		
		RequestSpecification req =	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.addHeader("authorization", token)
				.build();
		
		RequestSpecification crereq = given().spec(req).param("productName","APi Rest Assured").
		param("productAddedBy",userID).
		param("productCategory","Job").
		param("productSubCategory","TopSkill").
		param("productPrice","11500").
		param("productDescription","RahulShetty").
		param("productFor","IT")
		.multiPart("productImage", new File("C:\\Users\\DELL\\Downloads\\1.Rest-Assured.png"));
		
		
		A004_create_product_response Response = crereq.when().post("api/ecom/product/add-product").then().log().all().
				extract().response().as(A004_create_product_response.class);
		
		productID=	Response.getProductId();
		
		System.out.println(productID+" "+Response.getMessage());
		
	}
	
	@Test (priority =3)
	
	public static void create_order() {
		RequestSpecification req = 	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
		.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		
		A005_create_order_pojo cop = new A005_create_order_pojo();
		A006_create_order2 or = new A006_create_order2();
		or.setProductOrderedId(productID);
		or.setCountry("British Indian Ocean Territory");
		 
		ArrayList <A006_create_order2> Lor = new ArrayList<A006_create_order2>();
		Lor.add(or);
		cop.setOrders(Lor);
		RequestSpecification req2= given().log().all().spec(req).body(cop);
	A007_create_response response= 	req2.when().post("api/ecom/order/create-order").then().log().all().extract().response().as(A007_create_response.class);
		
	System.out.println(response.getProductOrderId().get(0));
	OrderID = response.getOrders().get(0);
	
	System.out.println(OrderID);
		
	
			
	}
	
	@Test (priority =4)
	public static void view_order() {
		
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").
				addHeader("authorization", token).build();
		
		given().spec(req).queryParam("id", OrderID).when().get("api/ecom/order/get-orders-details").then().log().all().
		extract().response().asString();
		
	}
	
	@Test (priority =5)
	public static void delete_order () {
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").
				addHeader("authorization", token).setContentType(ContentType.JSON).build();
		
		
		//given().spec(req).when().delete("api/ecom/order/delete-order/"+OrderID).then().log().all();
		
		//Another way 
		RequestSpecification deletepro = given().spec(req).pathParam("OrderID1", OrderID);
		deletepro.when().delete("api/ecom/order/delete-order/{OrderID1}").then().log().all();
		
		
	}

}
