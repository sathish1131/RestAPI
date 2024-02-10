package payloads;

import java.util.List;

public class LoopPayload {
	
	public LoopPayload(String na, String de, List<Object> li) {
		this.name=na;
		this.description=de;
		this.homepage=li;
		
	}
	private String name;
	private String description;
	List<Object> homepage;
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
	public List<Object> getHomepage() {
		return homepage;
	}
	public void setHomepage(List<Object> homepage) {
		this.homepage = homepage;
	}
	
	
	

}
