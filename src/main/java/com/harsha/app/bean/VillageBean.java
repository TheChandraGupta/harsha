package com.harsha.app.bean;

public class VillageBean {
	private int villageId;
	private int blockId;
	private String villageName;
	private String villageCode;
	private String blockName;
	private String blockCode;
	private String districtName;
	private String districtCode;
	private String stateName;
	private String stateCode;
	private int userId;
	
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
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
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
	public VillageBean(int villageId, int blockId, String villageCode,String villageName) {
		super();
		this.villageId = villageId;
		this.blockId = blockId;
		this.villageName = villageName;
		this.villageCode = villageCode;
	}
	public VillageBean() {
		super();
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
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
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
	
	

}
