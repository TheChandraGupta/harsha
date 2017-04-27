package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.ProjectBean;
import com.harsha.app.bean.StateBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONProject;
import com.harsha.app.json.JSONState;

@Path("state")
public class StateService {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallstate")
	public Response getAllState() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<StateBean> arr = DBHandler.getAllState( dbManager);
		//System.out.println(arr);
		send = JSONState.getAllStateJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbystate")
	public Response getStateById( @QueryParam("stateId") int stateId
			) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		StateBean getByStateBean = DBHandler.getByState(stateId, dbManager);
		send = JSONState.getByStateJSON(getByStateBean);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addstate")
	public Response addState( @QueryParam("stateName") String stateName,
			@QueryParam("stateCode") String stateCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addState(stateName, stateCode, dbManager);
		send = JSONState.addStateJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("updatestate")
	public Response updateState( @QueryParam("stateName") String stateName,
			@QueryParam("stateCode") String stateCode,
			@QueryParam("stateId") int stateId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateState(stateName, stateCode, stateId, dbManager);
		send = JSONState.updateStateJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}


}
