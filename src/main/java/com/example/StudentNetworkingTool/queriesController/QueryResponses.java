package com.example.StudentNetworkingTool.queriesController;

public class QueryResponses {
	private String instructorId;
	private String response;
	private String queryId;

	public QueryResponses(String instructorId, String response, String queryId) {
		super();
		this.instructorId = instructorId;
		this.response = response;
		this.queryId = queryId;
	}
	
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	
}
