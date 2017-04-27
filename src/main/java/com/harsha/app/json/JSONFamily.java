package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.FamilyBean;
import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.util.ServerTime;

public class JSONFamily {
	
	public static FamilyBean getFamilyData(String data) {
		FamilyBean family = null;
		try {
			JSONObject obj = new JSONObject(data);
			family = new FamilyBean(String.valueOf(obj.getLong("familyId")), 
					String.valueOf(obj.getInt("villageId")),
					String.valueOf(obj.getLong("income")),
					String.valueOf(obj.getLong("savings")),
					String.valueOf(obj.getInt("userId")));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return family;
	}
	
	public static String getAllFamily(int status, ArrayList<FamilyBean> family) {
		JSONObject j = new JSONObject();
		JSONArray jArr = new JSONArray();
		try {
			for(int i = 0; i<family.size(); i++ ){
				JSONObject obj = new JSONObject();
				FamilyBean f = family.get(i);
				obj.put("familyId", f.getFamilyId());
				obj.put("income", f.getIncome());
				obj.put("savings", f.getSavings());
				obj.put("villageId", f.getVillageId());
				jArr.put(obj);
			}
			j.put("status", status);
			j.put("serverTime", ServerTime.getServerTime());
			j.put("family", jArr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return j.toString();
	}
	
	public static String getStatus(int status) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("status", status);
			obj.put("serverTime", ServerTime.getServerTime());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj.toString();
	}

/*	public static String addFamilyJSON(int flag) {
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
*/
	public static String getAllFamilyJSON(ArrayList<FamilyBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				FamilyBean family = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("familyId",family.getFamilyId());
				obj.put("villageId",family.getVillageId());
				obj.put("income",family.getIncome());
				obj.put("savings",family.getSavings());
				
				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	}

	public static String getByVillageHouseholdJSON(ArrayList<HouseHoldBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				HouseHoldBean houseHold = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("stateId",houseHold.getStateId());
				obj.put("stateName",houseHold.getStateName());
				obj.put("stateCode",houseHold.getStateCode());
				obj.put("districtId",houseHold.getDistrictId());
				obj.put("districtName",houseHold.getDistrictname());
				obj.put("districtCode",houseHold.getDistrictCode());
				obj.put("blockId",houseHold.getBlockId());
				obj.put("blockName",houseHold.getBlockName());
				obj.put("blockCode",houseHold.getBlockCode());
				obj.put("villageId",houseHold.getVillageid());
				obj.put("villageName",houseHold.getVillageName());
				obj.put("villageCode",houseHold.getVillageCode());
				obj.put("surveyOwnerUserId",houseHold.getSurveyOwnerUserId());
				obj.put("surveyOwnerUserName",houseHold.getSurveyOwnerUserName());
				obj.put("surveyOwnerName",houseHold.getSurveyOwnerName());
				obj.put("religionId",houseHold.getReligionId());
				obj.put("religionName",houseHold.getReligionName());
				obj.put("contactNo",houseHold.getContactNo());
				obj.put("getNoOfFamilyMember",houseHold.getNoOfFamilyMember());
				obj.put("occupationId",houseHold.getOccupationId());
				obj.put("occupationName",houseHold.getOccupationName());
				obj.put("annualHHIncome",houseHold.getAnnualHHIncome());
				obj.put("remarks",houseHold.getRemarks());
				obj.put("householddataId",houseHold.getHouseholdDataId());
				
				
				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	}

	public static String getByBlockHouseholdJSON(ArrayList<HouseHoldBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				HouseHoldBean houseHold = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("stateId",houseHold.getStateId());
				obj.put("stateName",houseHold.getStateName());
				obj.put("stateCode",houseHold.getStateCode());
				obj.put("districtId",houseHold.getDistrictId());
				obj.put("districtName",houseHold.getDistrictname());
				obj.put("districtCode",houseHold.getDistrictCode());
				obj.put("blockId",houseHold.getBlockId());
				obj.put("blockName",houseHold.getBlockName());
				obj.put("blockCode",houseHold.getBlockCode());
				obj.put("villageId",houseHold.getVillageid());
				obj.put("villageName",houseHold.getVillageName());
				obj.put("villageCode",houseHold.getVillageCode());
				obj.put("surveyOwnerUserId",houseHold.getSurveyOwnerUserId());
				obj.put("surveyOwnerUserName",houseHold.getSurveyOwnerUserName());
				obj.put("surveyOwnerName",houseHold.getSurveyOwnerName());
				obj.put("religionId",houseHold.getReligionId());
				obj.put("religionName",houseHold.getReligionName());
				obj.put("contactNo",houseHold.getContactNo());
				obj.put("getNoOfFamilyMember",houseHold.getNoOfFamilyMember());
				obj.put("occupationId",houseHold.getOccupationId());
				obj.put("occupationName",houseHold.getOccupationName());
				obj.put("annualHHIncome",houseHold.getAnnualHHIncome());
				obj.put("remarks",houseHold.getRemarks());
				obj.put("householddataId",houseHold.getHouseholdDataId());
				
				
				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	}

	public static String getByDistrictHouseholdJSON(ArrayList<HouseHoldBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				HouseHoldBean houseHold = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("stateId",houseHold.getStateId());
				obj.put("stateName",houseHold.getStateName());
				obj.put("stateCode",houseHold.getStateCode());
				obj.put("districtId",houseHold.getDistrictId());
				obj.put("districtName",houseHold.getDistrictname());
				obj.put("districtCode",houseHold.getDistrictCode());
				obj.put("blockId",houseHold.getBlockId());
				obj.put("blockName",houseHold.getBlockName());
				obj.put("blockCode",houseHold.getBlockCode());
				obj.put("villageId",houseHold.getVillageid());
				obj.put("villageName",houseHold.getVillageName());
				obj.put("villageCode",houseHold.getVillageCode());
				obj.put("surveyOwnerUserId",houseHold.getSurveyOwnerUserId());
				obj.put("surveyOwnerUserName",houseHold.getSurveyOwnerUserName());
				obj.put("surveyOwnerName",houseHold.getSurveyOwnerName());
				obj.put("religionId",houseHold.getReligionId());
				obj.put("religionName",houseHold.getReligionName());
				obj.put("contactNo",houseHold.getContactNo());
				obj.put("getNoOfFamilyMember",houseHold.getNoOfFamilyMember());
				obj.put("occupationId",houseHold.getOccupationId());
				obj.put("occupationName",houseHold.getOccupationName());
				obj.put("annualHHIncome",houseHold.getAnnualHHIncome());
				obj.put("remarks",houseHold.getRemarks());
				obj.put("householddataId",houseHold.getHouseholdDataId());
				
				
				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	}

	public static String getByStateHouseholdJSON(ArrayList<HouseHoldBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				HouseHoldBean houseHold = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("stateId",houseHold.getStateId());
				obj.put("stateName",houseHold.getStateName());
				obj.put("stateCode",houseHold.getStateCode());
				obj.put("districtId",houseHold.getDistrictId());
				obj.put("districtName",houseHold.getDistrictname());
				obj.put("districtCode",houseHold.getDistrictCode());
				obj.put("blockId",houseHold.getBlockId());
				obj.put("blockName",houseHold.getBlockName());
				obj.put("blockCode",houseHold.getBlockCode());
				obj.put("villageId",houseHold.getVillageid());
				obj.put("villageName",houseHold.getVillageName());
				obj.put("villageCode",houseHold.getVillageCode());
				obj.put("surveyOwnerUserId",houseHold.getSurveyOwnerUserId());
				obj.put("surveyOwnerUserName",houseHold.getSurveyOwnerUserName());
				obj.put("surveyOwnerName",houseHold.getSurveyOwnerName());
				obj.put("religionId",houseHold.getReligionId());
				obj.put("religionName",houseHold.getReligionName());
				obj.put("contactNo",houseHold.getContactNo());
				obj.put("getNoOfFamilyMember",houseHold.getNoOfFamilyMember());
				obj.put("occupationId",houseHold.getOccupationId());
				obj.put("occupationName",houseHold.getOccupationName());
				obj.put("annualHHIncome",houseHold.getAnnualHHIncome());
				obj.put("remarks",houseHold.getRemarks());
				obj.put("householddataId",houseHold.getHouseholdDataId());
				
				
				array.put(obj);
				count++;
			}
			
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
	}

	public static String verificationHouseholdJSON(int flag) {
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
