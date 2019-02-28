package application.model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;

@Entity
@Table(name = "appointmentInfo")
public class AppointmentInfo implements Cloneable, Serializable {
	
	@Id @GeneratedValue
	@Column(name = "appointmentInfoId")
	private int appointmentInfoId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "startTime")
	private Timestamp startTime;
	
	@Column(name = "appointmentType")
	private String appointmentType;
	
	public AppointmentInfo() {
		
	}
	
	public AppointmentInfo(Date date, Timestamp startTime, String appointmentType) {
		this.date = date;
		this.startTime = startTime;
		this.appointmentType = appointmentType;
	}
	
	public AppointmentInfo(AppointmentInfo info) {
		this.appointmentType = info.appointmentType;
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
	
	/*
	 * doesn't seem to work; it doesn't like having the ID be null, but it also
	 * clones the old ID which overrites what is already in the DB :S
	@Override
	public Object clone() throws CloneNotSupportedException {
		AppointmentInfo clone = (AppointmentInfo) super.clone();
		clone.appointmentInfoId = (Integer) null;
		return clone;
	}
	*/
}
