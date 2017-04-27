package com.harsha.app.bean;

public class ReligionBean {

	private String religionName;
	private String religionCode;
	private int religionId;
	
	public String getReligionName() {
		return religionName;
	}
	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}
	public String getReligionCode() {
		return religionCode;
	}
	public void setReligionCode(String religionCode) {
		this.religionCode = religionCode;
	}
	public ReligionBean( String religionName, String religionCode, int religionId) {
		super();
		this.religionName = religionName;
		this.religionCode = religionCode;
		this.religionId = religionId;
	}
	public ReligionBean() {
		super();
	}
	public int getReligionId() {
		return religionId;
	}
	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}
}
