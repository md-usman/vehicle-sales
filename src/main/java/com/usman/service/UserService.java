package com.usman.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.usman.dao.*;
import com.usman.domain.AdminAddVehicle;
import com.usman.domain.User;
import com.usman.domain.Vehicle;
import com.usman.domain.VehicleUser;

public class UserService {
	
	public static void registerUserService(User user) throws ClassNotFoundException, SQLException {
		Dao.registerUser(user);
	}

	public static List<Vehicle> getSoldVehiclesService(String userId) throws ClassNotFoundException, SQLException {
		return Dao.getAllSoldVehicles(userId);
	}
	
	public static List<Vehicle> getBoughtVehiclesService(String userId) throws ClassNotFoundException, SQLException {
		return Dao.getAllBoughtVehicles(userId);
	}
	
	public static void sellVehicleService(AdminAddVehicle vehicle, String userId) throws ClassNotFoundException, SQLException {
		Dao.AddAdminVehicle(vehicle);
		Dao.insertSold(new VehicleUser(vehicle.getVehicleNumber(), userId, LocalDate.now().toString(), vehicle.getPrice()));
	}
	
	public static void boughtVehicleService(String vehicleNumber, String userId) throws ClassNotFoundException, SQLException {
		Dao.insertBought(new VehicleUser(vehicleNumber, userId, LocalDate.now().toString()));
	}
}
