package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.ProjectBean;
import com.harsha.app.bean.StateBean;

public class JSONState {

	public static String addStateJSON(int flag) {
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
	
	public static String getAllStateJSON(ArrayList<StateBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				StateBean state = arr.get(count);
				//System.out.println(asset);
				obj.put("stateId",state.getStateId());
				obj.put("stateName", state.getStateName());
				obj.put("stateCode",state.getStateCode());

				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
		
	}

	public static String getByStateJSON(StateBean getByStateBean) {

		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			
			obj.put("stateName",getByStateBean.getStateName());
			obj.put("stateCode", getByStateBean.getStateCode());

			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	}
	
	public static String updateStateJSON(int flag) {
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
