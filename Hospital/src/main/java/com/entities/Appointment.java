package com.entities;

public class Appointment {
	private String name;
	private String email;
	private String gender;
	private String dob;
	private String specsChose;
	private String Address;
	private String phone;
	
	public String getName() {
		return name;
	}
	
	public Appointment() {
		
	}
	
	public Appointment(String name, String email, String gender, String dob, String specsChose, String address,
			String phone) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.specsChose = specsChose;
		Address = address;
		this.phone = phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSpecsChose() {
		return specsChose;
	}
	public void setSpecsChose(String specsChose) {
		this.specsChose = specsChose;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	private String created;
	public void setDate(String create) {
		this.created= create;
	}
	
	public String getDate() {
		return created;
	}
}
