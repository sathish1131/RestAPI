package dataDriven;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqresCRUD extends Excel_Methods{
	@Test
	public void post() throws IOException {
		Response response = RestAssured.given().body(fileRead("reqres", 1, 2)).when().post(fileRead("reqres", 1, 1));
		fileWrite("reqres", 1, 3,String.valueOf(response.statusCode()) );
		fileWrite("reqres", 1, 5, response.asString());
		if(response.statusCode()==201) {
			fileWrite("reqres", 1, 4,"Passed");
		}else {
			fileWrite("reqres", 1, 4,"Failed");
		}
		workBookTearDown();
	}
	@Test
	public void put() throws IOException {
		Response response = RestAssured.given().body(fileRead("reqres", 2, 2)).when().put(fileRead("reqres", 2, 1));
		fileWrite("reqres", 2, 3,String.valueOf(response.statusCode()) );
		fileWrite("reqres", 2, 5, response.asString());
		if(response.statusCode()==200) {
			fileWrite("reqres", 2, 4,"Passed");
		}else {
			fileWrite("reqres", 2, 4,"Failed");
		}
		workBookTearDown();
	}
	@Test
	public void get() throws IOException {
		Response response = RestAssured.given().get(fileRead("reqres", 3, 1));
		fileWrite("reqres", 3, 3, String.valueOf(response.statusCode()));
		fileWrite("reqres", 3, 5,response.asString());
		if(response.statusCode()==200) {
			fileWrite("reqres", 3, 4, "Passed");
		}else {
			fileWrite("reqres", 3, 4, "Failed");
		}
		workBookTearDown();
	}
	@Test
	public void delete() throws IOException {
		Response response = RestAssured.given().delete(fileRead("reqres", 4, 1));
		fileWrite("reqres", 4, 3, String.valueOf(response.statusCode()));
		fileWrite("reqres", 4, 5,response.asString());
		if(response.statusCode()==204) {
			fileWrite("reqres", 4, 4,"Passed");
		}else {
			fileWrite("reqres", 4, 4, "Failed");
		}
		workBookTearDown();
	}
	
}