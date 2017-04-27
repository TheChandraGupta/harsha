package com.harsha.app.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.UserViewBean;

public class JSONCheckpoint {
	
	public static String getUserNameParseJSON(String json) {
		try {
			return new JSONArray(json).getJSONObject(0).getString("username");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "NA";
	}
	
	public static String getPasswordParseJSON(String json) {
		try {
			return new JSONArray(json).getJSONObject(0).getString("password");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "NA";
	}
	
	public static String loginJSON(UserViewBean userBean) {
		JSONObject obj = new JSONObject();
		try {
			int status = -1;
			if(userBean.getUserId()!=0)
				status = 0;
			
			obj.put("userId",userBean.getUserId());
			obj.put("profileId",userBean.getProfileId());
			obj.put("roleId",userBean.getRoleId());
			obj.put("roleName",userBean.getRole());
			obj.put("lastActivity",userBean.getLastActivity());
			obj.put("firstName",userBean.getFirstName());
			obj.put("lastName", userBean.getLastName());
			obj.put("username",userBean.getUserName());
			obj.put("email", userBean.getEmail());
			obj.put("address", userBean.getAddress());
			obj.put("phone",userBean.getPhone());
			obj.put("photo", userBean.getPhoto());
			obj.put("status", status);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return obj.toString();
		
	}

	public static String checkUsernameJSON(UserViewBean userBean) {
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			obj.put("userName",userBean.getUserName());
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
		}

	public static String enableJSON(int flag) {
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

	public static String disableJSON(int flag) {
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

	public static String changePasswordJSON(int flag) {
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

	public static String forgetPasswordJSON(UserViewBean userBean) {
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			
			obj.put("username",userBean.getUserName());
			obj.put("email", userBean.getEmail());
			obj.put("password", userBean.getPassword());
			obj.put("userId",userBean.getUserId());
			
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
			
		}
}
