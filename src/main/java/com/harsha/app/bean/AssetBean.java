package com.harsha.app.bean;

public class AssetBean {
	private int assetId;
	private String assetCode;
	private String assetName;
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getAssetCode() {
		return assetCode;
	}
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public AssetBean(int assetId, String assetCode, String assetName) {
		super();
		this.assetId = assetId;
		this.assetCode = assetCode;
		this.assetName = assetName;
	}
	public AssetBean() {
		super();
	}
	
}
