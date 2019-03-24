package application.model;

import javax.persistence.*;

@Entity
@Table(name = "clinics")
public class Clinic {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clinicId", updatable = false, nullable = false)
	private int clinicId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "num_doctors")
	private int num_doctors;

	@ManyToOne
	@JoinColumn(name = "num_nurses")
	private int num_nurses;

	@ManyToOne
	@JoinColumn(name = "num_rooms")
	private int num_rooms;
	
	@ManyToOne
	@JoinColumn(name = "num_bookings")
	private int num_bookings;

	public Clinic(){}

	public Clinic(int clinicId, String name, int num_doctors, int num_nurses, int num_rooms, int num_bookings) {
		this.clinicId = clinicId;
		this.name = name;
		this.num_doctors = num_doctors;
		this.num_nurses = num_nurses;
		this.num_rooms = num_rooms;
		this.num_bookings = num_bookings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum_doctors() {
		return num_doctors;
	}

	public void setNum_doctors(int num_doctors) {
		this.num_doctors = num_doctors;
	}

	public int getNum_nurses() {
		return num_nurses;
	}

	public void setNum_nurses(int num_nurses) {
		this.num_nurses = num_nurses;
	}

	public int getNum_rooms() {
		return num_rooms;
	}

	public void setNum_rooms(int num_rooms) {
		this.num_rooms = num_rooms;
	}

	public int getNum_bookings() {
		return num_bookings;
	}

	public void setNum_bookings(int num_bookings) {
		this.num_bookings = num_bookings;
	}


	

}
