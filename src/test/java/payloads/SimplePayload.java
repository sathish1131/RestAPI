package payloads;

public class SimplePayload {
	public SimplePayload(String n, String d, String h) {
		this.name = n;
		this.description = d;
		this.homePage = h;
	}

	private String name;
	private String description;
	private String homePage;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

}
