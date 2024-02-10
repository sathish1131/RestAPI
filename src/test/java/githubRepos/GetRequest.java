package githubRepos;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetRequest {
	@Test
	public void getReposForUser() {
		RestAssured.given().header("authorization","Bearer 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").accept(ContentType.JSON).when().get("https://api.github.com/users/sathish1131/repos").then().statusCode(200).log().all();
	}
	@Test
	public void getReposList() {
		RestAssured.given().header("authorization","Bearer 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").accept(ContentType.JSON).when().get("https://api.github.com/user/repos").then().statusCode(200).log().all();
	}
	@Test
	public void getReposPublic() {
		RestAssured.given().header("authorization","Bearer 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").accept(ContentType.JSON).when().get("https://api.github.com/repositories").then().statusCode(200).log().all();
	}
	@Test
	public void getRepoTopics() {
		RestAssured.given().header("authorization","Bearer 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").accept(ContentType.JSON).when().get("https://api.github.com/repos/sathish1131/PostmanProject/topics").then().statusCode(200).log().all();
	}
	@Test
	public void getReposTags() {
		RestAssured.given().header("authorization","Bearer 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").accept(ContentType.JSON).when().get("https://api.github.com/repos/sathish1131/PostmanProject/tags").then().statusCode(200).log().all();
	}
}
