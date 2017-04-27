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
import com.harsha.app.bean.QualityOfLifeBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONAsset;
import com.harsha.app.json.JSONImpact;
import com.harsha.app.json.JSONProjectAssignment;
import com.harsha.app.json.JSONQualityOfLife;

@Path("qualityoflife")
public class QualityOfLifeServices {

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("uploadqualityoflife")
	public Response addNewQualityOfLife(String data) 
		{
		QualityOfLifeBean quality  = JSONQualityOfLife.getQualityOfLifeData(data);
		String send = "";
		System.out.println("addNewQualityOfLife:" + data);
		int status = 0;
		try {
			DBManager dbManager = new DBManager();
			if(DBHandler.addNewQualityOfLife(quality, dbManager) == 0) 
				status = -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			status = -1;
		}		

		send = JSONQualityOfLife.getStatus(status);			
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	

}
