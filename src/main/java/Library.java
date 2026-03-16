import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Reusablemethod;
import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Library {
	
	@Test(dataProvider="BooksData")

	public void addbook(String auth, String isbn) throws IOException
	{
		
		// TODO Auto-generated method stub
		
		// Dynamic extrnal data set
		// parameterized through testng data provider
		//  content of the file to string -- content of file into byte -- convert byte data to string

		
		RestAssured.baseURI="http://216.10.245.166";
//		
//		String response = given().log().all().header("Content-Type","application/json")
//				.body(payload.lib("ashish","456")).when().post("Library/Addbook.php").then().assertThat().statusCode(200)
//			   .body("Msg", equalTo("successfully added")).extract().response().asString();		
		
		
		
		String response = given().log().all().header("Content-Type","application/json")
				.body(payload.lib(auth,isbn)).when().post("Library/Addbook.php").then().assertThat().statusCode(200)
			   .body("Msg", equalTo("successfully added")).extract().response().asString();		
		
		
		JsonPath js = Reusablemethod.rawTojson(response);
		
	    String s= js.get("ID");
		
	    
	    System.out.println("Response: " + response + " ID: " + s);
	    
//		String getresponse = given().header("Content-Type","application/json").queryParam("AuthorName", "Jane Doe")
//
//				.when().get("Library/GetBook.php").then().assertThat().statusCode(200)
//			   .extract().response().asString();		
//	    
//		System.out.println(getresponse);
		
		
	}

	@DataProvider(name="BooksData")
	
	public Object[][] getdata()
	
	{
		return new Object[][] {{"asio" ,"45454"},{"GHJK" ,"45789"}};
	}
	
	  @Test
	    public void addBookFromFile() throws IOException {
	        RestAssured.baseURI = "http://216.10.245.166";

	        // Read file content into String
	        String fileContent = new String(Files.readAllBytes(
	                Paths.get("C:\\Users\\FT-AS-1320\\Downloads\\new.json")));

	        String response = given()
	                .log().all()
	                .header("Content-Type", "application/json")
	                .body(fileContent)
	                .when()
	                .post("Library/Addbook.php")
	                .then()
	                .assertThat()
	                .statusCode(200)
	                .body("Msg", equalTo("successfully added"))
	                .extract()
	                .response()
	                .asString();

	        System.out.println(response);

	
}
}