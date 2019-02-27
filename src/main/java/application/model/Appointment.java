package application.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.*;

@Entity
@Table(name = "appointments")
public class Appointment {
	
	@Id @GeneratedValue
	@Column(name = "appointmentId")
	private int appointmentId;
	
	@Column(name = "room")
	private int room;
	
	@ManyToOne
	@JoinColumn(name = "appointmentInfoId")
	private AppointmentInfo appointmentInfo;
	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	/* @Column(name = "description")
	private String description; */
	
	/* @Column(name = "startTime")
	private Timestamp startTime; */

	public Appointment(int room, AppointmentInfo appointmentInfo, Doctor doctor, Patient patient) {
		this.room = room;
		this.appointmentInfo = appointmentInfo;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public AppointmentInfo getAppointmentInfo() {
		return appointmentInfo;
	}

	public void setAppointmentInfo(AppointmentInfo appointmentInfo) {
		this.appointmentInfo = appointmentInfo;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
