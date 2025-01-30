package Z001_others;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Z001_data_providers {
	
	@DataProvider (name = "SumNumbers")
	
	public Object[][] summ () {
		
		return new Object[][] {{1,2,3,4,5},{2,3,4,5,6}};
	}

	
	@Test (dataProvider  = "SumNumbers")
	
	public static void summ_n(int a,int b,int c,int d,int e) {
		int sum = a+b+c+d+e;
		
		System.out.println(sum);
	}
}
