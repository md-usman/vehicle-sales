package com.usman.service;

import java.sql.SQLException;

import com.usman.dao.Dao;

public class LoginService {
	
	public static String validateLoginService(String userName, String password) throws ClassNotFoundException, SQLException {
		return Dao.validateUser(userName, password);
	}
	
}
