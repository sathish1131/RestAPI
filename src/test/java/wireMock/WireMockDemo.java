package wireMock;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class WireMockDemo {
	int port=8080;
	WireMockServer server=new WireMockServer(port);
	@BeforeTest
	public void launchServer() {
		server.start();
		WireMock.configureFor(port);
		
		ResponseDefinitionBuilder res=new ResponseDefinitionBuilder();
		res.withBody("Courses");
		res.withStatus(201);
		
		WireMock.stubFor(WireMock.post("/users/greenstechnology").willReturn(res));		
	}
	@Test
	public void postRequest() {
		RestAssured.given().post("http://localhost:8080/users/greenstechnology").then().statusCode(201).extract().response();
	}
	@AfterTest
	public void tearDownServer() {
		if(server.isRunning() && server.port()==8080) {
			server.shutdown();
			System.out.println("Server Stopped...");
		}else {
			System.out.println("Server Not Stopped...");
		}
	}
}
