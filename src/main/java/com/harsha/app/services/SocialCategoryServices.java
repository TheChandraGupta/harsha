package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.OccupationBean;
import com.harsha.app.bean.SocialCategoryBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONOccupation;
import com.harsha.app.json.JSONSocialCategory;

@Path("social")
public class SocialCategoryServices {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addSocialCategory(@QueryParam("socialCategoryName")  String socialCategoryName,
			@QueryParam("socialCategoryCode")  int socialCategoryCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addSocialCategory(socialCategoryName,socialCategoryCode, dbManager);
		send = JSONSocialCategory.addSocialCategoryJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateSocialCategory(@QueryParam("socialCategoryId")  int socialCategoryId,
			@QueryParam("socialCategoryName")  String socialCategoryName,
			@QueryParam("socialCategoryCode")  String socialCategoryCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateSocialCategory(socialCategoryId,socialCategoryCode,socialCategoryName, dbManager);
		send = JSONSocialCategory.updateSocialCategoryJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallsocialcategory")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<SocialCategoryBean> arr = DBHandler.getAllSocialCategory( dbManager);
		//System.out.println(arr);
		send = JSONSocialCategory.getAllSocialCategoryJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
