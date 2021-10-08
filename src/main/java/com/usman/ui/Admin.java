package com.usman.ui;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Vehicle> list = new ArrayList<>();
		try {
			request.setAttribute("type", "( All Vehicles )");
			list= AdminService.getAllVehicleService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String wheels = request.getParameter("wheels");
		List<Vehicle> list = new ArrayList<>();
		if(wheels.equals("all"))
			try {
				request.setAttribute("type", "( All Vehicles )");
				list = AdminService.getAllVehicleService();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		else if(wheels.equals("two"))
			try {
				request.setAttribute("type", "( Two Wheeler )");
				list = AdminService.getVehiclesByCategoryService(2);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		else if(wheels.equals("three"))
			try {
				request.setAttribute("type", "( Three Wheeler )");
				list = AdminService.getVehiclesByCategoryService(3);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		else if(wheels.equals("four"))
			try {
				request.setAttribute("type", "( Four Wheeler )");
				list = AdminService.getVehiclesByCategoryService(4);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		else if(wheels.equals("six"))
			try {
				request.setAttribute("type", "( Six Wheeler )");
				list = AdminService.getVehiclesByCategoryService(6);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(wheels.equals("vNumber")) {
			String vehicleNumber = request.getParameter("number");
			try {
				request.setAttribute("type", "");
				list = (List<Vehicle>) AdminService.getVehicleByIdService(vehicleNumber);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
			
	}

}
