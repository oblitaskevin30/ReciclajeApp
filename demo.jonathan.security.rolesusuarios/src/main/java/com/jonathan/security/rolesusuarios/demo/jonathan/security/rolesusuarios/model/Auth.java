package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model;

public class Auth {

	private String email;
	private String password;

	public Auth() {}

	public Auth(String email, String password) {
		this.email = email;
		this.password = password;
	}

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
}