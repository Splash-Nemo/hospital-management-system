package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entities.User;
import com.entities.userID;

public class DAO {
	private Connection conn;

	public DAO(Connection conn) {
		this.conn = conn;
	}

	public boolean ifExists(String email) throws SQLException {
		String checkQuery = "SELECT COUNT(*) FROM hospital_data WHERE Email = ?";
		PreparedStatement checkStm = conn.prepareStatement(checkQuery);
		checkStm.setString(1, email);

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

		if (ifExists(user.getMail())) {
			return false;
		}

		String query = "INSERT INTO hospital_data(hospital_ID, Name, Email, Password) VALUES (?,?,?,?)";

		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, hospitalID);
		prep.setString(2, user.getName());
		prep.setString(3, user.getMail());
		prep.setString(4, user.getPassword());

		int rowAffected = prep.executeUpdate();
		return rowAffected > 0;
	}

	public boolean userLogin(User user) throws SQLException {
		// Later add to check if the email id is for normal user, or admin, or doctor
		// String status= "User";
		if (ifExists(user.getMail())) {
			return true;
		}

		return false;
	}

	public boolean adminLogin(User user) throws SQLException {
		// Later add to check if the email id is for normal user, or admin, or doctor
		// String status= "Admin";
		if (ifExists(user.getMail())) {
			return true;
		}

		return false;
	}

	public boolean doctorLogin(User user) throws SQLException {
		// Later add to check if the email id is for normal user, or admin, or doctor
		// String status= "Doctor";
		if (ifExists(user.getMail())) {
			return true;
		}

		return false;
	}
}
