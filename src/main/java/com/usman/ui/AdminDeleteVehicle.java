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

import com.usman.domain.Vehicle;
import com.usman.service.AdminService;

@WebServlet("/adminDeleteVehicle")
public class AdminDeleteVehicle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String vehicleNumber = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vehicleNumber = request.getParameter("vNumber");
		System.out.print(vehicleNumber);
		try {
			AdminService.deleteVehicleService(vehicleNumber);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Vehicle> list = new ArrayList<>();
		try {
			request.setAttribute("type", "( All Vehicles )");
			list= AdminService.getAllVehicleService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.setAttribute("message", "Vehicle number " + vehicleNumber + " successfully deleted");
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}
