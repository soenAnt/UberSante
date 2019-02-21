package application.model;

import javax.persistence.*;

@Entity
@Table(name = "nurses")
public class Nurse extends User{

	@Id @GeneratedValue
	@Column(name = "nurseId")
	private int nurseId;
	
	@Column(name = "accessId")
	private String accessId;

	public Nurse(String firstName,String lastName, int nurseId, String accessId, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.nurseId = nurseId;
		this.accessId = accessId;
	}

	public int getNurseId() {
		return nurseId;
	}

	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	
}
