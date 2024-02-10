package githubRepos;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchRequest {
	@Test
	public void updateRepository() {
		String jsonBody="{\"name\":\"DemoApi\",\"description\":\"Update Repository Demo\",\"homepage\":\"https://github.com\",\"private\":true,\"has_issues\":true,\"has_projects\":true,\"has_wiki\":true}";
		RestAssured.given().body(jsonBody).header("authorization","Bearer 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").accept(ContentType.JSON).contentType(ContentType.JSON).when().patch("https://api.github.com/repos/sathish1131/HiWorld").then().statusCode(200).log().all();
	}

}
