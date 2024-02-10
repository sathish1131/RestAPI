package exerciseAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ReqresCRUD {
	@Test
	public void reqresPost() {
		String jsonBody = "{\r\n" + "    \"name\": \"Ram\",\r\n" + "    \"job\": \"Teacher\"\r\n" + "}";
		RestAssured.given().body(jsonBody).when().post("https://reqres.in/api/users").then().statusCode(201).log()
				.all();
	}

	@Test
	public void reqresPut() {
		String jsonBody = "{\r\n" + "    \"name\": \"Rahul\",\r\n" + "    \"job\": \"API Tester\"\r\n" + "}";
		RestAssured.given().body(jsonBody).when().put("https://reqres.in/api/users/2").then().statusCode(200).log()
				.all();
	}

	@Test
	public void reqresGet() {
		RestAssured.when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void reqresDelete() {
		RestAssured.when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}

}
