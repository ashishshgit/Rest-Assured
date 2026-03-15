import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import java.io.File;

import Files.Reusablemethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class attachment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        RestAssured.baseURI="https://api.escuelajs.co";
		
		String response = given().header("Content-Type","multipart/form-data")
		.multiPart("file",new File ("C:\\Users\\Ashish\\Desktop\\1234.png"))
		.when().post("/api/v1/files/upload")
		.then().statusCode(201).body("originalname", equalTo("1234.png")).extract().response().asString();
		
		System.out.println(response);
	
		JsonPath js = Reusablemethod.rawTojson(response);
		String loc = js.get("location");
		
		System.out.println(loc);
	}

}
