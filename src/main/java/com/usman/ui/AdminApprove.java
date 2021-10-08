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

import com.usman.domain.PendingVehicles;
import com.usman.service.AdminService;


@WebServlet("/adminApprove")
public class AdminApprove extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PendingVehicles> vehicles = new ArrayList<PendingVehicles>();
		
		try {
			vehicles = AdminService.getAllPendingVehiclesService();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("admin.jsp");
		}
		request.setAttribute("pendingVehicles", vehicles);
		RequestDispatcher rd = request.getRequestDispatcher("approve.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String vehicleNumber = request.getParameter("vehicleNumber");
		String type = request.getParameter("type");
		if(type.equals("approve")) {
			int rating = Integer.parseInt(request.getParameter("rating"));
			try {
				AdminService.approveVehicleService(vehicleNumber, rating);
				request.setAttribute("message", "Successfully approved vehicle no " + vehicleNumber);
				doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("message", "Something went wrong please try again later.");
				doGet(request, response);
				e.printStackTrace();
			}
		} else {
			try {
				AdminService.deleteVehicleService(vehicleNumber);
				request.setAttribute("message", "Successfully Deleted vehicle no " + vehicleNumber);
				doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("message", "Something went wrong please try again later.");
				doGet(request, response);
				e.printStackTrace();
			}
		}

	}

}
