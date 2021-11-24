package com.example.StudentNetworkingTool.studentController;

import java.util.Date;

import org.springframework.web.bind.annotation.RestController;
@RestController
public class Student {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private String college;
	private String dept;
	private String[] contacts;
	private String studentId;

	public Student() {}
	
	public Student(String studentId, String userName, String password, String firstName, String lastName, String email, Date dob,
			String college, String dept, String[] contacts) {
		super();
		this.studentId = studentId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.college = college;
		this.dept = dept;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String[] getContacts() {
		return contacts;
	}
	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
