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

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private Collection<Booking> bookings;

	public Doctor(String firstName, String lastName, String specialty, String city,
				  int physicianPermitNumber, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.specialty = specialty;
		this.city = city;
		this.physicianPermitNumber = physicianPermitNumber;
	}

	public Doctor() {super();}

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

	public Collection<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}

	public Collection<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(Collection<Schedule> schedules) {
		this.schedules = schedules;
	}
}
