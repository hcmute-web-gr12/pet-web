package com.group12.petweb.model;

public class SignUpValidationError {
	private String username;
	private String email;
	private String password;
	private String passwordVerify;

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordVerify() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	@Override
	public String toString() {
		return "SignUpValidationError{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", passwordVerify='" + passwordVerify + '\'' +
				'}';
	}
}
