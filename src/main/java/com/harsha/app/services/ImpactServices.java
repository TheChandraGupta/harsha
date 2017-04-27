package com.harsha.app.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.ImpactBean;
import com.harsha.app.bean.ProjectAssignmentBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONAsset;
import com.harsha.app.json.JSONImpact;
import com.harsha.app.json.JSONProjectAssignment;

@Path("impact")
public class ImpactServices {

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("uploadimpact")
	public Response addNewImpact(String data) 
		{
		ImpactBean impact  = JSONImpact.getImpactData(data);
		String send = "";
		System.out.println("addNewImpact:" + data);
		int status = 0;
		try {
			DBManager dbManager = new DBManager();
			if(DBHandler.addNewImpact(impact, dbManager) == 0) 
				status = -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			status = -1;
		}		

		send = JSONImpact.getStatus(status);			
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addpolutry")
	public Response addAsset(@QueryParam("householdDataId")  int householdDataId,
			@QueryParam("noOfBatches") int noOfBatches, 
			@QueryParam("totalChicksPlacement") int totalChicksPlacement, 
			@QueryParam("mortality") int mortality, 
			@QueryParam("totalFeedConsumption") int totalFeedConsumption, 
			@QueryParam("FCR") int FCR, 
			@QueryParam("totalIncome") int totalIncome, 
			@QueryParam("baselineIncome") int baselineIncome, 
			@QueryParam("incrementalIncome") int incrementalIncome) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addPolutry(householdDataId, noOfBatches, totalChicksPlacement, mortality, totalFeedConsumption, FCR,
				totalIncome, baselineIncome, incrementalIncome, dbManager);
		send = JSONImpact.addImpactJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addvegitable")
	public Response addAsset(@QueryParam("householdDataId")  int householdDataId,
			@QueryParam("land")  int land,
			@QueryParam("noOfPlants")  int noOfPlants,
			@QueryParam("income")  int income,
			@QueryParam("production")  int production) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addVegitable(land, noOfPlants, income, production, householdDataId, dbManager);
		send = JSONImpact.addVegitableJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	

	@GET
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addgoat")
	public Response addGoat(@QueryParam("householdDataId")  int householdDataId,
			@QueryParam("noOfGoatAtBegening")  int noOfGoatAtBegening, 
			@QueryParam("presentGoatNos")  int presentGoatNos, 
			@QueryParam("goatSales")  int goatSales, 
			@QueryParam("mortality")  int mortality, 
			@QueryParam("goatValueAtBegening")  int goatValueAtBegening, 
			@QueryParam("presentValueOfGoat")  int presentValueOfGoat, 
			@QueryParam("salesOfGoat")  int salesOfGoat,
			@QueryParam("totalIncome")  int totalIncome,
			@QueryParam("baselineIncome")  int baselineIncome,
			@QueryParam("netIncrement")  int netIncrement) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addGoat(noOfGoatAtBegening, presentGoatNos, goatSales, mortality, goatValueAtBegening, presentValueOfGoat, salesOfGoat,
				totalIncome, baselineIncome, netIncrement, householdDataId, dbManager);
		send = JSONImpact.addGoatJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@GET
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addImpactDataType")
	public Response addImpactDataType(@QueryParam("impactDatatypeName") String impactDatatypeName,
			@QueryParam("tableName") String tableName) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addImpactDatatype(impactDatatypeName, tableName, dbManager);
		send = JSONImpact.addImpactDatatypeJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
