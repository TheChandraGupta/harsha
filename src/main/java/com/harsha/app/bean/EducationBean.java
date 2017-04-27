package com.harsha.app.bean;

public class EducationBean {

	private String educationName;
	private int educationCode;
	private int educationId;

	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	
	public EducationBean(String educationName, int educationCode, int educationId) {
		super();
		this.educationName = educationName;
		this.setEducationCode(educationCode);
		this.educationId = educationId;
	}
	public EducationBean() {
		super();
	}
	public int getEducationId() {
		return educationId;
	}
	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}
	public int getEducationCode() {
		return educationCode;
	}
	public void setEducationCode(int educationCode) {
		this.educationCode = educationCode;
	}
	
	
}
