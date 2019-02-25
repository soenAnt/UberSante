package application.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.*;

@Entity
@Table(name = "carts")
public class Cart {
	
	@Id @GeneratedValue
	@Column(name = "cartId")
	private int cartId;

	@Column(name = "startTime")
    private Timestamp startTime;

	@Column(name = "endTime")
	private Timestamp endTime;
	
	@Column(name = "appointmentType")
	private String appointmentType;

	@ManyToOne
    @JoinColumn
    private Patient patient;

	public Cart(){}

	public Cart(Patient patient, Timestamp startTime, String appointmentType) {
        this.patient = patient;
	    this.startTime = startTime;
        this.endTime = processEndTime(startTime, appointmentType);
        this.appointmentType = appointmentType;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
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
