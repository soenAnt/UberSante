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

	@Column(name = "startTime")
	private Timestamp startTime;

	@Column(name = "endTime")
	private Timestamp endTime;

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

	public Appointment(Timestamp startTime, int room, String appointmentType, String description,
					   Patient patient, Doctor doctor) {

		this.startTime = startTime;
		this.endTime = processEndTime(startTime, appointmentType);
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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
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

	private Timestamp processEndTime(Timestamp startTime, String appointmentType) {

		LocalDateTime start = startTime.toLocalDateTime();
		LocalDateTime end = null;

		if(appointmentType == "20min" || appointmentType == "walk-in"){
			end = start.plusMinutes(20);
		}
		else{
			end = start.plusMinutes(60);
		}

		endTime = Timestamp.valueOf(end);

		return endTime;
	}
}
