package com.doctors.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.DoctorDAO;
import com.database.DBconnect;
import com.entities.Doctor;
import com.entities.User;

@WebServlet("/doctorRegister")
public class doctorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public doctorRegister() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DoctorDAO dao= null;
		try {
			dao = new DoctorDAO(DBconnect.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<Doctor> list = new ArrayList<>();

        try {
            dao.getList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("docList", list);

        request.getRequestDispatcher("admin/doctors.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String quals= request.getParameter("quals");
		String specs= request.getParameter("specs");

		HttpSession session = request.getSession();

		if (name == null || name.isEmpty() || email == null || email.isEmpty()) {

			session.setAttribute("added-msg", "All Fields are Mandatory");
			response.sendRedirect("admin/doctors.jsp");
			return;
		}

		Doctor doc = new Doctor(name, email, quals, specs);
		DoctorDAO dao = null;

		boolean bool = false;
		
		try {
			dao = new DoctorDAO(DBconnect.getConnection());
			bool = dao.docRegister(doc);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Doctor> list = new ArrayList<>();
	    try {
	        dao.getList(list);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		if (bool) {
		    
		    session.setAttribute("docList", list);
		    session.setAttribute("added-msg", "Added Successfully");
		    response.sendRedirect("admin/doctors.jsp");
		} else {
		    session.setAttribute("added-msg", "Doctor Profile exists");
		    response.sendRedirect("admin/doctors.jsp");
		}

	}
}
