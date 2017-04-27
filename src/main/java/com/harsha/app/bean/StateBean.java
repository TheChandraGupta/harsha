package com.harsha.app.bean;

public class StateBean {
	private String stateCode;
	private String stateName;
	private int stateId;
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public StateBean(String stateCode, String stateName, int stateId) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.stateId = stateId;
	}
	public StateBean() {
		super();
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	

}
