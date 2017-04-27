package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.EducationBean;
import com.harsha.app.bean.ReligionBean;

public class JSONReligion {

	public static String addReligionJSON(int flag) {
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

	public static String updateReligionJSON(int flag) {
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

	public static String getAllReligionJSON(ArrayList<ReligionBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				ReligionBean religion = arr.get(count);
				//System.out.println(asset);
				obj.put("religionId",religion.getReligionId());
				obj.put("religionCode", religion.getReligionCode());
				obj.put("religionName",religion.getReligionName());

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
