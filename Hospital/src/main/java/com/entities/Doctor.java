package com.entities;

public class Doctor {
	private String name;
	private String email;
	private String quals;
	private String specs;
	
	public Doctor(String name, String email, String quals, String specs) {
		this.name = name;
		this.email = email;
		this.quals = quals;
		this.specs = specs;
	}
	
	public String getName() {
		return name;
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
	public String getQuals() {
		return quals;
	}
	public void setQuals(String quals) {
		this.quals = quals;
	}
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	
	
}
