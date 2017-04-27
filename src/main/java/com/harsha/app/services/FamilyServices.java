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
import com.harsha.app.bean.FamilyBean;
import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.bean.MemberBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONAsset;
import com.harsha.app.json.JSONDownload;
import com.harsha.app.json.JSONFamily;
import com.harsha.app.json.JSONHousehold;
import com.harsha.app.json.JSONMemberData;


@Path("family")
public class FamilyServices {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("upload")
	public Response addNewFamily(String data) 
		{
		FamilyBean family = JSONFamily.getFamilyData(data);
		String send = "";
		System.out.println("addNewFamily:" + data);
		int status = 0;
		try {
			DBManager dbManager = new DBManager();
			if(DBHandler.addFamily(family, dbManager) == 0) 
				status = -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			status = -1;
		}		

		send = JSONFamily.getStatus(status);			
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("download")
	public Response getAllFamily(String data) 	
		{
		
		String send = "";
		System.out.println("getAllFamily:" + data);
		int status = 0;
		
		ArrayList<FamilyBean> family = null;
		
		try {
			
			DBManager dbManager = new DBManager();
			String lastUpdated = JSONDownload.getLastUpdated(data);
			String userId = JSONDownload.getUserId(data);
			family = DBHandler.getAllFamily(userId, lastUpdated, dbManager);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			status=-1;
		}
		
		send = JSONFamily.getAllFamily(status, family);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	
	/*
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallfamily")
	public Response getAllFamiy() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<FamilyBean> arr = DBHandler.getAllFamily( dbManager);
		//System.out.println(arr);
		send = JSONFamily.getAllFamilyJSON(arr);
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
	*/

}
