package com.harsha.app.bean;

public class ProjectBean {
	public ProjectBean(int projectId, String projectName, String donerName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.donerName = donerName;
	}
	private int projectId;
	private String projectName;
	private String donerName;
	private int projectTypeId;
	private String lastUpdated;
	
	public int getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(int projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public ProjectBean(int projectId, String projectName, String donerName,
			int projectTypeId, String lastUpdated) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.donerName = donerName;
		this.projectTypeId = projectTypeId;
		this.lastUpdated = lastUpdated;
	}
	public ProjectBean(int projectId, String projectName, String donerName,
			int projectTypeId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.donerName = donerName;
		this.projectTypeId = projectTypeId;
	}
	public ProjectBean() {
		super();
	}
	public ProjectBean(String projectName, String donerName) {
		// TODO Auto-generated constructor stub
		this.projectName = projectName;
		this.donerName = donerName;
	}
	public String getDonerName() {
		return donerName;
	}
	public void setDonerName(String donerName) {
		this.donerName = donerName;
	}
	

}
