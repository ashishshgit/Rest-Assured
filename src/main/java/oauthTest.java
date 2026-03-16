import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import Files.Reusablemethod;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

public class oauthTest {

	public static void main(String[] args) {

		String CoruseTitle[] = { "Selenium Webdriver Jav", "Cypress", "Protractor" };

		String response = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
				.formParam("scope", "trust").when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);

		JsonPath js = Reusablemethod.rawTojson(response);

		String access_token = js.get("access_token");

		System.out.println(access_token);

		GetCourse gc = given().queryParam("access_token", access_token).when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);

		List<Api> apicourses = gc.getCourses().getApi();

		for (int i = 0; i < apicourses.size(); i++)

		{
			if (gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))

			{
				System.out.println(gc.getCourses().getApi().get(i).getPrice());
			}

		}

		ArrayList<String> arr = new ArrayList();

		List<pojo.WebAutomation> WebCourses = gc.getCourses().getWebAutomation();

		for (int j = 0; j < WebCourses.size(); j++)

		{
			arr.add(gc.getCourses().getWebAutomation().get(j).getCourseTitle());

			// System.out.println(gc.getCourses().getWebAutomation().get(i).getCourseTitle());
		}

		List<String> expectedlist = Arrays.asList(CoruseTitle);

		Assert.assertTrue(arr.equals(expectedlist));

	}
}
