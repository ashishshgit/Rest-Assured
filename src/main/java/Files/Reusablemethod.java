package Files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Reusablemethod {

public static String url = RestAssured.baseURI="https://api.restful-api.dev";

public static JsonPath rawTojson(String arg)
{

JsonPath js = new JsonPath(arg);

return js;

}


}




