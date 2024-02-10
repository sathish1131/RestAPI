package jsonParsingDemo;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonExtractReqres {
	JsonPath js;
	@Test
	public void reqresExtract() {
		js=new JsonPath(PayloadJson.reqresGetPage2());
		System.out.println("The Page Number : "+js.getInt("page"));
		System.out.println("The number of employees per page : "+js.getInt("per_page"));
		if(js.getString("data.first_name[0]").equalsIgnoreCase("Michael")) {
			System.out.println("The mailId of michael lawson : "+js.getString("data.email[0]"));
		}
		if(js.getInt("data.id[5]")==12) {
			System.out.println("The Name of employee of Id=12 : "+js.getString("data.first_name[5]")+" "+js.getString("data.last_name[5]"));
		}
		if(js.getString("data.first_name[3]").equalsIgnoreCase("Byron")) {
			System.out.println("The Id of employee name Byron Fields : "+js.getInt("data.id[3]"));
		}
		System.out.println("Url for support page : "+js.getString("support.url"));
		System.out.println("Text of the support page : "+js.getString("support.text"));
		if(js.getString("data.first_name[1]").equalsIgnoreCase("Lindsay")) {
			System.out.println("The avatar of Lindsay Fergusan : "+js.getString("data.avatar[1]"));
		}
		if(js.getInt("data.id[4]")==11) {
			System.out.println("The name and mail of the employee id=11 : ");
			System.out.println("Name : "+js.getString("data.first_name[4]")+" "+js.getString("data.last_name[4]"));
			System.out.println("Mail : "+js.getString("data.email[4]"));
		}
	}

}
