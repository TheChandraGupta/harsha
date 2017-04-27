package com.harsha.app.bean;

public class DistrictBean {

	private int stateId;
	private String districtName;
	private String districtCode;
	private int districtId;
	private String stateName;
	private String stateCode;
	
	
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public DistrictBean( int districtId, String districtCode,String districtName, int stateId) {
		super();
		this.stateId = stateId;
		this.districtName = districtName;
		this.districtCode = districtCode;
		this.districtId=districtId;
	}
	public DistrictBean() {
		super();
	}
	
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public DistrictBean(int stateId, String districtName, String districtCode,
			String stateName, int districtId) {
		super();
		this.stateId = stateId;
		this.districtName = districtName;
		this.districtCode = districtCode;
		this.districtId = districtId;
		this.stateName = stateName;
	}
	
	
}
