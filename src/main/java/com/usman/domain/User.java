package com.usman.domain;

public class User {
    private String userId;
    private String userName;
    private String password;
    private Long phoneNumber;
    private String address;
    private String role;

    public User(String userId, String userName, String password, Long phoneNumber, String address, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
    }
    
    

    public User(String userId, String userName, Long phoneNumber, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}



	public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public String getIdForHTML() {
    	return "#" + userId;
    }
}