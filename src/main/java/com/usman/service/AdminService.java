package com.usman.service;

import com.usman.domain.AdminAddVehicle;
import com.usman.domain.PendingVehicles;
import com.usman.domain.User;
import com.usman.domain.Vehicle;

import java.sql.SQLException;
import java.util.List;

import com.usman.dao.*;

public class AdminService {
	
	public static void addAdminVehicleService(AdminAddVehicle vehicle) throws ClassNotFoundException, SQLException {
		Dao.AddAdminVehicle(vehicle);
	}

	public static List<PendingVehicles> getAllPendingVehiclesService() throws ClassNotFoundException, SQLException {
		return Dao.getAllPendingVehicles();
	}
	
	public static void deleteVehicleService(String vehicleNumber) throws ClassNotFoundException, SQLException {
		Dao.deleteVehicle(vehicleNumber);
	}
	
	public static void approveVehicleService(String vehicleNumber, int rating) throws ClassNotFoundException, SQLException {
		Dao.approveVehicle(vehicleNumber, rating);
	}
	
	public static List<Vehicle> getAllVehicleService() throws ClassNotFoundException, SQLException {
		return Dao.getAllVehicles();
	}
	
	public static List<Vehicle> getSoldVehicleService() throws ClassNotFoundException, SQLException {
		return Dao.getSoldVehicles();
	}
	
	public static List<Vehicle> getVehiclesByCategoryService(int category) throws ClassNotFoundException, SQLException {
		return Dao.getVehiclesByCategory(category);
	}
	
	public static List<Vehicle> getVehicleByIdService(String number) throws ClassNotFoundException, SQLException {
		return Dao.getVehicleById(number);
	}
	
	public static List<User> getAllUsersService() throws ClassNotFoundException, SQLException {
		return Dao.getAllUsers();
	}
	
	public static void deleteUserService(String userId) throws ClassNotFoundException, SQLException {
		Dao.deleteUser(userId);
	}
}
