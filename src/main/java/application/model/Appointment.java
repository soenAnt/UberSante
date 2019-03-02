package application.model;

import javax.persistence.*;
import java.util.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Collection;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointmentId", updatable = false, nullable = false)
	private int appointmentId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "startTime")
	private Time startTime;

	@Column(name = "endTime")
    private Time endTime;

	@Column(name = "description")
    private String description;
	
	@Column(name = "appointmentType")
	private String appointmentType;

	@ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

	@OneToMany(mappedBy = "appointment")
	private Collection<Booking> bookings;

	@Transient
    private String uuid;
	
	public Appointment() {}

    public Appointment(Patient patient, Date date, Time startTime, String appointmentType, String description) {
        this.patient = patient;
	    this.date = date;
        this.startTime = startTime;
        this.appointmentType = appointmentType;
        this.endTime = processEndTime(startTime, appointmentType);
        this.description = description;
        this.uuid = "abc";
    }

    private Time processEndTime(Time startTime, String appointmentType) {

        LocalTime start = startTime.toLocalTime();
        LocalTime end;

        if(appointmentType.equals("20min") || appointmentType.equals("walk-in")){
            end = start.plusMinutes(20);
        }
        else{
            end = start.plusMinutes(60);
        }

        endTime = Time.valueOf(end);

        return endTime;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time startTime, String appointment_type) {
        this.endTime = processEndTime(startTime, appointment_type);
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Collection<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Collection<Booking> bookings) {
        this.bookings = bookings;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
