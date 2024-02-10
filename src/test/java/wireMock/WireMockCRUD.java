package wireMock;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class WireMockCRUD {
	int port=8080;
	WireMockServer server=new WireMockServer(port);
	@BeforeTest
	public void launchServer() {
		server.start();
		WireMock.configureFor(port);
		
		ResponseDefinitionBuilder postRes=new ResponseDefinitionBuilder();
		postRes.withBody("Post Request");
		postRes.withStatus(201);
		
		ResponseDefinitionBuilder getRes=new ResponseDefinitionBuilder();
		getRes.withBody("Get Request");
		getRes.withStatus(200);
		
		ResponseDefinitionBuilder putRes=new ResponseDefinitionBuilder();
		putRes.withBody("Put Request");
		putRes.withStatus(200);
		
		ResponseDefinitionBuilder delRes=new ResponseDefinitionBuilder();
		delRes.withBody("Delete Request");
		delRes.withStatus(204);
		
		WireMock.stubFor(WireMock.post("/users/postReq").willReturn(postRes));
		WireMock.stubFor(WireMock.put("/users/putReq").willReturn(putRes));
		WireMock.stubFor(WireMock.get("/users/getReq").willReturn(getRes));
		WireMock.stubFor(WireMock.delete("/users/delReq").willReturn(delRes));
		
	}
	@Test(priority=3)
	public void wireMockPost() {
		RestAssured.given().post("http://localhost:8080/users/postReq").then().statusCode(201).log().all();
	}
	@Test(priority=2)
	public void wireMockPut() {
		RestAssured.given().put("http://localhost:8080/users/putReq").then().statusCode(200).log().all();
	}
	@Test(priority=1)
	public void wireMockGet() {
		RestAssured.given().get("http://localhost:8080/users/getReq").then().statusCode(200).log().all();
	}
	@Test(priority=0)
	public void wireMockDelete() {
		RestAssured.given().delete("http://localhost:8080/users/delReq").then().statusCode(204).log().all();
	}
	@AfterTest
	public void tearServer() {
		if(server.port()==8080) {
			server.shutdown();
			System.out.println("Response Success and Server Stopped...");
		}else {
			System.out.println("Response Not Success And Server Is Still Running...");
		}
		
	}
}
