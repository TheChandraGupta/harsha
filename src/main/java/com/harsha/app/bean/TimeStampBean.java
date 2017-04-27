package com.harsha.app.bean;

public class TimeStampBean {
	private int tableStampId;
	private String tableName;
	private String lastUpdated;
	public int getTableStampId() {
		return tableStampId;
	}
	public void setTableStampId(int tableStampId) {
		this.tableStampId = tableStampId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public TimeStampBean(int tableStampId, String tableName, String lastUpdated) {
		super();
		this.tableStampId = tableStampId;
		this.tableName = tableName;
		this.lastUpdated = lastUpdated;
	}
	
}
