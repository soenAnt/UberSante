package model;

import javax.persistence.*;

@Entity
@Table(name = "nurses")
public class Nurse {

	@Id @GeneratedValue
	@Column(name = "nurseId")
	private int nurseId;
	
	@Column(name = "accessId")
	private String accessId;
	
	@Column(name = "password")
	private String password;

	public Nurse(int nurseId, String accessId, String password) {
		
		this.nurseId = nurseId;
		this.accessId = accessId;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
