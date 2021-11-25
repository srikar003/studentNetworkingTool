package com.example.StudentNetworkingTool.instructorController;

public class CorporateProfessional{
	private String company;
	private String areaOfExpertise;
	private String instructorId;
	
	public CorporateProfessional(String company, String areaOfExpertise, String instructorId) {
		super();
		this.company = company;
		this.areaOfExpertise = areaOfExpertise;
		this.instructorId = instructorId;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAreaOfExpertise() {
		return areaOfExpertise;
	}
	public void setAreaOfExpertise(String areaOfExpertise) {
		this.areaOfExpertise = areaOfExpertise;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	
}
