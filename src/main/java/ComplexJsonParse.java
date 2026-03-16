import org.testng.Assert;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		//Print no of course retrun by api
		//print total amount
		// print title of first course
		// print all course title and their prices.
		// print no copies sold by prticular couser
		//  verify the sum matches with total amount
		
		
		JsonPath js = new JsonPath(payload.Course());
		
		int NfCourses = js.get("courses.size()");
		System.out.println("No of courses = " + NfCourses);
		
        int total_amt = js.getInt("dashboard.totalPurchaseAmount");
		
		System.out.println("Total Amount of Courses = " +total_amt);
		
		String Title = js.get("courses[0].title");
		System.out.println("Title of first Course = " + Title);
		
		int sum =0;
		for(int i= 0; i<NfCourses; i++)
		{
		String All_Title = js.get("courses["+i+"].title");
		int All_Prices = js.getInt("courses["+i+"].price.");
		sum = sum+All_Prices ;
		int All_Copies = js.getInt("courses["+i+"].copies");
		

		System.out.println(All_Title + " , " + All_Prices + " , " + All_Copies);
		
		if (All_Title.equalsIgnoreCase("Machine Learning Advanced")) 
		{
		
           	int M_Copies = js.getInt("courses["+i+"].copies");
           	
           	System.out.println("Machine Learning Advanced " + M_Copies);
		
		}
		}
		Assert.assertEquals(total_amt, sum);
//	    System.out.println(sum);
//	    
//	    if (sum==total_amt)
//	    	
//	    {
//	    	System.out.println("Total Matched");
//	    }
//	    else
//	    {
//	    	System.out.println("Total Not Matched");
//
//	    }
//	
//	    
	
	}
}
