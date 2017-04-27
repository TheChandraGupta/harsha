package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.DistrictBean;

public class JSONDistrict {

	public static String addDistrictJSON(int flag) {
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
	public static String updateDistrictJSON(int flag) {
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
	
	public static String getByStateIdJSON(ArrayList<DistrictBean> arr) {

		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				DistrictBean district= arr.get(count);
				//System.out.println(asset);
				obj.put("districtId",district.getDistrictId());
				obj.put("districtCode",district.getDistrictCode());
				obj.put("districtName", district.getDistrictName());
				obj.put("stateId",district.getStateId());/*
				obj.put("stateCode",district.getStateCode());
				obj.put("stateName", district.getStateName());*/
				

				array.put(obj);
				count++;
			}
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return array.toString();
	}
		
	public static String getByDistrictIdJSON(DistrictBean district) {

		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			JSONObject obj = new JSONObject();
			obj.put("districtId",district.getDistrictId());
			obj.put("districtCode",district.getDistrictCode());
			obj.put("districtName", district.getDistrictName());
			obj.put("stateId",district.getStateId());/*
			obj.put("stateCode",district.getStateCode());
			obj.put("stateName", district.getStateName());*/
				

				array.put(obj);
				count++;
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return array.toString();
	}
	
	public static String getAllDistrictJSON(ArrayList<DistrictBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				DistrictBean district = arr.get(count);
				obj.put("districtId",district.getDistrictId());
				obj.put("districtCode", district.getDistrictCode());
				obj.put("districtName",district.getDistrictName());
				obj.put("stateId", district.getStateId());/*
				obj.put("stateCode",district.getStateCode());
				obj.put("stateName", district.getStateName());*/
				

				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	
	}


}
