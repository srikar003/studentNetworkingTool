package com.example.StudentNetworkingTool.eventController;

public class Event {
	private String eventId;
	private String eventName;
	private String instructorId;
	private String description;

	public Event(String eventId, String eventName, String description, String instructorId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.instructorId = instructorId;
		this.setDescription(description);
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
