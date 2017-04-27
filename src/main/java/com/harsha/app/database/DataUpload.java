package com.harsha.app.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class DataUpload {
	
	public static final int MAX_USER = 4;
	public static final int MAX_FAMILY = 3;
	public static final int MAX_FAMILY_MEMBER = 2;

	public static void insertNewUploadFileDetails(String fileNameGiven, String fileNameAssigned, DBManager dbManager) {
		System.out.println("insertNewUploadFileDetails="+fileNameGiven+"-"+fileNameAssigned);
		String query = "";
		try {
			query = "INSERT INTO serverdocuments (documentNameGiven, documentNameAssigned, uploadDateTime) VALUES"
					+ "('"+fileNameGiven+"','"+fileNameAssigned+"', NOW())";
			dbManager.getSt().executeUpdate(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public static void deleteFileFromServer(String serverDocumentsId, DBManager dbManager) {
		System.out.println("deleteFileFromServer="+serverDocumentsId);
		String query = "";
		try {
			query = "DELETE FROM serverdocuments where serverDocumentsId="+serverDocumentsId;
			dbManager.getSt().executeUpdate(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static JSONArray getAllUploadFileDetails(DBManager dbManager) {
		System.out.println("getAllUploadFileDetails");
		JSONArray jsonArray = new JSONArray();
		String query = "";
		try {
			query = "SELECT * FROM serverdocuments ORDER BY serverDocumentsId DESC";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("serverDocumentsId", rs.getInt("serverDocumentsId"));
				jObj.put("documentNameGiven", rs.getString("documentNameGiven"));
				jObj.put("documentNameAssigned", rs.getString("documentNameAssigned"));
				jObj.put("uploadDateTime", rs.getString("uploadDateTime"));
				jsonArray.put(jObj);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	public static void uploadFamilyArchieve(JSONArray familyList, DBManager dbManager) {
		System.out.println("uploadFamilyArchieve="+familyList.toString());
		String query = "";
		int userId=0, villageId=0;
		long familyId = 0;
		try {
			for(int i = 0; i<familyList.length(); i++ ){
				JSONObject family = familyList.getJSONObject(i);
				query = "SELECT getUserIdByVillageId(getVillageIdByCode("+family.getString("villageCode")+")) AS userId,"
						+ " getVillageIdByCode("+family.getString("villageCode")+") AS villageId";
				System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next()) {
					userId = rs.getInt("userId");
					villageId = rs.getInt("villageId");
				}
				query = "SELECT * FROM family WHERE houseHoldId='"+ family.getString("houseHoldId") +"'";
				System.out.println(userId + "-" + villageId);
				if(!isDataExist(query, dbManager)) {
					familyId = getLastFamilyId(userId, villageId, dbManager) + 1;
					query = "INSERT INTO family(familyId, villageId, income, savings, userId, lastUpdated, houseHoldId, surveyPeriod)"
							+ " VALUES ("+familyId+","+villageId+","+family.getInt("income")
							+ "," + family.getInt("savings") + ","+userId+", UNIX_TIMESTAMP(),'"+family.getString("houseHoldId")
							+ "', '"+family.getString("surveyPeriod")+"')";
				}
				else {
					query = "UPDATE family set "
							+ "villageId="+villageId +","
							+ "income="+family.getInt("income")+","
									+ "savings="+family.getInt("savings")+","
											+ "userId="+userId+","
													+ "lastUpdated=UNIX_TIMESTAMP(),"
													+ "surveyPeriod='"+family.getString("surveyPeriod")+"' "
							+ " WHERE houseHoldId='"+family.getString("houseHoldId") +"'";
				}
				insertEachRowArchieve(query, dbManager);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static void uploadMemberArchieve(JSONArray memberList, DBManager dbManager) {
		System.out.println("uploadMemberArchieve="+memberList.toString());
		String query = "";
		int userId=0;;
		long familyId = 0;
		long memberId = 0;
		try {
			for(int i = 0; i<memberList.length(); i++ ){
				JSONObject member = memberList.getJSONObject(i);
				query = "SELECT getUserIdByVillageId(getVillageIdByCode("+member.getString("villageCode")+")) AS userId,"
						+ " getVillageIdByCode("+member.getString("villageCode")+") AS villageId";
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next()) {
					userId = rs.getInt("userId");
				}
				member.put("userId", userId);
				query = "SELECT * FROM member WHERE memberName='"+member.getString("memberName")+"'"
						+ " AND familyId IN (SELECT familyId FROM family WHERE houseHoldId='"+ member.getString("houseHoldId") +"')"; 
				if(!isDataExist(query, dbManager)) { 
					familyId = getMemberFamilyId(member.getString("houseHoldId"), dbManager);
					memberId = getLastMemberId(familyId, dbManager) + 1;
					member.put("memberId", memberId);
					member.put("familyId", familyId);
					query = prepareMemberInsertQuery(member, true, dbManager);
				}
				else {
					query = prepareMemberInsertQuery(member, false, dbManager);
				}
				System.out.println(query);				
				insertEachRowArchieve(query, dbManager);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static void insertEachRowArchieve(String query, DBManager dbManager) {
		System.out.println("insertEachRowArchieve="+query);
		try {
			dbManager.getSt().executeUpdate(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static boolean isDataExist(String query, DBManager dbManager) {
		System.out.println("isDataExist="+query);
		boolean flag = false;
		try {
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
				flag = true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static long getMemberFamilyId(String houseHoldId, DBManager dbManager) {
		System.out.println("getLastFamilyId="+houseHoldId);
		long familyId = 0;
		String query = "";
		try {
			query = "SELECT familyId FROM family WHERE houseHoldId='"+houseHoldId+"'";
			System.out.println(query);
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
				familyId = rs.getLong("familyId");
			System.out.println("" + familyId);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return familyId;
	}
	
	public static long getLastFamilyId(int userId, int villageId, DBManager dbManager) {
		System.out.println("getLastFamilyId="+userId+"-"+villageId);
		long familyId = 0;
		String query = "";
		try {
			query = "SELECT familyId FROM family WHERE userId="+userId
					+ " AND villageId="+villageId+" ORDER BY familyId DESC LIMIT 1";
			System.out.println(query);
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
				familyId = rs.getLong("familyId");
			System.out.println("" + familyId);
			if(familyId == 0) {
				familyId = villageId;
				System.out.println("" + familyId);
				familyId = (long) (familyId * Math.pow(10, MAX_USER));
				System.out.println("" + familyId);
				familyId += userId;
				System.out.println("" + familyId);
				familyId = (long) (familyId * Math.pow(10, MAX_FAMILY));
				System.out.println("" + familyId);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return familyId;
	}

	public static long getLastMemberId(long familyId, DBManager dbManager) {
		System.out.println("getLastMemberId="+familyId);
		long memberId = 0;
		String query = "";
		try {
			query = "SELECT memberId FROM member WHERE familyId="+familyId
					+ " ORDER BY memberId DESC LIMIT 1";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
				memberId = rs.getLong("memberId");
			if(memberId == 0) {
				memberId = familyId;
				memberId = (long) (memberId * Math.pow(10, MAX_FAMILY_MEMBER));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return memberId;
	}
	
	public static String prepareMemberInsertQuery(JSONObject member, boolean newRecord, DBManager dbManager) {
		int genderId=0, socialCategoryId=0, occupationId=0, 
				maritalStatusId=0, disabilitiesId=0, religionId=0, 
				relationshipId=0, schemeId=0, educationId=0, educationStatusId=0;
		String query="";
		System.out.println(query);
		try {
			query = "SELECT getGenderIdByCode('"+member.getString("genderCode")+"') AS genderId,"
							+ "getSocialCategoryIdByCode('"+member.getString("socialCategoryCode")+"') AS socialCategoryId,"
							+ "getOccupationIdByCode('"+member.getString("occupationCode")+"') AS occupationId,"
							+ "getMaritalStatusIdByCode('"+member.getString("maritalStatusCode")+"') AS maritalStatusId,"
							+ "getDisabilityIdByCode('"+member.getString("disabilitiesCode")+"') AS disabilitiesId,"
							+ "getReligionIdByCode('"+member.getString("religionCode")+"') AS religionId,"
							+ "getRelationshipIdByCode('"+member.getString("relationshipCode")+"') AS relationshipId,"
							+ "getSchemeIdByName('"+member.getString("schemeCode")+"') AS schemeId,"
							+ "getEducationIdByCode('"+member.getString("educationCode")+"') AS educationId,"
							+ "getEducationStatusIdByCode('"+member.getString("educationStatusCode")+"') AS educationStatusId";
			System.out.println(query);
			ResultSet rs = dbManager.getSt().executeQuery(query);
			System.out.println(query);
			while(rs.next()) {
				genderId = rs.getInt("genderId");
				socialCategoryId = rs.getInt("genderId");
				occupationId = rs.getInt("occupationId");
				maritalStatusId = rs.getInt("maritalStatusId");
				disabilitiesId = rs.getInt("disabilitiesId");
				religionId = rs.getInt("religionId");
				relationshipId = rs.getInt("relationshipId");
				schemeId = rs.getInt("schemeId");
				educationId = rs.getInt("educationId");
				educationStatusId = rs.getInt("educationStatusId");
			}
			System.out.println(query);
			if(newRecord) {
				query = "INSERT INTO member"
						+ "(memberId, familyId,memberName,dob,"
						+ "genderId,socialCategoryId,aadharCard,"
						+ "voterId,bplCard,occupationId,maritalStatusId,"
						+ "disabilitiesId,religionId,relationshipId,"
						+ "schemeId,educationId,educationStatusId,"
						+ "approvalStatus,approvalRemark,jobCard,"
						+ "userId,lastUpdated) "
						+ "VALUES("+member.getLong("memberId")+", "+member.getLong("familyId")+",'"+member.getString("memberName")+"',"
						+ "'"+member.getString("dob")+"',"+genderId+","+socialCategoryId+",'"+member.getString("aadharCard")+"',"
						+ "'"+member.getString("voterId")+"','"+member.getString("bplCard")+"',"+occupationId+","
						+ ""+maritalStatusId+","+disabilitiesId+","+religionId+","
						+ ""+relationshipId+","+schemeId+","+educationId+","
						+ ""+educationStatusId+","+member.getInt("approvalStatus")+","
						+ "'"+member.getString("approvalRemark")+"','"+member.getString("jobCard")+"', "+member.getLong("userId")+",unix_timestamp())";
			}
			else {
				query = "UPDATE member SET "
						+ "memberName='"+member.getString("memberName")+"',"
						+ "dob='"+member.getString("dob")+"',"
						+ "genderId="+genderId+","
						+ "socialCategoryId="+socialCategoryId+","
						+ "aadharCard='"+member.getString("aadharCard")+"',"
						+ "voterId='"+member.getString("voterId")+"',"
						+ "bplCard='"+member.getString("bplCard")+"',"
						+ "occupationId="+occupationId+","
						+ "maritalStatusId="+maritalStatusId+","
						+ "disabilitiesId="+disabilitiesId+","
						+ "religionId="+religionId+","
						+ "relationshipId="+relationshipId+","
						+ "schemeId="+schemeId+","
						+ "educationId="+educationId+","
						+ "educationStatusId="+educationStatusId+","
						+ "approvalStatus="+member.getInt("approvalStatus")+","
						+ "approvalRemark='"+member.getString("approvalRemark")+"',"
						+ "jobCard='"+member.getString("jobCard")+"',"
						+ "userId="+member.getLong("userId")+","
						+ "lastUpdated=unix_timestamp()"
						+ " WHERE familyId=(SELECT familyId FROM family WHERE houseHoldId='"+ member.getString("houseHoldId") +"' "
								+ "ORDER BY familyId DESC LIMIT 1)";
			}
			
			System.out.println(query);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(query);
		return query;
	}
	
	public static long getCurrentTime() {
		return new Date().getTime() / 1000;
	}

}
