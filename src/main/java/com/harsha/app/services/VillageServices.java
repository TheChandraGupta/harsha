package com.harsha.app.services;

import java.util.ArrayList;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.VillageBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONVillage;
import com.harsha.app.json.JSONBlock;

@Path("village")
public class VillageServices {

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addvillage")
	public Response addVillage( @QueryParam("villageName") String villageName,
			@QueryParam("villageCode") String villageCode,
			@QueryParam("blockId") int blockId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addVillage(villageName, villageCode, blockId, dbManager);
		send = JSONVillage.addVillageJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("updatevillage")
	public Response updateVillage( @QueryParam("villageId") int villageId,
			@QueryParam("villageCode") String villageCode,
			@QueryParam("villageName") String villageName,
			@QueryParam("blockId") int blockId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateVillage(villageId, villageCode, villageName , blockId , dbManager);
		send = JSONVillage.updateVillageJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallvillage")
	public Response getAllVillage() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<VillageBean> arr = DBHandler.getAllVillage(0, dbManager);
		//System.out.println(arr);
		send = JSONVillage.getAllVillageJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbyvillageid")
	public Response getByVillageId(@QueryParam("villageId") int villageId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		VillageBean village = DBHandler.getByVillageId(villageId, dbManager);
		//System.out.println(arr);
		send = JSONVillage.getByVillageIdJSON(village);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbyblockid")
	public Response getByBlockId(@QueryParam("blockId") int blockId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<VillageBean> arr = DBHandler.getByBlockId(blockId, dbManager);
		//System.out.println(arr);
		send = JSONVillage.getByBlockIdJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
