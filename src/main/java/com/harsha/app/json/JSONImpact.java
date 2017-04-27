package com.harsha.app.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.ImpactBean;
import com.harsha.app.bean.ProjectAssignmentBean;

public class JSONImpact {
	//new code
	public static ImpactBean getImpactData(String data) {
		ImpactBean impact = null;
		try {
			JSONObject obj = new JSONObject(data);
			impact = new ImpactBean(
					//String.valueOf(obj.getLong("impactId")),
					String.valueOf(0),
					String.valueOf(obj.getLong("projectAssignmentId")), 
					String.valueOf(obj.getLong("projectAttributeId")),
							String.valueOf(obj.getLong("projectAttributeValue")),
					String.valueOf(obj.getLong("entryDate"))
					);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return impact;
	}
	
	public static String getStatus(int status) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("status", status);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj.toString();
	}
	
	public static String addImpactJSON(int flag) {


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

	public static String addVegitableJSON(int flag) {
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

	public static String addGoatJSON(int flag) {
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

	public static String addImpactDatatypeJSON(int flag) {
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
