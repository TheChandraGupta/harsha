package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.DisabilitiesBean;
import com.harsha.app.bean.RelationshipBean;

public class JSONDisabilities {

	public static String addDisabilitiesJSON(int flag) {
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

	public static String updateDisabilitiesJSON(int flag) {
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
			if(obj.equals(null))
			{
				obj.put("status",status);
				array.put(obj);

			}
			else
			{
				obj.put("status",true);
				array.put(obj);
			}
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	}

	public static String getAllDisabilitiesJSON(ArrayList<DisabilitiesBean> arr) {


		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				DisabilitiesBean disability = arr.get(count);
				//System.out.println(asset);
				obj.put("disabilityId",disability.getDisabilityId());
				obj.put("disabilityCode", disability.getDisabilityCode());
				obj.put("disabilityName",disability.getDisabiltyName());

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
