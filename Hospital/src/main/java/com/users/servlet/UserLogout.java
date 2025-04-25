package com.users.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userLogout")
public class UserLogout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		session.removeAttribute("userObj");
		session.removeAttribute("userMail");
		session.setAttribute("user-msg", "Logged-Out Successfully");
		resp.sendRedirect("forms/user_login.jsp");
	}
	
}
