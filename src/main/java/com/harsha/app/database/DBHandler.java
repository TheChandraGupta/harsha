package com.harsha.app.database;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.ws.rs.QueryParam;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.AssetDataBean;
import com.harsha.app.bean.AssetInfoBean;
import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.DisabilitiesBean;
import com.harsha.app.bean.FamilyBean;
import com.harsha.app.bean.FamilyMember;
import com.harsha.app.bean.ImpactBean;
import com.harsha.app.bean.ProjectAssignmentBean;
import com.harsha.app.bean.ProjectBean;
import com.harsha.app.bean.ProjectDataBean;
import com.harsha.app.bean.ProjectTypeBean;
import com.harsha.app.bean.QualityOfLifeBean;
import com.harsha.app.bean.RelationshipBean;
import com.harsha.app.bean.ReligionBean;
import com.harsha.app.bean.SchemeBean;
import com.harsha.app.bean.SocialCategoryBean;
import com.harsha.app.bean.DistrictBean;
import com.harsha.app.bean.EducationBean;
import com.harsha.app.bean.EducationStatusBean;
import com.harsha.app.bean.GenderBean;
import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.bean.MaritalStatusBean;
import com.harsha.app.bean.MemberBean;
import com.harsha.app.bean.MemberDataBean;
import com.harsha.app.bean.OccupationBean;
import com.harsha.app.bean.ProjectAttributeBean;
import com.harsha.app.bean.StateBean;
import com.harsha.app.bean.SupervisorAssignmentBean;
import com.harsha.app.bean.TimeStampBean;
import com.harsha.app.bean.UserViewBean;
import com.harsha.app.bean.VillageBean;

public class DBHandler {
	
