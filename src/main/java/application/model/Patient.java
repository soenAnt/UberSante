package application.model;

import application.datastructure.RegisterForm;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient extends User{

	@Column(name = "healthCardNumber")
	private String healthCardNumber;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;

    @OneToMany(mappedBy = "patient")
    private Collection<Appointment> appointments;

	@OneToMany(mappedBy = "patient")
	private Collection<Booking> bookings;

	@Transient
	private Cart cart;

	@Transient
    private Boolean hasCart = false;

	public Patient(){
	    super();
	}
	
	public Patient(String firstName, String lastName, String healthCardNumber, Date birthday, String gender,
			String phoneNumber, String email, String address, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.healthCardNumber = healthCardNumber;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

    public Patient(RegisterForm registerForm) {
	    super(registerForm.getFirstName(),registerForm.getLastName(),registerForm.getPassword(), registerForm.getUSER_TYPE());
        this.healthCardNumber = registerForm.getHealthCard();
        this.birthday = stringToDate(registerForm.getDateOfBirth());
        this.gender = registerForm.getGender();
        this.phoneNumber = registerForm.getPhoneNumber();
        this.email = registerForm.getEmail();
        this.address = registerForm.getAddress();
    }

    public Boolean getHasCart() {
        return hasCart;
    }

    public void setHasCart(Boolean hasCart) {
        this.hasCart = hasCart;
    }

    public String getHealthCardNumber() {
		return healthCardNumber;
	}
	public void setHealthCardNumber(String healthCardNumber) {
		this.healthCardNumber = healthCardNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    public Collection<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(Collection<Booking> bookings) {
        this.bookings = bookings;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	private Date stringToDate(String birthDate) {
        Date birth= null;
        try {
            birth = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birth;
    }
}
