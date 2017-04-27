package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.FamilyBean;
import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.bean.MemberBean;
import com.harsha.app.bean.MemberDataBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONDownload;
import com.harsha.app.json.JSONFamily;
import com.harsha.app.json.JSONHousehold;
import com.harsha.app.json.JSONMemberData;

@Path("member")
public class MemberServices {
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("upload")
	public Response addNewMember(String data) 	
		{
		
		String send = "";
		System.out.println("addNewMember:" + data);
		int status = 0;
		
		try {
			DBManager dbManager = new DBManager();
			MemberBean member = JSONMemberData.getMemberData(data);
			int flag = DBHandler.addNewMember(member, dbManager);
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
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("download")
	public Response getAllMember(String data) 	
		{
		
		String send = "";
		System.out.println("getAllMember:" + data);
		int status = 0;
		
		ArrayList<MemberBean> member = null;
		
		try {
			DBManager dbManager = new DBManager();
			String lastUpdated = JSONDownload.getLastUpdated(data);
			String userId = JSONDownload.getUserId(data);
			member = DBHandler.getAllMember(userId, lastUpdated, dbManager);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			status=-1;
		}
		
		send = JSONMemberData.getAllMember(status, member);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
}
