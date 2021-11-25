package com.example.StudentNetworkingTool.courseController;

import java.lang.String;

public class Course{
	private String courseId;
	private String courseName;
	private boolean isPaidResource;
	
	public Course(String courseId, String courseName, boolean isPaidResource) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.isPaidResource = isPaidResource;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public boolean isPaidResource() {
		return isPaidResource;
	}
	public void setPaidResource(boolean isPaidResource) {
		this.isPaidResource = isPaidResource;
	}

}
