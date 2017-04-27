package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.AssetInfoBean;
import com.harsha.app.bean.OccupationBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONAsset;
import com.harsha.app.json.JSONOccupation;

@Path("occupation")
public class OccupationServices {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addOccupation(@QueryParam("occupationName")  String occupationName,
			@QueryParam("occupationCode")  int occupationCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addOccupation(occupationName,occupationCode, dbManager);
		send = JSONOccupation.addOccupationJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateOccupation(@QueryParam("occupationId")  int occupationId,
			@QueryParam("occupationName")  String occupationName,
			@QueryParam("occupationCode")  int occupationCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateOccupation(occupationId,occupationCode,occupationName, dbManager);
		send = JSONOccupation.updateOccupationJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getalloccupation")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<OccupationBean> arr = DBHandler.getAllOccupation( dbManager);
		//System.out.println(arr);
		send = JSONOccupation.getAllOccupationJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	

}
