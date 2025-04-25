package com.users.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.DAO.DAO;
import com.database.DBconnect;
import com.entities.User;

@WebServlet("/userRegister")
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userRegister() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null
				|| password.isEmpty()) {

			session.setAttribute("reg-msg", "All Fields are Mandatory");
			response.sendRedirect("forms/register.jsp");
			return;
		}

		User user = new User(name, email, password);
		DAO dao = null;

		boolean bool = false;
		try {
			dao = new DAO(DBconnect.getConnection());
			bool = dao.userRegister(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (bool) {
			session.setAttribute("reg-msg", "Registered Successfully");
			response.sendRedirect("forms/register.jsp");
		} else {
			session.setAttribute("reg-msg", "Email ID exists");
			response.sendRedirect("forms/register.jsp");
		}
	}
}
