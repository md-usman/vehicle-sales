package com.usman.domain;

public class AdminAddVehicle {

	private String vehicleNumber;
	private int category;
	private int brand;
	private String year;
	private int price;
	private int isInsured;
	private int rating;
	private String userStatus;
	
	public AdminAddVehicle(String vehicleNumber, int category, int brand, String year, int price, int isInsured,
			int rating) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.category = category;
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.isInsured = isInsured;
		this.rating = rating;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getIsInsured() {
		return isInsured;
	}

	public void setIsInsured(int isInsured) {
		this.isInsured = isInsured;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
