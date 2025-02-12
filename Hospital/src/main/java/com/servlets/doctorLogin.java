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

@WebServlet("/doctorLogin")
public class doctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public doctorLogin() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if (email==null || password==null || email.isEmpty() || password.isEmpty()) {
			session.setAttribute("doc-msg", "All fields are mandatory");
			
			// Later set redirect to doctor-dashboard
			response.sendRedirect("forms/doctor_login.jsp");
			
			return;
		}

		User user = new User(email, password);
		DAO dao = null;

		boolean bool = false;
		try {
			dao = new DAO(DBconnect.getConnection());
			bool = dao.doctorLogin(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(bool) {
			session.setAttribute("doc-msg", "Valid Credentials");
			// Later set redirect to doctor-dashboard
			response.sendRedirect("forms/doctor_login.jsp");
		}else {
			session.setAttribute("doc-msg", "Invalid Credentials");
			response.sendRedirect("forms/doctor_login.jsp");
		}
	}

}
