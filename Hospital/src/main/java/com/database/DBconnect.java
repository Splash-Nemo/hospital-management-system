package com.database;

import java.sql.*;

public class DBconnect {
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/hms";
		String root= "root";
		String password= "aditya@1234";
		
		conn= DriverManager.getConnection(url, root, password);
		return conn;
	}
}
