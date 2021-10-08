package com.usman.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usman.domain.Vehicle;
import com.usman.service.AdminService;
import com.usman.service.UserService;

@WebServlet("/user")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vehicle> list = new ArrayList<>();
		try {
			list = AdminService.getAllVehicleService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vehicleNumber = request.getParameter("vNumber");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		try {
			UserService.boughtVehicleService(vehicleNumber, username);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		}
		
		request.setAttribute("message", "Vehicle number " + vehicleNumber + " Bought Successfully.");
		doGet(request, response);
		
	}

}
