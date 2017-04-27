package com.harsha.app.bean;

public class SupervisorAssignmentBean {
	
	private int supervisorAssignmentId;
	private int userId;
	private int villageId;
	private String villageCode;
	private String villageName;
	private String userName;
	private String lastUpdated;
	private int stateId;
	private int districtId;
	private int blockId;
	private String stateName;
	private String stateCode;
	private String districtCode;
	private String districtName;
	private String blockCode;
	private String blockName;
	
	
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
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
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getBlockCode() {
		return blockCode;
	}
	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getSupervisorAssignmentId() {
		return supervisorAssignmentId;
	}
	public void setSupervisorAssignmentId(int supervisorAssignmentId) {
		this.supervisorAssignmentId = supervisorAssignmentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVillageId() {
		return villageId;
	}
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	public String getVillageCode() {
		return villageCode;
	}
	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public SupervisorAssignmentBean(int supervisorAssignmentId, int userId, int villageId, String villageCode,
			String villageName, String userName) {
		super();
		this.supervisorAssignmentId = supervisorAssignmentId;
		this.userId = userId;
		this.villageId = villageId;
		this.villageCode = villageCode;
		this.villageName = villageName;
		this.userName = userName;
	}
	
	public SupervisorAssignmentBean() {
		super();
	}
	
	public SupervisorAssignmentBean(int supervisorAssignmentId, int userId, int villageId, String villageCode,
			String villageName, String userName, String lastUpdated) {
		super();
		this.supervisorAssignmentId = supervisorAssignmentId;
		this.userId = userId;
		this.villageId = villageId;
		this.villageCode = villageCode;
		this.villageName = villageName;
		this.userName = userName;
		this.lastUpdated = lastUpdated;
	}
	
	public SupervisorAssignmentBean(int supervisorAssignmentId, int userId, int villageId, String villageCode,
			String villageName, String userName, String lastUpdated, int stateId, int districtId, int blockId,
			String stateName, String stateCode, String districtCode, String districtName, String blockCode,
			String blockName) {
		super();
		this.supervisorAssignmentId = supervisorAssignmentId;
		this.userId = userId;
		this.villageId = villageId;
		this.villageCode = villageCode;
		this.villageName = villageName;
		this.userName = userName;
		this.lastUpdated = lastUpdated;
		this.stateId = stateId;
		this.districtId = districtId;
		this.blockId = blockId;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.blockCode = blockCode;
		this.blockName = blockName;
	}
	
	

}
