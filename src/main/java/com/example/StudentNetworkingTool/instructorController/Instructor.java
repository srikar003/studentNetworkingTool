package com.example.StudentNetworkingTool.instructorController;

public class Instructor {
	private String userName;
	private String password;
	private String instructorId;
	private int exp;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String[] contacts;
		
	public Instructor(String userName, String password, String instructorId, int exp, String firstName, String lastName,
			String email, String dob, String[] contacts) {
		super();
		this.userName = userName;
		this.password = password;
		this.instructorId = instructorId;
		this.exp = exp;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.contacts = contacts;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String[] getContacts() {
		return contacts;
	}
	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}
	
	
}
