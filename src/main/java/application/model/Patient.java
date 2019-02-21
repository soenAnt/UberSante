package application.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient extends User{

    @Id
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
	
	@Column(name = "healthCardNumber")
	private String healthCardNumber;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	
	public Patient(String firstName, String lastName, String healthCardNumber, Date birthday, char gender,
			int phoneNumber, String email, String address, String password, String userType) {
		super(firstName, lastName, password, userType);
		this.healthCardNumber = healthCardNumber;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
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


}
