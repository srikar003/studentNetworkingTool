package com.example.StudentNetworkingTool.courseController;

import java.lang.String;

public class Course {
	private String courseId;
	private String courseName;
	private boolean isPaidCourse;
	private double price;

	public Course(String courseId, String courseName, boolean isPaidCourse, double price) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.isPaidCourse = isPaidCourse;
		this.price = price;
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

	public boolean isPaidCourse() {
		return isPaidCourse;
	}

	public void setPaidCourse(boolean isPaidCourse) {
		this.isPaidCourse = isPaidCourse;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
