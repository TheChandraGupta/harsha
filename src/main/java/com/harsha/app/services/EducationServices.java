package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.EducationBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONEducation;

@Path("education")
public class EducationServices {
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addEducation(@QueryParam("educationName")  String educationName,
			@QueryParam("educationCode")  int educationCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addEducation(educationName,educationCode, dbManager);
		send = JSONEducation.addEducationJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateEducation(@QueryParam("educationId")  int educationId,
			@QueryParam("educationName")  String educationName,
			@QueryParam("educationCode")  int educationCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateEducation(educationId,educationCode,educationName, dbManager);
		send = JSONEducation.updateEducationJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getalleducation")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<EducationBean> arr = DBHandler.getAllEducation( dbManager);
		//System.out.println(arr);
		send = JSONEducation.getAllEducationJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
