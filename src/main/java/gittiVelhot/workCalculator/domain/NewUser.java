package gittiVelhot.workCalculator.domain;

public class NewUser {
	
	private String username;
	private String password;
    private String passwordCheck;

	public NewUser() {
	}

	public NewUser(String username, String password, String passwordCheck) {
		super();
        this.username = username;
		this.password = password;
		this.passwordCheck = passwordCheck;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", passwordCHECK=" + passwordCheck + "]";
	}
	
}

