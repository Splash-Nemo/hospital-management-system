package com.admin.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminLogout")
public class AdminLogout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		session.removeAttribute("adminObj");
		session.removeAttribute("docList");
		session.removeAttribute("appList");
		session.removeAttribute("userList");
		session.setAttribute("adminLoginMsg", "Logged-Out Successfully");
		resp.sendRedirect("forms/admin_login.jsp");
	}
	
}
