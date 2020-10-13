package com.servlet.application.model;

public class Employee {
	private int id;
	private String username;
	private String password;
	private String email;
	private String address; 
	private String contactNumber;
	
	
	public Employee(int id,String username,String password, String email, String address, String contactNumber) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
	}
	public Employee(String username,String password, String email, String address, String contactNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
	}
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
