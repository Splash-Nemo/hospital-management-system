package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.DAO;
import com.database.DBconnect;
import com.entities.User;

@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userLogin() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if (email==null || password==null || email.isEmpty() || password.isEmpty()) {
			session.setAttribute("user-msg", "All fields are mandatory");
			
			// Later set redirect to user-dashboard
			response.sendRedirect("forms/user_login.jsp");
			
			return;
		}

		User user = new User(email, password);
		DAO dao = null;

		boolean bool = false;
		try {
			dao = new DAO(DBconnect.getConnection());
			bool = dao.userLogin(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(bool) {
			session.setAttribute("user-msg", "Valid Credentials");
			// Later set redirect to user-dashboard
			response.sendRedirect("forms/user_login.jsp");
		}else {
			session.setAttribute("user-msg", "Invalid Credentials");
			response.sendRedirect("forms/user_login.jsp");
		}
	}
}
