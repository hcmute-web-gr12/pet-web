package com.group12.petweb.model;

public class LoginValidationError {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginValidationError{" +
				"email='" + getEmail() + '\'' +
				", password='" + getPassword() + '\'' +
				'}';
	}
}
