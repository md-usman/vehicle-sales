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
import com.usman.service.UserService;


@WebServlet("/userBought")
public class UserBought extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vehicle> list = new ArrayList<>();
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			list = UserService.getBoughtVehiclesService(username);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("type", "( Bought )");
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("userSold.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
