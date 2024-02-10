package payloads;

public class CP_Desc {
	public CP_Desc(String des,String reg,CP_Contries con) {
		this.description=des;
		this.region=reg;
		this.countries=con;
	}
	private String description;
	private String region;
	private CP_Contries countries;
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
	public CP_Contries getCountries() {
		return countries;
	}
	public void setCountries(CP_Contries countries) {
		this.countries = countries;
	}
	

}
