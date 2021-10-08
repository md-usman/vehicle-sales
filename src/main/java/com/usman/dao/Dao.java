package com.usman.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import com.usman.domain.AdminAddVehicle;
import com.usman.domain.PendingVehicles;
import com.usman.domain.User;
import com.usman.domain.Vehicle;
import com.usman.domain.VehicleUser;
import com.usman.util.DbConnection;

public class Dao {
	
	public static void registerUser(User user) throws SQLException, ClassNotFoundException {
		
        Connection con = DbConnection.getDbConnection();
        Statement stmt = con.createStatement();

        String statement = String.format("insert into user values('%s','%s','%s',%d, '%s', '%s');",
                user.getUserId(), user.getUserName(), user.getPassword(), user.getPhoneNumber(), user.getAddress(),
                user.getRole());
        ((java.sql.Statement) stmt).executeUpdate(statement);
        con.close();
    }
	
	public static String validateUser(String userName, String password) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getDbConnection();
        String query = "select u_role from user where u_id = ? and pass = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, userName);
        stmt.setString(2, password);
        String role = null;
        ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			role = rs.getString(1);
		}   
		con.close();
		return role;
	}
	
	public static void AddAdminVehicle(AdminAddVehicle vehicle) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getDbConnection();
		String query = "insert into vehicle values(?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, vehicle.getVehicleNumber());
		stmt.setInt(2, vehicle.getCategory());
		stmt.setInt(3, vehicle.getBrand());
		stmt.setString(4, vehicle.getYear());
		stmt.setInt(5, vehicle.getPrice());
		stmt.setInt(6, vehicle.getIsInsured());
		stmt.setInt(7, vehicle.getRating());
		stmt.setString(8, vehicle.getUserStatus());
		stmt.executeUpdate();
		con.close();
	}
	
	public static List<PendingVehicles> getAllPendingVehicles() throws ClassNotFoundException, SQLException {
		
		List<PendingVehicles> vehicles = new ArrayList<>();
		Connection con = DbConnection.getDbConnection();
		String query = "select v_no, c.c_type, b.b_name, v_year, v_price, v_insurance from vehicle v, category c, brand b where v.v_category=c.c_id and v.v_brand=b.b_id and v.u_status='pending';";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			vehicles.add(new PendingVehicles(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
		}
		con.close();
		return vehicles;
	}
	
	public static void deleteVehicle(String vehicleNumber) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		String query = "delete from vehicle where v_no = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, vehicleNumber);
		stmt.executeUpdate();
		con.close();
	}
	
	public static void approveVehicle(String vehicleNumber, int rating) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		String query = "select v_price from vehicle where v_no = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, vehicleNumber);
		ResultSet rs = stmt.executeQuery();
		int price = 0;
		while(rs.next()) 
			price = rs.getInt(1);
		int newPrice = price + (rating * 1000);
		query = "update vehicle set v_price = ?, v_condition = ?, u_status = ? where v_no = ?";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, newPrice);
		stmt.setInt(2, rating);
		stmt.setString(3, "ok");
		stmt.setString(4, vehicleNumber);
		stmt.executeUpdate();
		con.close();
	}

	public static List<Vehicle> getAllVehicles() throws ClassNotFoundException, SQLException {
		
		List<Vehicle> list = new ArrayList<>();
		Connection con = DbConnection.getDbConnection();
		String query = "select v_no, c.c_type, b.b_name, v_year, v_price, v_insurance, v_condition from vehicle v, category c, brand b where v.v_category=c.c_id and v.v_brand=b.b_id and v.u_status='ok';";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getInt(7)));
		}
		con.close();
		return list;
	}
	
	public static List<Vehicle> getSoldVehicles() throws ClassNotFoundException, SQLException {
		
		List<Vehicle> list = new ArrayList<>();
		Connection con = DbConnection.getDbConnection();
		String query = "select v_no, c.c_type, b.b_name, v_year, v_price, v_insurance, v_condition from vehicle v, category c, brand b where v.v_category=c.c_id and v.v_brand=b.b_id and v.u_status='sold';";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getInt(7)));
		}
		con.close();
		return list;
	}
	
	public static List<Vehicle> getVehiclesByCategory(int category) throws ClassNotFoundException, SQLException {
		
		List<Vehicle> list = new ArrayList<>();
		Connection con = DbConnection.getDbConnection();
		String query = "select v_no, c.c_type, b.b_name, v_year, v_price, v_insurance, v_condition from vehicle v, category c, brand b where v.v_category=c.c_id and v.v_brand=b.b_id and v.u_status='ok' and v_category = ?;";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, category);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getInt(7)));
		}
		con.close();
		return list;
	}
	
	public static List<Vehicle> getVehicleById(String number) throws ClassNotFoundException, SQLException {
		List<Vehicle> list = new ArrayList<>();
		Connection con = DbConnection.getDbConnection();
		String query = "select v_no, c.c_type, b.b_name, v_year, v_price, v_insurance, v_condition from vehicle v, category c, brand b where v.v_category=c.c_id and v.v_brand=b.b_id and v_no = ?;";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, number);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getInt(7)));
		}
		con.close();
		return list;
	}
	
	public static List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		List<User> userList = new ArrayList<>();
		Connection con = DbConnection.getDbConnection();
		String query = "select u_id, u_name, ph_no, address from user where u_role=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, "user");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) 
			userList.add(new User(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4) ));
		con.close();
		return userList;
	}
	
	public static void deleteUser(String userId) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		String query = "delete from user where u_id = ? and u_role=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, userId);
		stmt.setString(2, "user");
		stmt.executeUpdate();
		con.close();
	}
	
	public static List<Vehicle> getAllSoldVehicles(String userId) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		List<Vehicle> list = new ArrayList<>();
		String query = "select v.v_no, c.c_type, b.b_name, v_year, s.price, v_insurance, v_condition, time from vehicle v, category c, brand b, sold s where v.v_category=c.c_id and v.v_brand=b.b_id and v.v_no=s.v_no and s.u_id = ?;";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, userId);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getInt(7), rs.getString(8)));
		}
		con.close();
		return list;
	}
	
	public static List<Vehicle> getAllBoughtVehicles(String userId) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		List<Vehicle> list = new ArrayList<>();
		String query = "select v.v_no, c.c_type, b.b_name, v_year, v_price, v_insurance, v_condition, time from vehicle v, category c, brand b, bought s where v.v_category=c.c_id and v.v_brand=b.b_id and v.v_no=s.v_no and s.u_id = ?;";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, userId);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getInt(7), rs.getString(8)));
		}
		con.close();
		return list;
	}
	
	public static void insertSold(VehicleUser vehicle) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		String query = "insert into sold values(?, ?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1,  vehicle.getVehicleNumber());
		stmt.setString(2,  vehicle.getUserId());
		stmt.setString(3,  vehicle.getTime());
		stmt.setInt(4,  vehicle.getPrice());
		stmt.executeUpdate();
		con.close();
	}
	
	public static void insertBought(VehicleUser vehicle) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		String query = "insert into bought values(?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1,  vehicle.getVehicleNumber());
		stmt.setString(2,  vehicle.getUserId());
		stmt.setString(3,  vehicle.getTime());
		stmt.executeUpdate();
		query = "update vehicle set u_status = ? where v_no = ?";
		stmt = con.prepareStatement(query);
		stmt.setString(1,  "sold");
		stmt.setString(2, vehicle.getVehicleNumber());
		stmt.executeUpdate();
		con.close();
	}
}
