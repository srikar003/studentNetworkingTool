package com.example.StudentNetworkingTool.teachesController;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teaches {
	private String instructorId;
	private String courseId;
	
	public Teaches(String instructorId, String courseId) {
		super();
		this.instructorId = instructorId;
		this.courseId = courseId;
	}
	
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
}
