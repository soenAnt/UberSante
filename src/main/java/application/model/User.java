package application.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", updatable = false, nullable = false)
    private int userId;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "password")
	private String password;

	@Column(name = "userType")
	private String userType;
	
	public User(String firstName, String lastName, String password, String userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userType = userType;
	}

	public User() {

	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
