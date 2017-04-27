package com.harsha.app.bean;

public class HouseHoldBean {
	private int stateId;
	private String stateName;
	private String stateCode;
	private int districtId;
	private String districtname;
	private String districtCode;
	private int blockId;
	private String blockName;
	private String blockCode;
	private int villageid;
	private String villageName;
	private String villageCode;
	private int surveyOwnerUserId;
	private String surveyOwnerUserName;
	private String surveyOwnerName;
	private String surveyPeriod;
	private int socialCategoryId;
	private String socialCategoryName;
	private int religionId;
	private String religionName;
	private String contactNo;
	private int noOfFamilyMember;
	private int occupationId;
	private String occupationName;
	private int annualHHIncome;
	private String remarks;
	private int householdDataId;
	private String statusCode;
	private String uniqueHHId;
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getBlockCode() {
		return blockCode;
	}
	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}
	public int getVillageid() {
		return villageid;
	}
	public void setVillageid(int villageid) {
		this.villageid = villageid;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getVillageCode() {
		return villageCode;
	}
	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}
	public int getSurveyOwnerUserId() {
		return surveyOwnerUserId;
	}
	public void setSurveyOwnerUserId(int surveyOwnerUserId) {
		this.surveyOwnerUserId = surveyOwnerUserId;
	}
	public String getSurveyOwnerUserName() {
		return surveyOwnerUserName;
	}
	public void setSurveyOwnerUserName(String surveyOwnerUserName) {
		this.surveyOwnerUserName = surveyOwnerUserName;
	}
	public String getSurveyOwnerName() {
		return surveyOwnerName;
	}
	public void setSurveyOwnerName(String surveyOwnerName) {
		this.surveyOwnerName = surveyOwnerName;
	}
	public String getSurveyPeriod() {
		return surveyPeriod;
	}
	public void setSurveyPeriod(String surveyPeriod) {
		this.surveyPeriod = surveyPeriod;
	}
	public int getSocialCategoryId() {
		return socialCategoryId;
	}
	public void setSocialCategoryId(int socialCategoryId) {
		this.socialCategoryId = socialCategoryId;
	}
	public String getSocialCategoryName() {
		return socialCategoryName;
	}
	public void setSocialCategoryName(String socialCategoryName) {
		this.socialCategoryName = socialCategoryName;
	}
	public int getReligionId() {
		return religionId;
	}
	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}
	public String getReligionName() {
		return religionName;
	}
	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public int getNoOfFamilyMember() {
		return noOfFamilyMember;
	}
	public void setNoOfFamilyMember(int noOfFamilyMember) {
		this.noOfFamilyMember = noOfFamilyMember;
	}
	public int getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}
	public String getOccupationName() {
		return occupationName;
	}
	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
	public int getAnnualHHIncome() {
		return annualHHIncome;
	}
	public void setAnnualHHIncome(int annualHHIncome) {
		this.annualHHIncome = annualHHIncome;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public HouseHoldBean(int stateId, String stateName, String stateCode, int districtId, String districtname,
			String districtCode, int blockId, String blockName, String blockCode, int villageid, String villageName,
			String villageCode, int surveyOwnerUserId, String surveyOwnerUserName, String surveyOwnerName,
			String surveyPeriod, int socialCategoryId, String socialCategoryName, int religionId, String religionName,
			String contactNo, int noOfFamilyMember, int occupationId, String occupationName, int annualHHIncome,
			String remarks,int householdDataId, String statusCode,String uniqueHHId) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.districtId = districtId;
		this.districtname = districtname;
		this.districtCode = districtCode;
		this.blockId = blockId;
		this.blockName = blockName;
		this.blockCode = blockCode;
		this.villageid = villageid;
		this.villageName = villageName;
		this.villageCode = villageCode;
		this.surveyOwnerUserId = surveyOwnerUserId;
		this.surveyOwnerUserName = surveyOwnerUserName;
		this.surveyOwnerName = surveyOwnerName;
		this.surveyPeriod = surveyPeriod;
		this.socialCategoryId = socialCategoryId;
		this.socialCategoryName = socialCategoryName;
		this.religionId = religionId;
		this.religionName = religionName;
		this.contactNo = contactNo;
		this.noOfFamilyMember = noOfFamilyMember;
		this.occupationId = occupationId;
		this.occupationName = occupationName;
		this.annualHHIncome = annualHHIncome;
		this.remarks = remarks;
		this.householdDataId=householdDataId;
		this.statusCode=statusCode;
		this.uniqueHHId=uniqueHHId;
	}
	public HouseHoldBean() {
		super();
	}
	public int getHouseholdDataId() {
		return householdDataId;
	}
	public void setHouseholdDataId(int householdDataId) {
		this.householdDataId = householdDataId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getUniqueHHId() {
		return uniqueHHId;
	}
	public void setUniqueHHId(String uniqueHHId) {
		this.uniqueHHId = uniqueHHId;
	}
	

}
