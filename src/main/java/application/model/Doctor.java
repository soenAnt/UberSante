package application.model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor extends User{

	@Id
    private int userId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;

	@Column(name = "specialty")
	private String specialty;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "physicianPermitNumber")
	private int physicianPermitNumber;
	


	public Doctor(String firstName, String lastName, String specialty, String city,
			int physicianPermitNumber, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.specialty = specialty;
		this.city = city;
		this.physicianPermitNumber = physicianPermitNumber;
	}


	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
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
