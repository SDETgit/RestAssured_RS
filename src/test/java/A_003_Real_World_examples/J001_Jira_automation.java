package A_003_Real_World_examples;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import io.restassured.*;
import io.restassured.path.json.JsonPath;

//1. Go to Jira login 
//2. Go to Jira API create a token 
//3. Convert to baseic auth (Here we can use OAuth 2.0 also )
//ATATT3xFfGF0UnNsemYq5Vt2fF3hG9C40mVuVyJe8buoYn_9LZUkoH6XRzv3YNYoarTI0vv2Lu-QBfpc8Vfxu8dkHj72MsZQDWeeSqk8h0BSEZ-a0bY2CDxlB6vt3EdfJ2jTUdNPgQS6KS8h8agv37IMFghq9ZRbx_wlfgFI8CErzBSZCHZtL8A=5DCE12EB

//QVRBVFQzeEZmR0YwVW5Oc2VtWXE1VnQyZkYzaEc5QzQwbVZ1VnlKZThidW9Zbl85TFpVa29INlhSenYzWU5Zb2FyVEkwdnYyTHUtUUJmcGM4VmZ4dThka0hqNzJNc1pRRFdlZVNxazhoMEJTRVotYTBiWTJDRHhsQjZ2dDNFZGZKMmpUVWROUGdRUzZLUzhoOGFndjM3SU1GZ2hxOVpSYnhfd2xmZ0ZJOENFcnpCU1pDSFp0TDhBPTVEQ0UxMkVC


public class J001_Jira_automation {
	 public static String id;
	@Test
	public static void add_jira () {
	
	//Add task 
	RestAssured.baseURI = "https://sjshubham.atlassian.net";
	
String response = 	given()
	.header("Content-Type","application/json")
	.header("X-Atlassian-Token","no-check")
	.header("Authorization","Basic c2ouc2h1YmhhbUBvdXRsb29rLmNvbTpBVEFUVDN4RmZHRjAtbHBXeUdHQnk3bEhDRGdOM2ZLS2ZpVmlhclZVNk1aRktBc1dDZVljdVFFclM0eE1CM0I3SHQzMVBXeXdFbFNJNDN5bng3UDlvZTlUSmh2UkpwdzIxM2paV1FpWWMzTVlsRUxNWkljakk2RURoWFIzNVRNcGl4ODdxRDVxeTZIbnZRbDRnSGFwTXRnS3dnNXJxYURSVnA2SzF0QVZBRG10YjRUR1d6RU0tU2s9RUIxN0M1NEM=")
	.body("{\r\n"
			+ "    \"fields\": {\r\n"
			+ "       \"project\":\r\n"
			+ "       {\r\n"
			+ "          \"key\": \"RA\"\r\n"
			+ "       },\r\n"
			+ "       \"summary\": \"Write your summary here\",\r\n"
			+ "       \"issuetype\": {\r\n"
			+ "          \"name\": \"Task\"\r\n"
			+ "       }\r\n"
			+ "   }\r\n"
			+ "}").when().post("/rest/api/3/issue")
	.then().log().all().statusCode(201).extract().response().asString();

JsonPath js = new JsonPath(response);

 id = js.get("id");
System.out.println(id);

	}
	
	@Test
	public static void addttachment() {
		//Add attachment 
		System.out.println("dss  "+id);
		given().
		pathParam("key", id)
		.
		header("X-Atlassian-Token","no-check")
		.header("Authorization","Basic c2ouc2h1YmhhbUBvdXRsb29rLmNvbTpBVEFUVDN4RmZHRjAtbHBXeUdHQnk3bEhDRGdOM2ZLS2ZpVmlhclZVNk1aRktBc1dDZVljdVFFclM0eE1CM0I3SHQzMVBXeXdFbFNJNDN5bng3UDlvZTlUSmh2UkpwdzIxM2paV1FpWWMzTVlsRUxNWkljakk2RURoWFIzNVRNcGl4ODdxRDVxeTZIbnZRbDRnSGFwTXRnS3dnNXJxYURSVnA2SzF0QVZBRG10YjRUR1d6RU0tU2s9RUIxN0M1NEM=")
		.multiPart("file", new File("C:\\Users\\DELL\\Downloads\\Info.txt")).log().all()
		.post("rest/api/2/issue/{key}/attachments")
		.then().log().all().statusCode(200);
		
	}
}
