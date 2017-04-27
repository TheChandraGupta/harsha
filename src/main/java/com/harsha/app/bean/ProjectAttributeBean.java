package com.harsha.app.bean;

public class ProjectAttributeBean {
	private String projectAttributeId;
	private String attributeName;
	private String attributeSize;
	private String attributeType;
	private String projectTypeId;
	private String status;
	public ProjectAttributeBean(String attributeName, String projectTypeId,
			String fixedValue, String displaySequence) {
		super();
		this.attributeName = attributeName;
		this.projectTypeId = projectTypeId;
		this.fixedValue = fixedValue;
		this.displaySequence = displaySequence;
	}
	private String fixedValue;
	private String displaySequence;
	private String lastUpdated;
	
	public ProjectAttributeBean(String projectAttributeId, String attributeName, String attributeSize, String attributeType,
			String projectTypeId, String status, String fixedValue, String displaySequence,String lastUpdated) {
		super();
		this.projectAttributeId = projectAttributeId;
		this.attributeName = attributeName;
		this.attributeSize = attributeSize;
		this.attributeType = attributeType;
		this.projectTypeId = projectTypeId;
		this.status = status;
		this.fixedValue = fixedValue;
		this.displaySequence = displaySequence;
		this.lastUpdated= lastUpdated;
	}

	public ProjectAttributeBean(String projectAttributeId,
			String attributeName, String attributeSize, String attributeType,
			String projectTypeId, String status, String fixedValue,
			String displaySequence) {
		super();
		this.projectAttributeId = projectAttributeId;
		this.attributeName = attributeName;
		this.attributeSize = attributeSize;
		this.attributeType = attributeType;
		this.projectTypeId = projectTypeId;
		this.status = status;
		this.fixedValue = fixedValue;
		this.displaySequence = displaySequence;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}

	public String getDisplaySequence() {
		return displaySequence;
	}

	public void setDisplaySequence(String displaySequence) {
		this.displaySequence = displaySequence;
	}

	public ProjectAttributeBean(String projectAttributeId, String attributeName,
			String attributeSize, String attributeType, String projectTypeId) {
		super();
		this.projectAttributeId = projectAttributeId;
		this.attributeName = attributeName;
		this.attributeSize = attributeSize;
		this.attributeType = attributeType;
		this.projectTypeId = projectTypeId;
	}
	
	public ProjectAttributeBean() {
		// TODO Auto-generated constructor stub
	}

	public String getAttributeSize() {
		return attributeSize;
	}
	public void setAttributeSize(String attributeSize) {
		this.attributeSize = attributeSize;
	}
	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	
	
	public String getProjectAttributeId() {
		return projectAttributeId;
	}
	public void setProjectAttributeId(String projectAttributeId) {
		this.projectAttributeId = projectAttributeId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	};
	
}
