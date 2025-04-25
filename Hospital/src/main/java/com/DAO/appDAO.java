package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Appointment;

public class appDAO {
	private Connection conn;

	public appDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAppointment(Appointment ap) {
		boolean f = false;
		try {
			String query = "Insert into hms.appointments(name, email, gender, dob, specs_chose, address, phone) value(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ap.getName());
			ps.setString(2, ap.getEmail());
			ps.setString(3, ap.getGender());
			ps.setString(4, ap.getDob());
			ps.setString(5, ap.getSpecsChose());
			ps.setString(6, ap.getAddress());
			ps.setString(7, ap.getPhone());

			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public List<Appointment> getAll() throws SQLException{
		List<Appointment> list= new ArrayList<>();
		String query= "Select * from hms.appointments";
		PreparedStatement ps= conn.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			Appointment ap= new Appointment(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7)
					);
			ap.setDate(rs.getString(8));
			list.add(ap);
		}
		
		return list;
	}
	
	public List<Appointment> getApp(String email) throws SQLException{
		List<Appointment> list= new ArrayList<>();
		String query = "SELECT * FROM hms.appointments WHERE email = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, email); 
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			Appointment ap= new Appointment(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7)
					);
			ap.setDate(rs.getString(8));
			list.add(ap);
		}
		
		return list;
	}
}
