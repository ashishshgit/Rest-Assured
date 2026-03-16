import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Reusablemethod;
import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// given : All input details
		// when : submit the API // resource and HTTP method
		//Then : Vaidlate the response
		
		RestAssured.baseURI="https://api.restful-api.dev";
		String response = given().log().all().header("Content-Type","application/json")
		.body(payload.AddData())
		.when().post("objects").then().assertThat().statusCode(200)
	   .body("name", equalTo("Apple MacBook Pro 16")).header("Server", "cloudflare").extract().response().asString();
		
		//add place -- update place with  new data -- get data to validate if new data updated or not.
		
		System.out.println(response);
		
		JsonPath js= Reusablemethod.rawTojson(response);		
		String id = js.get("id");
		System.out.println("Actual Response id" +id);
		
        System.out.println("get all data done");

		
		//update 
		
		         given().log().all().header("Content-Type","application/json")
				.body(payload.UpdateData()).when().put("objects/"+id)
				.then().log().all().assertThat().body("name", equalTo("Ashish MacBook Pro 20"));
		         
		         System.out.println("Update done");
		          
		         
		        String NewResponse = given().log().all().header("Content-Type","application/json")
					.body(payload.UpdateData()).when().get("objects/"+id)
					.then().assertThat().body("name", equalTo("Ashish MacBook Pro 20")).extract().response().asString();
		        
		        JsonPath js2 = new JsonPath(NewResponse); //for parsing the json
				
				String id2 = js.get("id");
				System.out.println("New response id " + id);
		        			
		         System.out.println("get specific one done");
		         
		         Assert.assertEquals(id, "12334");

					
		         
				
		
		
		
		
		
		

	}

}