	public static int testingrest(String regd, DBManager dbManager) {
	System.out.println("testingrest");
	int counter = 0;
	try {
			CallableStatement pstm = dbManager.getCon().prepareCall("call testingrest(?,?)");
			pstm.setString(1, regd);
			pstm.registerOutParameter(2, Types.INTEGER);
			pstm.executeQuery();
			counter = pstm.getInt(2);						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return counter;
	}

	
//-----------------------------------------SIGNUP START-------------------------------------------
	
	public static void signup( String userName, String lastName, String firstName , String password,
			String email, String phone, String address, String photo,int roleId, DBManager dbManager) {
	try {
			CallableStatement pstm = dbManager.getCon().prepareCall("call signup(?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, userName);
			pstm.setString(2, password);
			pstm.setInt(3, roleId);
			pstm.setString(4, firstName);
			pstm.setString(5, lastName );
			pstm.setString(6, email);
			pstm.setString(7, phone);
			pstm.setString(8, address);
			pstm.setString(9, photo);
			pstm.executeUpdate();			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
//---------------------LOGIN--------------------
	
	
	public static UserViewBean login(String username,String password,DBManager dbManager)
	{
		UserViewBean userBean = new UserViewBean();
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call login(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, username);
			pstm.setString(2, password);	
			pstm.registerOutParameter(3, Types.INTEGER);
			pstm.registerOutParameter(4, Types.INTEGER);
			pstm.registerOutParameter(5, Types.INTEGER);
			pstm.registerOutParameter(6, Types.VARCHAR);
			pstm.registerOutParameter(7, Types.VARCHAR);
			pstm.registerOutParameter(8, Types.VARCHAR);
			pstm.registerOutParameter(9, Types.VARCHAR);
			pstm.registerOutParameter(10, Types.VARCHAR);
			pstm.registerOutParameter(11, Types.VARCHAR);
			pstm.registerOutParameter(12, Types.VARCHAR);
			pstm.registerOutParameter(13, Types.VARCHAR);
			
			pstm.executeQuery();
			userBean.setUserName(username);
			userBean.setUserId(pstm.getInt(3));
			userBean.setProfileId(pstm.getInt(4));
			userBean.setRoleId(pstm.getInt(5));
			userBean.setLastActivity(pstm.getString(6));
			userBean.setFirstName(pstm.getString(7));
			userBean.setLastName(pstm.getString(8));
			userBean.setEmail(pstm.getString(9));
			userBean.setPhone(pstm.getString(10));
			userBean.setAddress(pstm.getString(11));
			userBean.setPhoto(pstm.getString(12));
			userBean.setRole(pstm.getString(13));
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return userBean;
		
	} 
	
//	------------------------ADD ASSET(ASSETINFO)-------------------------
	
	
	
	public static int addAsset(int householdDataId, String description,int assetId, DBManager dbManager)
	{
		AssetInfoBean addAssetBean = new AssetInfoBean();
		int flag=0;
		try {
			
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewAsset(?,?,?,?)");
				pstm.setInt(1, householdDataId);
				pstm.setString(2, description);
				pstm.setInt(3, assetId);
				pstm.registerOutParameter(4, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return flag;
	}
	
//-----------------------------UPDATE ASSET(ASSETINFO)---------------------
	
	
		public static int updateAsset( int assetId,int householdDataId, String description, int assetInfoId, DBManager dbManager)
		{
			AssetInfoBean updateAssetBean = new AssetInfoBean();
			int flag=0;
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateAsset(?,?,?,?,?)");
				pstm.setInt(1, assetId);
				pstm.setInt(2, householdDataId);
				pstm.setString(3, description);
				pstm.setInt(4, assetInfoId);
				pstm.registerOutParameter(5, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(5);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			
			return flag;
		
	}
		

//---------------------ADD NEW ASSET (ASSET)--------------------
		

		public static int addNewAsset( String assetName, String assetCode,
				DBManager dbManager) {
			// TODO Auto-generated method stub
			int flag = 0;
			AssetBean addNewAssetBean = new AssetBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addAsset(?,?,?)");
				pstm.setString(1, assetName);
				pstm.setString(2, assetCode);
				pstm.registerOutParameter(3, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			return flag;
		}
		
//---------------------------UPDATE NEW ASSET------------------------
		
		
		public static int updateNewAsset( int assetId,  String assetName, String assetCode, DBManager dbManager)
		{
			int flag = 0;
			AssetBean updateNewAssetBean = new AssetBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateNewAsset(?,?,?,?)");
				pstm.setInt(1, assetId);
				pstm.setString(2, assetName);
				pstm.setString(3, assetCode);
				pstm.registerOutParameter(4, Types.INTEGER);
				pstm.executeQuery();	
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			
			return flag;
		
	}
		
		
//---------------------GET ALL ASSET---------------------
		
		
		
		public static ArrayList<AssetBean> getAllAsset(DBManager dbManager)
		{
			ArrayList<AssetBean> arr = new ArrayList<AssetBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM assetview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					AssetBean getAllAssetBean = new AssetBean(rs.getInt("assetId"), rs.getString("assetCode"), rs.getString("assetName"));
					arr.add(getAllAssetBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
			
		} 
		
		
//--------------------------- GET BY ASSET ID--------------------
		
		
		public static AssetBean getByAssetId( int assetId, DBManager dbManager) {
			// TODO Auto-generated method stub
			
			AssetBean addNewAssetBean = new AssetBean();
			try {
				
				String query="SELECT * FROM assetview WHERE assetId="+assetId;
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					addNewAssetBean.setAssetCode(rs.getString("assetCode"));
					addNewAssetBean.setAssetName(rs.getString("assetName"));
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			return addNewAssetBean;
		}
		
		
//------------------------ADD PROJECT-------------------------
	
		
		public static int addProject(String projectName, String donerName, DBManager dbManager)
		{
			int flag=0;
			ProjectBean addProjectBean = new ProjectBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewProject(?,?,?)");
				
				pstm.setString(1, projectName);
				pstm.setString(2, donerName);
				pstm.registerOutParameter(3, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}			
			
			return flag;
		}
		
//-----------------------------UPDATE PROJECT----------------------------
		
		
		
		public static int updateProject(int projectId, String projectName, String donerName,
				DBManager dbManager) {
			int flag = 0;
			ProjectBean updateProjectBean = new ProjectBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateProject(?,?,?,?)");
				pstm.setInt(1, projectId);
				pstm.setString(2, donerName);
				pstm.setString(3, projectName);
				pstm.registerOutParameter(4, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(4);
				System.out.println(flag);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}			
			System.out.println(flag);
			return flag;
		}
//-----------------------------UPDATE PROJECTTYPE----------------------------
		
		
		
				public static int updateProjectType(int projectTypeId, String projectTypeName,DBManager dbManager) {
					int flag = 0;
					
					try {
						CallableStatement pstm = dbManager.getCon().prepareCall("call updateProjectType(?,?,?)");
						pstm.setInt(1, projectTypeId);
						pstm.setString(2, projectTypeName);
						
						pstm.registerOutParameter(3, Types.INTEGER);
						pstm.executeQuery();
						flag = pstm.getInt(3);
						System.out.println(flag);
					}
					
					catch(SQLException e) {
						e.printStackTrace();
					}			
					System.out.println(flag);
					return flag;
				}
//-----------------------------UPDATE PROJECT ATTRIBUTE----------------------------
				
				
				
				public static int updateProjectAttribute(int projectAttributeId,int projectTypeId, String attributeName,int displaySequence,int fixedValue,int status,DBManager dbManager) {
					int flag = 0;
					
					try {
						CallableStatement pstm = dbManager.getCon().prepareCall("call updateProjectAttribute(?,?,?,?,?,?,?)");
						pstm.setInt(1, projectAttributeId);
						pstm.setInt(2, projectTypeId);
						pstm.setString(3, attributeName);
						pstm.setInt(4, displaySequence);
						pstm.setInt(5, fixedValue);
						pstm.setInt(6, status);
						pstm.registerOutParameter(7, Types.INTEGER);
						pstm.executeQuery();
						flag = pstm.getInt(7);
						System.out.println(flag);
					}
					
					catch(SQLException e) {
						e.printStackTrace();
					}			
					System.out.println(flag);
					return flag;
				}
		
//--------------------------------GET ALL STATE-------------------------
		
		
		public static ArrayList<StateBean> getAllState(DBManager dbManager)
		{
			ArrayList<StateBean> arr = new ArrayList<StateBean>();
			int count=0;
			
			try {
				
				String query="SELECT * FROM statemasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					StateBean getAllStateBean = new StateBean(rs.getString("stateCode"), rs.getString("stateName"), rs.getInt("stateId"));
					arr.add(getAllStateBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
			
		} 
		
//--------------------------------GET BY STATE ID-----------------------------
		
		
		
		public static StateBean getByState(int stateId,DBManager dbManager)
		{
			StateBean getByStateBean = new StateBean();
			try {
				
				String query="SELECT * FROM statemasterview where stateId="+stateId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					getByStateBean.setStateName(rs.getString("stateName"));
					getByStateBean.setStateCode(rs.getString("stateCode"));
					getByStateBean.setStateId(rs.getInt("stateId"));
				}
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return getByStateBean;
			
		} 
//----------------------------GET BY FAMILY REGULAR VIEW--------------------------
		public static ArrayList<FamilyMember> getByfamilymember(long familyId, DBManager dbManager)
		{
			ArrayList<FamilyMember> arr  = new ArrayList<FamilyMember>();
			try {
				
				String query="SELECT * FROM family,member where family.familyId=member.familyId AND family.familyId="+familyId;
				System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					FamilyMember getByFamilyMember= new FamilyMember(
							String.valueOf(rs.getString("familyId")),
							String.valueOf(rs.getString("villageId")),
							String.valueOf(rs.getInt("income")),
							String.valueOf(rs.getInt("savings")),
							String.valueOf(rs.getLong("memberId")),
							String.valueOf(rs.getString("memberName")),
							String.valueOf(rs.getInt("userId")),
							String.valueOf(rs.getString("dob")),
							String.valueOf(rs.getInt("genderId")),
							String.valueOf(rs.getInt("socialCategoryId")),
							String.valueOf(rs.getString("aadharCard")),
							String.valueOf(rs.getString("voterId")),
							String.valueOf(rs.getString("bplCard")),
							String.valueOf(rs.getString("jobCard")),
							String.valueOf(rs.getInt("occupationId")),
							String.valueOf(rs.getInt("maritalStatusId")),
							String.valueOf(rs.getInt("disabilitiesId")),
							String.valueOf(rs.getInt("religionId")),
							String.valueOf(rs.getInt("relationshipId")),
							String.valueOf(rs.getInt("schemeId")),
							String.valueOf(rs.getInt("educationId")),
							String.valueOf(rs.getInt("educationStatusId")),
							String.valueOf(rs.getInt("approvalStatus")),
							String.valueOf(rs.getString("approvalRemark"))
							);
					arr.add(getByFamilyMember);
					
				}		
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
			
		} 

		//-----------------------------GET ALL PROJECT BY ID--------------------------------
		
		

		public static ProjectBean getByProjectId(int projectId,DBManager dbManager)
		{
			ProjectBean getallprojectbean = new ProjectBean();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM project where projectId="+projectId+"";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					getallprojectbean = new ProjectBean(
							
							rs.getInt("projectId"),
							rs.getString("donerName"),
							rs.getString("projectName")
							);
					
					getallprojectbean.setProjectName(rs.getString("projectName"));
					getallprojectbean.setDonerName(rs.getString("donerName"));
					getallprojectbean.setProjectId(rs.getInt("projectId"));
			
			
			//System.out.println(getAllAssetBean);
			count++;
			//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return getallprojectbean;
			
		}
//-----------------------------GET ALL PROJECT--------------------------------
		
		
		public static ArrayList<ProjectBean> getAllProject(DBManager dbManager)
		{
			ArrayList<ProjectBean> arr = new ArrayList<ProjectBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM project";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					ProjectBean getAllProjectBean = new ProjectBean(rs.getInt("projectId"),  rs.getString("projectName"),rs.getString("donerName"),rs.getInt("projectTypeId"));
					arr.add(getAllProjectBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
			
		}
		//--------------------------------ADD MEMBERDATA---------------------------
		
		
		public static int addNewAssetData(
				AssetDataBean asset,
				DBManager dbManager) {
			int flag = 0;
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall(""
						+ "call addNewFamilyAsset(?,?,?,?,?)");
				pstm.setLong(1, asset.getAssetDataId());
				pstm.setLong(2, asset.getAssetId());
				pstm.setLong(3, asset.getFamilyId()); 
				pstm.setInt(4, asset.getAssetValue());
				pstm.registerOutParameter(5, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(5);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}			
			
			return flag;
		}
		
		
		/*public static ArrayList<MemberBean> getAllMember(String userId, String lastUpdated, DBManager dbManager) {
			ArrayList<MemberBean> member = new ArrayList<MemberBean>();
			
			try {
				String query="SELECT * FROM member WHERE userId="+userId+" AND lastUpdated>"+lastUpdated;
				System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					MemberBean m= new MemberBean(
							String.valueOf(rs.getLong("memberId")),
							String.valueOf(rs.getLong("familyId")),
							String.valueOf(rs.getString("memberName")),
							String.valueOf(rs.getInt("userId")),
							String.valueOf(rs.getString("dob")),
							String.valueOf(rs.getInt("genderId")),
							String.valueOf(rs.getInt("socialCategoryId")),
							String.valueOf(rs.getString("aadharCard")),
							String.valueOf(rs.getString("voterId")),
							String.valueOf(rs.getString("bplCard")),
							String.valueOf(rs.getString("jobCard")),
							String.valueOf(rs.getInt("occupationId")),
							String.valueOf(rs.getInt("maritalStatusId")),
							String.valueOf(rs.getInt("disabilitiesId")),
							String.valueOf(rs.getInt("religionId")),
							String.valueOf(rs.getInt("relationshipId")),
							String.valueOf(rs.getInt("schemeId")),
							String.valueOf(rs.getInt("educationId")),
							String.valueOf(rs.getInt("educationStatusId")),
							String.valueOf(rs.getInt("approvalStatus")),
							String.valueOf(rs.getString("approvalRemark"))
							);
					member.add(m);
				}					
			}			
			catch(SQLException e) {
				e.printStackTrace();
			}
							
			return member;
		}
*/
//------------------------------------ADD PROJECT ASSIGNMENT---------------------------------------
		

				public static int addNewProjectAssignment(ProjectAssignmentBean project, DBManager dbManager)
					{
						int flag = 0;
						try {
							CallableStatement pstm = dbManager.getCon().prepareCall("call addProjectAssignmemt(?,?,?,?,?,?,?,?)");
							
							pstm.setLong(1,Long.parseLong(project.getProjectAssignmentId()));
							pstm.setLong(2, Long.parseLong(project.getFamilyId()));
							pstm.setInt(3, project.getProjectId()); 
							//System.out.println(project.getVillageId());
							pstm.setInt(4,project.getStatus());
							pstm.setString(5,project.getEnrollmentIn());
							pstm.setString(6,project.getEnrollmentOut());
							pstm.setInt(7,project.getImmutableAttribute());
							pstm.registerOutParameter(8, Types.INTEGER);
							pstm.executeQuery();
							flag = pstm.getInt(8);
						}
						
						catch(SQLException e) {
							e.printStackTrace();
						}	

						return flag;
					}
//------------------------------------ADD IMPACT---------------------------------------
				

				public static int addNewImpact(ImpactBean impact, DBManager dbManager)
					{
						int flag = 0;
						try {
							CallableStatement pstm = dbManager.getCon().prepareCall("call addImpact(?,?,?,?,?,?)");
							
							pstm.setInt(1, Integer.parseInt(impact.getImpactId())); 
							pstm.setLong(2,Long.parseLong(impact.getProjectAssignmentId()));
							pstm.setLong(3,Long.parseLong(impact.getProjectAttributeId()));
							pstm.setLong(4,Long.parseLong(impact.getProjectAttributeValue()));
							pstm.setLong(5,Long.parseLong(impact.getEntryDate()));
							pstm.registerOutParameter(6, Types.INTEGER);
							pstm.executeQuery();
							flag = pstm.getInt(6);
						}
						
						catch(SQLException e) {
							e.printStackTrace();
						}	

						return flag;
					}

//------------------------------------ADD Quality of life---------------------------------------
				

				public static int addNewQualityOfLife(QualityOfLifeBean quality, DBManager dbManager)
					{
						int flag = 0;
						try {
							CallableStatement pstm = dbManager.getCon().prepareCall("call addQualityOfLife(?,?,?,?,?,?,?,?)");
							
							pstm.setLong(1, quality.getFamilyId()); 
							pstm.setInt(2,quality.getTotalIncomeIncrease());
							pstm.setInt(3,quality.getIncreaseInIncome());
							pstm.setInt(4,quality.getTotalSavingsIncrease());
							pstm.setInt(5,quality.getCentralSchemeDays());
							pstm.setInt(6,quality.getAssetsAcquired());
							pstm.setString(7,quality.getRemarks());
							pstm.registerOutParameter(8, Types.INTEGER);
							pstm.executeQuery();
							flag = pstm.getInt(8);
						}
						
						catch(SQLException e) {
							e.printStackTrace();
						}	

						return flag;
					}

//------------------------------------ADD HOUSEHOLD---------------------------------------
		


		public static int addHousehold(int stateId, int districtId, int blockId, int villageid, int surveyOwnerUserId, 
				String surveyPeriod, int socialCategoryId, int religionId, String contactNo, int noOfFamilyMember,
				int occupationId, int annualHHIncome, String remarks, DBManager dbManager)
		{
			int flag = 0;
			HouseHoldBean addHouseHoldBean = new HouseHoldBean();
			try {
				String query1="select stateName FROM state Where stateId="+stateId;
				String query2="select districtName FROM district where districtId="+districtId;
				String query3="select blockName FROM block where blockId="+blockId;
				String query4="select villageName FROM village where villageId="+villageid;
				String query5="SELECT * FROM householddata;";
				
				String stateName=null;
				String districtName=null;
				String blockName=null;
				String villageName=null;
				
				String uniqueCode="";
				ResultSet rs=dbManager.getSt().executeQuery(query1);
				while(rs.next())
				stateName=rs.getString("stateName");
				System.out.println(stateName);
				for(int i=0;i<2;i++)
				{
					uniqueCode+=stateName.charAt(i);
				}
				rs=dbManager.getSt().executeQuery(query2);;
				while(rs.next())
				districtName=rs.getString("districtName");
				System.out.println(districtName);
				for(int i=0;i<2;i++)
				{
					uniqueCode+=districtName.charAt(i);
				}
				rs=dbManager.getSt().executeQuery(query3);
				while(rs.next())
				blockName=rs.getString("blockName");
				System.out.println(blockName);
				for(int i=0;i<2;i++)
				{
					uniqueCode+=blockName.charAt(i);
				}
				rs=dbManager.getSt().executeQuery(query4);
				while(rs.next())
				villageName=rs.getString("villageName");
				System.out.println(villageName);
				for(int i=0;i<2;i++)
				{
					uniqueCode+=villageName.charAt(i);
				}
				rs=dbManager.getSt().executeQuery(query5);
				System.out.println(rs);
				int count=0;
				while(rs.next())
				{
					
					count=rs.getInt(1);
					System.out.println(count);
				}
							
				uniqueCode=uniqueCode+count;
				System.out.println("UNIQUE CODE="+uniqueCode);
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewHouseHold(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pstm.setInt(1, stateId);
				pstm.setInt(2, districtId);
				pstm.setInt(3,blockId); 
				pstm.setInt(4, villageid); 
				System.out.println(villageid);
				pstm.setInt(5, surveyOwnerUserId);
				pstm.setString(6, surveyPeriod);
				pstm.setInt(7, socialCategoryId); 
				pstm.setInt(8, religionId);
				pstm.setString(9, contactNo);
				pstm.setInt(10, noOfFamilyMember);
				pstm.setInt(11, occupationId);
				pstm.setInt(12, annualHHIncome);
				pstm.setString(13, remarks);
				pstm.setString(14, uniqueCode);
				pstm.registerOutParameter(15, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(15);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}	

			return flag;
		}

		
//------------------------------------ADD FAMILY DATA---------------------------------------
		

		public static int addFamily(FamilyBean family, DBManager dbManager)
			{
				int flag = 0;
				try {
					CallableStatement pstm = dbManager.getCon().prepareCall("call addNewFamily(?,?,?,?,?,?)");
					
					pstm.setLong(1, Long.parseLong(family.getFamilyId()));
					pstm.setInt(2, Integer.parseInt(family.getVillageId())); 
					System.out.println(family.getVillageId());
					pstm.setInt(3,Integer.parseInt(family.getIncome()));
					pstm.setInt(4,Integer.parseInt(family.getSavings()));
					pstm.setInt(5,Integer.parseInt(family.getUserId()));
					pstm.registerOutParameter(6, Types.INTEGER);
					pstm.executeQuery();
					flag = pstm.getInt(6);
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}	

				return flag;
			}
//-----------------GET BY ALL FAMILY----------------------
		
				public static ArrayList<FamilyBean> getAllFamily(DBManager dbManager) {
					ArrayList<FamilyBean> arr = new ArrayList<FamilyBean>();
					int count=0;
					
					try {
						
					// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
						
						String query="SELECT * FROM familyregularview";
						//System.out.println(query);
						ResultSet rs = dbManager.getSt().executeQuery(query);
						while(rs.next())
						{
							FamilyBean getAllFamilyBean = new FamilyBean(rs.getString("familyId"),rs.getString("villageId"),""+rs.getInt("income"),""+rs.getInt("savings"));
							arr.add(getAllFamilyBean);
							//System.out.println(getAllAssetBean);
							count++;
							//System.out.println(count);
						}			
					}
					
					catch(SQLException e) {
						e.printStackTrace();
					}
					return arr;
				}
				
				//--------------------------------ADD MEMBERDATA---------------------------
						
						
						public static int addMemberDataService(int houseHoldDataId, int stateId, int districtId, int blockId,
								int villageId, String name, String gender, int relationshipId, String dob, int age, int maritalStatusId,
								int educationId, int educationStatusId, String aadharCard, String electionCard, String addressPermanent,
								String pincodePermanent, String addressCurrent, String pincodeCurrent, int disabilityId, int schemeId,
								int incomeAnnual, String emailId, String mobileNumber, String alternateNumberWith, int occupationId,
								DBManager dbManager) {
							int flag = 0;
							MemberDataBean addMemberDataBean = new MemberDataBean();
							try {
								
								CallableStatement pstm = dbManager.getCon().prepareCall("call addNewHouseHoldMemberData(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
								pstm.setInt(1, houseHoldDataId);
								pstm.setInt(2, stateId);
								pstm.setInt(3, districtId);
								pstm.setInt(4,blockId);	
								pstm.setInt(5, villageId); 
								pstm.setString(6,name);
								pstm.setString(7, gender);
								pstm.setInt(8, relationshipId);
								System.out.println(relationshipId);
								pstm.setString(9,dob);
								pstm.setInt(10, age);
								pstm.setInt(11, maritalStatusId);
								pstm.setInt(12, educationId);
								pstm.setInt(13,educationStatusId);
								pstm.setString(14, aadharCard);
								pstm.setString(15,electionCard); 
								pstm.setString(16, addressPermanent); 
								pstm.setString(17, pincodePermanent); 
								pstm.setString(18, addressCurrent);
								pstm.setString(19,pincodeCurrent);
								pstm.setInt(20, disabilityId); 
								pstm.setInt(21, schemeId); 
								pstm.setInt(22, incomeAnnual); 
								pstm.setString(23, emailId);
								pstm.setString(24, mobileNumber);
								pstm.setString(25, alternateNumberWith);
								pstm.setInt(26, occupationId); 
								pstm.registerOutParameter(27, Types.INTEGER);
								pstm.executeQuery();
								flag = pstm.getInt(27);
							}
							
							catch(SQLException e) {
								e.printStackTrace();
							}			
							
							return flag;
						}		
			
			//--------------------------------ADD MEMBERDATA---------------------------
			
			
			public static int addNewMember(
					MemberBean memberBean,
					DBManager dbManager) {
				int flag = 0;
				try {
					
					CallableStatement pstm = dbManager.getCon().prepareCall(""
							+ "call addNewMember(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstm.setLong(1, Long.parseLong(memberBean.getMemberId()));
					pstm.setLong(2, Long.parseLong(memberBean.getFamilyId())); 
					pstm.setString(3, memberBean.getName());
					pstm.setString(4, memberBean.getDob()); 
					pstm.setInt(5, Integer.parseInt(memberBean.getGenderId()));
					pstm.setInt(6, Integer.parseInt(memberBean.getSocialCategoryId())); 
					pstm.setString(7, memberBean.getAadhaarCardId());
					pstm.setString(8, memberBean.getVoterId()); 
					pstm.setString(9, memberBean.getBplCard());
					pstm.setInt(10, Integer.parseInt(memberBean.getOccupationId())); 
					pstm.setInt(11, Integer.parseInt(memberBean.getMaritalStatusId()));
					pstm.setInt(12, Integer.parseInt(memberBean.getDisabilityId())); 
					pstm.setInt(13, Integer.parseInt(memberBean.getReligionId()));
					pstm.setInt(14, Integer.parseInt(memberBean.getRelationshipId())); 
					pstm.setInt(15, Integer.parseInt(memberBean.getSchemeId()));
					pstm.setInt(16, Integer.parseInt(memberBean.getEducationId())); 
					pstm.setInt(17, Integer.parseInt(memberBean.getEducationStatusId()));
					pstm.setInt(18, Integer.parseInt(memberBean.getUserId())); 
					pstm.setInt(19, Integer.parseInt(memberBean.getApprovalStatus()));
					pstm.setString(20, memberBean.getApprovalRemark()); 
					pstm.setString(21, memberBean.getJobCard()); 
					pstm.registerOutParameter(22, Types.INTEGER);
					pstm.executeQuery();
					flag = pstm.getInt(22);
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}			
				
				return flag;
			}

			public static ArrayList<MemberBean> getAllMember(String userId, String lastUpdated, DBManager dbManager) {
				ArrayList<MemberBean> member = new ArrayList<MemberBean>();
				
				try {
					String query = "SELECT * FROM member "
							+ "WHERE lastUpdated>"+lastUpdated+" AND familyId IN ("
							+ "SELECT familyId FROM family "
							+ "WHERE villageId IN ("
							+ "SELECT villageId FROM village "
							+ "WHERE userId="+userId+"))";
					System.out.println(query);
					ResultSet rs = dbManager.getSt().executeQuery(query);
					while(rs.next())
					{
						MemberBean m= new MemberBean(
								String.valueOf(rs.getLong("memberId")),
								String.valueOf(rs.getLong("familyId")),
								String.valueOf(rs.getString("memberName")),
								String.valueOf(rs.getInt("userId")),
								String.valueOf(rs.getString("dob")),
								String.valueOf(rs.getInt("genderId")),
								String.valueOf(rs.getInt("socialCategoryId")),
								String.valueOf(rs.getString("aadharCard")),
								String.valueOf(rs.getString("voterId")),
								String.valueOf(rs.getString("bplCard")),
								String.valueOf(rs.getString("jobCard")),
								String.valueOf(rs.getInt("occupationId")),
								String.valueOf(rs.getInt("maritalStatusId")),
								String.valueOf(rs.getInt("disabilitiesId")),
								String.valueOf(rs.getInt("religionId")),
								String.valueOf(rs.getInt("relationshipId")),
								String.valueOf(rs.getInt("schemeId")),
								String.valueOf(rs.getInt("educationId")),
								String.valueOf(rs.getInt("educationStatusId")),
								String.valueOf(rs.getInt("approvalStatus")),
								String.valueOf(rs.getString("approvalRemark"))
								);
						member.add(m);
					}					
				}			
				catch(SQLException e) {
					e.printStackTrace();
				}
								
				return member;
			}

			public static ArrayList<FamilyBean> getAllFamily(String userId, String lastUpdated, DBManager dbManager) {
				ArrayList<FamilyBean> family = new ArrayList<FamilyBean>();
				
				try {
					
					String query="SELECT * FROM family "
							+ "WHERE lastUpdated>"+lastUpdated+" AND villageId IN ("
							+ "SELECT villageId FROM village "
							+ "WHERE userId="+userId+")";
					System.out.println(query);
					ResultSet rs = dbManager.getSt().executeQuery(query);
					while(rs.next())
					{
						FamilyBean f = new FamilyBean(
								String.valueOf(rs.getLong("familyId")),
								String.valueOf(rs.getInt("villageId")),
								String.valueOf(rs.getInt("income")),
								String.valueOf(rs.getInt("savings"))
								);
						family.add(f);
					}
				}			
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				return family;
			}
			
			//-----------------------------------------GET ALL PROJECT ASSIGNMENT-------------------------------------------------
			// Get all Project assignment of family using User Id to fetch the family id
			public static ArrayList<ProjectAssignmentBean> getAllProjectAssignment(String userId, String lastUpdated, DBManager dbManager) {
				ArrayList<ProjectAssignmentBean> project = new ArrayList<ProjectAssignmentBean>();
				
				try {
					
					String query= "SELECT * FROM projectassignment "
							+ "WHERE lastUpdated>"+lastUpdated+" AND familyId IN ("
							+ "SELECT familyId FROM family "
							+ "WHERE villageId In ("
							+ "SELECT villageId FROM village "
							+ "WHERE userId="+userId+"))";
					System.out.println(query);
					ResultSet rs = dbManager.getSt().executeQuery(query);
					while(rs.next())
					{
						ProjectAssignmentBean p = new ProjectAssignmentBean();
						p.setProjectAssignmentId(String.valueOf(rs.getLong("projectAssignmentId")));
						p.setFamilyId(String.valueOf(rs.getLong("familyId")));
						p.setProjectId(rs.getInt("projectId"));
						p.setStatus(rs.getInt("status"));
						p.setEnrollmentIn(rs.getString("enrollmentIn"));
						p.setEnrollmentOut(rs.getString("enrollmentOut"));
						p.setLastUpdated(String.valueOf(rs.getLong("lastUpdated")));
						p.setImmutableAttribute(rs.getInt("immutableAttribute"));
						project.add(p);
					}
				}			
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				return project;
			}


//-------------------------------------ADD STATE---------------------------------------
		
		
		public static int addState(String stateName, String stateCode, DBManager dbManager) {
			// TODO Auto-generated method stub
			int flag=0;
			StateBean addStateBean=new StateBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewState(?,?,?)");
				
				pstm.setString(1, stateName);
				pstm.setString(2, stateCode);
				pstm.registerOutParameter(3, Types.INTEGER);
				pstm.executeQuery();
				flag = pstm.getInt(3);
				//System.out.println("Flag="+flag);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}			
			
			return flag;
		}

//------------------------------------- UPDATE STATE------------------------------------
		
		
		public static int updateState(String stateName, String stateCode, int stateId, DBManager dbManager) {
			int flag=0;
			
			try {
							CallableStatement pstm = dbManager.getCon().prepareCall("call updateState(?,?,?,?)");
							
							pstm.setString(1, stateName);
							pstm.setString(2, stateCode);
							pstm.setInt(3, stateId);
							pstm.registerOutParameter(4, Types.INTEGER);
							pstm.executeQuery();
							flag = pstm.getInt(4);
							
						}
						
						catch(SQLException e) {
							e.printStackTrace();
						}			
						
						return flag;
					}

//--------------------------------------ADD DISTRICT-----------------------------------
		
		
		public static int addDistrict(String districtName, String districtCode, int stateId, DBManager dbManager) {
			int flag=0;
			DistrictBean addDistrictBean = new DistrictBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewDistrict(?,?,?,?)");
				pstm.setString(1, districtName);
				pstm.setString(2, districtCode);
				pstm.setInt(3, stateId);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
			
		}

		
//------------------------------UPDATE DISTRICT----------------------------------------

		public static int updateDistrict(int districtId, String districtCode, String districtName, int stateId,
				DBManager dbManager) {
			int flag=0;
			DistrictBean updateDistrictBean=new DistrictBean();
			try {
							//System.out.println("SI = "+stateId);
							CallableStatement pstm = dbManager.getCon().prepareCall("call updateDistrict(?,?,?,?,?)");
							pstm.setInt(1, districtId);
							pstm.setString(2, districtCode);
							pstm.setString(3, districtName);
							pstm.setInt(4, stateId);
							pstm.registerOutParameter(5, Types.INTEGER);
							pstm.executeQuery();
							flag=pstm.getInt(5);
						}
						
						catch(SQLException e) {
							e.printStackTrace();
						}			
						
						return flag;
		}

//-------------------------GET ALL DISTRICT------------------------------
		
		
		public static ArrayList<DistrictBean> getAllDistrict(DBManager dbManager) {
			ArrayList<DistrictBean> arr = new ArrayList<DistrictBean>();
			int count=0;
			
			try {
				
				String query="SELECT * FROM districtmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					DistrictBean getAllDistrictBean = new DistrictBean(rs.getInt("districtId"),rs.getString("districtCode"), rs.getString("districtName"), rs.getInt("stateId"));
					getAllDistrictBean.setStateName(rs.getString("stateName"));
					getAllDistrictBean.setStateCode(rs.getString("stateCode"));
					arr.add(getAllDistrictBean);
					count++;
				}
			}			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}


//------------------------------ADD BLOCK---------------------------------------
		
		
		public static int addBlock(String blockName, String blockCode, int districtId, DBManager dbManager) {
			int flag = 0;
			BlockBean addBlockBean = new BlockBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewBlock(?,?,?,?)");
				pstm.setString(1, blockCode);
				pstm.setString(2, blockName);
				pstm.setInt(3, districtId);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//-------------------------UPDATE BLOCK--------------------------

		public static int updateBlock(int blockId, String blockCode, String blockName, int districtId,
				DBManager dbManager) {
			int flag=0;
			BlockBean updateBlockBean = new BlockBean();
			try {
				
				System.out.println("BI="+blockId+" BC="+blockCode+" BN="+blockName+" DI="+districtId);
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateBlock(?,?,?,?,?)");
				pstm.setInt(1, blockId);
				pstm.setString(2, blockCode);
				pstm.setString(3, blockName);
				pstm.setInt(4, districtId);
				pstm.registerOutParameter(5, Types.INTEGER);				
				pstm.executeQuery();
				flag = pstm.getInt(5);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

//-------------------------------ADD VILLAGE---------------------------------------
		
		
		public static int addVillage(String villageName, String villageCode, int blockId, DBManager dbManager) {
			int flag = 0;
			VillageBean addVillageBean = new VillageBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewVillage(?,?,?,?)");
				pstm.setString(1, villageCode);
				pstm.setString(2, villageName);
				pstm.setInt(3, blockId);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}


//-----------------------UPDATE VILLAGE--------------------------------
		
		
		public static int updateVillage(int villageId, String villageCode, String villageName, int blockId,
				DBManager dbManager) {
			int flag =0;
			
			try {
				
				System.out.println("VN="+villageName+" VC = "+villageCode+
					 	" BI="+blockId+" VI="+villageId);
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateVillage(?,?,?,?,?)");
				pstm.setInt(1, villageId);
				pstm.setString(2, villageCode);
				pstm.setString(3, villageName);
				pstm.setInt(4, blockId);
				pstm.registerOutParameter(5, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(5);
				flag = dbManager.getSt().executeUpdate("");
				if (flag > 0)
					flag=1;
				System.out.println("Flag : "+flag);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		//-----------------------UPDATE VILLAGE--------------------------------
		
		
		public static int updatesVillage(int villageId, String villageCode, String villageName,
				DBManager dbManager) {
			int flag =0;
			
			try {
				
				//System.out.println("VI "+villageId+" VC "+villageCode+" VN "+villageName);
				String query = "update village set villageName='"+villageName+"',villageCode='"+villageCode+"' where villageId="+villageId+" ";           
			    
				//System.out.println("QUERY="+query);
				
				flag = dbManager.getSt().executeUpdate(query);
				if (flag > 0)
					flag=1;
				else
					flag=0;
				System.out.println("FLAG = "+flag);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		
//-----------------GET BY ALL HOUSEHOLD----------------------
		
		public static ArrayList<HouseHoldBean> getAllHousehold(DBManager dbManager) {
			ArrayList<HouseHoldBean> arr = new ArrayList<HouseHoldBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM householdmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					HouseHoldBean getAllHouseholdBean = new HouseHoldBean(rs.getInt("stateId"), rs.getString("stateName"),rs.getString("stateCode"), 
							rs.getInt("districtId"),rs.getString("districtname"),rs.getString("districtCode"),rs.getInt("blockId"),rs.getString("blockName"),
							rs.getString("blockCode"),rs.getInt("villageid"),rs.getString("villageName"),rs.getString("villageCode"),rs.getInt("surveyOwnerUserId"),
							rs.getString("surveyOwnerUserName"), rs.getString("surveyOwnerName"),rs.getString("surveyPeriod"), rs.getInt("socialCategoryId"),
							rs.getString("socialCategoryName"), rs.getInt("religionId"), rs.getString("religionName"),rs.getString("contactNo"),
							rs.getInt("noOfFamilyMember"), rs.getInt("occupationId"), rs.getString("occupationName"), rs.getInt("annualHHIncome"),
							rs.getString("remarks"),rs.getInt("householdDataId"), rs.getString("statusCode"),rs.getString("uniqueHHId"));
					arr.add(getAllHouseholdBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
//--------------------------GET HOUSEHOLD BY ID-------------------------------
		
		
		public static HouseHoldBean getByHouseholdId(int householdDataId, DBManager dbManager) {
			HouseHoldBean householdBean = new HouseHoldBean();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM householdmasterview where householdDataId="+householdDataId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					 householdBean = new HouseHoldBean(rs.getInt("stateId"), rs.getString("stateName"),rs.getString("stateCode"), 
							rs.getInt("districtId"),rs.getString("districtname"),rs.getString("districtCode"),rs.getInt("blockId"),rs.getString("blockName"),
							rs.getString("blockCode"),rs.getInt("villageid"),rs.getString("villageName"),rs.getString("villageCode"),rs.getInt("surveyOwnerUserId"),
							rs.getString("surveyOwnerUserName"), rs.getString("surveyOwnerName"),rs.getString("surveyPeriod"), rs.getInt("socialCategoryId"),
							rs.getString("socialCategoryName"), rs.getInt("religionId"), rs.getString("religionName"),rs.getString("contactNo"),
							rs.getInt("noOfFamilyMember"), rs.getInt("occupationId"), rs.getString("occupationName"), rs.getInt("annualHHIncome"),
							rs.getString("remarks"),rs.getInt("householdDataId"), rs.getString("statusCode"),rs.getString("uniqueHHId"));
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return householdBean;
		}
	
		
//------------------------------GET ALL MEMBERDATA----------------------------

		public static ArrayList<MemberDataBean> getAllMemberData(DBManager dbManager) {
			ArrayList<MemberDataBean> arr = new ArrayList<MemberDataBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM memberinfomasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					MemberDataBean member = new MemberDataBean();
					member.setHouseHoldDataId(rs.getInt("householddataId"));
					member.setStateId(rs.getInt("stateId"));
					member.setStateName(rs.getString("stateName"));
					member.setStateCode(rs.getString("stateCode"));
					member.setDistrictId(rs.getInt("districtId"));
					member.setDistrictCode( rs.getString("districtCode"));
					member.setDistrictName(rs.getString("districtName"));
					member.setBlockId(rs.getInt("blockId"));
					member.setBlockCode(rs.getString("blockCode"));
					member.setBlockName( rs.getString("blockName"));
					member.setVillageId(rs.getInt("villageId"));
					member.setVillageName(rs.getString("villageName")); 
					member.setVillageCode(rs.getString("villageCode"));
					member.setMembername(rs.getString("membername"));
					member.setGender(rs.getString("gender"));
					member.setRelationshipId(rs.getInt("relationshipId"));
					member.setRelationshipName(rs.getString("relationshipName"));
					member.setDob(rs.getString("dob"));
					member.setAge(rs.getInt("age"));
					member.setMaritalStatusId(rs.getInt("maritalStatusId"));
					member.setMaritalStatusName(rs.getString("maritalStatusname"));
					member.setEducationId(rs.getInt("educationId"));
					member.setEducationName(rs.getString("educationName"));
					member.setEducationStatusId(rs.getInt("educationStatusId"));
					member.setEducationStatusName(rs.getString("educationStatusName"));
					member.setAadharCard(rs.getString("aadharCard"));
					member.setElectionCard(rs.getString("electionCard"));
					member.setAddressPermanent(rs.getString("addressPermanent"));
					member.setPincodePermanent(rs.getString("pincodePermanent"));
					member.setAddressCurrent(rs.getString("addressCurrent"));
					member.setPincodeCurrent(rs.getString("pincodeCurrent"));
					member.setDisabilityId(rs.getInt("disabilityId"));
					member.setDisabilityName(rs.getString("disabilityName"));
					member.setSchemeId(rs.getInt("schemeId"));
					member.setSchemeName(rs.getString("schemeName"));
					member.setIncomeAnnual(rs.getInt("incomeAnnual"));  
					member.setEmailId(rs.getString("emailId"));
					member.setMobileNumber(rs.getString("mobileNumber"));
					member.setAlternateNumberWith(rs.getString("alternateNumberWith"));
					member.setOccupationId(rs.getInt("occupationId"));
					member.setOccupationName(rs.getString("occupationName"));
					member.setMemberDataId(rs.getInt("memberDataId"));
					MemberDataBean getAllMemberDataBean = new MemberDataBean(rs.getInt("houseHoldDataId"), rs.getInt("stateId"),
							 rs.getString("stateCode"),rs.getString("stateName"), rs.getInt("districtId"),
							rs.getString("districtName"), rs.getString("districtCode"), rs.getInt("blockId"), rs.getString("blockName"),  rs.getString("blockCode"),rs.getInt("villageId"),
							rs.getString("villageName"),  rs.getString("villageCode"), rs.getString("membername"), rs.getString("gender"),rs.getInt("relationshipId"),
							rs.getString("relationshipName"), rs.getString("dob"),rs.getInt("age"), rs.getInt("maritalStatusId"), rs.getString("maritalStatusname"),
							rs.getInt("educationId"),  rs.getString("educationName"),rs.getInt("educationStatusId"),  rs.getString("educationStatusName"),  rs.getString("aadharCard"),
							rs.getString("electionCard"), rs.getString("addressPermanent"), rs.getString("pincodePermanent"), rs.getString("addressCurrent"),
							rs.getString("pincodeCurrent"),rs.getInt("disabilityId"),  rs.getString("disabilityName"), rs.getInt("schemeId"),  rs.getString("schemeName"),
							rs.getInt("incomeAnnual"),  rs.getString("emailId"), rs.getString("mobileNumber"), rs.getString("alternateNumberWith"),rs.getInt("occupationId"),
							rs.getString("occupationName"),rs.getInt("memberDataId"),rs.getString("statusCode"));
					arr.add(member);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
		
//--------------------------------GET MEMBERDATA BY ID-------------------------------
		
		
		public static MemberDataBean getByMemberDataId(int memberdataId, DBManager dbManager) {
			MemberDataBean member = new MemberDataBean();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM memberinfomasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					member = new MemberDataBean();
					member.setHouseHoldDataId(rs.getInt("householddataId"));
					member.setStateId(rs.getInt("stateId"));
					member.setStateName(rs.getString("stateName"));
					member.setStateCode(rs.getString("stateCode"));
					member.setDistrictId(rs.getInt("districtId"));
					member.setDistrictCode( rs.getString("districtCode"));
					member.setDistrictName(rs.getString("districtName"));
					member.setBlockId(rs.getInt("blockId"));
					member.setBlockCode(rs.getString("blockCode"));
					member.setBlockName( rs.getString("blockName"));
					member.setVillageId(rs.getInt("villageId"));
					member.setVillageName(rs.getString("villageName")); 
					member.setVillageCode(rs.getString("villageCode"));
					member.setMembername(rs.getString("membername"));
					member.setGender(rs.getString("gender"));
					member.setRelationshipId(rs.getInt("relationshipId"));
					member.setRelationshipName(rs.getString("relationshipName"));
					member.setDob(rs.getString("dob"));
					member.setAge(rs.getInt("age"));
					member.setMaritalStatusId(rs.getInt("maritalStatusId"));
					member.setMaritalStatusName(rs.getString("maritalStatusname"));
					member.setEducationId(rs.getInt("educationId"));
					member.setEducationName(rs.getString("educationName"));
					member.setEducationStatusId(rs.getInt("educationStatusId"));
					member.setEducationStatusName(rs.getString("educationStatusName"));
					member.setAadharCard(rs.getString("aadharCard"));
					member.setElectionCard(rs.getString("electionCard"));
					member.setAddressPermanent(rs.getString("addressPermanent"));
					member.setPincodePermanent(rs.getString("pincodePermanent"));
					member.setAddressCurrent(rs.getString("addressCurrent"));
					member.setPincodeCurrent(rs.getString("pincodeCurrent"));
					member.setDisabilityId(rs.getInt("disabilityId"));
					member.setDisabilityName(rs.getString("disabilityName"));
					member.setSchemeId(rs.getInt("schemeId"));
					member.setSchemeName(rs.getString("schemeName"));
					member.setIncomeAnnual(rs.getInt("incomeAnnual"));  
					member.setEmailId(rs.getString("emailId"));
					member.setMobileNumber(rs.getString("mobileNumber"));
					member.setAlternateNumberWith(rs.getString("alternateNumberWith"));
					member.setOccupationId(rs.getInt("occupationId"));
					member.setOccupationName(rs.getString("occupationName"));
					member.setMemberDataId(rs.getInt("memberDataId"));
					MemberDataBean getAllMemberDataBean = new MemberDataBean(rs.getInt("houseHoldDataId"), rs.getInt("stateId"),
							 rs.getString("stateCode"),rs.getString("stateName"), rs.getInt("districtId"),
							rs.getString("districtName"), rs.getString("districtCode"), rs.getInt("blockId"), rs.getString("blockName"),  rs.getString("blockCode"),rs.getInt("villageId"),
							rs.getString("villageName"),  rs.getString("villageCode"), rs.getString("membername"), rs.getString("gender"),rs.getInt("relationshipId"),
							rs.getString("relationshipName"), rs.getString("dob"),rs.getInt("age"), rs.getInt("maritalStatusId"), rs.getString("maritalStatusname"),
							rs.getInt("educationId"),  rs.getString("educationName"),rs.getInt("educationStatusId"),  rs.getString("educationStatusName"),  rs.getString("aadharCard"),
							rs.getString("electionCard"), rs.getString("addressPermanent"), rs.getString("pincodePermanent"), rs.getString("addressCurrent"),
							rs.getString("pincodeCurrent"),rs.getInt("disabilityId"),  rs.getString("disabilityName"), rs.getInt("schemeId"),  rs.getString("schemeName"),
							rs.getInt("incomeAnnual"),  rs.getString("emailId"), rs.getString("mobileNumber"), rs.getString("alternateNumberWith"),rs.getInt("occupationId"),
							rs.getString("occupationName"),rs.getInt("memberDataId"),rs.getString("statusCode"));
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return member;
		}
		
//-----------------------------GET BY VILLAGE HOUSEHOLD-----------------------------

		public static ArrayList<HouseHoldBean> getByVillageHousehold(int villageid, DBManager dbManager) {


			ArrayList<HouseHoldBean> arr = new ArrayList<HouseHoldBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM householdmasterview where villageid="+villageid;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					HouseHoldBean getAllHouseholdBean = new HouseHoldBean(rs.getInt("stateId"), rs.getString("stateName"),rs.getString("stateCode"), 
							rs.getInt("districtId"),rs.getString("districtname"),rs.getString("districtCode"),rs.getInt("blockId"),rs.getString("blockName"),
							rs.getString("blockCode"),rs.getInt("villageid"),rs.getString("villageName"),rs.getString("villageCode"),rs.getInt("surveyOwnerUserId"),
							rs.getString("surveyOwnerUserName"), rs.getString("surveyOwnerName"),rs.getString("surveyPeriod"), rs.getInt("socialCategoryId"),
							rs.getString("socialCategoryName"), rs.getInt("religionId"), rs.getString("religionName"),rs.getString("contactNo"),
							rs.getInt("noOfFamilyMember"), rs.getInt("occupationId"), rs.getString("occupationName"), rs.getInt("annualHHIncome"),
							rs.getString("remarks"),rs.getInt("householdDataId"), rs.getString("statusCode"),rs.getString("uniqueHHId"));
					arr.add(getAllHouseholdBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
//---------------------Family Member Bean---------------
		public static ArrayList<FamilyMember> getAllFamilyMember(int managerId, DBManager dbManager) {
			//public static ArrayList<MemberBean> getAllMember(DBManager dbManager) {
				ArrayList<FamilyMember> familyMember = new ArrayList<FamilyMember>();
				String query = "";
				if(managerId == 0)
					query="SELECT * FROM family,member where family.familyId=member.familyId AND relationshipId=1";
				else
					query="SELECT * FROM family,member where family.familyId=member.familyId AND relationshipId=1 AND "
							+ "family.villageId IN (SELECT villageId FROM village WHERE userId IN (SELECT userId FROM "
							+ "user WHERE managerId="+managerId+"))";
				try {
					
					//TODO commented by irfan
					//String query="SELECT * FROM member";
					System.out.println(query);
					ResultSet rs = dbManager.getSt().executeQuery(query);
					while(rs.next())
					{
						FamilyMember m= new FamilyMember(
								String.valueOf(rs.getString("familyId")),
								String.valueOf(rs.getString("villageId")),
								String.valueOf(rs.getInt("income")),
								String.valueOf(rs.getInt("savings")),
								String.valueOf(rs.getLong("memberId")),
								String.valueOf(rs.getString("memberName")),
								String.valueOf(rs.getInt("userId")),
								String.valueOf(rs.getString("dob")),
								String.valueOf(rs.getInt("genderId")),
								String.valueOf(rs.getInt("socialCategoryId")),
								String.valueOf(rs.getString("aadharCard")),
								String.valueOf(rs.getString("voterId")),
								String.valueOf(rs.getString("bplCard")),
								String.valueOf(rs.getString("jobCard")),
								String.valueOf(rs.getInt("occupationId")),
								String.valueOf(rs.getInt("maritalStatusId")),
								String.valueOf(rs.getInt("disabilitiesId")),
								String.valueOf(rs.getInt("religionId")),
								String.valueOf(rs.getInt("relationshipId")),
								String.valueOf(rs.getInt("schemeId")),
								String.valueOf(rs.getInt("educationId")),
								String.valueOf(rs.getInt("educationStatusId")),
								String.valueOf(rs.getInt("approvalStatus")),
								String.valueOf(rs.getString("approvalRemark"))
								
								);
						familyMember.add(m);
					}					
				}			
				catch(SQLException e) {
					e.printStackTrace();
				}
								
				return familyMember;
			}

		/*public static ArrayList<FamilyMember> getAllFamilyMemberForManager(DBManager dbManager) {
			//public static ArrayList<MemberBean> getAllMember(DBManager dbManager) {
				ArrayList<FamilyMember> familyMember = new ArrayList<FamilyMember>();
				
				try {
					String query="SELECT * FROM family,member where family.familyId=member.familyId AND relationshipId=1";
					//TODO commented by irfan
					//String query="SELECT * FROM member";
					System.out.println(query);
					ResultSet rs = dbManager.getSt().executeQuery(query);
					while(rs.next())
					{
						FamilyMember m= new FamilyMember(
								String.valueOf(rs.getString("familyId")),
								String.valueOf(rs.getString("villageId")),
								String.valueOf(rs.getInt("income")),
								String.valueOf(rs.getInt("savings")),
								String.valueOf(rs.getLong("memberId")),
								String.valueOf(rs.getString("memberName")),
								String.valueOf(rs.getInt("userId")),
								String.valueOf(rs.getString("dob")),
								String.valueOf(rs.getInt("genderId")),
								String.valueOf(rs.getInt("socialCategoryId")),
								String.valueOf(rs.getString("aadharCard")),
								String.valueOf(rs.getString("voterId")),
								String.valueOf(rs.getString("bplCard")),
								String.valueOf(rs.getString("jobCard")),
								String.valueOf(rs.getInt("occupationId")),
								String.valueOf(rs.getInt("maritalStatusId")),
								String.valueOf(rs.getInt("disabilitiesId")),
								String.valueOf(rs.getInt("religionId")),
								String.valueOf(rs.getInt("relationshipId")),
								String.valueOf(rs.getInt("schemeId")),
								String.valueOf(rs.getInt("educationId")),
								String.valueOf(rs.getInt("educationStatusId")),
								String.valueOf(rs.getInt("approvalStatus")),
								String.valueOf(rs.getString("approvalRemark"))
								
								);
						familyMember.add(m);
					}					
				}			
				catch(SQLException e) {
					e.printStackTrace();
				}
								
				return familyMember;
			}*/


//---------------------------------GET BY BLOCK HOUSEHOLD---------------------------
		
		
		public static ArrayList<HouseHoldBean> getByBlockHousehold(int blockId, DBManager dbManager) {

			ArrayList<HouseHoldBean> arr = new ArrayList<HouseHoldBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM householdmasterview where blockId="+blockId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					HouseHoldBean getAllHouseholdBean = new HouseHoldBean(rs.getInt("stateId"), rs.getString("stateName"),rs.getString("stateCode"), 
							rs.getInt("districtId"),rs.getString("districtname"),rs.getString("districtCode"),rs.getInt("blockId"),rs.getString("blockName"),
							rs.getString("blockCode"),rs.getInt("villageid"),rs.getString("villageName"),rs.getString("villageCode"),rs.getInt("surveyOwnerUserId"),
							rs.getString("surveyOwnerUserName"), rs.getString("surveyOwnerName"),rs.getString("surveyPeriod"), rs.getInt("socialCategoryId"),
							rs.getString("socialCategoryName"), rs.getInt("religionId"), rs.getString("religionName"),rs.getString("contactNo"),
							rs.getInt("noOfFamilyMember"), rs.getInt("occupationId"), rs.getString("occupationName"), rs.getInt("annualHHIncome"),
							rs.getString("remarks"),rs.getInt("householdDataId"), rs.getString("statusCode"), rs.getString("uniqueHHId"));
					arr.add(getAllHouseholdBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
		
//----------------------GET BY DISTRICT HOUSEHOLD--------------------------

		public static ArrayList<HouseHoldBean> getByDistrictHousehold(int districtId, DBManager dbManager) {
			ArrayList<HouseHoldBean> arr = new ArrayList<HouseHoldBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM householdmasterview where districtId="+districtId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					HouseHoldBean getAllHouseholdBean = new HouseHoldBean(rs.getInt("stateId"), rs.getString("stateName"),rs.getString("stateCode"), 
							rs.getInt("districtId"),rs.getString("districtname"),rs.getString("districtCode"),rs.getInt("blockId"),rs.getString("blockName"),
							rs.getString("blockCode"),rs.getInt("villageid"),rs.getString("villageName"),rs.getString("villageCode"),rs.getInt("surveyOwnerUserId"),
							rs.getString("surveyOwnerUserName"), rs.getString("surveyOwnerName"),rs.getString("surveyPeriod"), rs.getInt("socialCategoryId"),
							rs.getString("socialCategoryName"), rs.getInt("religionId"), rs.getString("religionName"),rs.getString("contactNo"),
							rs.getInt("noOfFamilyMember"), rs.getInt("occupationId"), rs.getString("occupationName"), rs.getInt("annualHHIncome"),
							rs.getString("remarks"),rs.getInt("householdDataId"), rs.getString("statusCode"), rs.getString("uniqueHHId"));
					arr.add(getAllHouseholdBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//-------------------------------GET BY VILLAGE MEMBERDATA----------------------------
		
		
		public static ArrayList<MemberDataBean> getByVillageMemberData(int villageId, DBManager dbManager){
			ArrayList<MemberDataBean> arr = new ArrayList<MemberDataBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM memberinfomasterview where villageId="+villageId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					MemberDataBean getAllMemberDataBean = new MemberDataBean(rs.getInt("houseHoldDataId"), rs.getInt("stateId"),
							rs.getString("stateName"), rs.getString("stateCode"), rs.getInt("districtId"),
							rs.getString("districtName"), rs.getString("districtCode"), rs.getInt("blockId"), 
							rs.getString("blockName"),  rs.getString("blockCode"),rs.getInt("villageId"),
							rs.getString("villageName"),  rs.getString("villageCode"), rs.getString("membername"), 
							rs.getString("gender"),rs.getInt("relationshipId"),	rs.getString("relationshipName"),
							rs.getString("dob"),rs.getInt("age"), rs.getInt("maritalStatusId"), rs.getString("maritalStatusName"),
							rs.getInt("educationId"),  rs.getString("educationName"),rs.getInt("educationStatusId"),  
							rs.getString("educationStatusName"),  rs.getString("aadharCard"),rs.getString("electionCard"),
							rs.getString("addressPermanent"), rs.getString("pincodePermanent"), rs.getString("addressCurrent"),
							rs.getString("pincodeCurrent"),rs.getInt("disabilityId"),  rs.getString("disabilityName"), 
							rs.getInt("schemeId"),  rs.getString("schemeName"),	rs.getInt("incomeAnnual"),  rs.getString("emailId"),
							rs.getString("mobileNumber"), rs.getString("alternateNumberWith"),rs.getInt("occupationId"),
							rs.getString("occupationName"),rs.getInt("memberDataId"),rs.getString("statusCode"));
					arr.add(getAllMemberDataBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		


//-----------------------ADD OCCUPATION-------------------------
		
		
		public static int addOccupation(String occupationName, int occupationCode, DBManager dbManager) {
			int flag = 0;
			OccupationBean addOccupationBean = new OccupationBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewOccupation(?,?,?)");
				pstm.setInt(1, occupationCode);
				pstm.setString(2, occupationName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag=pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
		
//---------------------UPDATE OCCUPATION-------------------------
		
		
		public static int updateOccupation(int occupationId, int occupationCode, String occupationName, DBManager dbManager) {
			int flag = 0;
			OccupationBean updateOccupationBean = new OccupationBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateOccupation(?,?,?,?)");
				pstm.setInt(1, occupationId);
				pstm.setInt(2, occupationCode);
				pstm.setString(3, occupationName);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}


//------------------------------GET ALL OCCUPATION----------------------------
		
		
		public static ArrayList<OccupationBean> getAllOccupation(DBManager dbManager) {
			ArrayList<OccupationBean> arr = new ArrayList<OccupationBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM occupationmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					OccupationBean getAllOccupationBean = new OccupationBean(rs.getString("occupationName"), rs.getString("occupationCode"), rs.getInt("occupationId"));
					arr.add(getAllOccupationBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
//------------------------------------ADD SOCIAL CATEGORY-----------------------------

		public static int addSocialCategory(String socialCategoryName, int socialCategoryCode,
				DBManager dbManager) {
			int flag=0;
			SocialCategoryBean addSocialCategoryBean = new SocialCategoryBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewSocialCategory(?,?,?)");
				pstm.setInt(1, socialCategoryCode);
				pstm.setString(2, socialCategoryName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//-----------------------------UPDATE SOCIAL CATEGORY------------------------------
		
		
		public static int updateSocialCategory(int socialCategoryId, String socialCategoryCode,
				String socialCategoryName, DBManager dbManager) {
			int flag = 0;
			//SocialCategoryBean updateSocialCategoryBean = new SocialCategoryBean();
			try {
				System.out.println(socialCategoryCode);
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateSocialCategory(?,?,?,?)");
				pstm.setInt(1, socialCategoryId);
				pstm.setString(2,socialCategoryCode);
				pstm.setString(3, socialCategoryName);
				System.out.println(socialCategoryCode);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
		
//----------------------------GET ALL SOCIAL CATEGORY------------------------
		
		
		public static ArrayList<SocialCategoryBean> getAllSocialCategory(DBManager dbManager) {
			ArrayList<SocialCategoryBean> arr = new ArrayList<SocialCategoryBean>();
			int count=0;
			
			try {
				String query="SELECT * FROM socialcategorymasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					SocialCategoryBean getAllSocialCategoryBean = new SocialCategoryBean(rs.getString("socialCategoryCode"), rs.getString("socialCategoryName"), rs.getInt("socialCategoryId"));
					arr.add(getAllSocialCategoryBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
		
//-----------------------ADD RELATIONSHIP-------------------------------------
		

		public static int addRelationship(String relationshipName, int relationshipCode,
				DBManager dbManager) {
			int flag = 0;
			RelationshipBean addRelationshipBean = new RelationshipBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewRelationship(?,?,?)");
				pstm.setInt(1, relationshipCode);
				pstm.setString(2, relationshipName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag= pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
//-----------------------UPDATE RELATIONSHIP---------------------------
		
		

		public static int updateRelationship(int relationshipId, int relationshipCode,
				String relationshipName, DBManager dbManager) {
			int flag = 0;
			RelationshipBean updateRelationshipBean = new RelationshipBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateRelationship(?,?,?,?)");
				pstm.setInt(1, relationshipId);
				pstm.setInt(2, relationshipCode);
				pstm.setString(3, relationshipName);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		

//-------------------------GET ALL RELATIONSHIP--------------------------------
		
		

		public static ArrayList<RelationshipBean> getAllRelationship(DBManager dbManager) {
			ArrayList<RelationshipBean> arr = new ArrayList<RelationshipBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM relationshipmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					RelationshipBean getAllRelationshipBean = new RelationshipBean(rs.getString("relationshipName"), 
							rs.getString("relationshipCode"), rs.getInt("relationshipId"));
					arr.add(getAllRelationshipBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;

		}

		
//-----------------------------ADD DISABILITIES-------------------------
		
		
		public static int addDisabilities(String disabilityName, int disabilityCode,
				DBManager dbManager) {
			int flag = 0;
			DisabilitiesBean addDisabilitiesBean = new DisabilitiesBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewDisabilities(?,?,?)");
				pstm.setInt(1, disabilityCode);
				pstm.setString(2, disabilityName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
			
		}

		
//------------------------------UPDATE DISABILITIES-------------------------------
		
		
		public static int updateDisabilities(int disabilityId, int disabilityCode,
				String disabilityName, DBManager dbManager) {
			int flag = 0;
			DisabilitiesBean updateDisabilitiesBean = new DisabilitiesBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateDisabilities(?,?,?,?)");
				pstm.setInt(1, disabilityId);
				pstm.setInt(2, disabilityCode);
				pstm.setString(3, disabilityName);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		

//----------------------------GET ALL DISABILITIES-------------------------
		

		public static ArrayList<DisabilitiesBean> getAllDisabilities(DBManager dbManager) {

			ArrayList<DisabilitiesBean> arr = new ArrayList<DisabilitiesBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM disabilitiesmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					DisabilitiesBean getAllDisabilitiesBean = new DisabilitiesBean(rs.getString("disabilityCode"), 
							rs.getString("disabilityName"), rs.getInt("disabilityId"));
					arr.add(getAllDisabilitiesBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
			
		}

		
//--------------------------ADD EDUCATION----------------------------
		
		
		public static int addEducation(String educationName, int educationCode, DBManager dbManager) {

			int flag = 0;
			EducationBean addEducationBean = new EducationBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewEducation(?,?,?)");
				pstm.setInt(1, educationCode);
				pstm.setString(2, educationName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//---------------------------UPDATE EDUCATION--------------------
		
		
		public static int updateEducation(int educationId, int educationCode, String educationName,
				DBManager dbManager) {

			int flag = 0;
			EducationBean updateEducationBean = new EducationBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateEducation(?,?,?,?)");
				pstm.setInt(1, educationId);
				pstm.setInt(2, educationCode);
				pstm.setString(3, educationName);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
//-------------------------GET ALL EDUCATION-----------------------
		

		public static ArrayList<EducationBean> getAllEducation(DBManager dbManager) {


			ArrayList<EducationBean> arr = new ArrayList<EducationBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM educationmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					EducationBean getAllEducationBean = new EducationBean(rs.getString("educationName"), 
							rs.getInt("educationCode"), rs.getInt("educationId"));
					arr.add(getAllEducationBean);
					System.out.println(getAllEducationBean);
					count++;
					//System.out.println(count);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
		
//------------------------ADD EDUCATION STATUS---------------------------
		
		
		public static int addEducationStatus(String educationStatusName, int educationStatusCode,
				DBManager dbManager) {
			int flag = 0;
			EducationStatusBean addEducationStatusBean = new EducationStatusBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewEducationStatus(?,?,?)");
				pstm.setInt(1, educationStatusCode);
				System.out.println(educationStatusCode);
				pstm.setString(2, educationStatusName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		public static int updateEducationStatus(int educationStatusId, int educationStatusCode,
				String educationStatusName, DBManager dbManager) {

			int flag=0;
			EducationStatusBean updateEducationStatusBean = new EducationStatusBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateEducationStatus(?,?,?,?)");
				pstm.setInt(1, educationStatusId);
				pstm.setInt(2, educationStatusCode);
				pstm.setString(3, educationStatusName);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		public static ArrayList<EducationStatusBean> getAllEducationStatus(DBManager dbManager) {


			ArrayList<EducationStatusBean> arr = new ArrayList<EducationStatusBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM educationstatusmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					EducationStatusBean getAllEducationStatusBean = new EducationStatusBean(rs.getString("educationStatusName"), 
							rs.getString("educationStatusCode"), rs.getInt("educationStatusId"));
					arr.add(getAllEducationStatusBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//------------------------------ADD RELIGION--------------------------
		
		
		public static int addReligion(String religionName, int religionCode, DBManager dbManager) {

			int flag = 0;
			ReligionBean addReligionBean = new ReligionBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewReligion(?,?,?)");
				pstm.setInt(1, religionCode);
				pstm.setString(2, religionName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
//------------------------------UPDATE RELIGION--------------------------------
		

		public static int updateReligion(int religionId, int religionCode, String religionName,
				DBManager dbManager) {
			int flag = 0;
			ReligionBean updateReligionBean = new ReligionBean();
			try {
				//System.out.println("ReligionId="+religionId+" ReligionCode="+religionCode+" ReligionName="+religionName);
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateReligion(?,?,?,?)");
				pstm.setInt(1, religionId);
				pstm.setInt(2, religionCode);
				pstm.setString(3, religionName);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		public static ArrayList<ReligionBean> getAllReligion(DBManager dbManager) {
			
			ArrayList<ReligionBean> arr = new ArrayList<ReligionBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM religionmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					ReligionBean getAllReligionBean = new ReligionBean(rs.getString("religionName"), 
							rs.getString("religionCode"), rs.getInt("religionId"));
					arr.add(getAllReligionBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//------------------------------ADD SCHEME--------------------------
		
		
		public static int addScheme(String schemeName, DBManager dbManager) {
			int flag = 0;
			SchemeBean addSchemeBean = new SchemeBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewScheme(?,?)");
				pstm.setString(1, schemeName);
				pstm.registerOutParameter(2, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(2);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//------------------------------------UPDATE SCHEME------------------------------
		
		
		public static int updateScheme(int schemeId, String schemeName, DBManager dbManager) {
			int flag = 0;
			SchemeBean updateSchemeBean = new SchemeBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateScheme(?,?,?)");
				pstm.setInt(1, schemeId);
				pstm.setString(2, schemeName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//-----------------------------GET ALL SCHEME-----------------------------
		
		
		public static ArrayList<SchemeBean> getAllScheme(DBManager dbManager) {
			
			ArrayList<SchemeBean> arr = new ArrayList<SchemeBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM schememasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					SchemeBean getAllSchemeBean = new SchemeBean(rs.getString("schemeName"),rs.getInt("schemeId"));
					arr.add(getAllSchemeBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
		
//----------------------------------ADD MARITAL STATUS-------------------------------------
		

		public static int addMaritalStatus( int maritalStatusCode,String maritalStatusName,
				DBManager dbManager) {

			int flag = 0;
			MaritalStatusBean addMaritalStatusBean = new MaritalStatusBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewMaritalStatus(?,?,?)");
				pstm.setInt(1, maritalStatusCode);
				pstm.setString(2, maritalStatusName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//---------------------------------UPDATE MARITAL STATUS--------------------------------
		
		
		public static int updateMaritalStatus(int maritalStatusId, int maritalStatusCode,
				String maritalStatusName, DBManager dbManager) {
			int flag = 0;
			MaritalStatusBean updateMaritalStatusBean = new MaritalStatusBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call updateMaritalStatus(?,?,?,?)");
				pstm.setInt(1, maritalStatusId);
				pstm.setInt(2, maritalStatusCode);
				pstm.setString(3, maritalStatusName);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
//---------------------------------GET ALL MARITAL STATUS-----------------------------------

		public static ArrayList<MaritalStatusBean> getAllMaritalStatus(DBManager dbManager) {


			ArrayList<MaritalStatusBean> arr = new ArrayList<MaritalStatusBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM maritalstatusmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					MaritalStatusBean getAllMaritalStatusBean = new MaritalStatusBean(rs.getString("maritalStatusName"), 
							rs.getString("maritalStatusCode"), rs.getInt("maritalStatusId"));
					arr.add(getAllMaritalStatusBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

	
//------------------------------GET ALL BLOCK----------------------------
		
		
		public static ArrayList<BlockBean> getAllBlock(DBManager dbManager) {
			ArrayList<BlockBean> arr = new ArrayList<BlockBean>();
			int count=0;
			
			try {
				
				String query="SELECT * FROM blockmasterview";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					BlockBean getAllBlockBean = new BlockBean(rs.getInt("districtId"),rs.getString("blockName"), rs.getString("blockCode"), rs.getInt("blockId"));
					getAllBlockBean.setDistrictName(rs.getString("districtName"));
					getAllBlockBean.setDistrictCode(rs.getString("districtCode"));
					getAllBlockBean.setStateName(rs.getString("stateName"));
					getAllBlockBean.setStateCode(rs.getString("stateCode"));
					arr.add(getAllBlockBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//---------------------------GET BLOCK BY DISTRICT ID-----------------------------------
		
		
		public static ArrayList<BlockBean> getByDistrictIdBlock(int districtId, DBManager dbManager) {
			ArrayList<BlockBean> arr = new ArrayList<BlockBean>();
			int count=0;
			
			try {
				
				String query="SELECT * FROM blockmasterview where districtId="+districtId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					BlockBean getAllBlockBean = new BlockBean(rs.getInt("districtId"),rs.getString("blockName"), rs.getString("blockCode"), rs.getInt("blockId"));
					getAllBlockBean.setDistrictName(rs.getString("districtName"));
					getAllBlockBean.setDistrictCode(rs.getString("districtCode"));
					getAllBlockBean.setStateName(rs.getString("stateName"));
					getAllBlockBean.setStateCode(rs.getString("stateCode"));
					arr.add(getAllBlockBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//------------------------------GET BLOCK BY BLOCK ID------------------------
		
		
		public static BlockBean getByBlockIdBlock(int blockId, DBManager dbManager) {
			BlockBean getAllBlockBean = new BlockBean();
			int count=0;
			
			try {
				
				String query="SELECT * FROM blockmasterview where blockId="+blockId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					getAllBlockBean = new BlockBean(rs.getInt("districtId"),rs.getString("blockName"), rs.getString("blockCode"), rs.getInt("blockId"));
					getAllBlockBean.setDistrictName(rs.getString("districtName"));
					getAllBlockBean.setDistrictCode(rs.getString("districtCode"));
					getAllBlockBean.setStateName(rs.getString("stateName"));
					getAllBlockBean.setStateCode(rs.getString("stateCode"));
					getAllBlockBean.setBlockId(rs.getInt("blockId"));
					getAllBlockBean.setDistrictId(rs.getInt("districtId"));
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return getAllBlockBean;
		}

		
//---------------------------------GET DISTRICT BY DISTRICT ID--------------------------
		
		
		public static DistrictBean getByDistrictId(int districtId, DBManager dbManager) {
			DistrictBean getAllDistrictBean = new DistrictBean();
			int count=0;
			
			try {
				
				String query="SELECT * FROM districtmasterview where districtId="+districtId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					getAllDistrictBean = new DistrictBean(rs.getInt("districtId"),rs.getString("districtName"), rs.getString("districtCode"), rs.getString("stateName"),rs.getInt("stateId"));
					getAllDistrictBean.setStateId(rs.getInt("stateId"));
					getAllDistrictBean.setStateName(rs.getString("stateName"));
					getAllDistrictBean.setDistrictId(rs.getInt("districtId"));
					getAllDistrictBean.setDistrictName(rs.getString("districtName"));
					getAllDistrictBean.setDistrictCode(rs.getString("districtCode"));
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return getAllDistrictBean;
		}
		
		
//--------------------------GET DISTRICT BY STATE ID-----------------------------------

		public static ArrayList<DistrictBean> getByStateId(int stateId, DBManager dbManager) {
			ArrayList<DistrictBean> arr = new ArrayList<DistrictBean>();
			int count=0;
			
			try {
				
				String query="SELECT * FROM districtmasterview where stateId="+stateId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					DistrictBean getAllDistrictBean = new DistrictBean(rs.getInt("districtId"), rs.getString("districtCode"), rs.getString("districtName"), rs.getInt("stateId"));
					getAllDistrictBean.setStateName(rs.getString("stateName"));
					getAllDistrictBean.setStateCode(rs.getString("stateCode"));
					arr.add(getAllDistrictBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//----------------------------------GET ALL VILLAGE-------------------------------
		
		
		public static ArrayList<VillageBean> getAllVillage(int managerId, DBManager dbManager) {

			String query = "";
			ArrayList<VillageBean> arr = new ArrayList<VillageBean>();
			
			if(managerId == 0) 
				query = "SELECT * FROM villagemasterview";
			else 
				query = "SELECT * FROM villagemasterview WHERE userId IN (SELECT userId FROM user WHERE managerId="+managerId+")";
			
			try {
				
				
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					VillageBean getAllVillageBean = new VillageBean(rs.getInt("villageId"),rs.getInt("blockId"), rs.getString("villageCode"), rs.getString("villageName"));
					getAllVillageBean.setVillageName(rs.getString("villageName"));
					getAllVillageBean.setVillageCode(rs.getString("villageCode"));
					getAllVillageBean.setBlockName(rs.getString("blockName"));
					getAllVillageBean.setBlockCode(rs.getString("blockCode"));
					getAllVillageBean.setDistrictName(rs.getString("districtName"));
					getAllVillageBean.setDistrictCode(rs.getString("districtCode"));
					getAllVillageBean.setStateName(rs.getString("stateName"));
					getAllVillageBean.setStateCode(rs.getString("stateCode"));
					getAllVillageBean.setUserId(rs.getInt("userId"));
					arr.add(getAllVillageBean);
					//System.out.println(getAllAssetBean);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
		
//--------------------------------------GET VILLAGE BY VILLAGE ID-----------------------------------------
		
		

		public static VillageBean getByVillageId(int villageId, DBManager dbManager) {
			VillageBean getAllVillageBean = new VillageBean();
			int count=0;
			
			try {
				
				String query="SELECT * FROM villagemasterview where villageId="+villageId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					getAllVillageBean = new VillageBean(rs.getInt("blockId"),rs.getInt("villageId"), rs.getString("villageCode"), rs.getString("villageName"));
					getAllVillageBean.setVillageName(rs.getString("villageName"));
					getAllVillageBean.setVillageCode(rs.getString("villageCode"));
					getAllVillageBean.setBlockName(rs.getString("blockName"));
					getAllVillageBean.setBlockCode(rs.getString("blockCode"));
					getAllVillageBean.setDistrictName(rs.getString("districtName"));
					getAllVillageBean.setDistrictCode(rs.getString("districtCode"));
					getAllVillageBean.setStateName(rs.getString("stateName"));
					getAllVillageBean.setStateCode(rs.getString("stateCode"));
					getAllVillageBean.setVillageId(rs.getInt("villageId"));
					
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return getAllVillageBean;
		}

		
//---------------------------------GET VILLAGE BY BLOCKID------------------------------------
		
		
		public static ArrayList<VillageBean> getByBlockId(int blockId, DBManager dbManager) {
			ArrayList<VillageBean> arr = new ArrayList<VillageBean>();
			int count=0;
			
			try {
				
				String query="SELECT * FROM villagemasterview where blockId="+blockId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					VillageBean getAllVillageBean = new VillageBean();
					getAllVillageBean.setVillageName(rs.getString("villageName"));
					getAllVillageBean.setVillageCode(rs.getString("villageCode"));
					getAllVillageBean.setVillageId(rs.getInt("villageId"));
					getAllVillageBean.setBlockName(rs.getString("blockName"));
					getAllVillageBean.setBlockCode(rs.getString("blockCode"));
					getAllVillageBean.setDistrictName(rs.getString("districtName"));
					getAllVillageBean.setDistrictCode(rs.getString("districtCode"));
					getAllVillageBean.setStateName(rs.getString("stateName"));
					getAllVillageBean.setStateCode(rs.getString("stateCode"));
					arr.add(getAllVillageBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		

//-------------------------------GET MEMBERDATA BY BLOCKID----------------------------------------

		public static ArrayList<MemberDataBean> getByBlockMemberData(int blockId, DBManager dbManager) {
			ArrayList<MemberDataBean> arr = new ArrayList<MemberDataBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM memberinfomasterview where blockId="+blockId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					MemberDataBean member = new MemberDataBean();
					member.setHouseHoldDataId(rs.getInt("householddataId"));
					member.setStateId(rs.getInt("stateId"));
					member.setStateName(rs.getString("stateName"));
					member.setStateCode(rs.getString("stateCode"));
					member.setDistrictId(rs.getInt("districtId"));
					member.setDistrictCode( rs.getString("districtCode"));
					member.setDistrictName(rs.getString("districtName"));
					member.setBlockId(rs.getInt("blockId"));
					member.setBlockCode(rs.getString("blockCode"));
					member.setBlockName( rs.getString("blockName"));
					member.setVillageId(rs.getInt("villageId"));
					member.setVillageName(rs.getString("villageName")); 
					member.setVillageCode(rs.getString("villageCode"));
					member.setMembername(rs.getString("membername"));
					member.setGender(rs.getString("gender"));
					member.setRelationshipId(rs.getInt("relationshipId"));
					member.setRelationshipName(rs.getString("relationshipName"));
					member.setDob(rs.getString("dob"));
					member.setAge(rs.getInt("age"));
					member.setMaritalStatusId(rs.getInt("maritalStatusId"));
					member.setMaritalStatusName(rs.getString("maritalStatusname"));
					member.setEducationId(rs.getInt("educationId"));
					member.setEducationName(rs.getString("educationName"));
					member.setEducationStatusId(rs.getInt("educationStatusId"));
					member.setEducationStatusName(rs.getString("educationStatusName"));
					member.setAadharCard(rs.getString("aadharCard"));
					member.setElectionCard(rs.getString("electionCard"));
					member.setAddressPermanent(rs.getString("addressPermanent"));
					member.setPincodePermanent(rs.getString("pincodePermanent"));
					member.setAddressCurrent(rs.getString("addressCurrent"));
					member.setPincodeCurrent(rs.getString("pincodeCurrent"));
					member.setDisabilityId(rs.getInt("disabilityId"));
					member.setDisabilityName(rs.getString("disabilityName"));
					member.setSchemeId(rs.getInt("schemeId"));
					member.setSchemeName(rs.getString("schemeName"));
					member.setIncomeAnnual(rs.getInt("incomeAnnual"));  
					member.setEmailId(rs.getString("emailId"));
					member.setMobileNumber(rs.getString("mobileNumber"));
					member.setAlternateNumberWith(rs.getString("alternateNumberWith"));
					member.setOccupationId(rs.getInt("occupationId"));
					member.setOccupationName(rs.getString("occupationName"));
					member.setMemberDataId(rs.getInt("memberDataId"));
					arr.add(member);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
		
//---------------------------------------GET MEMBERDATA BY DISTRICTID---------------------------------------
		

		public static ArrayList<MemberDataBean> getByDistrictMemberData(int districtId, DBManager dbManager) {
			ArrayList<MemberDataBean> arr = new ArrayList<MemberDataBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM memberinfomasterview where districtId="+districtId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					MemberDataBean member = new MemberDataBean();
					member.setHouseHoldDataId(rs.getInt("householddataId"));
					member.setStateId(rs.getInt("stateId"));
					member.setStateName(rs.getString("stateName"));
					member.setStateCode(rs.getString("stateCode"));
					member.setDistrictId(rs.getInt("districtId"));
					member.setDistrictCode( rs.getString("districtCode"));
					member.setDistrictName(rs.getString("districtName"));
					member.setBlockId(rs.getInt("blockId"));
					member.setBlockCode(rs.getString("blockCode"));
					member.setBlockName( rs.getString("blockName"));
					member.setVillageId(rs.getInt("villageId"));
					member.setVillageName(rs.getString("villageName")); 
					member.setVillageCode(rs.getString("villageCode"));
					member.setMembername(rs.getString("membername"));
					member.setGender(rs.getString("gender"));
					member.setRelationshipId(rs.getInt("relationshipId"));
					member.setRelationshipName(rs.getString("relationshipName"));
					member.setDob(rs.getString("dob"));
					member.setAge(rs.getInt("age"));
					member.setMaritalStatusId(rs.getInt("maritalStatusId"));
					member.setMaritalStatusName(rs.getString("maritalStatusname"));
					member.setEducationId(rs.getInt("educationId"));
					member.setEducationName(rs.getString("educationName"));
					member.setEducationStatusId(rs.getInt("educationStatusId"));
					member.setEducationStatusName(rs.getString("educationStatusName"));
					member.setAadharCard(rs.getString("aadharCard"));
					member.setElectionCard(rs.getString("electionCard"));
					member.setAddressPermanent(rs.getString("addressPermanent"));
					member.setPincodePermanent(rs.getString("pincodePermanent"));
					member.setAddressCurrent(rs.getString("addressCurrent"));
					member.setPincodeCurrent(rs.getString("pincodeCurrent"));
					member.setDisabilityId(rs.getInt("disabilityId"));
					member.setDisabilityName(rs.getString("disabilityName"));
					member.setSchemeId(rs.getInt("schemeId"));
					member.setSchemeName(rs.getString("schemeName"));
					member.setIncomeAnnual(rs.getInt("incomeAnnual"));  
					member.setEmailId(rs.getString("emailId"));
					member.setMobileNumber(rs.getString("mobileNumber"));
					member.setAlternateNumberWith(rs.getString("alternateNumberWith"));
					member.setOccupationId(rs.getInt("occupationId"));
					member.setOccupationName(rs.getString("occupationName"));
					member.setMemberDataId(rs.getInt("memberDataId"));
					arr.add(member);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

	
//------------------------------------GET MEMBERDATA BY STATE ID-----------------------------------
		
		
		public static ArrayList<MemberDataBean> getByStateMemberData(int stateId, DBManager dbManager) {
			ArrayList<MemberDataBean> arr = new ArrayList<MemberDataBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM memberinfomasterview where stateId="+stateId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					MemberDataBean member = new MemberDataBean();
					member.setHouseHoldDataId(rs.getInt("householddataId"));
					member.setStateId(rs.getInt("stateId"));
					member.setStateName(rs.getString("stateName"));
					member.setStateCode(rs.getString("stateCode"));
					member.setDistrictId(rs.getInt("districtId"));
					member.setDistrictCode( rs.getString("districtCode"));
					member.setDistrictName(rs.getString("districtName"));
					member.setBlockId(rs.getInt("blockId"));
					member.setBlockCode(rs.getString("blockCode"));
					member.setBlockName( rs.getString("blockName"));
					member.setVillageId(rs.getInt("villageId"));
					member.setVillageName(rs.getString("villageName")); 
					member.setVillageCode(rs.getString("villageCode"));
					member.setMembername(rs.getString("membername"));
					member.setGender(rs.getString("gender"));
					member.setRelationshipId(rs.getInt("relationshipId"));
					member.setRelationshipName(rs.getString("relationshipName"));
					member.setDob(rs.getString("dob"));
					member.setAge(rs.getInt("age"));
					member.setMaritalStatusId(rs.getInt("maritalStatusId"));
					member.setMaritalStatusName(rs.getString("maritalStatusname"));
					member.setEducationId(rs.getInt("educationId"));
					member.setEducationName(rs.getString("educationName"));
					member.setEducationStatusId(rs.getInt("educationStatusId"));
					member.setEducationStatusName(rs.getString("educationStatusName"));
					member.setAadharCard(rs.getString("aadharCard"));
					member.setElectionCard(rs.getString("electionCard"));
					member.setAddressPermanent(rs.getString("addressPermanent"));
					member.setPincodePermanent(rs.getString("pincodePermanent"));
					member.setAddressCurrent(rs.getString("addressCurrent"));
					member.setPincodeCurrent(rs.getString("pincodeCurrent"));
					member.setDisabilityId(rs.getInt("disabilityId"));
					member.setDisabilityName(rs.getString("disabilityName"));
					member.setSchemeId(rs.getInt("schemeId"));
					member.setSchemeName(rs.getString("schemeName"));
					member.setIncomeAnnual(rs.getInt("incomeAnnual"));  
					member.setEmailId(rs.getString("emailId"));
					member.setMobileNumber(rs.getString("mobileNumber"));
					member.setAlternateNumberWith(rs.getString("alternateNumberWith"));
					member.setOccupationId(rs.getInt("occupationId"));
					member.setOccupationName(rs.getString("occupationName"));
					member.setMemberDataId(rs.getInt("memberDataId"));
					arr.add(member);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//---------------------------CHECK USERNAME-----------------------------
		
		
		public static UserViewBean checkUsername(String username, DBManager dbManager) {
			UserViewBean userBean = new UserViewBean();
			try {
								
				String query="SELECT * FROM usermasterview where userName='"+username+"'";
				System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					userBean.setUserName(rs.getString("userName"));
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return userBean;
		}


//----------------------------GET HOUSEHOLD BY STATE------------------------------
		
		
		public static ArrayList<HouseHoldBean> getByStateHousehold(int stateId, DBManager dbManager) {
			ArrayList<HouseHoldBean> arr = new ArrayList<HouseHoldBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM householdmasterview where stateId="+stateId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					HouseHoldBean getAllHouseholdBean = new HouseHoldBean(rs.getInt("stateId"), rs.getString("stateName"),rs.getString("stateCode"), 
							rs.getInt("districtId"),rs.getString("districtname"),rs.getString("districtCode"),rs.getInt("blockId"),rs.getString("blockName"),
							rs.getString("blockCode"),rs.getInt("villageid"),rs.getString("villageName"),rs.getString("villageCode"),rs.getInt("surveyOwnerUserId"),
							rs.getString("surveyOwnerUserName"), rs.getString("surveyOwnerName"),rs.getString("surveyPeriod"), rs.getInt("socialCategoryId"),
							rs.getString("socialCategoryName"), rs.getInt("religionId"), rs.getString("religionName"),rs.getString("contactNo"),
							rs.getInt("noOfFamilyMember"), rs.getInt("occupationId"), rs.getString("occupationName"), rs.getInt("annualHHIncome"),
							rs.getString("remarks"),rs.getInt("householdDataId"),rs.getString("statusCode"),rs.getString("uniqueHHId"));
					arr.add(getAllHouseholdBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}			
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}

		
//-------------------------ENABLE USER---------------------------
		

		public static int enableUser(int userId, DBManager dbManager) {
			int flag = 0;
			UserViewBean enableUserViewBean = new UserViewBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call enableUser(?,?)");
				pstm.setInt(1, userId);
				pstm.registerOutParameter(2, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(2);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}


		public static int disableUser(int userId, DBManager dbManager) {
			int flag =0;
			UserViewBean enableUserViewBean = new UserViewBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call disableUser(?,?)");
				pstm.setInt(1, userId);
				pstm.registerOutParameter(2, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(2);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//----------------------------------CHANGE PASSWORD-------------------------
		

		public static int changePassword(int userId, String oldPassword, String newPassword,
				DBManager dbManager) {
			int flag = 0;
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call changepassword(?,?,?,?)");
				pstm.setInt(1, userId);
				pstm.setString(2, oldPassword);
				pstm.setString(3, newPassword);
				pstm.registerOutParameter(4, Types.INTEGER);
				
				pstm.executeQuery();
				
				flag = pstm.getInt(4);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}


		public static UserViewBean forgetPassword(String username, DBManager dbManager) {
			UserViewBean userBean = new UserViewBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call forgetpassword(?,?,?,?)");
				pstm.setString(1, username);
				pstm.registerOutParameter(2, Types.VARCHAR);
				pstm.registerOutParameter(3, Types.VARCHAR);
				pstm.registerOutParameter(4, Types.INTEGER);
				pstm.executeQuery();
				userBean.setUserName(username);
				userBean.setEmail(pstm.getString(2));
				userBean.setPassword(pstm.getString(3));
				userBean.setUserId(pstm.getInt(4));
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return userBean;
		}


		public static int verificationHousehold(int householddataId, String statusCode, DBManager dbManager) {
			int flag = 0;
			HouseHoldBean updateHouseHoldBean = new HouseHoldBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call verification(?,?,?)");
				pstm.setInt(1, householddataId);
				pstm.setString(2, statusCode);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
		
//------------------------------VERIFICATION MEMBER----------------------------
		
		
		public static int verificationMember(int memberdataId, String statusCode, DBManager dbManager) {
			int flag = 0;
			MemberDataBean updateMemberDataBean = new MemberDataBean();
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call verificationmember(?,?,?)");
				pstm.setInt(1, memberdataId);
				pstm.setString(2, statusCode);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
//-----------------------------ANALYSIS HOME DATA---------------------------------
		
		public static int displayStaff(DBManager dbManager)
		{
			int count=1;
			try
			{
				String query="Select count(*) as counter FROM usermasterview WHERE roleName='SUPERVISOR' OR roleName='MANAGER'";
				ResultSet rs = dbManager.getSt().executeQuery(query);
				
				while(rs.next())
				{
					count = rs.getInt("counter");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
			
		}
		
		public static int displayVillages(DBManager dbManager)
		{
			int count=1;
			try
			{
				String query="Select count(*) as counter FROM village";
				ResultSet rs = dbManager.getSt().executeQuery(query);
				
				while(rs.next())
				{
					count = rs.getInt("counter");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;			
		}
		public static int displayProject(DBManager dbManager)
		{
			int count=1;
			try
			{
				String query="Select count(*) as counter FROM project";
				ResultSet rs = dbManager.getSt().executeQuery(query);
				
				while(rs.next())
				{
					count = rs.getInt("counter");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
		public static int displayFamily(DBManager dbManager)
		{
			int count=1;
			try
			{
				String query="Select count(*) as counter FROM family";
				ResultSet rs = dbManager.getSt().executeQuery(query);
				
				while(rs.next())
				{
					count = rs.getInt("counter");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
			
		}
		public static int displayManager(DBManager dbManager)
		{
			int count=1;
			try
			{
				String query="Select count(*) as counter FROM usermasterview WHERE roleName ='MANAGER'";
				ResultSet rs = dbManager.getSt().executeQuery(query);
				
				while(rs.next())
				{
					count = rs.getInt("counter");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
			
		}
		public static int displaySupervisor(DBManager dbManager)
		{
			int count=1;
			try
			{
				String query="Select count(*) as counter FROM usermasterview WHERE roleName ='SUPERVISOR'";
				ResultSet rs = dbManager.getSt().executeQuery(query);
				
				while(rs.next())
				{
					count = rs.getInt("counter");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
			
		}
		
		
		

		
//-------------------------------ADD POULTRY--------------------------------
		

		public static int addPolutry(int householdDataId, int noOfBatches, int totalChicksPlacement, int mortality,
				int totalFeedConsumption, int FCR, int totalIncome, int baselineIncome, int incrementalIncome,
				DBManager dbManager) {
			int flag = 0;
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewPolutary(?,?,?,?,?,?,?,?,?,?)");
				pstm.setInt(1, householdDataId);
				pstm.setInt(2, noOfBatches);
				pstm.setInt(3, totalChicksPlacement);
				pstm.setInt(4, mortality);
				pstm.setInt(5, totalFeedConsumption);
				pstm.setInt(6, FCR);
				pstm.setInt(7, totalIncome);
				pstm.setInt(8, baselineIncome);
				pstm.setInt(9, incrementalIncome);
				pstm.registerOutParameter(10, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(10);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//----------------------------------ADD VEGITABLE------------------------
		

		public static int addVegitable(int land, int noOfPlants, int income, int production, int householdDataId,
				DBManager dbManager) {
			int flag = 0;
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewVegitable(?,?,?,?,?,?)");
				pstm.setInt(1, householdDataId);
				pstm.setInt(2, land);
				pstm.setInt(3, noOfPlants);
				pstm.setInt(4, income);
				pstm.setInt(5, production);
				pstm.registerOutParameter(6, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(6);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
//-----------------------------ADD GOAT------------------------------

		public static int addGoat(int noOfGoatAtBegening, int presentGoatNos, int goatSales, int mortality,
				int goatValueAtBegening, int presentValueOfGoat, int salesOfGoat, int totalIncome, int baselineIncome,
				int netIncrement, int householdDataId, DBManager dbManager) {
			int flag = 0;
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewGoat(?,?,?,?,?,?,?,?,?,?,?)");
				pstm.setInt(1, householdDataId);
				pstm.setInt(2, noOfGoatAtBegening);
				pstm.setInt(3, presentGoatNos);
				pstm.setInt(4, goatSales);
				pstm.setInt(5, mortality);
				pstm.setInt(6, goatValueAtBegening);
				pstm.setInt(7, presentValueOfGoat);
				pstm.setInt(8, salesOfGoat);
				pstm.setInt(9, totalIncome);
				pstm.setInt(10, baselineIncome);
				pstm.setInt(11, netIncrement);
				
				pstm.registerOutParameter(12, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(12);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}


		public static int addImpactDatatype(String impactDatatypeName, String tableName, DBManager dbManager) {
			int flag = 0;
			try {
				
				CallableStatement pstm = dbManager.getCon().prepareCall("call addNewImpactdataType(?,?,?)");
				pstm.setString(1, impactDatatypeName);
				pstm.setString(2, tableName);
				pstm.registerOutParameter(3, Types.INTEGER);
				
				pstm.executeQuery();
				flag = pstm.getInt(3);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}		
		

public static ArrayList<UserViewBean> getAllManager(DBManager dbManager)
{

	ArrayList<UserViewBean> manager = new ArrayList<UserViewBean>();
	
	try
	{
		String query="Select * FROM usermasterview WHERE roleName ='MANAGER'";
		ResultSet rs = dbManager.getSt().executeQuery(query);
		
		while(rs.next())
		{
			UserViewBean userBean = new UserViewBean();
			userBean.setUserName(rs.getString("username"));
			userBean.setUserId(rs.getInt("userId"));
			userBean.setProfileId(rs.getInt("profileId"));
			userBean.setRoleId(rs.getInt("roleId"));
			userBean.setLastActivity(rs.getString("lastActivity"));
			userBean.setFirstName(rs.getString("firstName"));
			userBean.setLastName(rs.getString("lastName"));
			userBean.setEmail(rs.getString("email"));
			userBean.setPhone(rs.getString("phone"));
			userBean.setAddress(rs.getString("address"));
			userBean.setPhoto(rs.getString("photo"));
			userBean.setRole(rs.getString("roleName"));
			
			manager.add(userBean);
			
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return manager;
	
}


public static UserViewBean getManager(int userId, DBManager dbManager)
{

	UserViewBean userBean = new UserViewBean();
	
	try
	{
		String query="Select * FROM usermasterview WHERE roleName ='MANAGER' AND userId="+userId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		
		while(rs.next())
		{
			userBean = new UserViewBean();
			userBean.setUserName(rs.getString("username"));
			userBean.setUserId(rs.getInt("userId"));
			userBean.setProfileId(rs.getInt("profileId"));
			userBean.setRoleId(rs.getInt("roleId"));
			userBean.setLastActivity(rs.getString("lastActivity"));
			userBean.setFirstName(rs.getString("firstName"));
			userBean.setLastName(rs.getString("lastName"));
			userBean.setEmail(rs.getString("email"));
			userBean.setPhone(rs.getString("phone"));
			userBean.setAddress(rs.getString("address"));
			userBean.setPhoto(rs.getString("photo"));
			userBean.setRole(rs.getString("roleName"));
			userBean.setStatusCode(rs.getString("statusCode"));
			userBean.setPassword(rs.getString("password"));
			
			
			
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return userBean;
	
}

public static ArrayList<UserViewBean> getAllSupervisor(DBManager dbManager)
{

	ArrayList<UserViewBean> supervisor = new ArrayList<UserViewBean>();
	
	try
	{
		String query="Select * FROM usermasterview WHERE roleName ='SUPERVISOR'";
		ResultSet rs = dbManager.getSt().executeQuery(query);
		
		while(rs.next())
		{
			UserViewBean userBean = new UserViewBean();
			userBean.setUserName(rs.getString("username"));
			userBean.setUserId(rs.getInt("userId"));
			/*userBean.setProfileId(rs.getInt("profileId"));
			userBean.setRoleId(rs.getInt("roleId"));
			userBean.setLastActivity(rs.getString("lastActivity"));*/
			userBean.setFirstName(rs.getString("firstName"));
			userBean.setLastName(rs.getString("lastName"));
			userBean.setEmail(rs.getString("email"));
			userBean.setPhone(rs.getString("phone"));
			userBean.setAddress(rs.getString("address"));
			userBean.setManagerId(rs.getInt("managerId"));
			//userBean.setPhoto(rs.getString("photo"));
			//userBean.setRole(rs.getString("roleName"));
			
			supervisor.add(userBean);
			
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return supervisor;
	
}

public static ArrayList<UserViewBean> getAllSupervisorByManagerId(int managerId, DBManager dbManager)
{

	ArrayList<UserViewBean> supervisor = new ArrayList<UserViewBean>();
	
	try
	{
		String query="Select * FROM usermasterview WHERE roleName ='SUPERVISOR' AND managerId="+managerId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		
		while(rs.next())
		{
			UserViewBean userBean = new UserViewBean();
			userBean.setUserName(rs.getString("username"));
			userBean.setUserId(rs.getInt("userId"));
			/*userBean.setProfileId(rs.getInt("profileId"));
			userBean.setRoleId(rs.getInt("roleId"));
			userBean.setLastActivity(rs.getString("lastActivity"));*/
			userBean.setFirstName(rs.getString("firstName"));
			userBean.setLastName(rs.getString("lastName"));
			userBean.setEmail(rs.getString("email"));
			userBean.setPhone(rs.getString("phone"));
			userBean.setAddress(rs.getString("address"));
			userBean.setManagerId(rs.getInt("managerId"));
			//userBean.setPhoto(rs.getString("photo"));
			//userBean.setRole(rs.getString("roleName"));
			
			supervisor.add(userBean);
			
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return supervisor;
	
}

public static UserViewBean getSupervisor(int userId, DBManager dbManager)
{

	UserViewBean userBean = new UserViewBean();
	
	try
	{
		String query="Select * FROM usermasterview WHERE roleName ='SUPERVISOR' AND userId="+userId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		
		while(rs.next())
		{
			userBean = new UserViewBean();
			userBean.setUserName(rs.getString("username"));
			userBean.setUserId(rs.getInt("userId"));
			userBean.setProfileId(rs.getInt("profileId"));
			userBean.setRoleId(rs.getInt("roleId"));
			userBean.setLastActivity(rs.getString("lastActivity"));
			userBean.setFirstName(rs.getString("firstName"));
			userBean.setLastName(rs.getString("lastName"));
			userBean.setEmail(rs.getString("email"));
			userBean.setPhone(rs.getString("phone"));
			userBean.setAddress(rs.getString("address"));
			userBean.setPhoto(rs.getString("photo"));
			userBean.setRole(rs.getString("roleName"));
			userBean.setStatusCode(rs.getString("statusCode"));
			userBean.setPassword(rs.getString("password"));
			
			
			
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return userBean;
	
}
public static ReligionBean getByReligionId( int religionId, DBManager dbManager) {
	// TODO Auto-generated method stub
	
	ReligionBean addNewReligionBean = new ReligionBean();
	try {
		
		String query="SELECT * FROM religion WHERE religionId="+religionId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			addNewReligionBean.setReligionCode(rs.getString("religionCode"));
			addNewReligionBean.setReligionName(rs.getString("religionName"));
			addNewReligionBean.setReligionId(rs.getInt("religionId"));
		}
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	return addNewReligionBean;
}
public static SocialCategoryBean getBySocialCategoryId( int socialCategoryId, DBManager dbManager) {
	// TODO Auto-generated method stub
	
	SocialCategoryBean addNewSocialCategoryBean = new SocialCategoryBean();
	try {
		
		String query="SELECT * FROM socialCategory WHERE socialCategoryId="+socialCategoryId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			addNewSocialCategoryBean.setSocialCategoryCode(rs.getString("socialCategoryCode"));
			addNewSocialCategoryBean.setSocialCategoryName(rs.getString("socialCategoryName"));
			addNewSocialCategoryBean.setSocialcategoryId(rs.getInt("socialcategoryId"));
		}
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	return addNewSocialCategoryBean;
}
public static SchemeBean getBySchemeId( int schemeId, DBManager dbManager) {
	// TODO Auto-generated method stub
	
	SchemeBean addNewSchemeBean = new SchemeBean();
	try {
		
		String query="SELECT * FROM scheme WHERE schemeId="+schemeId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			addNewSchemeBean.setSchemeName(rs.getString("schemeName"));
			addNewSchemeBean.setSchemeId(rs.getInt("schemeId"));
		}
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	return addNewSchemeBean;
}
public static EducationBean getByEducationId( int educationId, DBManager dbManager) {
	// TODO Auto-generated method stub
	
	EducationBean addNewEducationBean = new EducationBean();
	try {
		
		String query="SELECT * FROM education WHERE educationId="+educationId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			addNewEducationBean.setEducationName(rs.getString("educationName"));
			addNewEducationBean.setEducationCode(rs.getInt("educationCode"));
			addNewEducationBean.setEducationId(rs.getInt("educationId"));
		}
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	return addNewEducationBean;
}
public static OccupationBean getByOccupationId( int occupationId, DBManager dbManager) {
	// TODO Auto-generated method stub
	
	OccupationBean addNewOccupationBean = new OccupationBean();
	try {
		
		String query="SELECT * FROM occupation WHERE occupationId="+occupationId;
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			addNewOccupationBean.setOccupationName(rs.getString("occupationName"));
			addNewOccupationBean.setOccupationCode(rs.getString("occupationCode"));
			addNewOccupationBean.setOccupationId(rs.getInt("occupationId"));
		}
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	return addNewOccupationBean;
}
public static int addSupervisorAssignment(int userId, int stateId, int districtId, int blockId, int villageId, DBManager dbManager)
{
	int flag=0;
	try {
		
			CallableStatement pstm = dbManager.getCon().prepareCall("call addSupervisorAssignment(?,?,?)");
			pstm.setInt(1, userId);
			pstm.setInt(2, villageId);
			pstm.registerOutParameter(3, Types.INTEGER);
			pstm.executeQuery();
			flag = pstm.getInt(3);
		}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
}
public static int addManagerAssignment(int userId, int supervisorId, DBManager dbManager)
{
	int flag=0;
	try {
		
		CallableStatement pstm = dbManager.getCon().prepareCall("call addManagerAssignment(?,?,?)");
		pstm.setInt(1, userId);
		pstm.setInt(2, supervisorId);
		pstm.registerOutParameter(3, Types.INTEGER);
		pstm.executeQuery();
		flag = pstm.getInt(3);
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	
	
	return flag;
}

public static int updateUser( 
			int userId, 
			String	userName, 
			String password, 
			int roleId, 
			String statusCode,
			String firstName, 
			String lastName, 
			String email, 
			String phone, 
			String address, DBManager dbManager)
{
	int flag=0;
	try {
		
		CallableStatement pstm = dbManager.getCon().prepareCall("call updateUser(?,?,?,?,?,?,?,?,?,?,?)");
		pstm.setInt(1, userId);
		pstm.setString(2, userName);
		pstm.setString(3, password);
		pstm.setInt(4, roleId);
		pstm.setString(5, statusCode);
		pstm.setString(6, firstName);
		pstm.setString(7, lastName);
		pstm.setString(8, email);
		pstm.setString(9, phone);
		pstm.setString(10, address);
		pstm.registerOutParameter(11, Types.INTEGER);
		pstm.executeQuery();
		flag = pstm.getInt(11);
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return flag;

}

	
	public static ArrayList<SupervisorAssignmentBean> getSupervisorAssignment( String userId, String time, DBManager dbManager) {
		// TODO Auto-generated method stub
		
		ArrayList<SupervisorAssignmentBean> supervisorAssignmentBean = new ArrayList<SupervisorAssignmentBean>();
		try {
			
			String query="SELECT * FROM supervisorview WHERE userId="+userId+" AND lastUpdated > '"+time+"'";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
			{
				SupervisorAssignmentBean s = new SupervisorAssignmentBean(
						rs.getInt("supervisorAssignmentId"),
						rs.getInt("userId"),
						rs.getInt("villageId"),
						rs.getString("villageCode"),
						rs.getString("villageName"),
						rs.getString("userName"),
						rs.getString("lastUpdated"),
						rs.getInt("stateId"),
						rs.getInt("districtId"),
						rs.getInt("blockId"),
						rs.getString("stateName"),
						rs.getString("stateCode"),
						rs.getString("districtCode"),
						rs.getString("districtName"),
						rs.getString("blockCode"),
						rs.getString("blockName"));
					
				supervisorAssignmentBean.add(s);
				//addNewOccupationBean.setOccupationName(rs.getString("occupationName"));
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return supervisorAssignmentBean;
	}
	
	
	public static ArrayList<StateBean> getSupervisorAssignmentState( String userId, String time, DBManager dbManager) {
		// TODO Auto-generated method stub
		
		ArrayList<StateBean> state = new ArrayList<StateBean>();
		try {
			
			String query="SELECT * FROM locationmasterview WHERE userId="+userId+" AND lastUpdated > '"+time+"' GROUP BY stateId";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
			{
				StateBean s = new StateBean(
						rs.getString("stateCode"),
						rs.getString("stateName"),
						rs.getInt("stateId"));
					
				state.add(s);
				//addNewOccupationBean.setOccupationName(rs.getString("occupationName"));
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return state;
	}

	
	
	public static ArrayList<DistrictBean> getSupervisorAssignmentDistrict( String userId, String time, DBManager dbManager) {
		// TODO Auto-generated method stub
		
		ArrayList<DistrictBean> district = new ArrayList<DistrictBean>();
		try {
			
			String query="SELECT * FROM locationmasterview WHERE userId="+userId+" AND lastUpdated > '"+time+"' GROUP BY districtId";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
			{
				DistrictBean s = new DistrictBean(
						rs.getInt("districtId"),
						rs.getString("districtCode"),
						rs.getString("districtName"),
						rs.getInt("stateId"));
					
				district.add(s);
				//addNewOccupationBean.setOccupationName(rs.getString("occupationName"));
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return district;
	}

	
	
	public static ArrayList<BlockBean> getSupervisorAssignmentBlock( String userId, String time, DBManager dbManager) {
		// TODO Auto-generated method stub
		
		ArrayList<BlockBean> block = new ArrayList<BlockBean>();
		try {
			
			String query="SELECT * FROM locationmasterview WHERE userId="+userId+" AND lastUpdated > '"+time+"' GROUP BY blockId";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
			{
				BlockBean s = new BlockBean(
						rs.getInt("districtId"),
						rs.getString("blockName"),
						rs.getString("blockCode"),
						rs.getInt("blockId"));
					
				block.add(s);
				//addNewOccupationBean.setOccupationName(rs.getString("occupationName"));
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return block;
	}

	
	public static ArrayList<VillageBean> getSupervisorAssignmentVillage( String userId, String time, DBManager dbManager) {
		// TODO Auto-generated method stub
		
		ArrayList<VillageBean> village = new ArrayList<VillageBean>();
		try {
			
			String query="SELECT * FROM locationmasterview WHERE userId="+userId+" AND lastUpdated > '"+time+"' GROUP BY villageId";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
			{
				VillageBean s = new VillageBean(
						rs.getInt("villageId"),
						rs.getInt("blockId"),
						rs.getString("villageCode"),
						rs.getString("villageName"));
					
				village.add(s);
				//addNewOccupationBean.setOccupationName(rs.getString("occupationName"));
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return village;
	}
//------------------------------ADD Intervention---------------------------------------
	
	
			public static int addIntervention(String projectName, String donerName, int projectTypeId, DBManager dbManager) {
				int flag = 0;
				ProjectBean addprojectBean = new ProjectBean();
				try {
					
					CallableStatement pstm = dbManager.getCon().prepareCall("call addNewProject(?,?,?,?)");
					pstm.setString(1, projectName);
					pstm.setString(2, donerName);
					pstm.setInt(3, projectTypeId);
					pstm.registerOutParameter(4, Types.INTEGER);
					
					pstm.executeQuery();
					flag = pstm.getInt(4);
					System.out.println("flag1"+flag);
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				return flag;
			}
			//------------------------------ADD Intervention Attribute---------------------------------------
			
			
			public static int addInterventionAttribute(int projectAttributeId,int projectTypeId,String attributeName, int displaySequence, int fixedValue,int status, DBManager dbManager) {
				int flag = 0;
				ProjectAttributeBean addprojectattributeBean = new ProjectAttributeBean();
				try {
					/*System.out.println("PTID="+projectTypeId+" AN="+attributeName+" DS="+displaySequence+" FV="
							+fixedValue+" S="+status);
					*/
					CallableStatement pstm = dbManager.getCon().prepareCall("call updateProjectAttribute(?,?,?,?,?,?,?)");
					pstm.setInt(1, projectAttributeId);
					pstm.setInt(2, projectTypeId);
					pstm.setString(3, attributeName);
					pstm.setInt(4, displaySequence);
					pstm.setInt(5,fixedValue);
					pstm.setInt(6,status);
					pstm.registerOutParameter(7, Types.INTEGER);
					
					pstm.executeQuery();
					flag = pstm.getInt(7);
					System.out.println("flag1"+flag);
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				return flag;
			}



			//-----------------------------GET ALL PROJECTATTRIBUTEs new one--------------------------------


			public static ArrayList<ProjectDataBean> getAllProjectAttributes(DBManager dbManager)
			{
				ArrayList<ProjectDataBean> arr = new ArrayList<ProjectDataBean>();
				int count=0;
				
				try {
					
				// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
					
					String query="SELECT * FROM projecttype,projectattribute WHERE projecttype.projectTypeId=projectattribute.projectTypeId";
					//System.out.println(query);
					ResultSet rs = dbManager.getSt().executeQuery(query);
					while(rs.next())
					{
						ProjectDataBean getAllProjectAttributeBean = new ProjectDataBean();
						getAllProjectAttributeBean.setProjectAttributeId(String.valueOf(rs.getString("projectAttributeId")));
						getAllProjectAttributeBean.setAttributeName(rs.getString("attributeName"));
						getAllProjectAttributeBean.setAttributeSize(String.valueOf(rs.getInt("attributeSize")));
						getAllProjectAttributeBean.setAttributeType(rs.getString("attributeType"));
						getAllProjectAttributeBean.setProjectTypeId(String.valueOf(rs.getInt("projecttype.projectTypeId")));
						getAllProjectAttributeBean.setProjectTypeName(rs.getString("projectTypeName"));
						getAllProjectAttributeBean.setStatus(String.valueOf(rs.getInt("status")));
						getAllProjectAttributeBean.setFixedValue(String.valueOf(rs.getInt("fixedValue")));
						getAllProjectAttributeBean.setDisplaySequence(String.valueOf(rs.getInt("displaySequence")));
						getAllProjectAttributeBean.setLastUpdated(String.valueOf(rs.getLong("lastUpdated")));
						arr.add(getAllProjectAttributeBean);
						//System.out.println(getAllAssetBean);
						count++;
						//System.out.println(count);
					}
					
					
					
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}
				return arr;
				
			} 
			//-----------------------------GET ALL PROJECTATTRIBUTEs new one--------------------------------


		public static ArrayList<ProjectDataBean> getProjectAttributesById(int projectAttributeId, DBManager dbManager)
		{
			ArrayList<ProjectDataBean> arr = new ArrayList<ProjectDataBean>();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM projecttype,projectattribute "
						+ "WHERE projecttype.projectTypeId=projectattribute.projectTypeId"
						+ " AND projectattribute.projectAttributeId="+projectAttributeId;
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					ProjectDataBean getAllProjectAttributeBean = new ProjectDataBean();
					getAllProjectAttributeBean.setProjectAttributeId(String.valueOf(rs.getString("projectAttributeId")));
					getAllProjectAttributeBean.setAttributeName(rs.getString("attributeName"));
					getAllProjectAttributeBean.setAttributeSize(String.valueOf(rs.getInt("attributeSize")));
					getAllProjectAttributeBean.setAttributeType(rs.getString("attributeType"));
					getAllProjectAttributeBean.setProjectTypeId(String.valueOf(rs.getInt("projecttype.projectTypeId")));
					getAllProjectAttributeBean.setProjectTypeName(rs.getString("projectTypeName"));
					getAllProjectAttributeBean.setStatus(String.valueOf(rs.getInt("status")));
					getAllProjectAttributeBean.setFixedValue(String.valueOf(rs.getInt("fixedValue")));
					getAllProjectAttributeBean.setDisplaySequence(String.valueOf(rs.getInt("displaySequence")));
					getAllProjectAttributeBean.setLastUpdated(String.valueOf(rs.getLong("lastUpdated")));
					arr.add(getAllProjectAttributeBean);
					//System.out.println(getAllAssetBean);
					count++;
					//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return arr;
			
		} 
//-----------------------------GET ALL PROJECTATTRIBUTE--------------------------------


public static ArrayList<ProjectAttributeBean> getAllProjectAttribute(DBManager dbManager)
{
	ArrayList<ProjectAttributeBean> arr = new ArrayList<ProjectAttributeBean>();
	int count=0;
	
	try {
		
	// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
		
		String query="SELECT * FROM projectattribute";
		//System.out.println(query);
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			ProjectAttributeBean getAllProjectAttributeBean = new ProjectAttributeBean(
					String.valueOf(rs.getInt("projectAttributeId")), 
					rs.getString("attributeName"), 
					String.valueOf(rs.getInt("attributeSize")),
					rs.getString("attributetype"),
					String.valueOf(rs.getInt("projectTypeId")), 
					String.valueOf(rs.getInt("status")),
					String.valueOf(rs.getInt("fixedValue")), 
					String.valueOf(rs.getInt("displaySequence")));
			arr.add(getAllProjectAttributeBean);
			//System.out.println(getAllAssetBean);
			count++;
			//System.out.println(count);
		}
		
		
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return arr;
	
} 
//-----------------------------GET ALL PROJECT BY ID--------------------------------



		public static ProjectAttributeBean getByProjectAttributeId(int projectAttributeId,DBManager dbManager)
		{
			ProjectAttributeBean getallprojectattributebean = new ProjectAttributeBean();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM projectattribute where projectAttributeId="+projectAttributeId+"";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					getallprojectattributebean = new ProjectAttributeBean(
							
							rs.getString("projectTypeId"),
							rs.getString("attributeName"),
							rs.getString("displaySequence"),
							rs.getString("fixedValue")
							
							
							);
					
					getallprojectattributebean.setProjectTypeId(rs.getString("projectTypeId"));
					getallprojectattributebean.setAttributeName(rs.getString("attributeName"));
					getallprojectattributebean.setDisplaySequence(rs.getString("displaySequence"));
					getallprojectattributebean.setFixedValue(rs.getString("fixedValue"));
					
			
			
			//System.out.println(getAllAssetBean);
			count++;
			//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return getallprojectattributebean;
			
		}
//-----------------------------GET ALL PROJECTTYPE--------------------------------


public static ArrayList<ProjectTypeBean> getAllProjecttype(DBManager dbManager)
{
	ArrayList<ProjectTypeBean> arr = new ArrayList<ProjectTypeBean>();
	int count=0;
	ProjectTypeBean addProjectTypeBean = new ProjectTypeBean();
	try {
		
	// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
		
		String query="SELECT * FROM projecttype";
		//System.out.println(query);
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			ProjectTypeBean getAllProjectType = new ProjectTypeBean( rs.getInt("projectTypeId"),rs.getString("projectTypeName"));
			arr.add(getAllProjectType);
			//System.out.println(getAllAssetBean);
			count++;
			//System.out.println(count);
		}
		
		
		
		
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return arr;
	
} 
//------------------------------ADD Intervention Type---------------------------------------


public static int addInterventionType(String projectTypeName, DBManager dbManager) {
	int flag = 0;
	try {
		
		CallableStatement pstm = dbManager.getCon().prepareCall("call addNewProjectType(?,?)");
		pstm.setString(1, projectTypeName);
		pstm.registerOutParameter(2, Types.INTEGER);
		
		pstm.executeQuery();
		flag = pstm.getInt(2);
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
}

//------------------------------Update SupervisorAssignment---------------------------------------


public static int updateSupervisorAssignment(int villageId, int userId, DBManager dbManager) {
	int flag = 0;
	try {
		
		CallableStatement pstm = dbManager.getCon().prepareCall("call updateSupervisorVillageAssignment(?,?,?)");
		pstm.setInt(1, villageId);
		pstm.setInt(2, userId);
		pstm.registerOutParameter(3, Types.INTEGER);
		
		pstm.executeQuery();
		flag = pstm.getInt(3);
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
}

//------------------------------Update ManagerAssignment---------------------------------------


public static int updateManagerAssignment(int userId, int managerId, DBManager dbManager) {
	int flag = 0;
	try {
		
		CallableStatement pstm = dbManager.getCon().prepareCall("call updateManagerSupervisorAssignment(?,?,?)");
		pstm.setInt(1, userId);
		pstm.setInt(2, managerId);
		pstm.registerOutParameter(3, Types.INTEGER);
		
		pstm.executeQuery();
		flag = pstm.getInt(3);
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return flag;
}
//-----------------------------GET ALL PROJECT BY ID--------------------------------



		public static ProjectTypeBean getByProjectTypeId(int projectTypeId,DBManager dbManager)
		{
			ProjectTypeBean getallprojecttypebean = new ProjectTypeBean();
			int count=0;
			
			try {
				
			// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
				
				String query="SELECT * FROM projecttype where projectTypeId="+projectTypeId+"";
				//System.out.println(query);
				ResultSet rs = dbManager.getSt().executeQuery(query);
				while(rs.next())
				{
					getallprojecttypebean = new ProjectTypeBean(
							
							rs.getInt("projectTypeId"),
							rs.getString("projectTypeName")
							);
					
					getallprojecttypebean.setProjectTypeName(rs.getString("projectTypeName"));
					getallprojecttypebean.setProjectTypeId(rs.getInt("projectTypeId"));
					
			
			
			//System.out.println(getAllAssetBean);
			count++;
			//System.out.println(count);
				}
				
				
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return getallprojecttypebean;
			
		}
//-----------------------------GET ALL GENDER--------------------------------


public static ArrayList<GenderBean> getAllGender(DBManager dbManager)
{
	ArrayList<GenderBean> arr = new ArrayList<GenderBean>();
	int count=0;
	
	try {
		
	// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
		
		String query="SELECT * FROM gender";
		//System.out.println(query);
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			GenderBean getAllGenderBean = new GenderBean(rs.getInt("genderId"), rs.getString("genderName"));
			arr.add(getAllGenderBean);
			//System.out.println(getAllAssetBean);
			count++;
			//System.out.println(count);
		}
		
		
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return arr;
	
} 
//-----------------------------GET ALL TimeStamp--------------------------------


public static ArrayList<TimeStampBean> getAlltimeStamp(String lastUpdated, DBManager dbManager)
{
	ArrayList<TimeStampBean> arr = new ArrayList<TimeStampBean>();
	int count=0;
	
	try {
		
	// SELECT * FROM ASSETMASTERVIEW  SELECT * FROM harsha.assetview
		
		String query="SELECT * FROM tabletimestamp where lastUpdated > '"+lastUpdated+"'";
		
		System.out.println(query);
		ResultSet rs = dbManager.getSt().executeQuery(query);
		while(rs.next())
		{
			TimeStampBean getAlltimeStamp = new TimeStampBean(rs.getInt("tableTimeStampId"), rs.getString("tableName"),rs.getString("lastUpdated"));
			arr.add(getAlltimeStamp);
			//System.out.println(getAllAssetBean);
			count++;
			//System.out.println(count);
		}
		
		
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	return arr;
	
}

public static JSONObject getAnalysisCount(DBManager dbManager)
{
	JSONObject jObj = new JSONObject();
	String tableNames[] = {"state","district","block","village","family","member","project","projecttype","serverdocuments"}; 
	int count=0;
	
	try {
		
		for(int i=0; i<tableNames.length; i++) {
			String query="SELECT COUNT(*) AS counter FROM " + tableNames[i];
			System.out.println(query);
			ResultSet rs = dbManager.getSt().executeQuery(query);
			while(rs.next())
			{
				count = rs.getInt("counter");
				jObj.put(tableNames[i], count);
			}
		}
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return jObj;
	
}

public static JSONArray getAgricultureImpactReport(long fromDate, long toDate, DBManager dbManager) {
	JSONArray jsonArray = new JSONArray();
	try {
		String query = "SELECT * FROM agricultureregularview WHERE entryDate<="+toDate+" AND entryDate>="+fromDate;
		System.out.println(query);
		System.out.println(query);
		System.out.println(query);
		ResultSet rs = dbManager.getSt().executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next()) {
			JSONObject jObj = new JSONObject();
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
				String key = rsmd.getColumnName(i);
				String value = "";
				if(rsmd.getColumnType(i) == Types.VARCHAR)
					value = rs.getString(key);
				else if(rsmd.getColumnType(i) == Types.INTEGER)
					value = String.valueOf(rs.getInt(key));
				else if(rsmd.getColumnType(i) == Types.BIGINT)
					value = String.valueOf(rs.getLong(key));
				jObj.put(key,value);
				System.out.println("Key="+key+"\tValue="+value);
			}
			jsonArray.put(jObj);
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	catch(JSONException e) {
		e.printStackTrace();
	}
	return jsonArray;
}





}



























