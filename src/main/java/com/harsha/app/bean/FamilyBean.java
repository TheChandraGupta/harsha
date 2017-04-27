package com.harsha.app.bean;

import java.util.Collection;

public class FamilyBean {
	private String familyId;
	private String villageId;
	private String income;
	private String savings;
	private String userId;
	private String lastUpdated;
	private String houseHoldId;
	
	public String getHouseHoldId() {
		return houseHoldId;
	}
	public void setHouseHoldId(String houseHoldId) {
		this.houseHoldId = houseHoldId;
	}
	public FamilyBean(String familyId, String villageId, String income,
			String savings, String userId, String lastUpdated) {
		super();
		this.familyId = familyId;
		this.villageId = villageId;
		this.income = income;
		this.savings = savings;
		this.userId = userId;
		this.lastUpdated = lastUpdated;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public FamilyBean(String familyId, String villageId, String income,
			String savings, String userId) {
		super();
		this.familyId = familyId;
		this.villageId = villageId;
		this.income = income;
		this.savings = savings;
		this.userId = userId;
	}
	public FamilyBean(String familyId, String villageId, String income,
			String savings) {
		super();
		this.familyId = familyId;
		this.villageId = villageId;
		this.income = income;
		this.savings = savings;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
	public String getVillageId() {
		return villageId;
	}
	public void setVillageId(String villageid) {
		this.villageId = villageid;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getSavings() {
		return savings;
	}
	public void setSavings(String savings) {
		this.savings = savings;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}