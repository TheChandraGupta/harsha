package com.harsha.app.bean;

public class AssetDataBean {
private int assetDataId;
private int assetId;
private long familyId;
public AssetDataBean(int assetDataId, int assetId, long familyId,
		int assetValue, long lastUpdated) {
	super();
	this.assetDataId = assetDataId;
	this.assetId = assetId;
	this.familyId = familyId;
	this.assetValue = assetValue;
	this.lastUpdated = lastUpdated;
}
private int assetValue;
private long lastUpdated;


public AssetDataBean(int assetDataId, int assetId, long familyId, int assetValue) {
	super();
	this.assetDataId = assetDataId;
	this.assetId = assetId;
	this.familyId = familyId;
	this.assetValue = assetValue;
}
public int getAssetDataId() {
	return assetDataId;
}
public void setAssetDataId(int assetDataId) {
	this.assetDataId = assetDataId;
}
public int getAssetId() {
	return assetId;
}
public void setAssetId(int assetId) {
	this.assetId = assetId;
}
public long getFamilyId() {
	return familyId;
}
public void setFamilyId(long familyId) {
	this.familyId = familyId;
}
public int getAssetValue() {
	return assetValue;
}
public void setAssetValue(int assetValue) {
	this.assetValue = assetValue;
}
public long getLastUpdated() {
	return lastUpdated;
}
public void setLastUpdated(long lastUpdated) {
	this.lastUpdated = lastUpdated;
}

}
