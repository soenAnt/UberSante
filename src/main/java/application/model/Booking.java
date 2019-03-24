package application.model;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId", updatable = false, nullable = false)
	private int bookingId;
	
	@Column(name = "room")
	private int room;
	
	@Column(name = "location")
	private String location;

	@ManyToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;

	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

	public Booking(){}

	public Booking(Doctor doctor, Patient patient, Appointment appointment, int room, String location) {
        this.doctor = doctor;
	    this.patient = patient;
		this.appointment = appointment;
        this.room = room;
        this.location = location;
	}

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
