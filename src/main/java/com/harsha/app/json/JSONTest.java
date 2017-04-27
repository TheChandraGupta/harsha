package com.harsha.app.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JSONTest {
	
public static String testingRestJSON(int count) {
		
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		
		try {

			obj.put("counter", count);
			
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
		
	}

}
