package com.harsha.app.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


//import com.google.gson.Gson;
import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.AssetDataBean;
import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.DisabilitiesBean;
import com.harsha.app.bean.DistrictBean;
import com.harsha.app.bean.EducationBean;
import com.harsha.app.bean.EducationStatusBean;
import com.harsha.app.bean.GenderBean;
import com.harsha.app.bean.MaritalStatusBean;
import com.harsha.app.bean.OccupationBean;
import com.harsha.app.bean.ProjectAttributeBean;
import com.harsha.app.bean.ProjectBean;
import com.harsha.app.bean.ProjectTypeBean;
import com.harsha.app.bean.RelationshipBean;
import com.harsha.app.bean.ReligionBean;
import com.harsha.app.bean.SchemeBean;
import com.harsha.app.bean.SocialCategoryBean;
import com.harsha.app.bean.StateBean;
import com.harsha.app.bean.SupervisorAssignmentBean;
import com.harsha.app.bean.TimeStampBean;
import com.harsha.app.bean.VillageBean;
import com.harsha.app.util.ServerTime;


public class JSONDownload {

	public static String getAllDataJSON(
			ArrayList<AssetBean> asset1,
			ArrayList<DisabilitiesBean> disabilities1,
			ArrayList<EducationBean> education1,
			ArrayList<EducationStatusBean> educationStatus1,
			ArrayList<MaritalStatusBean> maritalStatus1,
			ArrayList<OccupationBean> occupation1,
			ArrayList<RelationshipBean> relationship1,
			ArrayList<ReligionBean> religion1,
			ArrayList<SchemeBean> scheme1,
			ArrayList<SocialCategoryBean> socialCategory1,
			ArrayList<ProjectBean> project1) {
		
		JSONObject objAll = new JSONObject();
				
		try {
			int count=0;
			/*
			
			count=0;
			JSONArray array1 = new JSONArray();
			while(count<asset1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(asset1.get(count));
				AssetDataBean asset = asset1.get(count);
				//System.out.println(asset);
				obj.put("assetId",asset.getAssetId());
				obj.put("assetDataId", asset.getAssetDataId());
				obj.put("assetValue", asset.getAssetValue());
				obj.put("familyId",asset.getFamilyId());

				array1.put(obj);
				count++;
			}
			objAll.put("AssetBean", array1);
			*/

			count=0;
			JSONArray array2 = new JSONArray();
			while(count<disabilities1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(disabilities1.get(count));
				DisabilitiesBean disability = disabilities1.get(count);
				//System.out.println(asset);
				obj.put("disabilityId",disability.getDisabilityId());
				obj.put("disabilityCode", disability.getDisabilityCode());
				obj.put("disabilityName",disability.getDisabiltyName());

				array2.put(obj);
				count++;
			}
			objAll.put("DisabilitiesBean", array2);
			

			count=0;
			JSONArray array3 = new JSONArray();
			while(count<education1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(education1.get(count));
				EducationBean education = education1.get(count);
				//System.out.println(asset);
				obj.put("educationId",education.getEducationId());
				obj.put("educationCode", education.getEducationCode());
				obj.put("educationName",education.getEducationName());

				array3.put(obj);
				count++;
			}
			objAll.put("EducationBean", array3);
			

			count=0;
			JSONArray array4 = new JSONArray();
			while(count<educationStatus1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(educationStatus1.get(count));
				EducationStatusBean education = educationStatus1.get(count);
				//System.out.println(asset);
				obj.put("educationStatusId",education.getEducationStatusId());
				obj.put("educationStatusCode", education.getEducationStatusCode());
				obj.put("educationStatusName",education.getEducationStatusName());

				array4.put(obj);
				count++;
			}
			objAll.put("EducationStatusBean", array4);
			

			count=0;
			JSONArray array5 = new JSONArray();
			while(count<maritalStatus1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(maritalStatus1.get(count));
				MaritalStatusBean maritalStatus = maritalStatus1.get(count);
				//System.out.println(asset);
				obj.put("maritalStatusId",maritalStatus.getMaritalStatusId());
				obj.put("maritalStatusCode", maritalStatus.getMaritalStatusCode());
				obj.put("maritalStatusName",maritalStatus.getMaritalStatusName());

				array5.put(obj);
				count++;
			}
			objAll.put("MaritalStatusBean", array5);
			

			count=0;
			JSONArray array6 = new JSONArray();
			while(count<occupation1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(occupation1.get(count));
				OccupationBean occupation = occupation1.get(count);
				//System.out.println(asset);
				obj.put("occupationId",occupation.getOccupationId());
				obj.put("occupationCode", occupation.getOccupationCode());
				obj.put("occupationName",occupation.getOccupationName());

				array6.put(obj);
				count++;
			}
			objAll.put("OccupationBean", array6);
			

			count=0;
			JSONArray array7 = new JSONArray();
			while(count<relationship1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(relationship1.get(count));
				RelationshipBean relation = relationship1.get(count);
				//System.out.println(asset);
				obj.put("relationshipId",relation.getRelationshipId());
				obj.put("relationshipCode", relation.getRelationshipCode());
				obj.put("relationshipName",relation.getRelationshipName());

				array7.put(obj);
				count++;
			}
			objAll.put("RelationshipBean", array7);
			

			count=0;
			JSONArray array8 = new JSONArray();
			while(count<religion1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(religion1.get(count));
				ReligionBean religion = religion1.get(count);
				//System.out.println(asset);
				obj.put("religionId",religion.getReligionId());
				obj.put("religionCode", religion.getReligionCode());
				obj.put("religionName",religion.getReligionName());

				array8.put(obj);
				count++;
			}
			objAll.put("ReligionBean", array8);
			

			count=0;
			JSONArray array9 = new JSONArray();
			while(count<scheme1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(scheme1.get(count));
				SchemeBean scheme = scheme1.get(count);
				//System.out.println(asset);
				obj.put("schemeId",scheme.getSchemeId());
				obj.put("schemeName",scheme.getSchemeName());

				array9.put(obj);
				count++;
			}
			objAll.put("SchemeBean", array9);
			

			count=0;
			JSONArray array10 = new JSONArray();
			while(count<socialCategory1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(socialCategory1.get(count));
				SocialCategoryBean social = socialCategory1.get(count);
				//System.out.println(asset);
				obj.put("socialCategoryId",social.getSocialcategoryId());
				obj.put("socialCategoryCode", social.getSocialCategoryCode());
				obj.put("socialCategoryName",social.getSocialCategoryName());

				array10.put(obj);
				count++;
			}
			objAll.put("SocialCategoryBean", array10);

			count=0;
			JSONArray array11 = new JSONArray();
			while(count<project1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(project1.get(count));
				ProjectBean project = project1.get(count);
				//System.out.println(asset);
				obj.put("projectId",project.getProjectId());
				obj.put("donorName", project.getDonerName());
				obj.put("projectName",project.getProjectName());

				array11.put(obj);
				count++;
			}
			objAll.put("ProjectBean", array11);
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return objAll.toString();
			
	}

	public static String getLastUpdated(String data) {
		String lastUpdated = "";
		try {
			JSONArray aObj = new JSONArray(data);
			JSONObject obj = aObj.getJSONObject(0);
			lastUpdated = obj.getString("lastUpdated");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastUpdated;
	}

	public static String getUserId(String data) {
		String lastUpdated = "";
		try {
			JSONArray aObj = new JSONArray(data);
			JSONObject obj = aObj.getJSONObject(0);
			lastUpdated = obj.getString("userId");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastUpdated;
	}
	
	public static String getAllMasterDataJSON(
			
			ArrayList<AssetBean> asset1,
			ArrayList<DisabilitiesBean> disabilities1,
			ArrayList<EducationBean> education1,
			ArrayList<EducationStatusBean> educationStatus1,
			ArrayList<MaritalStatusBean> maritalStatus1,
			ArrayList<OccupationBean> occupation1,
			ArrayList<RelationshipBean> relationship1,
			ArrayList<ReligionBean> religion1,
			ArrayList<SchemeBean> scheme1,
			ArrayList<SocialCategoryBean> socialCategory1,
			ArrayList<ProjectBean> project1,
			ArrayList<ProjectAttributeBean> projectattribute1,
			ArrayList<ProjectTypeBean> projecttype1,
			ArrayList<GenderBean> gender1,
			ArrayList<TimeStampBean> timestamp1,
			int status)
	
	{
		
		
		JSONObject objAll = new JSONObject();
		JSONArray arrAll = new JSONArray();
		
		try {
			
			System.out.println(timestamp1.size());
			for(int x=0;x<timestamp1.size();x++) {
				TimeStampBean t = timestamp1.get(x);
			int count=0;
			String tableName = t.getTableName();
			System.out.println(t.getTableName());
			
			if(tableName.equals("asset")){
			JSONObject obj1 = new JSONObject();
			count=0;
			JSONArray array1 = new JSONArray();
			while(count<asset1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(asset1.get(count));
				AssetBean asset = asset1.get(count);
				//System.out.println(asset);
				obj.put("assetId",asset.getAssetId());
				obj.put("assetCode", asset.getAssetCode());
				obj.put("assetName",asset.getAssetName());

				array1.put(obj);
				count++;
			}
			obj1.put("asset", array1);
			arrAll.put(obj1);
			}
			
			if(tableName.equals("disabilities")){
			count=0;
			JSONObject obj2 = new JSONObject();
			JSONArray array2 = new JSONArray();
			while(count<disabilities1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(disabilities1.get(count));
				DisabilitiesBean disability = disabilities1.get(count);
				//System.out.println(asset);
				obj.put("disabilityId",disability.getDisabilityId());
				obj.put("disabilityCode", disability.getDisabilityCode());
				obj.put("disabilityName",disability.getDisabiltyName());

				array2.put(obj);
				count++;
			}
			obj2.put("disabilities", array2);
			arrAll.put(obj2);
			}
			
			if(tableName.equals("education")){
			count=0;
			JSONObject obj3 = new JSONObject();
			JSONArray array3 = new JSONArray();
			while(count<education1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(education1.get(count));
				EducationBean education = education1.get(count);
				//System.out.println(asset);
				obj.put("educationId",education.getEducationId());
				obj.put("educationCode", education.getEducationCode());
				obj.put("educationName",education.getEducationName());

				array3.put(obj);
				count++;
			}
			obj3.put("education", array3);
			arrAll.put(obj3);
			}
			
			if(tableName.equals("educationstatus")){
			count=0;
			JSONObject obj4 = new JSONObject();
			JSONArray array4 = new JSONArray();
			while(count<educationStatus1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(educationStatus1.get(count));
				EducationStatusBean education = educationStatus1.get(count);
				//System.out.println(asset);
				obj.put("educationStatusId",education.getEducationStatusId());
				obj.put("educationStatusCode", education.getEducationStatusCode());
				obj.put("educationStatusName",education.getEducationStatusName());

				array4.put(obj);
				count++;
			}
			obj4.put("educationstatus", array4);
			arrAll.put(obj4);
			}
			
			if(tableName.equals("maritalstatus")){
			count=0;
			JSONObject obj5 = new JSONObject();
			JSONArray array5 = new JSONArray();
			while(count<maritalStatus1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(maritalStatus1.get(count));
				MaritalStatusBean maritalStatus = maritalStatus1.get(count);
				//System.out.println(asset);
				obj.put("maritalStatusId",maritalStatus.getMaritalStatusId());
				obj.put("maritalStatusCode", maritalStatus.getMaritalStatusCode());
				obj.put("maritalStatusName",maritalStatus.getMaritalStatusName());

				array5.put(obj);
				count++;
			}
			obj5.put("maritalstatus", array5);
			arrAll.put(obj5);
			}
			
			if(tableName.equals("occupation")){
			count=0;
			JSONObject obj6 = new JSONObject(); 
			JSONArray array6 = new JSONArray();
			while(count<occupation1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(occupation1.get(count));
				OccupationBean occupation = occupation1.get(count);
				//System.out.println(asset);
				obj.put("occupationId",occupation.getOccupationId());
				obj.put("occupationCode", occupation.getOccupationCode());
				obj.put("occupationName",occupation.getOccupationName());

				array6.put(obj);
				count++;
			}
			obj6.put("occupation", array6);
			arrAll.put(obj6);
			}
			
			if(tableName.equals("relationship")){
			count=0;
			JSONObject obj7 = new JSONObject();
			JSONArray array7 = new JSONArray();
			while(count<relationship1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(relationship1.get(count));
				RelationshipBean relation = relationship1.get(count);
				//System.out.println(asset);
				obj.put("relationshipId",relation.getRelationshipId());
				obj.put("relationshipCode", relation.getRelationshipCode());
				obj.put("relationshipName",relation.getRelationshipName());

				array7.put(obj);
				count++;
			}
			obj7.put("relationship", array7);
			arrAll.put(obj7);
			}

			if(tableName.equals("religion")){
			count=0;
			JSONObject obj8 = new JSONObject();
			JSONArray array8 = new JSONArray();
			while(count<religion1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(religion1.get(count));
				ReligionBean religion = religion1.get(count);
				//System.out.println(asset);
				obj.put("religionId",religion.getReligionId());
				obj.put("religionCode", religion.getReligionCode());
				obj.put("religionName",religion.getReligionName());

				array8.put(obj);
				count++;
			}
			obj8.put("religion", array8);
			arrAll.put(obj8);
			}
			
			if(tableName.equals("scheme")){
			count=0;
			JSONObject obj9 = new JSONObject();
			JSONArray array9 = new JSONArray();
			while(count<scheme1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(scheme1.get(count));
				SchemeBean scheme = scheme1.get(count);
				//System.out.println(asset);
				obj.put("schemeId",scheme.getSchemeId());
				obj.put("schemeName",scheme.getSchemeName());

				array9.put(obj);
				count++;
			}
			obj9.put("scheme", array9);
			arrAll.put(obj9);
			}

			if(tableName.equals("socialcategory")){
			count=0;
			JSONObject obj10 = new JSONObject();
			JSONArray array10 = new JSONArray();
			while(count<socialCategory1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(socialCategory1.get(count));
				SocialCategoryBean social = socialCategory1.get(count);
				//System.out.println(asset);
				obj.put("socialCategoryId",social.getSocialcategoryId());
				obj.put("socialCategoryCode", social.getSocialCategoryCode());
				obj.put("socialCategoryName",social.getSocialCategoryName());

				array10.put(obj);
				count++;
			}
			obj10.put("socialcategory", array10);
			arrAll.put(obj10);
			}
			
			if(tableName.equals("project")){
			count=0;
			JSONObject obj11 = new JSONObject();
			JSONArray array11 = new JSONArray();
			while(count<project1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(project1.get(count));
				ProjectBean project = project1.get(count);
				//System.out.println(asset);
				obj.put("projectId",project.getProjectId());
				obj.put("projectName",project.getProjectName());
				obj.put("donorName", project.getDonerName());
				obj.put("projectTypeId", project.getProjectTypeId());

				array11.put(obj);
				count++;
			}
			obj11.put("project", array11);
			arrAll.put(obj11);
			}
			
			if(tableName.equals("projectattribute")){
			count=0;
			JSONObject obj12 = new JSONObject();
			JSONArray array12 = new JSONArray();
			while(count<projectattribute1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(projectattribute1.get(count));
				ProjectAttributeBean projectattribute = projectattribute1.get(count);
				//System.out.println(asset);
				obj.put("projectAttributeId",projectattribute.getProjectAttributeId());
				obj.put("attributeName", projectattribute.getAttributeName());
				obj.put("projectTypeId",projectattribute.getProjectTypeId());	
				obj.put("attributeSize",projectattribute.getAttributeSize());
				obj.put("attributeType",projectattribute.getAttributeType());
				obj.put("status", projectattribute.getStatus());
				obj.put("fixedValue", projectattribute.getFixedValue());
				obj.put("displaySequence", projectattribute.getDisplaySequence());
				array12.put(obj);
				count++;
			}
			// TODO No Changes. Just Testing.
			// Testing
			obj12.put("projectattribute", array12);
			arrAll.put(obj12);
			}
			
			if(tableName.equals("projecttype")){
			count=0;
			JSONObject obj13 = new JSONObject();
			JSONArray array13 = new JSONArray();
			while(count<projecttype1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(projecttype1.get(count));
				ProjectTypeBean projecttype = projecttype1.get(count);
				//System.out.println(asset);
				obj.put("projectTypeId",projecttype.getProjectTypeId());
				obj.put("projectTypeName", projecttype.getProjectTypeName());
				
				array13.put(obj);
				count++;
			}
			obj13.put("projecttype", array13);
			arrAll.put(obj13);
			}
			
			if(tableName.equals("gender")){
			count=0;
			JSONObject obj14 = new JSONObject();
			JSONArray array14 = new JSONArray();
			while(count<gender1.size()) 
			{
				JSONObject obj = new JSONObject();
				System.out.println(gender1.get(count));
				GenderBean gender = gender1.get(count);
				//System.out.println(asset);
				obj.put("genderId",gender.getGenderId());
				obj.put("genderName", gender.getGenderName());
				
				array14.put(obj);
				count++;
			}
			obj14.put("gender", array14);
			arrAll.put(obj14);
			
			}
			}
			//arrAll.put(project1);
			//arrAll.put(obj1);
			
			
			objAll.put("status", status);
			objAll.put("serverTime", ServerTime.getServerTime());
			objAll.put("MasterData", arrAll);
			//objAll = arrAll.toJSONObject(arrAll);
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return objAll.toString();
		
		// TODO remove unwanted code.
		
		
		
		/*JSONObject objAll = new JSONObject();
		
		
		JSONArray objArray = new JSONArray();
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(asset1) + "\n" + gson.toJsonTree(asset1) + "\n" + gson.excluder());
		
		return gson.toJsonTree(socialCategory1).toString();
		//return objAll.toString();
*/			
	}
	
/*	public static JSONArray generateMasterJSON( ArrayList<DisabilitiesBean> disabilities) {
		JSONArray jsonArray = new JSONArray();
		for(int i=0; i<disabilities.size(); i++) {
			DisabilitiesBean dis = disabilities.get(i);
			JSONObject obj = new JSONObject();
		}
		return jsonArray;
	}
*/
	public static String getUserDataJSON(
			ArrayList<StateBean> s,
			ArrayList<DistrictBean> d,
			ArrayList<BlockBean> b,
			ArrayList<VillageBean> v,
			int status) {
				
		JSONObject objAll = new JSONObject();
		JSONArray arrAll = new JSONArray();	
		
		try {
			
			int count = 0;
			if(s.size()>0) {
				JSONObject obj2 = new JSONObject();
				JSONArray array2 = new JSONArray();
				while(count<s.size()) 
				{
					JSONObject obj = new JSONObject();
					System.out.println(s.get(count));
					StateBean state = s.get(count);
					//System.out.println(asset);
					obj.put("stateId",state.getStateId());
					obj.put("stateName", state.getStateName());
					obj.put("stateCode",state.getStateCode());
		
					array2.put(obj);
					count++;
				}
				obj2.put("state", array2);
				arrAll.put(obj2);
			}
			

			if(d.size()>0) {
				count = 0;
				JSONObject obj1 = new JSONObject();
				JSONArray array1 = new JSONArray();
				while(count<d.size()) 
				{
					JSONObject obj = new JSONObject();
					System.out.println(d.get(count));
					DistrictBean district = d.get(count);
					//System.out.println(asset);
					obj.put("districtId",district.getDistrictId());
					obj.put("districtCode",district.getDistrictCode());
					obj.put("districtName", district.getDistrictName());
					obj.put("stateId",district.getStateId());
		
					array1.put(obj);
					count++;
				}
				obj1.put("district", array1);
				arrAll.put(obj1);
			}
			

			if(b.size()>0) {
				count = 0;
				JSONObject obj3 = new JSONObject();
				JSONArray array3 = new JSONArray();
				while(count<b.size()) 
				{
					JSONObject obj = new JSONObject();
					System.out.println(b.get(count));
					BlockBean block = b.get(count);
					//System.out.println(asset);
					obj.put("blockId",block.getBlockId());
					obj.put("blockCode",block.getBlockCode());
					obj.put("blockName", block.getBlockName());
					obj.put("districtId",block.getDistrictId());
		
					array3.put(obj);
					count++;
				}
				obj3.put("block", array3);
				arrAll.put(obj3);
			}
			

			if(v.size()>0) {
				count = 0;
				JSONObject obj4 = new JSONObject();
				JSONArray array4 = new JSONArray();
				while(count<v.size()) 
				{
					JSONObject obj = new JSONObject();
					System.out.println(v.get(count));
					VillageBean village = v.get(count);
					//System.out.println(asset);
					obj.put("villageId",village.getVillageId());
					obj.put("villageCode",village.getVillageCode());
					obj.put("villageName", village.getVillageName());
					obj.put("blockId",village.getBlockId());
		
					array4.put(obj);
					count++;
				}
				obj4.put("village", array4);
				arrAll.put(obj4);
			}

			
			objAll.put("status", status);
			objAll.put("serverTime", ServerTime.getServerTime());
			objAll.put("MasterData", arrAll);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return objAll.toString();
			
	}

	

}
