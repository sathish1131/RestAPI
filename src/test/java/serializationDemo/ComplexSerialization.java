package serializationDemo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payloads.CP_Contries;
import payloads.CP_Data;
import payloads.CP_Desc;

public class ComplexSerialization {
	@Test
	public void complexSerializationTest() throws JsonProcessingException {

		String des = "Map containing Country, Capital, Currency, and some States of that Country";
		String reg = "Asia";
		String con = "India";
		int min = 6;
		int max = 45;
		String cur = "Rupee";
		String cap = "New Delhi";

		CP_Data obj3=new CP_Data(min, max, cur, cap);
		CP_Contries obj2=new CP_Contries(con, obj3);
		CP_Desc obj1 = new CP_Desc(des, reg, obj2);
		
		ObjectMapper obj=new ObjectMapper();
		String jsonPayload = obj.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);
		System.out.println(jsonPayload);
	}

}
