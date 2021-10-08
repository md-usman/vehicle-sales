package com.usman.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.usman.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usman.domain.User;

@WebServlet("/signup")
public class Signup extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = null, lname = null, userId = null, password = null, address = null, role = null;
		Long phNo = 0l;
		
		try {
			 fname = request.getParameter("firstName");
			 lname = request.getParameter("lastName");
			 userId = request.getParameter("userId");
			 password = request.getParameter("password");
			 phNo = Long.parseLong(request.getParameter("phNo"));
			 address = request.getParameter("address");
			 role = request.getParameter("role");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Please Enter the details Correctly.");
			doGet(request, response);
			return;
		}
		
		
		
		String name = String.format(fname + " " + lname);
		
		User user = new User(userId, name, password, phNo, address, role);
		
		try {
			UserService.registerUserService(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "User id " + userId + " already present, try another.");
			doGet(request, response);
			return;
		}
		
		response.sendRedirect("home.jsp");
		
	}

}
