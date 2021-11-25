package com.example.StudentNetworkingTool.queriesController;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Queries {
	private String queryId;
	private String question;
	private String studentId;
	private String courseId;
	
	public Queries(String queryId, String question, String studentId, String courseId) {
		super();
		this.queryId = queryId;
		this.question = question;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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
