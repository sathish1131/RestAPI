package payloads;

public class DBPayload {
	
	private String firstName;
	private String lastName;
	private int subjectId;
	private int id;
	public DBPayload(String fir, String las, int sub, int id2) {
		this.firstName=fir;
		this.lastName=las;
		this.subjectId=sub;
		this.id=id2;
	}
	public DBPayload(String fir, String las, int sub) {
		this.firstName=fir;
		this.lastName=las;
		this.subjectId=sub;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
