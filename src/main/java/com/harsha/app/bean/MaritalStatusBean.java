package com.harsha.app.bean;

public class MaritalStatusBean {
	
	private String maritalStatusCode;
	private String maritalStatusName;
	private int maritalStatusId;
	
	public String getMaritalStatusCode() {
		return maritalStatusCode;
	}
	public void setMaritalStatusCode(String maritalStatusCode) {
		this.maritalStatusCode = maritalStatusCode;
	}
	public String getMaritalStatusName() {
		return maritalStatusName;
	}
	public void setMaritalStatusName(String maritalStatusName) {
		this.maritalStatusName = maritalStatusName;
	}
	public MaritalStatusBean( String maritalStatusName,  String maritalStatusCode,int maritalStatusId) {
		super();
		this.maritalStatusCode = maritalStatusCode;
		this.maritalStatusName = maritalStatusName;
		this.maritalStatusId = maritalStatusId;
	}
	public MaritalStatusBean() {
		super();
	}
	public int getMaritalStatusId() {
		return maritalStatusId;
	}
	public void setMaritalStatusId(int maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}
	
	

}
