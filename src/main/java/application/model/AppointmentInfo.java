package application.model;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;

@Entity
@Table(name = "appointmentInfo")
public class AppointmentInfo {
	
	@Id @GeneratedValue
	@Column(name = "appointmentInfoId")
	private int appointmentInfoId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "startTime")
	private Timestamp startTime;
	
	@Column(name = "appointmentType")
	private String appointmentType;
	
	public AppointmentInfo(Date date, Timestamp startTime, String appointmentType) {
		this.date = date;
		this.startTime = startTime;
		this.appointmentType = appointmentType;
	}

	public int getAppointmentInfoId() {
		return appointmentInfoId;
	}

	public void setAppointmentInfoId(int appointmentInfoId) {
		this.appointmentInfoId = appointmentInfoId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

}
