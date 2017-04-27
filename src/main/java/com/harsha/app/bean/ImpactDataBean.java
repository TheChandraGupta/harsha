package com.harsha.app.bean;

public class ImpactDataBean {
	private int householdDataId;
	private int noOfBatches;
	private int totalChicksPlacement;
	private int mortality;
	private int totalFeedConsumption;
	private int FCR;
	private int totalIncome;
	private int baselineIncome;
	private int incrementalIncome;
	private int impactDatatypeId;
	private String impactDatatypeName; 
	private String tableName;
	public int getHouseholdDataId() {
		return householdDataId;
	}
	public void setHouseholdDataId(int householdDataId) {
		this.householdDataId = householdDataId;
	}
	public int getNoOfBatches() {
		return noOfBatches;
	}
	public void setNoOfBatches(int noOfBatches) {
		this.noOfBatches = noOfBatches;
	}
	public int getTotalChicksPlacement() {
		return totalChicksPlacement;
	}
	public void setTotalChicksPlacement(int totalChicksPlacement) {
		this.totalChicksPlacement = totalChicksPlacement;
	}
	public int getMortality() {
		return mortality;
	}
	public void setMortality(int mortality) {
		this.mortality = mortality;
	}
	public int getTotalFeedConsumption() {
		return totalFeedConsumption;
	}
	public void setTotalFeedConsumption(int totalFeedConsumption) {
		this.totalFeedConsumption = totalFeedConsumption;
	}
	public int getFCR() {
		return FCR;
	}
	public void setFCR(int fCR) {
		FCR = fCR;
	}
	public int getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(int totalIncome) {
		this.totalIncome = totalIncome;
	}
	public int getBaselineIncome() {
		return baselineIncome;
	}
	public void setBaselineIncome(int baselineIncome) {
		this.baselineIncome = baselineIncome;
	}
	public int getIncrementalIncome() {
		return incrementalIncome;
	}
	public void setIncrementalIncome(int incrementalIncome) {
		this.incrementalIncome = incrementalIncome;
	}
	public int getImpactDatatypeId() {
		return impactDatatypeId;
	}
	public void setImpactDatatypeId(int impactDatatypeId) {
		this.impactDatatypeId = impactDatatypeId;
	}
	public String getImpactDatatypeName() {
		return impactDatatypeName;
	}
	public void setImpactDatatypeName(String impactDatatypeName) {
		this.impactDatatypeName = impactDatatypeName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

}
