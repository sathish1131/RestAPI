package jsonServer;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import payloads.DBPayload;

public class CRUD_DB {
	@Test(priority=4)
	public void getRequest() {
		RestAssured.given().accept(ContentType.JSON).when().get("http://localhost:3000/users").then().statusCode(200).log().all();
	}
	@Test(priority =0)
	public void postRequest() throws JsonProcessingException {
		String fir="Jagan";
		String las="Kuram";
		int sub=2;
		int id=6;
		DBPayload pay=new DBPayload(fir,las,sub,id);
		String val = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pay);
		RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(val).when().post("http://localhost:3000/users").then().statusCode(201).log().all();
	}
	@Test(priority=-1)
	public void deleteRequest() {
		RestAssured.given().accept(ContentType.JSON).when().delete("http://localhost:3000/users/6").then().statusCode(200).log().all();
	}
	@Test(priority=2)
	public void putRequest() {
		String fir="Jegan";
		String las="Kumar";
		int sub=1;
		DBPayload pay=new DBPayload(fir,las,sub);
		RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(pay).when().put("http://localhost:3000/users/6").then().statusCode(200).log().all();
	}
	@SuppressWarnings("unchecked")
	@Test(priority=3)
	public void patchRequest() {
		JSONObject obj = new JSONObject();
		obj.put("lastName","Tiwari");
		obj.put("subjectId", 2);
		RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(obj).when().patch("http://localhost:3000/users/6").then().statusCode(200).log().all();
	}

}
