package model;

import javax.persistence.*;
import java.util.Date;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id @GeneratedValue
	@Column(name = "appointmentId")
	private int appointmentId;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@Column(name = "startTime")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalDateTime startTime;
	
	@Column(name = "endTime")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalDateTime endTime;
		
	@Column(name = "room")
	private int room;
	
	@Column(name = "appointmentType")
	private String appointmentType;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	public Appointment(int appointmentId, LocalDate date, LocalDateTime startTime, LocalDateTime endTime, int room,
			String appointmentType, String description, Patient patient, Doctor doctor) {
		
		this.appointmentId = appointmentId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
		this.appointmentType = appointmentType;
		this.description = description;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
