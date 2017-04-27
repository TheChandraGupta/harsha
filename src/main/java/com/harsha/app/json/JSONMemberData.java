package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.FamilyBean;
import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.bean.MemberBean;
import com.harsha.app.bean.MemberDataBean;
import com.harsha.app.util.ServerTime;

public class JSONMemberData {
	

	public static MemberBean getMemberData(String data) {
		MemberBean member = null;
		try {
			JSONObject obj = new JSONObject(data);
			
			member = new MemberBean(
					String.valueOf(obj.getLong("memberId")),
					String.valueOf(obj.getLong("familyId")),
					String.valueOf(obj.getString("name")),
					String.valueOf(obj.getInt("userId")),
					String.valueOf(obj.getString("dob")),
					String.valueOf(obj.getInt("genderId")),
					String.valueOf(obj.getInt("socialCategoryId")),
					String.valueOf(obj.getString("aadhaarCardId")),
					String.valueOf(obj.getString("voterId")),
					String.valueOf(obj.getString("bplCard")),
					String.valueOf(obj.getString("jobCard")),
					String.valueOf(obj.getInt("occupationId")),
					String.valueOf(obj.getInt("maritalStatusId")),
					String.valueOf(obj.getInt("disabilityId")),
					String.valueOf(obj.getInt("religionId")),
					String.valueOf(obj.getInt("relationshipId")),
					String.valueOf(obj.getInt("schemeId")),
					String.valueOf(obj.getInt("educationId")),
					String.valueOf(obj.getInt("educationStatusId")),
					String.valueOf(-1),
					String.valueOf("Pending")
					);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public static String getAllMember(int status, ArrayList<MemberBean> member) {
		JSONObject jObj = new JSONObject();
		JSONArray jArr = new JSONArray();
		try {
			for(int i=0; i<member.size(); i++) {
				JSONObject obj = new JSONObject();
				MemberBean m = member.get(i);
				obj.put("memberId", m.getMemberId());
				obj.put("familyId", m.getFamilyId());
				//obj.put("userId", m.getUserId());
				obj.put("name", m.getName());
				obj.put("dob", m.getDob());
				obj.put("genderId", m.getGenderId());
				obj.put("socialCategoryId", m.getSocialCategoryId());
				obj.put("aadhaarCardId", m.getAadhaarCardId());
				obj.put("voterId", m.getVoterId());
				obj.put("bplCard", m.getBplCard());
				obj.put("jobCard", m.getJobCard());
				obj.put("occupationId", m.getOccupationId());
				obj.put("maritalStatusId", m.getMaritalStatusId());
				obj.put("disabilityId", m.getDisabilityId());
				obj.put("religionId", m.getReligionId());
				obj.put("relationshipId", m.getRelationshipId());
				obj.put("schemeId", m.getSchemeId());
				obj.put("educationId", m.getEducationId());
				obj.put("educationStatusId", m.getEducationStatusId());
				obj.put("approvalStatus", m.getApprovalStatus());
				obj.put("approvalRemark", m.getApprovalRemark());
				jArr.put(obj);
			}
			jObj.put("status", status);
			jObj.put("serverTime", ServerTime.getServerTime());
			jObj.put("member", jArr);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return jObj.toString();
	}
	

	public static String addMemberDataJSON(int flag) {
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

	public static String getAllMemberdataJSON(ArrayList<MemberDataBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				MemberDataBean memberdata = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("houseHoldDataId",memberdata.getHouseHoldDataId());
				obj.put("stateId",memberdata.getStateId());
				obj.put("stateName",memberdata.getStateName());
				obj.put("stateCode",memberdata.getStateCode());
				obj.put("districtId",memberdata.getDistrictId());
				obj.put("districtName",memberdata.getDistrictName());
				obj.put("districtCode",memberdata.getDistrictCode());
				obj.put("blockId",memberdata.getBlockId());
				obj.put("blockCode",memberdata.getBlockName());
				obj.put("blockName",memberdata.getBlockCode());
				obj.put("villageId",memberdata.getVillageId());
				obj.put("villageName",memberdata.getVillageName());
				obj.put("villageCode",memberdata.getVillageCode());
				obj.put("memberName",memberdata.getMembername());
				obj.put("gender",memberdata.getGender());
				obj.put("relationshipId",memberdata.getRelationshipId());
				obj.put("relationshipName",memberdata.getRelationshipName());
				obj.put("dob",memberdata.getDob());
				obj.put("age",memberdata.getAge());
				obj.put("maritalStatusId",memberdata.getMaritalStatusId());
				obj.put("maritalStatusName",memberdata.getMaritalStatusName());
				obj.put("EducationId",memberdata.getEducationId());
				obj.put("EducationName",memberdata.getEducationName());
				obj.put("EducationStatusId",memberdata.getEducationStatusId());
				obj.put("EducationStatusName",memberdata.getEducationStatusName());
				obj.put("aadharcard",memberdata.getAadharCard());
				obj.put("electionCard",memberdata.getElectionCard());
				obj.put("addressPermanent",memberdata.getAddressPermanent());
				obj.put("pincodePermanent",memberdata.getPincodePermanent());
				obj.put("addressCurrent",memberdata.getAddressCurrent());
				obj.put("pincodeCurrent",memberdata.getPincodeCurrent());
				obj.put("disabilityId",memberdata.getDisabilityId());
				obj.put("disabilityName",memberdata.getDisabilityName());
				obj.put("schemeId",memberdata.getSchemeId());
				obj.put("schemeName",memberdata.getSchemeName());
				obj.put("incomeAnnual",memberdata.getIncomeAnnual());
				obj.put("emailId",memberdata.getEmailId());
				obj.put("mobileNumber",memberdata.getMobileNumber());
				obj.put("alternameNumberWith",memberdata.getAlternateNumberWith());
				obj.put("occupationId",memberdata.getOccupationId());
				obj.put("occupationName",memberdata.getOccupationName());
				obj.put("memberDataId",memberdata.getMemberDataId());
				obj.put("statusCode", memberdata.getStatusCode());
				
				array.put(obj);
				count++;
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return array.toString();
	}

	public static String getByVillageMemberdataJSON(ArrayList<MemberDataBean> arr) {

		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				MemberDataBean memberdata = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("houseHoldDataId",memberdata.getHouseHoldDataId());
				obj.put("stateId",memberdata.getStateId());
				obj.put("stateName",memberdata.getStateName());
				obj.put("stateCode",memberdata.getStateCode());
				obj.put("districtId",memberdata.getDistrictId());
				obj.put("districtName",memberdata.getDistrictName());
				obj.put("districtCode",memberdata.getDistrictCode());
				obj.put("blockId",memberdata.getBlockId());
				obj.put("blockCode",memberdata.getBlockName());
				obj.put("blockName",memberdata.getBlockCode());
				obj.put("villageId",memberdata.getVillageId());
				obj.put("villageName",memberdata.getVillageName());
				obj.put("villageCode",memberdata.getVillageCode());
				obj.put("memberName",memberdata.getMembername());
				obj.put("gender",memberdata.getGender());
				obj.put("relationshipId",memberdata.getRelationshipId());
				obj.put("relationshipName",memberdata.getRelationshipName());
				obj.put("dob",memberdata.getDob());
				obj.put("age",memberdata.getAge());
				obj.put("maritalStatusId",memberdata.getMaritalStatusId());
				obj.put("maritalStatusName",memberdata.getMaritalStatusName());
				obj.put("EducationId",memberdata.getEducationId());
				obj.put("EducationName",memberdata.getEducationName());
				obj.put("EducationStatusId",memberdata.getEducationStatusId());
				obj.put("EducationStatusName",memberdata.getEducationStatusName());
				obj.put("aadharcard",memberdata.getAadharCard());
				obj.put("electionCard",memberdata.getElectionCard());
				obj.put("addressPermanent",memberdata.getAddressPermanent());
				obj.put("pincodePermanent",memberdata.getPincodePermanent());
				obj.put("addressCurrent",memberdata.getAddressCurrent());
				obj.put("pincodeCurrent",memberdata.getPincodeCurrent());
				obj.put("disabilityId",memberdata.getDisabilityId());
				obj.put("disabilityName",memberdata.getDisabilityName());
				obj.put("schemeId",memberdata.getSchemeId());
				obj.put("schemeName",memberdata.getSchemeName());
				obj.put("incomeAnnual",memberdata.getIncomeAnnual());
				obj.put("emailId",memberdata.getEmailId());
				obj.put("mobileNumber",memberdata.getMobileNumber());
				obj.put("alternameNumberWith",memberdata.getAlternateNumberWith());
				obj.put("occupationId",memberdata.getOccupationId());
				obj.put("occupationName",memberdata.getOccupationName());
				obj.put("memberDataId",memberdata.getMemberDataId());
				
				array.put(obj);
				count++;
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return array.toString();
	}

	public static String getByBlockMemberdataJSON(ArrayList<MemberDataBean> arr) {

		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				MemberDataBean memberdata = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("houseHoldDataId",memberdata.getHouseHoldDataId());
				obj.put("stateId",memberdata.getStateId());
				obj.put("stateName",memberdata.getStateName());
				obj.put("stateCode",memberdata.getStateCode());
				obj.put("districtId",memberdata.getDistrictId());
				obj.put("districtName",memberdata.getDistrictName());
				obj.put("districtCode",memberdata.getDistrictCode());
				obj.put("blockId",memberdata.getBlockId());
				obj.put("blockCode",memberdata.getBlockName());
				obj.put("blockName",memberdata.getBlockCode());
				obj.put("villageId",memberdata.getVillageId());
				obj.put("villageName",memberdata.getVillageName());
				obj.put("villageCode",memberdata.getVillageCode());
				obj.put("memberName",memberdata.getMembername());
				obj.put("gender",memberdata.getGender());
				obj.put("relationshipId",memberdata.getRelationshipId());
				obj.put("relationshipName",memberdata.getRelationshipName());
				obj.put("dob",memberdata.getDob());
				obj.put("age",memberdata.getAge());
				obj.put("maritalStatusId",memberdata.getMaritalStatusId());
				obj.put("maritalStatusName",memberdata.getMaritalStatusName());
				obj.put("EducationId",memberdata.getEducationId());
				obj.put("EducationName",memberdata.getEducationName());
				obj.put("EducationStatusId",memberdata.getEducationStatusId());
				obj.put("EducationStatusName",memberdata.getEducationStatusName());
				obj.put("aadharcard",memberdata.getAadharCard());
				obj.put("electionCard",memberdata.getElectionCard());
				obj.put("addressPermanent",memberdata.getAddressPermanent());
				obj.put("pincodePermanent",memberdata.getPincodePermanent());
				obj.put("addressCurrent",memberdata.getAddressCurrent());
				obj.put("pincodeCurrent",memberdata.getPincodeCurrent());
				obj.put("disabilityId",memberdata.getDisabilityId());
				obj.put("disabilityName",memberdata.getDisabilityName());
				obj.put("schemeId",memberdata.getSchemeId());
				obj.put("schemeName",memberdata.getSchemeName());
				obj.put("incomeAnnual",memberdata.getIncomeAnnual());
				obj.put("emailId",memberdata.getEmailId());
				obj.put("mobileNumber",memberdata.getMobileNumber());
				obj.put("alternameNumberWith",memberdata.getAlternateNumberWith());
				obj.put("occupationId",memberdata.getOccupationId());
				obj.put("occupationName",memberdata.getOccupationName());
				obj.put("memberDataId",memberdata.getMemberDataId());
				
				array.put(obj);
				count++;
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return array.toString();
	}

	public static String getByDistrictMemberdataJSON(ArrayList<MemberDataBean> arr) {


		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				MemberDataBean memberdata = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("houseHoldDataId",memberdata.getHouseHoldDataId());
				obj.put("stateId",memberdata.getStateId());
				obj.put("stateName",memberdata.getStateName());
				obj.put("stateCode",memberdata.getStateCode());
				obj.put("districtId",memberdata.getDistrictId());
				obj.put("districtName",memberdata.getDistrictName());
				obj.put("districtCode",memberdata.getDistrictCode());
				obj.put("blockId",memberdata.getBlockId());
				obj.put("blockCode",memberdata.getBlockName());
				obj.put("blockName",memberdata.getBlockCode());
				obj.put("villageId",memberdata.getVillageId());
				obj.put("villageName",memberdata.getVillageName());
				obj.put("villageCode",memberdata.getVillageCode());
				obj.put("memberName",memberdata.getMembername());
				obj.put("gender",memberdata.getGender());
				obj.put("relationshipId",memberdata.getRelationshipId());
				obj.put("relationshipName",memberdata.getRelationshipName());
				obj.put("dob",memberdata.getDob());
				obj.put("age",memberdata.getAge());
				obj.put("maritalStatusId",memberdata.getMaritalStatusId());
				obj.put("maritalStatusName",memberdata.getMaritalStatusName());
				obj.put("EducationId",memberdata.getEducationId());
				obj.put("EducationName",memberdata.getEducationName());
				obj.put("EducationStatusId",memberdata.getEducationStatusId());
				obj.put("EducationStatusName",memberdata.getEducationStatusName());
				obj.put("aadharcard",memberdata.getAadharCard());
				obj.put("electionCard",memberdata.getElectionCard());
				obj.put("addressPermanent",memberdata.getAddressPermanent());
				obj.put("pincodePermanent",memberdata.getPincodePermanent());
				obj.put("addressCurrent",memberdata.getAddressCurrent());
				obj.put("pincodeCurrent",memberdata.getPincodeCurrent());
				obj.put("disabilityId",memberdata.getDisabilityId());
				obj.put("disabilityName",memberdata.getDisabilityName());
				obj.put("schemeId",memberdata.getSchemeId());
				obj.put("schemeName",memberdata.getSchemeName());
				obj.put("incomeAnnual",memberdata.getIncomeAnnual());
				obj.put("emailId",memberdata.getEmailId());
				obj.put("mobileNumber",memberdata.getMobileNumber());
				obj.put("alternameNumberWith",memberdata.getAlternateNumberWith());
				obj.put("occupationId",memberdata.getOccupationId());
				obj.put("occupationName",memberdata.getOccupationName());
				obj.put("memberDataId",memberdata.getMemberDataId());
				
				array.put(obj);
				count++;
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return array.toString();
	}

	public static String getByStateMemberdataJSON(ArrayList<MemberDataBean> arr) {
		JSONArray array = new JSONArray();
		try {
			int count=0;
			
			while(count<arr.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(arr.get(count));
				MemberDataBean memberdata = arr.get(count);
				System.out.println(arr.getClass());
				obj.put("houseHoldDataId",memberdata.getHouseHoldDataId());
				obj.put("stateId",memberdata.getStateId());
				obj.put("stateName",memberdata.getStateName());
				obj.put("stateCode",memberdata.getStateCode());
				obj.put("districtId",memberdata.getDistrictId());
				obj.put("districtName",memberdata.getDistrictName());
				obj.put("districtCode",memberdata.getDistrictCode());
				obj.put("blockId",memberdata.getBlockId());
				obj.put("blockCode",memberdata.getBlockName());
				obj.put("blockName",memberdata.getBlockCode());
				obj.put("villageId",memberdata.getVillageId());
				obj.put("villageName",memberdata.getVillageName());
				obj.put("villageCode",memberdata.getVillageCode());
				obj.put("memberName",memberdata.getMembername());
				obj.put("gender",memberdata.getGender());
				obj.put("relationshipId",memberdata.getRelationshipId());
				obj.put("relationshipName",memberdata.getRelationshipName());
				obj.put("dob",memberdata.getDob());
				obj.put("age",memberdata.getAge());
				obj.put("maritalStatusId",memberdata.getMaritalStatusId());
				obj.put("maritalStatusName",memberdata.getMaritalStatusName());
				obj.put("EducationId",memberdata.getEducationId());
				obj.put("EducationName",memberdata.getEducationName());
				obj.put("EducationStatusId",memberdata.getEducationStatusId());
				obj.put("EducationStatusName",memberdata.getEducationStatusName());
				obj.put("aadharcard",memberdata.getAadharCard());
				obj.put("electionCard",memberdata.getElectionCard());
				obj.put("addressPermanent",memberdata.getAddressPermanent());
				obj.put("pincodePermanent",memberdata.getPincodePermanent());
				obj.put("addressCurrent",memberdata.getAddressCurrent());
				obj.put("pincodeCurrent",memberdata.getPincodeCurrent());
				obj.put("disabilityId",memberdata.getDisabilityId());
				obj.put("disabilityName",memberdata.getDisabilityName());
				obj.put("schemeId",memberdata.getSchemeId());
				obj.put("schemeName",memberdata.getSchemeName());
				obj.put("incomeAnnual",memberdata.getIncomeAnnual());
				obj.put("emailId",memberdata.getEmailId());
				obj.put("mobileNumber",memberdata.getMobileNumber());
				obj.put("alternameNumberWith",memberdata.getAlternateNumberWith());
				obj.put("occupationId",memberdata.getOccupationId());
				obj.put("occupationName",memberdata.getOccupationName());
				obj.put("memberDataId",memberdata.getMemberDataId());
				
				array.put(obj);
				count++;
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return array.toString();
	}

	public static String verificationMemberJSON(int flag) {
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
