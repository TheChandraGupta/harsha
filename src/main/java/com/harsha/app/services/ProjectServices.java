package com.harsha.app.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.ProjectAssignmentBean;
import com.harsha.app.bean.ProjectBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONDownload;
import com.harsha.app.json.JSONProject;
import com.harsha.app.json.JSONProjectAssignment;

@Path("project")
public class ProjectServices {
	

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("uploadprojectassignment")
	public Response addNewProjectAssignment(String data) 
		{
		ProjectAssignmentBean project  = JSONProjectAssignment.getprojectAssignmentData(data);
		String send = "";
		System.out.println("addNewProjectAssignment:" + data);
		int status = 0;
		try {
			DBManager dbManager = new DBManager();
			if(DBHandler.addNewProjectAssignment(project, dbManager) == 0) 
				status = -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			status = -1;
		}		

		send = JSONProjectAssignment.getStatus(status);			
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("downloadprojectassignment")
	public Response getProjectAssignment(String data) 
		{
		
		String send = "";
		System.out.println("getProjectAssignment:" + data);
		int status = 0;
		
		ArrayList<ProjectAssignmentBean> project = null;
		
		try {
			
			DBManager dbManager = new DBManager();
			String lastUpdated = JSONDownload.getLastUpdated(data);
			String userId = JSONDownload.getUserId(data);
			project = DBHandler.getAllProjectAssignment(userId, lastUpdated, dbManager);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			status=-1;
		}
		
		send = JSONProjectAssignment.setProjectAssignmentData(status, project);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("addproject")
	public Response addProject(
			@QueryParam("projectName")  String projectName,
			@QueryParam("donorName")  String donerName) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.addProject( projectName, donerName, dbManager);
		send = JSONProject.addProjectJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("updateproject")
	public Response updateProject( @QueryParam("projectId")  int projectId,
			@QueryParam("projectName")  String projectName,
			@QueryParam("donorName")  String donerName) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.updateProject(projectId, projectName, donerName, dbManager);
		send = JSONProject.updateProjectJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("getallproject")
	public Response getAllProject() 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		ArrayList<ProjectBean> arr = DBHandler.getAllProject( dbManager);
		//System.out.println(arr);
		send = JSONProject.getAllProjectJSON(arr);
		//System.out.println(send);
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
