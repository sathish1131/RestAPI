package payloads;

public class CP_Contries {
	public CP_Contries(String cont,CP_Data dat) {
		this.country=cont;
		this.data=dat;
	}
	private String country;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public CP_Data getData() {
		return data;
	}
	public void setData(CP_Data data) {
		this.data = data;
	}
	private CP_Data data;

}
