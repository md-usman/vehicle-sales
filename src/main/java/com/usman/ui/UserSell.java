package com.usman.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usman.domain.AdminAddVehicle;
import com.usman.service.UserService;

@WebServlet("/userSell")
public class UserSell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("userSell.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int vehicleCategory = 2, vehicleBrand = 1, vehiclePrice = 5000, isVehicleInsured = 1;
		String vehicleNumber = "100", vehicleyear = "now";
		
		try {
			vehicleNumber = request.getParameter("vehicleNumber");
			vehicleCategory = Integer.parseInt(request.getParameter("category"));
			vehicleBrand = Integer.parseInt(request.getParameter("brand"));
			vehicleyear = request.getParameter("year");
			vehiclePrice = Integer.parseInt(request.getParameter("price"));
			isVehicleInsured = Integer.parseInt(request.getParameter("insured"));
			
		} catch(Exception e) {
			request.removeAttribute("message");
			request.setAttribute("message", "Please Enter all the fields correctly");
			doGet(request, response);
			return;
		}
		
		AdminAddVehicle vehicle = new AdminAddVehicle(vehicleNumber, vehicleCategory, vehicleBrand, vehicleyear, vehiclePrice, isVehicleInsured, 0);
		vehicle.setUserStatus("pending");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		try {
			UserService.sellVehicleService(vehicle, username);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.removeAttribute("message");
			request.setAttribute("message", "Vehicle " + vehicleNumber +  " Already Exists, Please enter another vehicle");
			doGet(request, response);
			return;
		}
		
		request.removeAttribute("message");
		request.setAttribute("message", "Vehicle number " + vehicleNumber + " successfully sold.");
		doGet(request, response);
	}

}
