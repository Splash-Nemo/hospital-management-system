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

@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public adminLogin() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if (email==null || password==null || email.isEmpty() || password.isEmpty()) {
			session.setAttribute("admin-msg", "All fields are mandatory");
			
			// Later set redirect to admin-dashboard
			response.sendRedirect("forms/admin_login.jsp");
			
			return;
		}

		User user = new User(email, password);
		DAO dao = null;

		boolean bool = false;
		try {
			dao = new DAO(DBconnect.getConnection());
			bool = dao.adminLogin(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(bool) {
			session.setAttribute("admin-msg", "Valid Credentials");
			// Later set redirect to admin-dashboard
			response.sendRedirect("forms/admin_login.jsp");
		}else {
			session.setAttribute("admin-msg", "Invalid Credentials");
			response.sendRedirect("forms/admin_login.jsp");
		}
	}

}
