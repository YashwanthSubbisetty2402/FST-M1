package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

	// Set the headers
	Map<String, String> headers = new HashMap<String, String>();

	// Create the contract(Pact)
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {

		// set the headers
		headers.put("Content-Type", "application/json");

		// Create the request and response body, Dsl0- Domain specific language
		DslPart requestResponseBody = new PactDslJsonBody().
				numberType("id", 123).
				stringType("firstName", "Vinay").
				stringType("lastName", "DT").
				stringType("email", "vinay@example.com");

		// Create the contract
		return builder.given("POST Request").
		uponReceiving("request to create user").
		method("POST").
		path("/api/users").
		headers(headers).
		body(requestResponseBody).
		willRespondWith().
		status(201).
		body(requestResponseBody).
		toPact();

	}

	// Consumer test with mock provider
	@Test
	@PactTestFor(providerName = "UserProvider", port = "8282")
	public void postRequestTest() {
		//Create a request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 123);
		reqBody.put("firstName", "Vinay");
		reqBody.put("lastName", "DT");
		reqBody.put("email", "vinay@example.com");
		//send a request, get response, assert response
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).
		when().post().
		then().statusCode(201).body("id", equalTo(123)).log().all();
		
	}
	
	
}
