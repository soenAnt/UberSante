package application.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient extends User{
	@Id @GeneratedValue
	@Column(name = "patientId")
	private int patientId;
	
	@Column(name = "healthCardNumber")
	private String healthCardNumber;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	
	public Patient(int patientId, String firstName, String lastName, String healthCardNumber, Date birthday, char gender,
			int phoneNumber, String email, String address, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.patientId = patientId;
		this.healthCardNumber = healthCardNumber;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String gethealthCardNumber() {
		return healthCardNumber;
	}
	public void sethealthCardNumber(String healthCardNumber) {
		this.healthCardNumber = healthCardNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
