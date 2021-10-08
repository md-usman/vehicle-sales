package com.usman.domain;

public class UserRole {
	
	private String role;
	private boolean isValidated;

	public UserRole(String role, boolean isValidated) {
		super();
		this.role = role;
		this.isValidated = isValidated;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isValidated() {
		return isValidated;
	}
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	
}
