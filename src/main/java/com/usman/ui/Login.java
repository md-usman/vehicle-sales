package com.usman.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usman.service.LoginService;

@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
		String role = null;
		try {
			role = (String) LoginService.validateLoginService(userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		
		if(role != null) {
			if(role.equals("admin")) {
				
				HttpSession session = request.getSession();
				session.setAttribute("username", "admin");
				
				Admin ad = new Admin();
				ad.doGet(request, response);
				return;
				
			} else if (role.equals("user")) {
				
				HttpSession session = request.getSession();
				session.setAttribute("username", userName);
				User u = new User();
				u.doGet(request, response);
				return;
				
			}
		}
		request.setAttribute("message", "Invalid UserName or Password");
		doGet(request, response);
	}

}
