package com.harsha.app.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.UserViewBean;

public class JSONLogin {
	
	public static String loginJSON(UserViewBean userBean) {
	JSONArray array = new JSONArray();
	try {
		
		JSONObject obj = new JSONObject();

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

		array.put(obj);
		
	}
	catch(JSONException e) {
		e.printStackTrace();
	}
	
	return array.toString();
		
	}

}
