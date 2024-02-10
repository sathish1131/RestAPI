package demoTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Demo_1 {
	
	@Test
	public void jsonParsingReal() {
		Response response = RestAssured.given()
							.accept(ContentType.JSON)
							.get("https://cdn-api.co-vin.in/api/v4/appointment/sessions/public/calendarByDistrict?district_id=395&date=27-09-2023");
		System.out.println(response.asString());
		String payload=response.asString();
		JsonPath obj=new JsonPath(payload);
		System.out.println("CenterId : "+obj.getString("centers[0].center_id"));
		System.out.println("Name : "+obj.getString("centers[0].name"));
		System.out.println("Address : "+obj.getString("centers[0].address"));
		System.out.println("StateName : "+obj.getString("centers[0].state_name"));
		System.out.println("DistrictName : "+obj.getString("centers[0].district_name"));
		
	}

}
