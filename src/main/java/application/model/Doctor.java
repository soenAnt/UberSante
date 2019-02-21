package application.model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor extends User{

	@Id @GeneratedValue
	@Column(name = "doctorId")
	private int doctorId;

	@Column(name = "specailty")
	private String specailty;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "physicianPermitNumber")
	private int physicianPermitNumber;
	


	public Doctor(int doctorId, String firstName, String lastName, String specailty, String city,
			int physicianPermitNumber, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.doctorId = doctorId;
		this.specailty = specailty;
		this.city = city;
		this.physicianPermitNumber = physicianPermitNumber;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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


}
