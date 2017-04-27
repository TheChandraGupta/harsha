package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.ReligionBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONReligion;

@Path("religion")
public class ReligionServices {

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addReligion(@QueryParam("religionName")  String religionName,
			@QueryParam("religionCode")  int religionCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addReligion(religionName,religionCode, dbManager);
		send = JSONReligion.addReligionJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateReligion(@QueryParam("religionId")  int religionId,
			@QueryParam("religionName")  String religionName,
			@QueryParam("religionCode")  int religionCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateReligion(religionId,religionCode,religionName, dbManager);
		send = JSONReligion.updateReligionJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallreligion")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<ReligionBean> arr = DBHandler.getAllReligion( dbManager);
		//System.out.println(arr);
		send = JSONReligion.getAllReligionJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
