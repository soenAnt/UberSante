package application.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "doctors")
public class Doctor extends User {

	@Column(name = "specialty")
	private String specialty;

	@Column(name = "city")
	private String city;

	@Column(name = "physicianPermitNumber")
	private int physicianPermitNumber;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private Collection<Schedule> schedules;

	public Doctor() {}

	public Doctor(String firstName, String lastName, String specialty, String city,
				  int physicianPermitNumber, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.specialty = specialty;
		this.city = city;
		this.physicianPermitNumber = physicianPermitNumber;
	}


}
