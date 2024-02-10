package demoTests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestDemoWebsite {
	@Ignore
	@Test(priority = 0)
	public void getAllEmployees() {
		RestAssured.given().get("https://dummy.restapiexample.com/api/v1/employees").then().statusCode(200).log().all();
	}
	@Ignore
	@Test(priority = 2)
	public void getSingleEmployee() {
		Response response = RestAssured.given().get("https://dummy.restapiexample.com/api/v1/employee/18");
		Assert.assertEquals(response.statusCode(), 200);
	}
	@Ignore
	@Test(priority = 3)
	public void createSingleEmployee() {
		String jsonBody="{\"name\":\"Sathish\",\"salary\":\"960000\",\"age\":\"28\"}";
		RestAssured.given().body(jsonBody).when().post("https://dummy.restapiexample.com/api/v1/create").then().statusCode(200).log().all();
	}
	@Ignore
	@Test(priority = 4)
	public void updateSingleEmployee() {
		RestAssured.given().body("{\"name\":\"SathishKumar\",\"salary\":\"1000000\",\"age\":\"28\"}").when().put("https://dummy.restapiexample.com/api/v1/update/21").then().statusCode(200).log().all();
	}
	@Ignore
	@Test(priority = 1)
	public void deleteSingleEmployee() {
		RestAssured.given().delete("https://dummy.restapiexample.com/api/v1/delete/18").then().statusCode(200).log().all();
	}

}
