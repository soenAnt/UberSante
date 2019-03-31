package application.model;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId", updatable = false, nullable = false)
	private int bookingId;
	
	@Column(name = "room")
	private int room;

	@ManyToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;

	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @Transient
    private double fee;
    @Transient
    private double tax;
    @Transient
    private double total_fee;

    @Transient
    private String string_fee;
    @Transient
    private String string_tax;
    @Transient
    private String string_total_fee;
    @Transient
    private NumberFormat formatter = new DecimalFormat("#0.00");

    public Booking(){}

	public Booking(Doctor doctor, Patient patient, Appointment appointment, int room) {
        this.doctor = doctor;
	    this.patient = patient;
		this.appointment = appointment;
        this.room = room;
        this.fee = 130.00;
        this.string_fee = formatter.format(this.fee) + "$";
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


    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
        this.string_tax = formatter.format(tax) + "$";
    }

    public double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
        this.string_total_fee = formatter.format(total_fee) + "$";
    }

    public String getString_fee() {
        return string_fee;
    }

    public void setString_fee(String string_fee) {
        this.string_fee = string_fee;
    }

    public String getString_tax() {
        return string_tax;
    }

    public void setString_tax(String string_tax) {
        this.string_tax = string_tax;
    }

    public String getString_total_fee() {
        return string_total_fee;
    }

    public void setString_total_fee(String string_total_fee) {
        this.string_total_fee = string_total_fee;
    }
}
