package A_001_API_Basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class B003_SUm_test_ng {
	/*
	 * 1. Print No of courses returned by API
	 * 
	 * 2.Print Purchase Amount
	 * 
	 * 3. Print Title of the first course
	 * 
	 * 4. Print All course titles and their respective Prices
	 * 
	 * 5. Print no of copies sold by RPA Course
	 * 
	 * 6. Verify if Sum of all Course prices matches with Purchase Amount
	 */
	@Test
	public static void sum() {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(payload.coursePrice());
		
		//1. Print No of courses returned by API
		int numCourse = js.getInt("courses.size()");
		System.out.println(numCourse);
		
		//2.Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		//3. Print Title of the first course
		String title = js.get("courses[1].title");
		System.out.println(title);
		
		
		//4. Print All course titles and their respective Prices
		for(int i=0;i<numCourse;i++)
		{
			String title1 = js.get("courses["+i+"].title");
			int price1 = js.getInt("courses["+i+"].price");
			//System.out.println(title1+" "+price1);
			
			System.out.println(js.get("courses["+i+"].title").toString()+" "+js.getInt("courses["+i+"].price"));
		}
		
		//5. Print no of copies sold by RPA Course
		for(int j=0;j<numCourse;j++)
		{
			String title2 = js.get("courses["+j+"].title");
			if(title2.equals("RPA"))
			{
				int copies = js.getInt("courses["+j+"].copies");
				System.out.println(title2+" has copies of "+copies);
				break;
			}
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		
		int sum = 0; 
		for(int k=0;k<numCourse;k++)
		{
			int price = js.getInt("courses["+k+"].price");
			int copies = js.getInt("courses["+k+"].copies");
			sum = sum+price*copies;
		}
		
		System.out.println(sum);
		Assert.assertEquals(sum, purchaseAmount);
		
	}
}


