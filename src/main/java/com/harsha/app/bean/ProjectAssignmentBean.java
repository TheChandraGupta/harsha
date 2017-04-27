package com.harsha.app.bean;

public class ProjectAssignmentBean {
	private String projectAssignmentId;	
	private String familyId;
	private int projectId;
	private int status;
	private String enrollmentIn;
	private String enrollmentOut;	
	private String lastUpdated;
	private int immutableAttribute;
	
	public ProjectAssignmentBean() {
		
	}
	
	public ProjectAssignmentBean(String familyId, int projectId, int status,
			String enrollmentIn, String enrollmentOut, int immutableAttribute) {
		super();
		this.familyId = familyId;
		this.projectId = projectId;
		this.status = status;
		this.enrollmentIn = enrollmentIn;
		this.enrollmentOut = enrollmentOut;
		this.immutableAttribute = immutableAttribute;
	}
	public ProjectAssignmentBean(String familyId, int projectId, int status,
			String enrollmentIn, String enrollmentOut, String lastUpdated,
			int immutableAttribute) {
		super();
		this.familyId = familyId;
		this.projectId = projectId;
		this.status = status;
		this.enrollmentIn = enrollmentIn;
		this.enrollmentOut = enrollmentOut;
		this.lastUpdated = lastUpdated;
		this.immutableAttribute = immutableAttribute;
	}
	public ProjectAssignmentBean(String projectAssignmentId, String familyId,
			int projectId, int status, String enrollmentIn,
			String enrollmentOut, int immutableAttribute) {
		super();
		this.projectAssignmentId = projectAssignmentId;
		this.familyId = familyId;
		this.projectId = projectId;
		this.status = status;
		this.enrollmentIn = enrollmentIn;
		this.enrollmentOut = enrollmentOut;
		this.immutableAttribute = immutableAttribute;
	}
	public ProjectAssignmentBean(String projectAssignmentId, String familyId,
			int projectId, int status, String enrollmentIn, String enrollmentOut,
			String lastUpdated, int immutableAttribute) {
		super();
		this.projectAssignmentId = projectAssignmentId;
		this.familyId = familyId;
		this.projectId = projectId;
		this.status = status;
		this.enrollmentIn = enrollmentIn;
		this.enrollmentOut = enrollmentOut;
		this.lastUpdated = lastUpdated;
		this.immutableAttribute = immutableAttribute;
	}
	public String getProjectAssignmentId() {
		return projectAssignmentId;
	}
	public void setProjectAssignmentId(String projectAssignmentId) {
		this.projectAssignmentId = projectAssignmentId;
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getEnrollmentIn() {
		return enrollmentIn;
	}
	public void setEnrollmentIn(String enrollmentIn) {
		this.enrollmentIn = enrollmentIn;
	}
	public String getEnrollmentOut() {
		return enrollmentOut;
	}
	public void setEnrollmentOut(String enrollmentOut) {
		this.enrollmentOut = enrollmentOut;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getImmutableAttribute() {
		return immutableAttribute;
	}
	public void setImmutableAttribute(int immutableAttribute) {
		this.immutableAttribute = immutableAttribute;
	}
	
}
