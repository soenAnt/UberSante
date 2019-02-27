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
	
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "appointmentInfoId")
	private AppointmentInfo appointmentInfo;
	
	public Cart(Patient patient, AppointmentInfo appointmentInfo) {
		this.patient = patient;
		this.appointmentInfo = appointmentInfo;
	}
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public AppointmentInfo getAppointmentInfo() {
		return appointmentInfo;
	}

	public void setAppointmentInfo(AppointmentInfo appointmentInfo) {
		this.appointmentInfo = appointmentInfo;
	}
	
}
