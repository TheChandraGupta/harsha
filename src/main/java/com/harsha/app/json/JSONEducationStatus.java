package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.EducationBean;
import com.harsha.app.bean.EducationStatusBean;

public class JSONEducationStatus {

	public static String addEducationStatusJSON(int flag) {
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

	public static String updateEducationStatusJSON(int flag) {
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

	public static String getAllEducationStatusJSON(ArrayList<EducationStatusBean> arr) {
		
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				EducationStatusBean education = arr.get(count);
				//System.out.println(asset);
				obj.put("educationStatusId",education.getEducationStatusId());
				obj.put("educationStatusCode", education.getEducationStatusCode());
				obj.put("educationStatusName",education.getEducationStatusName());

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
