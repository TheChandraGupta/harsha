package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.DisabilitiesBean;
import com.harsha.app.bean.EducationBean;

public class JSONEducation {

	public static String addEducationJSON(int flag) {
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

	public static String updateEducationJSON(int flag) {
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

	public static String getAllEducationJSON(ArrayList<EducationBean> arr) {
		
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				EducationBean education = arr.get(count);
				//System.out.println(asset);
				obj.put("educationId",education.getEducationId());
				obj.put("educationCode", education.getEducationCode());
				obj.put("educationName",education.getEducationName());

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
