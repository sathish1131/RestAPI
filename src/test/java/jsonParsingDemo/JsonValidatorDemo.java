package jsonParsingDemo;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
public class JsonValidatorDemo {
	JsonPath js;
	@Test
	public void employeeDetailsExtract() {
		js=new JsonPath(PayloadJson.employeeDetails());
		System.out.println("Total Number Of Employees : "+js.getInt("employeeDetails.size()"));
		System.out.println("Total Amount of Salary : "+js.getInt("dashBoard.totalSalary"));
		System.out.println("Name Of The First Employee : "+js.getString("employeeDetails.name[0]"));
		System.out.println("Experience Of Sundarpitchai : "+js.getString("employeeDetails.exp[2]"));
	}
	
}
