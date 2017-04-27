package com.harsha.app.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harsha.app.bean.UserViewBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBManager;
import com.harsha.app.database.DBHandler;
import com.harsha.app.json.JSONCheckpoint;
import com.harsha.app.json.JSONSignup;
import com.harsha.app.json.JSONTest;



@Path("test")
public class APIServices {

	@GET
	//@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("status")
	public Response apiTest() {
		System.out.println("apiTest");
		return Response.ok("{'msg': 'API Connection Successful'}")
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("developer")
	public Response checkDeveloperCount(@QueryParam("regd") String regd) {
		System.out.println("checkDeveloperCount");
		
		String send = "checkDeveloperCount";
		
		DBManager dbManager = new DBManager();
		
		send = JSONTest.testingRestJSON(DBHandler.testingrest(regd, dbManager));
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("signup")
	public Response signUp(@QueryParam("firstName") String firstName, 
			@QueryParam("lastName") String lastName, 
			@QueryParam("roleId")  	int roleId,
			@QueryParam("userName") String userName, 
			@QueryParam("password") String password,
			@QueryParam("email")  	String email,
			@QueryParam("phone")  	String phone,
			@QueryParam("address")  String address,
			@QueryParam("photo")  	String photo
			)
		{
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(roleId);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(address);
		System.out.println(photo);
		String send = "";
		
		DBManager dbManager = new DBManager();
		DBHandler.signup(firstName,lastName,userName,password,email,phone,address,photo,roleId, dbManager);
		send = JSONSignup.signupJSON();
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("login")
	public Response login(@QueryParam("userName")  String userName, 
			@QueryParam("password")  String password) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		UserViewBean userBean = DBHandler.login(userName,password, dbManager);
		send = JSONCheckpoint.loginJSON(userBean);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	/*
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("status")
	public Response apiTest() {
		System.out.println("apiTest");
		return Response.ok("{'msg': 'API Connection Successful'}")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Consumes(Constant.REST_RESPONSE_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("developer")
	public Response checkDeveloperCount(
			@FormParam("regd") String regd) {
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
	/*
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
*/
}
