package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.bean.MemberDataBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONHousehold;
import com.harsha.app.json.JSONMemberData;

@Path("memberdata")
public class MemberDataServices {
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("add")
	public Response getAllDistrict( @QueryParam("houseHoldDataId")		int houseHoldDataId,  
			@QueryParam("stateId")				int stateId,
			@QueryParam("districtId")			int districtId,
			@QueryParam("blockId")  			int blockId,
			@QueryParam("villageId") 			int villageId,
			@QueryParam("name")  				String name,
			@QueryParam("gender")  				String gender,
			@QueryParam("relationshipId") 		int relationshipId,
			@QueryParam("dob") 					String dob,
			@QueryParam("age") 					int age,
			@QueryParam("maritalStatusId") 		int maritalStatusId,
			@QueryParam("educationId")  		int educationId,
			@QueryParam("educationStatusId") 	int educationStatusId,
			@QueryParam("aadharCard") 			String aadharCard,
			@QueryParam("electionCard") 		String electionCard,
			@QueryParam("addressPermanent") 	String addressPermanent,
			@QueryParam("pincodePermanent") 	String pincodePermanent,
			@QueryParam("addressCurrent") 		String addressCurrent,
			@QueryParam("pincodeCurrent") 		String pincodeCurrent,
			@QueryParam("disabilityId") 		int disabilityId,
			@QueryParam("schemeId") 			int schemeId,
			@QueryParam("incomeAnnual") 		int incomeAnnual,
			@QueryParam("emailId") 				String emailId,
			@QueryParam("mobileNumber") 		String mobileNumber,
			@QueryParam("alternateNumberWith") 	String alternateNumberWith,
			@QueryParam("occupationId") 		int occupationId,
			@QueryParam("statusCode") 		String statusCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addMemberDataService(houseHoldDataId, stateId, districtId, blockId, villageId, name, gender,
				relationshipId, dob, age, maritalStatusId, educationId, educationStatusId, aadharCard, electionCard, addressPermanent,
				pincodePermanent, addressCurrent, pincodeCurrent, disabilityId, schemeId, incomeAnnual, emailId, mobileNumber, alternateNumberWith ,
				occupationId, dbManager);
		send = JSONMemberData.addMemberDataJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallmemberdata")
	public Response getAllMemberdata() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<MemberDataBean> arr = DBHandler.getAllMemberData( dbManager);
		//System.out.println(arr);
		send = JSONMemberData.getAllMemberdataJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbyvillage")
	public Response getByVillageMemberdata(@QueryParam("villageId")		int villageId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<MemberDataBean> arr = DBHandler.getByVillageMemberData(villageId, dbManager);
		//System.out.println(arr);
		send = JSONMemberData.getByVillageMemberdataJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbyblock")
	public Response getByBlockMemberdata(@QueryParam("blockId")		int blockId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<MemberDataBean> arr = DBHandler.getByBlockMemberData(blockId, dbManager);
		//System.out.println(arr);
		send = JSONMemberData.getByBlockMemberdataJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbydistrict")
	public Response getByDistrictMemberdata(@QueryParam("districtId")		int districtId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<MemberDataBean> arr = DBHandler.getByDistrictMemberData(districtId, dbManager);
		//System.out.println(arr);
		send = JSONMemberData.getByDistrictMemberdataJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getbystate")
	public Response getByStateMemberdata(@QueryParam("stateId")		int stateId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<MemberDataBean> arr = DBHandler.getByStateMemberData(stateId, dbManager);
		//System.out.println(arr);
		send = JSONMemberData.getByStateMemberdataJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("verification")
	public Response verification(@QueryParam("memberdataId")		int memberdataId,
			@QueryParam("statusCode")		String statusCode) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.verificationMember(memberdataId, statusCode, dbManager);
		//System.out.println(arr);
		send = JSONMemberData.verificationMemberJSON(flag);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
