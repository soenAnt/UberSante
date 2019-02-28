package application.model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;
import java.util.Collection;

@Entity
@Table(name = "appointmentInfo")
public class AppointmentInfo implements Cloneable, Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointmentInfoId", updatable = false, nullable = false)
	private int appointmentInfoId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "startTime")
	private Timestamp startTime;
	
	@Column(name = "appointmentType")
	private String appointmentType;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "appointmentInfo", cascade = CascadeType.ALL)
	private Collection<Appointment> appointments;
	
	public AppointmentInfo() {
		
	}
	
	public AppointmentInfo(Date date, Timestamp startTime, String appointmentType, String description) {
		this.date = date;
		this.startTime = startTime;
		this.appointmentType = appointmentType;
		this.description = description;
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

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
