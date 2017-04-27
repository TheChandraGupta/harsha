package com.harsha.app.bean;

public class EducationStatusBean {
	private String educationStatusName;
	private String educationStatusCode;
	private int educationStatusId;
	
	public String getEducationStatusName() {
		return educationStatusName;
	}
	public void setEducationStatusName(String educationStatusName) {
		this.educationStatusName = educationStatusName;
	}
	public String getEducationStatusCode() {
		return educationStatusCode;
	}
	public void setEducationStatusCode(String educationStatusCode) {
		this.educationStatusCode = educationStatusCode;
	}
	public EducationStatusBean( String educationStatusName, String educationStatusCode, int educationStatusId) {
		super();
		this.educationStatusName = educationStatusName;
		this.educationStatusCode = educationStatusCode;
		this.educationStatusId=educationStatusId;
	}
	public EducationStatusBean() {
		super();
	}
	public int getEducationStatusId() {
		return educationStatusId;
	}
	public void setEducationStatusId(int educationStatusId) {
		this.educationStatusId = educationStatusId;
	}

}
