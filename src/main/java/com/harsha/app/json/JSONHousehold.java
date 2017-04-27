package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.HouseHoldBean;

public class JSONHousehold {
	public static String addHouseHoldJSON(int flag) {
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

	public static String getAllHouseholdJSON(ArrayList<HouseHoldBean> arr) {
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
				obj.put("statusCode",houseHold.getHouseholdDataId());
				
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
