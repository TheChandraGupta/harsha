package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.SchemeBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONScheme;

@Path("scheme")
public class SchemeServices {
	

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addScheme(@QueryParam("schemeName")  String schemeName)
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addScheme(schemeName, dbManager);
		send = JSONScheme.addSchemeJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateScheme(@QueryParam("schemeId")  int schemeId,
			@QueryParam("schemeName")  String schemeName) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateScheme(schemeId,schemeName, dbManager);
		send = JSONScheme.updateSchemeJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallscheme")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<SchemeBean> arr = DBHandler.getAllScheme( dbManager);
		//System.out.println(arr);
		send = JSONScheme.getAllSchemeJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
