package com.example.StudentNetworkingTool.instructorController;

public class Professor {
	private String university;
	private String dept;
	private String instructorId;
	public Professor(String university, String dept, String instructorId) {
		super();
		this.university = university;
		this.dept = dept;
		this.instructorId = instructorId;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
}
