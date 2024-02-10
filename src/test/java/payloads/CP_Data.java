package payloads;

public class CP_Data {
	public CP_Data(int min,int max,String cur,String cap) {
		this.minimumtemp=min;
		this.maximumtemp=max;
		this.currency=cur;
		this.capital=cap;
	}
	private int minimumtemp;
	private int maximumtemp;
	private String currency;
	private String capital;
	public int getMinimumtemp() {
		return minimumtemp;
	}
	public void setMinimumtemp(int minimumtemp) {
		this.minimumtemp = minimumtemp;
	}
	public int getMaximumtemp() {
		return maximumtemp;
	}
	public void setMaximumtemp(int maximumtemp) {
		this.maximumtemp = maximumtemp;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
}
