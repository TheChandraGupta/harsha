package com.harsha.app.bean;

public class GenderBean {
	private int genderId;
	private String genderName;
	public GenderBean(int genderId, String genderName) {
		super();
		this.genderId = genderId;
		this.genderName = genderName;
	}
	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
}
