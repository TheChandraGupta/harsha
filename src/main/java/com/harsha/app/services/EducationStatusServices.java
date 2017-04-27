package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.EducationBean;
import com.harsha.app.bean.EducationStatusBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONEducation;
import com.harsha.app.json.JSONEducationStatus;

@Path("educationstatus")
public class EducationStatusServices {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addEducationStatus(@QueryParam("educationStatusName")  String educationStatusName,
			@QueryParam("educationStatusCode")  int educationStatusCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addEducationStatus(educationStatusName,educationStatusCode, dbManager);
		send = JSONEducationStatus.addEducationStatusJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateEducationStatus(@QueryParam("educationStatusId")  int educationStatusId,
			@QueryParam("educationStatusName")  String educationStatusName,
			@QueryParam("educationStatusCode")  int educationStatusCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateEducationStatus(educationStatusId,educationStatusCode,educationStatusName, dbManager);
		send = JSONEducationStatus.updateEducationStatusJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getalleducationstatus")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<EducationStatusBean> arr = DBHandler.getAllEducationStatus( dbManager);
		//System.out.println(arr);
		send = JSONEducationStatus.getAllEducationStatusJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")				
				.build();
	}

}
