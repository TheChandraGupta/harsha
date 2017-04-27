package com.harsha.app.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class JSONSignup {
public static String signupJSON() {
		
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		
		try {

			obj.put("status", true);
	
			
			
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
		
	}

}
