package com.admin.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.DAO;
import com.DAO.DoctorDAO;
import com.DAO.appDAO;
import com.database.DBconnect;
import com.entities.Appointment;
import com.entities.Doctor;
import com.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet{

	@Override
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
		
		if(bool) {
			appDAO appdao=null;
			DoctorDAO docDao= null;
			
			try {
				docDao= new DoctorDAO(DBconnect.getConnection());
				appdao = new appDAO(DBconnect.getConnection());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Appointment> appList = new ArrayList<>();
			List<Doctor> docList= new ArrayList<>();
			List<User> userList= new ArrayList<>();
			try {
				docList= (ArrayList) docDao.getAll();
				appList= (ArrayList) appdao.getAll();
				userList= (ArrayList) dao.getUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			session.setAttribute("appList", appList);
			session.setAttribute("docList", docList);
			session.setAttribute("userList", userList);
			session.setAttribute("adminObj", user);
			// Later set redirect to admin-dashboard
			response.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("adminLoginMsg", "Invalid Credentials");
			response.sendRedirect("forms/admin_login.jsp");
		}
	}
	
}
