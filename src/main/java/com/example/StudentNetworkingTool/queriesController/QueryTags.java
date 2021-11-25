package com.example.StudentNetworkingTool.queriesController;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryTags {
	private String hashTags;
	private String queryId;
	
	public QueryTags(String hashTags, String queryId) {
		super();
		this.hashTags = hashTags;
		this.queryId = queryId;
	}
	
	public String getHashTags() {
		return hashTags;
	}
	public void setHashTags(String hashTags) {
		this.hashTags = hashTags;
	}
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	
}
