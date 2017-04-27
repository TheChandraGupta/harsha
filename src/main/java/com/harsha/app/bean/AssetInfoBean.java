package com.harsha.app.bean;

public class AssetInfoBean {
		private int assetId;
		private int houseHoldDataId;
		private String description;
		private int assetInfoId;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getAssetId() {
			return assetId;
		}
		public void setAssetId(int assetId) {
			this.assetId = assetId;
		}
		public AssetInfoBean(int assetId,int houseHoldDataId,String description,int assetInfoId) {
			super();
			this.assetId = assetId;
			this.houseHoldDataId = houseHoldDataId;
			this.description = description;
			this.assetInfoId=assetInfoId;
		}
		public AssetInfoBean() {
			super();
		}
		public int getHouseHoldDataId() {
			return houseHoldDataId;
		}
		public void setHouseHoldDataId(int houseHoldDataId) {
			this.houseHoldDataId = houseHoldDataId;
		}
		public int getAssetInfoId() {
			return assetInfoId;
		}
		public void setAssetInfoId(int assetInfoId) {
			this.assetInfoId = assetInfoId;
		}
		
		
	}

	
