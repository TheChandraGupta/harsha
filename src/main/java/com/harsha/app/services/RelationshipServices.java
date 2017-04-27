package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.OccupationBean;
import com.harsha.app.bean.RelationshipBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONOccupation;
import com.harsha.app.json.JSONRelationship;

@Path("relationship")
public class RelationshipServices {

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addRelationship(@QueryParam("relationshipName")  String relationshipName,
			@QueryParam("relationshipCode")  int relationshipCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addRelationship(relationshipName,relationshipCode, dbManager);
		send = JSONRelationship.addRelationshipJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateRelationship(@QueryParam("relationshipId")  int relationshipId,
			@QueryParam("relationshipName")  String relationshipName,
			@QueryParam("relationshipCode")  int relationshipCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateRelationship(relationshipId,relationshipCode,relationshipName, dbManager);
		send = JSONRelationship.updateRelationshipJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallrelationship")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<RelationshipBean> arr = DBHandler.getAllRelationship( dbManager);
		//System.out.println(arr);
		send = JSONRelationship.getAllRelationshipJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
