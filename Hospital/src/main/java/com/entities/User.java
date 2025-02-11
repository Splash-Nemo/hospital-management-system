package com.entities;

import com.database.*;
import java.sql.*;

public class User {
	private String name;
	private String email;
	private String password;
	
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
