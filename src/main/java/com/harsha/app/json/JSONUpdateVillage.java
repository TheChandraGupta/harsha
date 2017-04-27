package com.harsha.app.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.VillageBean;

public class JSONUpdateVillage {

	public static String updateVillageJSON(VillageBean updateVillageBean) {
		JSONArray array = new JSONArray();
		try {
				JSONObject obj = new JSONObject();
				obj.put("status",true);
				array.put(obj);
				
			}
		catch(JSONException e) {
				e.printStackTrace();
			}
			
		return array.toString();
	}

}
