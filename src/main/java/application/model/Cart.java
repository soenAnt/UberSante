package application.model;

import javax.persistence.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "carts")
public class Cart {
	
	@Id @GeneratedValue
	@Column(name = "appointmentId")
	private int cartId;
	
	@Column(name = "date")
	private int patientId;
	
	@Column(name = "endTime")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalDateTime datetime;
	
	@Column(name = "appointmentType")
	private String appointmentType;

	public Cart(int cartId, int patientId, LocalDateTime datetime, String appointmentType) {
		
		this.cartId = cartId;
		this.patientId = patientId;
		this.datetime = datetime;
		this.appointmentType = appointmentType;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	
	
}
