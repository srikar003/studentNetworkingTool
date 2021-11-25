package com.example.StudentNetworkingTool.eventController;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventParticipation {
	private String studentId;
	private String eventId;
	
	public EventParticipation(String studentId, String eventId) {
		super();
		this.studentId = studentId;
		this.eventId = eventId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	
}
