package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.StateBean;

public class JSONBlock {

	public static String addBlockJSON(int flag) {
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
	
	public static String updateBlockJSON(int flag) {
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

	public static String getAllBlockJSON(ArrayList<BlockBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				BlockBean block= arr.get(count);
				//System.out.println(asset);
				obj.put("blockId",block.getBlockId());
				obj.put("blockCode",block.getBlockCode());
				obj.put("blockName", block.getBlockName());
				obj.put("districtId",block.getDistrictId());/*
				obj.put("districtCode",block.getDistrictCode());
				obj.put("districtName", block.getDistrictName());*/
				

				array.put(obj);
				count++;
			}
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return array.toString();
			
	}

	public static String getByBlockIdJSON(BlockBean block) {

		JSONArray array = new JSONArray();
		try {
			int count=0;
			JSONObject obj = new JSONObject();
			obj.put("blockId",block.getBlockId());
				obj.put("blockCode",block.getBlockCode());
				obj.put("blockName", block.getBlockName());
				obj.put("districtId",block.getDistrictId());/*
				obj.put("districtCode",block.getDistrictCode());
				obj.put("districtName", block.getDistrictName());*/

				array.put(obj);
				count++;
			}
		
		catch(JSONException e) {
			e.printStackTrace();
		}
		return array.toString();
	}
		

}
