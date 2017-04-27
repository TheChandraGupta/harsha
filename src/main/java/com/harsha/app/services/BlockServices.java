package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.StateBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONBlock;
import com.harsha.app.json.JSONState;

@Path("block")
public class BlockServices {
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addblock")
	public Response addBlock( @QueryParam("blockName") String blockName,
			@QueryParam("blockCode") String blockCode,
			@QueryParam("districtId") int districtId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addBlock(blockName, blockCode, districtId, dbManager);
		send = JSONBlock.addBlockJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("updateblock")
	public Response updateBlock( @QueryParam("blockId") int blockId,
			@QueryParam("blockCode") String blockCode,
			@QueryParam("blockName") String blockName,
			@QueryParam("districtId") int districtId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateBlock(blockId, blockCode,blockName ,districtId , dbManager);
		send = JSONBlock.updateBlockJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallblock")
	public Response getAllBlock() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<BlockBean> arr = DBHandler.getAllBlock( dbManager);
		//System.out.println(arr);
		send = JSONBlock.getAllBlockJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbydistrictid")
	public Response getBYDistrictIdBlock(@QueryParam("districtId") int districtId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<BlockBean> arr = DBHandler.getByDistrictIdBlock(districtId, dbManager);
		//System.out.println(arr);
		send = JSONBlock.getAllBlockJSON(arr);
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
		BlockBean arr = DBHandler.getByBlockIdBlock(blockId, dbManager);
		//System.out.println(arr);
		send = JSONBlock.getByBlockIdJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
