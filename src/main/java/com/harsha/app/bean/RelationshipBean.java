package com.harsha.app.bean;

public class RelationshipBean {
	private String relationshipName;
	private String relationshipCode;
	private int relationshipId;
	public String getRelationshipName() {
		return relationshipName;
	}
	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}
	public String getRelationshipCode() {
		return relationshipCode;
	}
	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}
	public RelationshipBean( String relationshipName, String relationshipCode, int relationshipId) {
		super();
		this.relationshipName = relationshipName;
		this.relationshipCode = relationshipCode;
		this.relationshipId = relationshipId;
	}
	public RelationshipBean() {
		super();
	}
	public int getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}
	

}
