package com.harsha.app.bean;

public class ProjectTypeBean {
	private int projectTypeId;
	private String projectTypeName;
	
	public int getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(int projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	public String getProjectTypeName() {
		return projectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
	public ProjectTypeBean(int projectTypeId, String projectTypeName) {
		super();
		this.projectTypeId = projectTypeId;
		this.projectTypeName = projectTypeName;
	}
	
	public ProjectTypeBean(String projectTypeName) {
		super();
		this.projectTypeName = projectTypeName;
	}
	public ProjectTypeBean() {
		// TODO Auto-generated constructor stub
	}
	
}
