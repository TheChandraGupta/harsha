package com.harsha.app.bean;

public class OccupationBean {
	private String occupationName;
	private String occupationCode;
	private int occupationId;
	public String getOccupationName() {
		return occupationName;
	}
	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
	public String getOccupationCode() {
		return occupationCode;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	public OccupationBean(String occupationName, String occupationCode, int occupationId) {
		super();
		this.occupationName = occupationName;
		this.occupationCode = occupationCode;
		this.occupationId = occupationId;
	}
	public OccupationBean() {
		super();
	}
	public int getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}

	

}
