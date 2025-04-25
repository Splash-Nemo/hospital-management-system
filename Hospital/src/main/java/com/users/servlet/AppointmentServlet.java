package com.users.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.DAO.appDAO;
import com.database.DBconnect;
import com.entities.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/setApp")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String email= req.getParameter("email");
		String gender= req.getParameter("gender");
		String dob= req.getParameter("dob");
		String specsChose= req.getParameter("specialist");
		String address= req.getParameter("address");
		String phone= req.getParameter("phone");
		
		Appointment ap= new Appointment(name, email, gender, dob,specsChose, address, phone);
		appDAO dao= null;
		
		HttpSession session= req.getSession();
		
		try {
			dao= new appDAO(DBconnect.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(dao.addAppointment(ap)) {
			session.setAttribute("succ-msg", "Appointment Added Successfully");
			resp.sendRedirect("user/set_app.jsp");
		}else {
			session.setAttribute("succ-msg", "Failed to add appointment");
			resp.sendRedirect("user/set_app.jsp");
		}
	}

}
