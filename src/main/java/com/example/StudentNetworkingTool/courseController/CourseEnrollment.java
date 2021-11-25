package com.example.StudentNetworkingTool.courseController;

public class CourseEnrollment {
	private String studentId;
	private String courseId;
	
	public CourseEnrollment(String studentId, String courseId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
}
