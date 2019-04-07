package application.model;

import javax.persistence.*;

@Entity
@Table(name = "nurses")
public class Nurse extends User{

	@Column(name = "accessId")
	private String accessId;

	public Nurse(String firstName,String lastName, String accessId, String password, String userType,  String location) {
		super(firstName, lastName, password, userType, location);
		this.accessId = accessId;
	}
	public Nurse() {super();}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	
}
