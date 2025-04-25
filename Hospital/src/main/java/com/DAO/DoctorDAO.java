package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Doctor;

public class DoctorDAO {
	private Connection conn;
	
	public DoctorDAO(Connection conn) {
		this.conn= conn;
	}
	
	public boolean ifExists(String email) throws SQLException {
		String checkQuery = "SELECT COUNT(*) FROM doctor_data WHERE Email = ?";
		PreparedStatement checkStm = conn.prepareStatement(checkQuery);
		checkStm.setString(1, email);

		ResultSet check = checkStm.executeQuery();
		if (check.next() && check.getInt(1) > 0) {
			return true;
		}

		return false;
	}

	public boolean docRegister(Doctor doc) throws SQLException {

		if (ifExists(doc.getEmail())) {
			return false;
		}

		String query = "INSERT INTO doctor_data( Name, Email, Qualifications, Specialization) VALUES (?,?,?,?)";

		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, doc.getName());
		prep.setString(2, doc.getEmail());
		prep.setString(3, doc.getQuals());
		prep.setString(4, doc.getSpecs());
		
		int rowAffected = prep.executeUpdate();
		return rowAffected > 0;
	}

	public boolean docLogin(Doctor doc) throws SQLException {
		if (ifExists(doc.getEmail())) {
			return true;
		}

		return false;
	}
	
	public void getList(List<Doctor> docList) throws SQLException {
	    String query = "SELECT * FROM doctor_data";
	    PreparedStatement prep = conn.prepareStatement(query);
	    ResultSet rs = prep.executeQuery();
	    
	    while (rs.next()) {
	        Doctor d = new Doctor(
	            rs.getString("Name"),
	            rs.getString("Email"),
	            rs.getString("Qualifications"),
	            rs.getString("Specialization")
	        );
	        docList.add(d);
	    }
	}
	
	public ArrayList<Doctor> getAll() throws SQLException{
		String query = "SELECT * FROM doctor_data";
	    PreparedStatement prep = conn.prepareStatement(query);
	    ResultSet rs = prep.executeQuery();
	    
	    ArrayList<Doctor> docList= new ArrayList<>();
	    
	    while (rs.next()) {
	        Doctor d = new Doctor(
	            rs.getString("Name"),
	            rs.getString("Email"),
	            rs.getString("Qualifications"),
	            rs.getString("Specialization")
	        );
	        docList.add(d);
	    }
	    
	    return docList;
	}

}
