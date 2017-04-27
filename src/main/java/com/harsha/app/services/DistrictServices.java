package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.DistrictBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONAsset;
import com.harsha.app.json.JSONDistrict;


@Path("district")
public class DistrictServices {
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbydistrictid")
	public Response getAllDistrict(@QueryParam("districtId") int districtId
			) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		DistrictBean getByDistrictIdBean = DBHandler.getByDistrictId(districtId, dbManager);
		send = JSONDistrict.getByDistrictIdJSON(getByDistrictIdBean);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbystateid")
	public Response getStateById( @QueryParam("stateId") int stateId
			) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<DistrictBean> getByStateIdBean = DBHandler.getByStateId(stateId, dbManager);
		send = JSONDistrict.getByStateIdJSON(getByStateIdBean);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("adddistrict")
	public Response addDistrict( @QueryParam("districtName") String districtName,
			@QueryParam("districtCode") String districtCode,
			@QueryParam("stateId") int stateId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addDistrict(districtName, districtCode, stateId, dbManager);
		send = JSONDistrict.addDistrictJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("updatedistrict")
	public Response updateDistrict( @QueryParam("districtId") int districtId,
			@QueryParam("districtCode") String districtCode,
			@QueryParam("districtName") String districtName,
			@QueryParam("stateId") int stateId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateDistrict(districtId, districtCode,districtName ,stateId , dbManager);
		send = JSONDistrict.updateDistrictJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getalldistrict")
	public Response getAllAsset() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<DistrictBean> arr = DBHandler.getAllDistrict( dbManager);
		//System.out.println(arr);
		send = JSONDistrict.getAllDistrictJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}


}
