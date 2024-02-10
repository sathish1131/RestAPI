package dataDriven;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GithubSingleCRUD extends Excel_Methods{
	Response response;
	@Test
	public void githubCRUD() throws IOException {
		for (int i = 1; i <= 4; i++) {
			switch (fileRead("github", i, 0).toLowerCase()) {
			case "post":
				response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).header("authorization", fileRead("github", i, 2))
									.body(fileRead("github", i, 3)).when().post(fileRead("github", i, 1));
				break;
			case "put":
				response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).header("authorization", fileRead("github", i, 2))
									.body(fileRead("github", i, 3)).when().put(fileRead("github", i, 1));
				break;
			case "get":
				response = RestAssured.given().accept(ContentType.JSON).when().get(fileRead("github", i, 1));
				break;
			case "delete":
				response = RestAssured.given().header("authorization", fileRead("github", i, 2)).when().delete(fileRead("github", i, 1));
				break;
			}
			int sc = response.statusCode();
			fileWrite("github", i, 4 , String.valueOf(response.statusCode()));
			fileWrite("github", i, 6 , response.asString());
			if (sc == 201 || sc == 200 || sc == 204) {
				fileWrite("github", i, 5, "Passed");
			} else {
				fileWrite("github", i, 5, "Failed");
			}
		}
		workBookTearDown();
	}
}