package com.harsha.app.bean;

public class QualityOfLifeBean {
	private int qualiltyOfLifeId;
	private long familyId;
	private int totalIncomeIncrease;
	private int increaseInIncome;
	private int totalSavingsIncrease;
	private int centralSchemeDays;
	private int assetsAcquired;
	private String remarks;
	private long lastUpdated;
	
	public QualityOfLifeBean(long familyId, int totalIncomeIncrease,
			int increaseInIncome, int totalSavingsIncrease,
			int centralSchemeDays, int assetsAcquired, String remarks) {
		super();
		this.familyId = familyId;
		this.totalIncomeIncrease = totalIncomeIncrease;
		this.increaseInIncome = increaseInIncome;
		this.totalSavingsIncrease = totalSavingsIncrease;
		this.centralSchemeDays = centralSchemeDays;
		this.assetsAcquired = assetsAcquired;
		this.remarks = remarks;
	}
	public QualityOfLifeBean() {
		super();
	}
	public QualityOfLifeBean(int qualiltyOfLifeId, long familyId,
			int totalIncomeIncrease, int increaseInIncome,
			int totalSavingsIncrease, int centralSchemeDays,
			int assetsAcquired, String remarks, long lastUpdated) {
		super();
		this.qualiltyOfLifeId = qualiltyOfLifeId;
		this.familyId = familyId;
		this.totalIncomeIncrease = totalIncomeIncrease;
		this.increaseInIncome = increaseInIncome;
		this.totalSavingsIncrease = totalSavingsIncrease;
		this.centralSchemeDays = centralSchemeDays;
		this.assetsAcquired = assetsAcquired;
		this.remarks = remarks;
		this.lastUpdated = lastUpdated;
	}
	
	public int getQualiltyOfLifeId() {
		return qualiltyOfLifeId;
	}
	public void setQualiltyOfLifeId(int qualiltyOfLifeId) {
		this.qualiltyOfLifeId = qualiltyOfLifeId;
	}
	public long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}
	public int getTotalIncomeIncrease() {
		return totalIncomeIncrease;
	}
	public void setTotalIncomeIncrease(int totalIncomeIncrease) {
		this.totalIncomeIncrease = totalIncomeIncrease;
	}
	public int getIncreaseInIncome() {
		return increaseInIncome;
	}
	public void setIncreaseInIncome(int increaseInIncome) {
		this.increaseInIncome = increaseInIncome;
	}
	public int getTotalSavingsIncrease() {
		return totalSavingsIncrease;
	}
	public void setTotalSavingsIncrease(int totalSavingsIncrease) {
		this.totalSavingsIncrease = totalSavingsIncrease;
	}
	public int getCentralSchemeDays() {
		return centralSchemeDays;
	}
	public void setCentralSchemeDays(int centralSchemeDays) {
		this.centralSchemeDays = centralSchemeDays;
	}
	public int getAssetsAcquired() {
		return assetsAcquired;
	}
	public void setAssetsAcquired(int assetsAcquired) {
		this.assetsAcquired = assetsAcquired;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

}
