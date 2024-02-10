package payloads;

import java.util.LinkedHashMap;

public class CP_PayloadList {

	public CP_PayloadList(String des, String reg, LinkedHashMap<String,Object> map) {
		this.description=des;
		this.region=reg;
		this.countries=map;

	}
	private String description;
	private String region;
	private LinkedHashMap<String, Object> countries;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public LinkedHashMap<String, Object> getCountries() {
		return countries;
	}
	public void setCountries(LinkedHashMap<String, Object> countries) {
		this.countries = countries;
	}
	
	

}
