package gittiVelhot.workCalculator.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

@Entity (name = "users")
@JsonIgnoreProperties(value = { "passwordHash" , "passwordConfirmation"})
public class User {
	@Id
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String passwordHash;

	@Column(name = "role", nullable = false)
	private String role;
	
    @Transient
    private String passwordConfirmation;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<WorkingHours> workingHours;
	
	public User() {
	}

	public User(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
    public String getpasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

	public List<WorkingHours> getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(List<WorkingHours> workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", passwordHash=" + passwordHash + ", role=" + role + ", workingHours="
				+ workingHours + "]";
	}
	
}

