package exerciseAPI;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GithubCRUD {
	@Test(priority=0)
	public void githubPost() {
		String jsonBody="{\"name\":\"DemoRepo\",\"description\":\"Testing CRUD using RestAssured\",\"homepage\":\"https://github.com\",\"private\":false,\"is_template\":true}";
		RestAssured.given().body(jsonBody).header("authorization", "Bearer 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").accept(ContentType.JSON).contentType(ContentType.JSON).when().post("https://api.github.com/user/repos").then().statusCode(201).log().all();
	}
	@Test
	public void githubPut() {
		String jsonBody="{\"names\":[\"restapi\",\"demo\",\"restassured\",\"api\"]}";
		RestAssured.given().body(jsonBody).header("authorization", "Bearer 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").accept(ContentType.JSON).contentType(ContentType.JSON).when().put("https://api.github.com/repos/sathish1131/DemoRepo/topics").then().statusCode(200).log().all();
	}
	@Test(priority=1)
	public void githubGet() {
		RestAssured.given().accept(ContentType.JSON).when().get("https://api.github.com/repos/sathish1131/DemoRepo").then().statusCode(200).log().all();
	}
	@Test(priority=2)
	public void githubDelete() {
		RestAssured.given().header("authorization","Bearer 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").when().delete("https://api.github.com/repos/sathish1131/DemoRepo").then().statusCode(204).log().all();
	}
}
