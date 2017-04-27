package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.VillageBean;

public class JSONVillage {

	public static String addVillageJSON(int flag) {
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

	public static String getAllVillageJSON(ArrayList<VillageBean> arr) {

		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				VillageBean village= arr.get(count);
				//System.out.println(asset);
				obj.put("villageId",village.getVillageId());
				obj.put("villageCode",village.getVillageCode());
				obj.put("villageName", village.getVillageName());
				obj.put("blockId",village.getBlockId());/*
				obj.put("blockName",village.getBlockName());
				obj.put("blockCode",village.getBlockCode());*/
				

				array.put(obj);
				count++;
			}
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return array.toString();
	}

	public static String getByVillageIdJSON(VillageBean village) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			JSONObject obj = new JSONObject();
			obj.put("villageId",village.getVillageId());
			obj.put("villageCode",village.getVillageCode());
			obj.put("villageName", village.getVillageName());
			obj.put("blockId",village.getBlockId());/*
			obj.put("blockName",village.getBlockName());
			obj.put("blockCode",village.getBlockCode());*/
				

				array.put(obj);
				count++;
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return array.toString();
	}

	public static String getByBlockIdJSON(ArrayList<VillageBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				VillageBean village= arr.get(count);
				//System.out.println(asset);
				obj.put("villageId",village.getVillageId());
				obj.put("villageCode",village.getVillageCode());
				obj.put("villageName", village.getVillageName());
				obj.put("blockId",village.getBlockId());/*
				obj.put("blockName",village.getBlockName());
				obj.put("blockCode",village.getBlockCode());*/
				

				array.put(obj);
				count++;
			}
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return array.toString();
	}
	public static String updateVillageJSON(int flag) {
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


}
