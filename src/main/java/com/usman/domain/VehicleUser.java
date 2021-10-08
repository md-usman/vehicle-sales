package com.usman.domain;

public class VehicleUser {
	private String vehicleNumber;
	private String userId;
	private String Time;
	private int price;
	
	public VehicleUser(String vehicleNumber, String userId, String time) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.userId = userId;
		Time = time;
	}
	
	
	
	public VehicleUser(String vehicleNumber, String userId, String time, int price) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.userId = userId;
		Time = time;
		this.price = price;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
	
}
