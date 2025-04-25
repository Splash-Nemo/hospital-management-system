package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.User;
import com.entities.userID;

public class DAO {
	private Connection conn;

	public DAO(Connection conn) {
		this.conn = conn;
	}

	public boolean ifExists(String email, String type) throws SQLException {
		String checkQuery = "SELECT COUNT(*) FROM hospital_data WHERE Email = ? AND TYPE=?";
		PreparedStatement checkStm = conn.prepareStatement(checkQuery);
		checkStm.setString(1, email);
		checkStm.setString(2, type);

		ResultSet check = checkStm.executeQuery();
		if (check.next() && check.getInt(1) > 0) {
			return true;
		}

		return false;
	}

	public boolean ifIdExists(int hospitalID) throws SQLException {
		String checkQuery = "SELECT COUNT(*) FROM hospital_data WHERE hospital_ID = ?";
		PreparedStatement checkStm = conn.prepareStatement(checkQuery);
		checkStm.setInt(1, hospitalID);

		ResultSet check = checkStm.executeQuery();
		if (check.next() && check.getInt(1) > 0) {
			return true;
		}

		return false;
	}

	public boolean userRegister(User user) throws SQLException {
		int hospitalID = userID.userIDGenerator();

		while (ifIdExists(hospitalID)) {
			hospitalID = userID.userIDGenerator();
		}

		if (ifExists(user.getMail(),"user")) {
			return false;
		}

		String query = "INSERT INTO hospital_data(hospital_ID, Name, Email, Password, Type) VALUES (?,?,?,?,?)";

		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, hospitalID);
		prep.setString(2, user.getName());
		prep.setString(3, user.getMail());
		prep.setString(4, user.getPassword());
		prep.setString(5, "user");

		int rowAffected = prep.executeUpdate();
		return rowAffected > 0;
	}

	public boolean userLogin(User user) throws SQLException {
		// Later add to check if the email id is for normal user, or admin, or doctor
		// String status= "User";
		if (ifExists(user.getMail(), "user")) {
			return true;
		}

		return false;
	}

	public boolean adminLogin(User user) throws SQLException {
		// Later add to check if the email id is for normal user, or admin, or doctor
		// String status= "Admin";
		if (ifExists(user.getMail(), "admin")) {
			return true;
		}

		return false;
	}
	
	public boolean adminRegister(User user) throws SQLException {
		int hospitalID = userID.userIDGenerator();

		while (ifIdExists(hospitalID)) {
			hospitalID = userID.userIDGenerator();
		}

		if (ifExists(user.getMail(),"admin")) {
			return false;
		}

		String query = "INSERT INTO hospital_data(hospital_ID, Name, Email, Password, Type) VALUES (?,?,?,?,?)";

		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, hospitalID);
		prep.setString(2, user.getName());
		prep.setString(3, user.getMail());
		prep.setString(4, user.getPassword());
		prep.setString(5, "admin");

		int rowAffected = prep.executeUpdate();
		return rowAffected > 0;
	}
	
	public List<User> getUsers() throws SQLException{
		List<User> userList= new ArrayList<>();
		
		String query= "Select * from hms.hospital_data where type= ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, "user");
				
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			User user= new User(rs.getString(2), rs.getString(3), rs.getString(4));
			user.setHospitalID(Integer.parseInt(rs.getString(1)));
			userList.add(user);
		}
		
		return userList;
	}
}
