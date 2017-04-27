package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.DisabilitiesBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONDisabilities;

@Path("disabilities")
public class DisabilitiesServices {
	

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addDisabilities(@QueryParam("disabilityName")  String disabilityName,
			@QueryParam("disabilityCode")  int disabilityCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addDisabilities(disabilityName,disabilityCode, dbManager);
		send = JSONDisabilities.addDisabilitiesJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateDisabilities(@QueryParam("disabilityId")  int disabilityId,
			@QueryParam("disabilityName")  String disabilityName,
			@QueryParam("disabilityCode")  int disabilityCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateDisabilities(disabilityId,disabilityCode,disabilityName, dbManager);
		send = JSONDisabilities.updateDisabilitiesJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getalldisabilities")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<DisabilitiesBean> arr = DBHandler.getAllDisabilities( dbManager);
		//System.out.println(arr);
		send = JSONDisabilities.getAllDisabilitiesJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
