package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.MaritalStatusBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONMaritalStatus;

@Path("maritalstatus")
public class MaritalStatusServices {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addMaritalStatus(@QueryParam("maritalStatusName")  String maritalStatusName,
			@QueryParam("maritalStatusCode")  int maritalStatusCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addMaritalStatus(maritalStatusCode, maritalStatusName,dbManager);
		send = JSONMaritalStatus.addMaritalStatusJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateMaritalStatus(@QueryParam("maritalStatusId")  int maritalStatusId,
			@QueryParam("maritalStatusName")  String maritalStatusName,
			@QueryParam("maritalStatusCode")  int maritalStatusCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateMaritalStatus(maritalStatusId,maritalStatusCode,maritalStatusName, dbManager);
		send = JSONMaritalStatus.updateMaritalStatusJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallmaritalstatus")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<MaritalStatusBean> arr = DBHandler.getAllMaritalStatus( dbManager);
		//System.out.println(arr);
		send = JSONMaritalStatus.getAllMaritalStatusJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
