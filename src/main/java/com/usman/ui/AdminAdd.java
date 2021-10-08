package com.usman.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usman.domain.AdminAddVehicle;
import com.usman.service.AdminService;



@WebServlet("/adminAdd")
public class AdminAdd extends HttpServlet {
       

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("adminAdd.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int vehicleCategory = 2, vehicleBrand = 1, vehiclePrice = 5000, isVehicleInsured = 1, vehicleRating = 5;
		String vehicleNumber = "100", vehicleyear = "now";
		
		try {
			vehicleNumber = request.getParameter("vehicleNumber");
			vehicleCategory = Integer.parseInt(request.getParameter("category"));
			vehicleBrand = Integer.parseInt(request.getParameter("brand"));
			vehicleyear = request.getParameter("year");
			vehiclePrice = Integer.parseInt(request.getParameter("price"));
			isVehicleInsured = Integer.parseInt(request.getParameter("insured"));
			vehicleRating = Integer.parseInt(request.getParameter("rating"));
			
			
		} catch(Exception e) {
			request.removeAttribute("message");
			request.setAttribute("message", "Please Enter all the fields correctly");
			doGet(request, response);
			return;
		}
		
		AdminAddVehicle vehicle = new AdminAddVehicle(vehicleNumber, vehicleCategory, vehicleBrand, vehicleyear, vehiclePrice, isVehicleInsured, vehicleRating);
		vehicle.setPrice(vehicle.getPrice() + (vehicle.getRating() * 1000));
		vehicle.setUserStatus("ok");
		try {
			AdminService.addAdminVehicleService(vehicle);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			request.removeAttribute("message");
			request.setAttribute("message", "Vehicle " + vehicleNumber +  " Already Exists, Please enter another vehicle");
			doGet(request, response);
			return;
		}
		request.removeAttribute("message");
		request.setAttribute("message", "Vehicle number " + vehicleNumber + " successfully added.");
		doGet(request, response);
	}

}
