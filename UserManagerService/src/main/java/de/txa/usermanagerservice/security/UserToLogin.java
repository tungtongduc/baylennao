package de.txa.usermanagerservice.security;

public class UserToLogin {

	private String email;
	private String password;
	private UserRoll userRoll;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRoll getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(UserRoll userRoll) {
		this.userRoll = userRoll;
	}
}
