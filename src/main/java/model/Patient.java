package model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {
	@Id @GeneratedValue
	@Column(name = "patientId")
	private int patientId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
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
	
	@Column(name = "password")
	private String password;
	
	public Patient(int patientId, String firstName, String lastName, String healthCardNumber, Date birthday, char gender,
			int phoneNumber, String email, String address, String password) {
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.healthCardNumber = healthCardNumber;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
