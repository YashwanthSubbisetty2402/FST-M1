package activities;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity4 {

	@Test
	public void GetPetDetails() {
		baseURI = "https://petstore.swagger.io/v2/pet";

		Response response = given().contentType(ContentType.JSON) // Set headers
				.when().get(baseURI + "/findByStatus?status=sold"); // Run GET request

		System.out.println(response.getHeaders());

		System.out.println("------------------------------------------");

		String responseBody = response.getBody().asPrettyString();

		System.out.println("Response Body is =>  " + responseBody);


		response.then().statusCode(200);
		response.then().body("[0].status", equalTo("sold"));
	}

	@Test
    public void getReq() {
    	given().
    	  baseUri("https://petstore.swagger.io/v2/pet").
    	  header("Content-Type","application/json").
    	  pathParam("petId",77232).
    	  log().all().
    	when().
    	    get("/{petId}").
    	then().
    		statusCode(200).
    		body("status", equalTo("alive")).
    		body("name", equalTo("Riley")).
    		log().all();
    	    	    	
    }

}
