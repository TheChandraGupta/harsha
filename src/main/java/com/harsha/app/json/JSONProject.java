package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.ProjectBean;

public class JSONProject {
	public static String addProjectJSON(int flag) {
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
	public static String getAllProjectJSON(ArrayList<ProjectBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				ProjectBean project = arr.get(count);
				//System.out.println(asset);
				obj.put("projectId",project.getProjectId());
				obj.put("projectName",project.getProjectName());
				obj.put("donorName", project.getDonerName());
				

				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
	}
	public static String updateProjectJSON(int flag) {
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
