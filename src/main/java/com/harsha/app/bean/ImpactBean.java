package com.harsha.app.bean;

public class ImpactBean {
	private String impactId;
	private String projectAssignmentId;
	private String ProjectAttributeId;
	private String projectAttributeValue;
	private String entryDate;
	public ImpactBean(String impactId, String projectAssignmentId,
			String ProjectAttributeId, String projectAttributeValue, String entryDate) {
		super();
		this.impactId = impactId;
		this.projectAssignmentId = projectAssignmentId;
		this.ProjectAttributeId = ProjectAttributeId;
		this.projectAttributeValue = projectAttributeValue;
		this.entryDate = entryDate;
	}
	
	public String getImpactId() {
		return impactId;
	}
	public void setImpactId(String impactId) {
		this.impactId = impactId;
	}
	public String getProjectAssignmentId() {
		return projectAssignmentId;
	}
	public void setProjectAssignmentId(String projectAssignmentId) {
		this.projectAssignmentId = projectAssignmentId;
	}
	public String getProjectAttributeId() {
		return ProjectAttributeId;
	}
	public void setProjectAttributeId(String ProjectAttributeId) {
		this.ProjectAttributeId = ProjectAttributeId;
	}
	public String getProjectAttributeValue() {
		return projectAttributeValue;
	}
	public void setProjectAttributeValue(String projectAttributeValue) {
		this.projectAttributeValue = projectAttributeValue;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	

}
