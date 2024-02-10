package serializationDemo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payloads.LoopPayload;

public class LoopSerialization {
	@Test
	public void serializationTest() throws JsonProcessingException {
		String na="lander";
		String de="this is ur first planet";
		List<Object> li=new ArrayList<Object>();
		li.add("https://www.isro.com");
		li.add("https://www.hackers.com");
		li.add(10);
		
		LoopPayload lp=new LoopPayload(na,de,li);
		ObjectMapper obj=new ObjectMapper();
		String loopPayload = obj.writerWithDefaultPrettyPrinter().writeValueAsString(lp);
		System.out.println(loopPayload);
	}
	

}
