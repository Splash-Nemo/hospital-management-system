package com.users.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

		if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
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
			Connection conn = DBconnect.getConnection();

			String sql = "SELECT name FROM hospital_data WHERE Email = ? AND Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getMail());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) user.setName(rs.getString("name"));
			else user.setName("Name not set");

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (bool) {

			session.setAttribute("userObj", user);
			// Later set redirect to user-dashboard
			session.setAttribute("userMail", user.getMail());
			response.sendRedirect("user/index.jsp");
		} else {
			session.setAttribute("user-msg", "Invalid Credentials");
			response.sendRedirect("forms/user_login.jsp");
		}
	}
}
