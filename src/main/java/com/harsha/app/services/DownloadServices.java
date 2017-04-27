package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONDownload;
import com.harsha.app.database.DBHandler;



@Path("download")
public class DownloadServices {

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("data")
	public Response apiData() {
		System.out.println("apiData");
		
		String send = "";
		
		DBManager dbManager = new DBManager();
		
		/*
		 * Get All Data
		 */
		// All Asset
		ArrayList<AssetBean> asset = DBHandler.getAllAsset( dbManager);
		// All Disabilties
		ArrayList<DisabilitiesBean> disabilities = DBHandler.getAllDisabilities( dbManager);
		// All Education
		ArrayList<EducationBean> education = DBHandler.getAllEducation( dbManager);
		// All Education Status
		ArrayList<EducationStatusBean> educationStatus = DBHandler.getAllEducationStatus( dbManager);
		// All Marital Status
		ArrayList<MaritalStatusBean> maritalStatus = DBHandler.getAllMaritalStatus( dbManager);
		// All Occupation
		ArrayList<OccupationBean> occupation = DBHandler.getAllOccupation( dbManager);
		// All Relationship
		ArrayList<RelationshipBean> relationship = DBHandler.getAllRelationship( dbManager);
		// All Religion
		ArrayList<ReligionBean> religion = DBHandler.getAllReligion( dbManager);
		// All Scheme
		ArrayList<SchemeBean> scheme = DBHandler.getAllScheme( dbManager);
		// All Social Category
		ArrayList<SocialCategoryBean> socialCategory = DBHandler.getAllSocialCategory( dbManager);
		// All Project
		ArrayList<ProjectBean> project = DBHandler.getAllProject(dbManager);
		
		send = JSONDownload.getAllDataJSON(asset, 
				disabilities, 
				education, 
				educationStatus, 
				maritalStatus, 
				occupation, 
				relationship, 
				religion, 
				scheme, 
				socialCategory,
				project);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("master")
	public Response masterData(String data) {
		String lastUpdated = JSONDownload.getLastUpdated(data);
		System.out.println("masterData-"+lastUpdated+"\n"+data);
		
		String send = "";
		
		int status = 0;
		
		ArrayList<AssetBean> asset = null;
		ArrayList<DisabilitiesBean> disabilities = null;
		ArrayList<EducationBean> education = null;
		ArrayList<EducationStatusBean> educationStatus = null;
		ArrayList<MaritalStatusBean> maritalStatus = null;
		ArrayList<OccupationBean> occupation = null;
		ArrayList<RelationshipBean> relationship = null;
		ArrayList<ReligionBean> religion = null;
		ArrayList<SchemeBean> scheme = null;
		ArrayList<SocialCategoryBean> socialCategory = null;
		ArrayList<ProjectBean> project = null;
		ArrayList<ProjectAttributeBean> projectattribute = null;
		ArrayList<ProjectTypeBean> projecttype = null;
		ArrayList<GenderBean> gender = null;
		ArrayList<TimeStampBean> timestamp = null;
		
		try {

			DBManager dbManager = new DBManager();
			
			/*
			 * Get All Data
			 */
			// All Asset
			asset = DBHandler.getAllAsset( dbManager);
			// All Disabilties
			disabilities = DBHandler.getAllDisabilities( dbManager);
			// All Education
			education = DBHandler.getAllEducation( dbManager);
			// All Education Status
			educationStatus = DBHandler.getAllEducationStatus( dbManager);
			// All Marital Status
			maritalStatus = DBHandler.getAllMaritalStatus( dbManager);
			// All Occupation
			occupation = DBHandler.getAllOccupation( dbManager);
			// All Relationship
			relationship = DBHandler.getAllRelationship( dbManager);
			// All Religion
			religion = DBHandler.getAllReligion( dbManager);
			// All Scheme
			scheme = DBHandler.getAllScheme( dbManager);
			// All Social Category
			socialCategory = DBHandler.getAllSocialCategory( dbManager);
			// All Project
			project = DBHandler.getAllProject(dbManager);
			//All ProjectAtributes
			projectattribute = DBHandler.getAllProjectAttribute(dbManager);
			//All ProjectAtributes
			projecttype = DBHandler.getAllProjecttype(dbManager);
			//All Gender
			gender = DBHandler.getAllGender(dbManager);
			
			//ALL TIMESTAMP
			timestamp = DBHandler.getAlltimeStamp(lastUpdated, dbManager);
			
		}
		catch(Exception e) {
			status=-1;
		}
		
		
		send = JSONDownload.getAllMasterDataJSON(asset, 
				disabilities, 
				education, 
				educationStatus, 
				maritalStatus, 
				occupation, 
				relationship, 
				religion, 
				scheme, 
				socialCategory,
				project,
				projectattribute,
				projecttype,
				gender,
				timestamp,
				status);
		
		// Testing TODO
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("location")
	public Response locationData(String data) {
		
		String lastUpdated = JSONDownload.getLastUpdated(data);
		String userId = JSONDownload.getUserId(data);
		
		System.out.println("locationData" + lastUpdated + " " + userId+"\n"+data);
		
		String send = "";
		int status = 0;
		
		ArrayList<StateBean> state = null;
		ArrayList<DistrictBean> district = null;
		ArrayList<BlockBean> block = null;
		ArrayList<VillageBean> village = null;
		
		DBManager dbManager = new DBManager();
		try {

			//ArrayList<SupervisorAssignmentBean> sab = DBHandler.getSupervisorAssignment(userId, lastUpdated, dbManager);
			state = DBHandler.getSupervisorAssignmentState(userId, lastUpdated, dbManager);
			district = DBHandler.getSupervisorAssignmentDistrict(userId, lastUpdated, dbManager);
			block = DBHandler.getSupervisorAssignmentBlock(userId, lastUpdated, dbManager);
			village = DBHandler.getSupervisorAssignmentVillage(userId, lastUpdated, dbManager);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			status = -1;
		}
		send = JSONDownload.getUserDataJSON(state, district, block, village, status);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
		
}
