package dataDriven;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class ReqresSingleCRUD extends Excel_Methods {
	Response response;
	@Test
	public void reqresCRUD() throws IOException {
		for (int i = 1; i <= 4; i++) {
			switch (fileRead("reqres", i, 0).toLowerCase()) {
			case "post":
				response = RestAssured.given().body(fileRead("reqres", i, 2)).when().post(fileRead("reqres", i, 1));
				break;
			case "put":
				response = RestAssured.given().body(fileRead("reqres", i, 2)).when().put(fileRead("reqres", i, 1));
				break;
			case "get":
				response = RestAssured.given().get(fileRead("reqres", i, 1));
				break;
			case "delete":
				response = RestAssured.given().delete(fileRead("reqres", i, 1));
				break;
			}
			int sc = response.statusCode();
			fileWrite("reqres", i, 3 , String.valueOf(response.statusCode()));
			fileWrite("reqres", i, 5 , response.asString());
			if (sc == 201 || sc == 200 || sc == 204) {
				fileWrite("reqres", i, 4, "Passed");
			} else {
				fileWrite("reqres", i, 4, "Failed");
			}
		}
		workBookTearDown();
	}
}
