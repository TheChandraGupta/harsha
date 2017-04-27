package com.harsha.app.bean;

import javax.ws.rs.QueryParam;

public class MemberBean {
	
	private String memberId;
	private String familyId;
	private String name;
	private String userId;
	private String dob;
	private String genderId;
	private String socialCategoryId;
	private String aadhaarCardId;
	private String voterId;
	private String bplCard;
	private String jobCard;
	private String occupationId;
	private String maritalStatusId;
	private String disabilityId;
	private String religionId;
	private String relationshipId;
	private String schemeId;
	private String educationId;
	private String educationStatusId;
	private String approvalStatus;
	
	private String approvalRemark;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFamilyId() {
		return familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getSocialCategoryId() {
		return socialCategoryId;
	}

	public void setSocialCategoryId(String socialCategoryId) {
		this.socialCategoryId = socialCategoryId;
	}

	public String getAadhaarCardId() {
		return aadhaarCardId;
	}

	public void setAadhaarCardId(String aadhaarCardId) {
		this.aadhaarCardId = aadhaarCardId;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getBplCard() {
		return bplCard;
	}

	public void setBplCard(String bplCard) {
		this.bplCard = bplCard;
	}

	public String getJobCard() {
		return jobCard;
	}

	public void setJobCard(String jobCard) {
		this.jobCard = jobCard;
	}

	public String getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(String occupationId) {
		this.occupationId = occupationId;
	}

	public String getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(String maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public String getDisabilityId() {
		return disabilityId;
	}

	public void setDisabilityId(String disabilityId) {
		this.disabilityId = disabilityId;
	}

	public String getReligionId() {
		return religionId;
	}

	public void setReligionId(String religionId) {
		this.religionId = religionId;
	}

	public String getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getEducationId() {
		return educationId;
	}

	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}

	public String getEducationStatusId() {
		return educationStatusId;
	}

	public void setEducationStatusId(String educationStatusId) {
		this.educationStatusId = educationStatusId;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}

	public MemberBean(String memberId, String familyId, String name, String userId, String dob, String genderId,
			String socialCategoryId, String aadhaarCardId, String voterId, String bplCard, String jobCard,
			String occupationId, String maritalStatusId, String disabilityId, String religionId, String relationshipId,
			String schemeId, String educationId, String educationStatusId, String approvalStatus,
			String approvalRemark) {
		super();
		this.memberId = memberId;
		this.familyId = familyId;
		this.name = name;
		this.userId = userId;
		this.dob = dob;
		this.genderId = genderId;
		this.socialCategoryId = socialCategoryId;
		this.aadhaarCardId = aadhaarCardId;
		this.voterId = voterId;
		this.bplCard = bplCard;
		this.jobCard = jobCard;
		this.occupationId = occupationId;
		this.maritalStatusId = maritalStatusId;
		this.disabilityId = disabilityId;
		this.religionId = religionId;
		this.relationshipId = relationshipId;
		this.schemeId = schemeId;
		this.educationId = educationId;
		this.educationStatusId = educationStatusId;
		this.approvalStatus = approvalStatus;
		this.approvalRemark = approvalRemark;
	}

	public MemberBean(String memberId, String familyId, String name, String userId, String dob, String genderId,
			String socialCategoryId, String aadhaarCardId, String voterId, String bplCard, String jobCard,
			String occupationId, String maritalStatusId, String disabilityId, String religionId, String relationshipId,
			String schemeId, String educationId, String educationStatusId) {
		super();
		this.memberId = memberId;
		this.familyId = familyId;
		this.name = name;
		this.userId = userId;
		this.dob = dob;
		this.genderId = genderId;
		this.socialCategoryId = socialCategoryId;
		this.aadhaarCardId = aadhaarCardId;
		this.voterId = voterId;
		this.bplCard = bplCard;
		this.jobCard = jobCard;
		this.occupationId = occupationId;
		this.maritalStatusId = maritalStatusId;
		this.disabilityId = disabilityId;
		this.religionId = religionId;
		this.relationshipId = relationshipId;
		this.schemeId = schemeId;
		this.educationId = educationId;
		this.educationStatusId = educationStatusId;
	}

	public MemberBean() {
		super();
	}
	

}
