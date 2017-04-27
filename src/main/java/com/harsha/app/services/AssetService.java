package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.AssetDataBean;
import com.harsha.app.bean.AssetInfoBean;
import com.harsha.app.bean.MemberBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONAsset;
import com.harsha.app.json.JSONDownload;
import com.harsha.app.json.JSONFamily;
import com.harsha.app.json.JSONMemberData;

@Path("assetdata")
public class AssetService {
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("upload")
	public Response addNewAssetData(String data) 	
		{
		
		String send = "";
		System.out.println("addNewAssetData:" + data);
		int status = 0;
		
		try {
			DBManager dbManager = new DBManager();
			AssetDataBean asset = JSONAsset.getAssetData(data);
			int flag = DBHandler.addNewAssetData(asset, dbManager);
			if(flag==0) {
				status=-1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			status=-1;
		}
		
		send = JSONFamily.getStatus(status);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	/*@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("download")
	public Response getAllAsset(String data) 	
		{
		
		String send = "";
		System.out.println("getAllAsset:" + data);
		int status = 0;
		
		ArrayList<MemberBean> member = null;
		
		try {
			DBManager dbManager = new DBManager();
			String lastUpdated = JSONDownload.getLastUpdated(data);
			String userId = JSONDownload.getUserId(data);
			member = DBHandler.getAllAsset (userId, lastUpdated, dbManager);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			status=-1;
		}
		
		send = JSONAsset.getAllAsset(status, member);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}*/
// Asset New Code Above
	
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response addAsset(@QueryParam("householdDataId")  int householdDatId, 
			@QueryParam("description")  String description,
			@QueryParam("assetId")  int assetId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addAsset(householdDatId, description, assetId, dbManager);
		send = JSONAsset.addAssetJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("update")
	public Response updateAsset(@QueryParam("householdDataId")  int householdDataId,
			@QueryParam("assetId")  int assetId,
			@QueryParam("description")  String description,
			@QueryParam("assetInfoId")  int assetInfoId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateAsset(assetId, householdDataId, description, assetInfoId, dbManager);
		send = JSONAsset.updateAssetJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addnewasset")
	public Response addAsset(
			@QueryParam("assetName")  String assetName,
			@QueryParam("assetCode")  String assetCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addNewAsset( assetName, assetCode, dbManager);
		send = JSONAsset.addNewAssetJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("updatenewasset")
	public Response addAsset(@QueryParam("assetId")  int assetId,
			@QueryParam("assetName")  String assetName,
			@QueryParam("assetCode")  String assetCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateNewAsset( assetId, assetName, assetCode, dbManager);
		send = JSONAsset.updateNewAssetJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallasset")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<AssetBean> arr = DBHandler.getAllAsset( dbManager);
		//System.out.println(arr);
		send = JSONAsset.getAllAssetJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbyassetid")
	public Response getByAssetId(@QueryParam("assetId")  int assetId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		AssetBean getByAssetIdBean = DBHandler.getByAssetId( assetId, dbManager);
		send = JSONAsset.getByAssetIdJSON(getByAssetIdBean);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	
}
