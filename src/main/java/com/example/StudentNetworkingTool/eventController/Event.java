package com.example.StudentNetworkingTool.eventController;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Event {
	private String eventId;
	private String eventName;
		
	public Event(String eventId, String eventName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
	}
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
}
