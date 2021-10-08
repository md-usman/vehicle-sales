package com.usman.domain;

public class Vehicle {
	private String vehicleNumber;
	private String vehicleType;
	private String vehicleBrand;
	private String vehicleYear;
	private int vehiclePrice;
	private boolean vehicleInsurance;
	private int vehicleRating;
	private String time;
	
	
	
	public Vehicle(String vehicleNumber, String vehicleType, String vehicleBrand, String vehicleYear, int vehiclePrice,
			boolean vehicleInsurance, int vehicleRating, String time) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleYear = vehicleYear;
		this.vehiclePrice = vehiclePrice;
		this.vehicleInsurance = vehicleInsurance;
		this.vehicleRating = vehicleRating;
		this.time = time;
	}

	public Vehicle(String vehicleNumber, String vehicleType, String vehicleBrand, String vehicleYear, int vehiclePrice,
			boolean vehicleInsurance, int vehicleRating) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleYear = vehicleYear;
		this.vehiclePrice = vehiclePrice;
		this.vehicleInsurance = vehicleInsurance;
		this.vehicleRating = vehicleRating;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public int getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(int vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public String getVehicleInsurance() {
		return vehicleInsurance ? "Yes" : "No";
	}

	public void setVehicleInsurance(boolean vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}

	public int getVehicleRating() {
		return vehicleRating;
	}

	public void setVehicleRating(int vehicleRating) {
		this.vehicleRating = vehicleRating;
	}
	
	public String getIdForHTML() {
		return "#" + vehicleNumber;
	}
}
