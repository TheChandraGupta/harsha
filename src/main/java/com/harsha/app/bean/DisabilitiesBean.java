package com.harsha.app.bean;

public class DisabilitiesBean {

	private int disabilityId;
	private String disabilityCode;
	private String disabiltyName;
	
	public String getDisabilityCode() {
		return disabilityCode;
	}
	public void setDisabilityCode(String disabilityCode) {
		this.disabilityCode = disabilityCode;
	}
	public String getDisabiltyName() {
		return disabiltyName;
	}
	public void setDisabiltyName(String disabiltyName) {
		this.disabiltyName = disabiltyName;
	}
	public DisabilitiesBean(String disabilityCode, String disabiltyName, int disabilityId) {
		super();
		this.disabilityCode = disabilityCode;
		this.disabiltyName = disabiltyName;
		this.disabilityId=disabilityId;
	}
	public DisabilitiesBean() {
		super();
	}
	public int getDisabilityId() {
		return disabilityId;
	}
	public void setDisabilityId(int disabilityId) {
		this.disabilityId = disabilityId;
	}
	
	
}
