package com.usman.domain;

public class PendingVehicles {
	private String vehicleNumber;
	private String vehicleType;
	private String vehicleBrand;
	private String vehicleYear;
	private int vehiclePrice;
	private boolean isVehicleInsured;
	
	public PendingVehicles(String vehicleNumber, String vehicleType, String vehicleBrand, String vehicleYear,
			int vehiclePrice, boolean isVehicleInsured) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleYear = vehicleYear;
		this.vehiclePrice = vehiclePrice;
		this.isVehicleInsured = isVehicleInsured;
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

	public String isVehicleInsured() {
		
		return isVehicleInsured ? "Yes" : "No";
		
	}

	public void setVehicleInsured(boolean isVehicleInsured) {
		this.isVehicleInsured = isVehicleInsured;
	}
	
	
}
