package model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id @GeneratedValue
	@Column(name = "doctorId")
	private int doctorId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "specailty")
	private String specailty;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "physicianPermitNumber")
	private int physicianPermitNumber;
	
	@Column(name = "password")
	private String password;

	public Doctor(int doctorId, String firstName, String lastName, String specailty, String city,
			int physicianPermitNumber, String password) {
		
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specailty = specailty;
		this.city = city;
		this.physicianPermitNumber = physicianPermitNumber;
		this.password = password;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	public String getSpecailty() {
		return specailty;
	}

	public void setSpecailty(String specailty) {
		this.specailty = specailty;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhysicianPermitNumber() {
		return physicianPermitNumber;
	}

	public void setPhysicianPermitNumber(int physicianPermitNumber) {
		this.physicianPermitNumber = physicianPermitNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
