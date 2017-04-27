package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.AssetDataBean;
import com.harsha.app.bean.AssetInfoBean;
import com.harsha.app.bean.MemberBean;


public class JSONAsset {
	
	//New Code
	public static AssetDataBean getAssetData(String data) {
		AssetDataBean asssetdata = null;
		try {
			JSONObject obj = new JSONObject(data);
			
			asssetdata = new AssetDataBean(
					obj.getInt("assetDataId"),
					obj.getInt("assetId"),
					obj.getLong("familyId"),
					obj.getInt("assetValue"),
					obj.getLong("lastUpdated")
					);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return asssetdata;
	}
	
	
	
	
	
	
	
	public static String addAssetJSON(int flag) {
		boolean status = false;
		if(flag==0) {
			status = false;
		}
		else {
			status = true;
		}
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			
			obj.put("status",status);
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
		}
	public static String addNewAssetJSON(int flag) {
		boolean status = false;
		if(flag==0) {
			status = false;
		}
		else {
			status = true;
		}
		JSONArray array = new JSONArray();
		try {
				JSONObject obj = new JSONObject();
				obj.put("status",status);
				array.put(obj);
				
			}
		catch(JSONException e) {
				e.printStackTrace();
			}
			
		return array.toString();
				
	}
	public static String updateAssetJSON(int flag) {
		boolean status = false;
		if(flag==0) {
			status = false;
		}
		else {
			status = true;
		}
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			
			obj.put("status",status);
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
		}
	
	public static String getAllAssetJSON(ArrayList<AssetBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				AssetBean asset = arr.get(count);
				//System.out.println(asset);
				obj.put("assetId",asset.getAssetId());
				obj.put("assetCode", asset.getAssetCode());
				obj.put("assetName",asset.getAssetName());

				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
	}

	public static String updateNewAssetJSON(int flag) {
		boolean status = false;
		if(flag==0) {
			status = false;
		}
		else {
			status = true;
		}
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			
			obj.put("status",status);
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
		}
	public static String getByAssetIdJSON(AssetBean getByAssetIdBean) {
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			
			obj.put("assetCode",getByAssetIdBean.getAssetCode());
			obj.put("assetName",getByAssetIdBean.getAssetName());
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
		}
	
	}

