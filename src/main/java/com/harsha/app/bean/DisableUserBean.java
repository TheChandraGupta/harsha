package com.harsha.app.bean;

public class DisableUserBean {
	private String statusCode;
	private String userId;
	private String role;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public DisableUserBean(String statusCode, String userId, String role) {
		super();
		this.statusCode = statusCode;
		this.userId = userId;
		this.role = role;
	}
	public DisableUserBean() {
		super();
	}
	

}
