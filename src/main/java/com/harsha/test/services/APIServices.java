package com.harsha.test.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harsha.constant.Constant;
import com.harsha.test.database.DBManager;
import com.harsha.test.database.DBQuery;
import com.harsha.test.json.JSONTest;

@Path("test")
public class APIServices {
	
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("status")
	public Response apiTest() {
		System.out.println("apiTest");
		return Response.ok("{'msg': 'API Connection Successful'}")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	//@Consumes(Constant.REST_RESPONSE_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("developer")
	public Response checkDeveloperCount(
			@QueryParam("regd") String regd) {
		System.out.println("checkDeveloperCount");
		
		String send = "checkDeveloperCount";
		
		DBManager dbManager = new DBManager();
		
		send = JSONTest.testingRestJSON(DBQuery.testingrest(regd, dbManager));
		/*
		send = send + "\n"
				+ Constant.DRIVER + "\n"
				+ Constant.URL + "\n"
				+ Constant.USER + "\n"
				+ Constant.PASS + "\n";
		*/
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	//@Consumes(Constant.REST_RESPONSE_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("developer2")
	public Response checkDeveloperCount2(
			@QueryParam("regd") String regd) {
		System.out.println("checkDeveloperCount");
		
		String send = "checkDeveloperCount";
		
		DBManager dbManager = new DBManager();
		
		send = JSONTest.testingRestJSON(DBQuery.testingrest(regd, dbManager));
		/*
		send = send + "\n"
				+ Constant.DRIVER + "\n"
				+ Constant.URL + "\n"
				+ Constant.USER + "\n"
				+ Constant.PASS + "\n";
		*/
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
