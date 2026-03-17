import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Files.Reusablemethod;
import Pojo2.Login;
import Pojo2.LoginResponse;
import Pojo2.PlaceOrder;
import Pojo2.order;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class EcommerceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Login lo= new Login();
		
		lo.setUserEmail("as123@gmail.com");
		lo.setUserPassword("Test@1234");
		

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.setContentType(ContentType.JSON).build();
				
				ResponseSpecification rp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

				RequestSpecification res  = given().log().all().spec(req).body(lo);
				
				LoginResponse lrpe =res.when().post("api/ecom/auth/login").then().spec(rp).extract().response().as(LoginResponse.class);
		        
			    System.out.println(lrpe.getToken());
			    System.out.println(lrpe.getUserId());
			    
			    String token = lrpe.getToken();
			    String userID = lrpe.getUserId();
			    
			    
			    //Create product
				RequestSpecification req2 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			    .addHeader("authorization", token).build();
				
				RequestSpecification res2= given().spec(req2).param("productName", "Laptop")
				.param("productAddedBy", userID).param("productCategory", "fashsion")
				.param("productSubCategory", "Shirts").param("productPrice", "11500")
				.param("productDescription", "TestUSERTestUSERTestUSERTestUSER").param("productFor", "women")
				.multiPart("productImage", new File("C:\\Users\\FT-AS-1320\\Downloads\\as.png"));
				
				String r = res2.when().post("/api/ecom/product/add-product").then().extract().response().asPrettyString();
				
				JsonPath js = Reusablemethod.rawTojson(r);				
				
				System.out.println(r);
				String id = js.get("productId");
				System.out.println(id);

				
				// Place order
				PlaceOrder po = new PlaceOrder();
                po.setCountry("India");
                po.setProductOrderedId(id);
                
                List<PlaceOrder> ord = new ArrayList<PlaceOrder>();
                ord.add(po);
                
                order od = new order();
                od.setOrders(ord);
                      
           
				
				
				RequestSpecification req3 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					    .addHeader("authorization", token).setContentType(ContentType.JSON).build();
				
				RequestSpecification res3= given().log().all().spec(req3).body(od);
				
				String r2 = res3.when().post("/api/ecom/order/create-order").then().extract().response().asPrettyString();

				System.out.println(r2);
				
				

		
	}

}
