package activities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

public class Activity5 {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;

	@BeforeClass
	public void setUp() {

		requestSpec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet")
				.addHeader("Content-Type", "application/json").build();


		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectResponseTime(lessThanOrEqualTo(4000L))
				.build();
	}

	
	@Test(priority = 1)
	public void postRequest() {
		// Create request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 8723022);
		reqBody.put("name", "julie");
		reqBody.put("status", "alive");
		// Send request, save response
		Response response = given().spec(requestSpec).body(reqBody).when().post();

		// Extract the pet id
		petId = response.then().extract().path("id");

		// Assertions -- in the response we are asserting/validating the body that the
		// status is alive
		response.then().spec(responseSpec).body("status", equalTo("alive")).log().all();

	}
	
	 	 @Test(priority = 2)
	 public void getRequest() {
		 		 given().spec(requestSpec).pathParam("petId", petId).log().uri().
		 when().get("/{petId").
		 then().spec(responseSpec).body("status", equalTo("alive")).log().all();
		  
	 }
	 
	 
	 @Test(priority = 3)
	 public void deleteRequest() {
		 		 given().spec(requestSpec).pathParam("petId", petId).log().uri().
		 when().delete("/{petId}").
		 then().spec(responseSpec).body("message", equalTo(""+petId)).log().all();
		 
	 }
	
}
