package serializationDemo;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payloads.CP_PayloadList;

public class ComplexSerializationList {
	@Test
	public void test() throws JsonProcessingException {
		String des="Map containing Country, Capital, Currency, and some States of that Country";
		String reg="Asia";
		LinkedHashMap<String , Object> dataMap = new LinkedHashMap<>();
		dataMap.put("minimumtemp", 6);
		dataMap.put("maximumtemp", 45);
		dataMap.put("currency", "Rupee");
		dataMap.put("capital", "New Delhi");
		LinkedHashMap<String , Object> map = new LinkedHashMap<>();
		map.put("country","India");
		map.put("data", dataMap);
		
		CP_PayloadList pay=new CP_PayloadList(des,reg,map);
		ObjectMapper obj=new ObjectMapper();
		String payload = obj.writerWithDefaultPrettyPrinter().writeValueAsString(pay);
		System.out.println(payload);
	}

}
