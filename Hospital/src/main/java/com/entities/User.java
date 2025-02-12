package com.entities;

import com.database.*;
import java.sql.*;

public class User {
	private int hospitalID;
	private String name;
	private String email;
	private String password;
	
	public User() {}
	
	public User(int hospitalID, String name, String email, String password) {
		this.email= email;
		this.hospitalID= hospitalID;
		this.name= name;
		this.password= password;
	}
	
	public User(String name, String email, String password) {
		this.name= name;
		this.password= password;
		this.email= email;
	}
	
	public void setHospitalID(int hospitalID) {
		this.hospitalID= hospitalID;
	}
	
	public int getHospitalID() {
		return hospitalID;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	
	public void setMail(String email) {
		this.email= email;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
