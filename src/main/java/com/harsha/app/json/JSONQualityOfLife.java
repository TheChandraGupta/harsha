package com.harsha.app.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.ImpactBean;
import com.harsha.app.bean.ProjectAssignmentBean;
import com.harsha.app.bean.QualityOfLifeBean;

public class JSONQualityOfLife {
	//new code
	public static QualityOfLifeBean getQualityOfLifeData(String data) {
		QualityOfLifeBean quality = null;
		try {
			JSONObject obj = new JSONObject(data);
			quality = new QualityOfLifeBean(
					obj.getLong("familyId"),
					obj.getInt("totalIncomeIncrease"),
					obj.getInt("increaseInIncome"),
					obj.getInt("totalSavingsIncrease"),
					obj.getInt("centralSchemeDays"),
					obj.getInt("assetsAcquired"),
					obj.getString("remarks"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return quality;
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
