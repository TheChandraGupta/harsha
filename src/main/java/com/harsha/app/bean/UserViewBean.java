package com.harsha.app.bean;

public class UserViewBean {
	private int userId ;
	private int managerId ;
	private String userName ; 
	private String password; 
	private int roleId ; 
	private String lastActivity ;
	private int profileId; 
	private String firstName ;
	private String lastName ; 
	private String email ; 
	private String phone ; 
	private String address ;
	private String photo ;
	private String role ;
	private String statusCode;
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public UserViewBean(int userId, String userName, String password, int roleId, String lastActivity, int profileId,
			String firstName, String lastName, String email, String phone, String address, String photo, String role, String statusCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.lastActivity = lastActivity;
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.photo = photo;
		this.role = role;
		this.statusCode = statusCode;
	}
	public UserViewBean() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getLastActivity() {
		return lastActivity;
	}
	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
