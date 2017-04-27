package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONAsset;
import com.harsha.app.json.JSONHousehold;


@Path("household")
public class HouseholdServices {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response getAllDistrict(
						@QueryParam("stateId") 				int stateId,
						@QueryParam("districtId")			int districtId,
						@QueryParam("blockId")				int blockId,
						@QueryParam("villageid")			int villageid,
						@QueryParam("surveyOwnerUserId")	int surveyOwnerUserId,
						@QueryParam("surveyPeriod")			String surveyPeriod,
						@QueryParam("socialCategoryId")		int socialCategoryId,
						@QueryParam("religionId")			int religionId,
						@QueryParam("contactNo")			String contactNo,
						@QueryParam("noOfFamilyMember")		int noOfFamilyMember,
						@QueryParam("occupationId")			int occupationId,
						@QueryParam("annualHHIncome")		int annualHHIncome,
						@QueryParam("remarks")				String remarks
						) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addHousehold(stateId, districtId, blockId, villageid, surveyOwnerUserId,
				surveyPeriod, socialCategoryId,	religionId, contactNo, noOfFamilyMember, occupationId, annualHHIncome, remarks, dbManager);
		send = JSONHousehold.addHouseHoldJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallhousehold")
	public Response getAllHousehold() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<HouseHoldBean> arr = DBHandler.getAllHousehold( dbManager);
		//System.out.println(arr);
		send = JSONHousehold.getAllHouseholdJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbyvillage")
	public Response getByVillage(@QueryParam("villageid")			int villageid) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<HouseHoldBean> arr = DBHandler.getByVillageHousehold(villageid, dbManager);
		//System.out.println(arr);
		send = JSONHousehold.getByVillageHouseholdJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbyblock")
	public Response getByblock(@QueryParam("blockId")		int blockId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<HouseHoldBean> arr = DBHandler.getByBlockHousehold(blockId, dbManager);
		//System.out.println(arr);
		send = JSONHousehold.getByBlockHouseholdJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbydistrict")
	public Response getByDistrict(@QueryParam("districtId")		int districtId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<HouseHoldBean> arr = DBHandler.getByDistrictHousehold(districtId, dbManager);
		//System.out.println(arr);
		send = JSONHousehold.getByDistrictHouseholdJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbystate")
	public Response getByState(@QueryParam("stateId")		int stateId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<HouseHoldBean> arr = DBHandler.getByStateHousehold(stateId, dbManager);
		//System.out.println(arr);
		send = JSONHousehold.getByStateHouseholdJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("verification")
	public Response verification(@QueryParam("householddataId")		int householddataId,
			@QueryParam("statusCode")		String statusCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.verificationHousehold(householddataId, statusCode, dbManager);
		//System.out.println(arr);
		send = JSONHousehold.verificationHouseholdJSON(flag);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	

}
