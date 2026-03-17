import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Pojo2.AddPlace;
import Pojo2.location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class reqspecbuild {

	public static void main(String[] args) {

		AddPlace ap = new AddPlace();

		ap.setAccuracy(50);
		ap.setName("Test Data");
		ap.setPhone_number("75545455554");
		ap.setAddress("Near this that");
		ap.setWebsite("www.ok.com");
		ap.setLanguage("Hindi");
		List<String> s = new ArrayList<String>();
		s.add("One");
		s.add("Two");
		ap.setTypes(s);

		location l = new location();
		l.setLat(-34.056566);
		l.setLng(34.866646);
		ap.setLocation(l);
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addQueryParam("key", "qaclick23")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification rp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		RequestSpecification res  = given().spec(req).body(ap);
		
		Response rpe =res.when().post("/maps/api/place/add/json").then().spec(rp).extract().response();
		System.out.println(rpe.asString());
		
	}

}
