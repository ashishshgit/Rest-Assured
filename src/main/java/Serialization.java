import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Serialization {

	public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com/";
        
       String rep = given().queryParam("key", "qaclick23")
        .when().post("maps/api/place/add/json")
        .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(rep);

		
	}
	
}
