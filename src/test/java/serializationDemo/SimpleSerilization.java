package serializationDemo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payloads.SimplePayload;

public class SimpleSerilization {
	@Test
	public void simpleSerializationTest() throws JsonProcessingException {
		String name = "pragyan";
		String desc = "this is your first mission";
		String home = "https://www.techtracker.com";
		SimplePayload p = new SimplePayload(name, desc, home);
		ObjectMapper obj = new ObjectMapper();
		String payLoad = obj.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		System.out.println(payLoad);
		
	}

}
