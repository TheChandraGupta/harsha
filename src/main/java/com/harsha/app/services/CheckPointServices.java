package com.harsha.app.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harsha.app.util.*;
import com.harsha.app.bean.UserViewBean;
import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.json.JSONCheckpoint;
import com.harsha.app.util.EmailSendingServlet;

@Path("checkpoint")
public class CheckPointServices {
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login")
	public Response login(String data) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		UserViewBean userBean = DBHandler.login(JSONCheckpoint.getUserNameParseJSON(data),
				JSONCheckpoint.getPasswordParseJSON(data), 
				dbManager);
		send = JSONCheckpoint.loginJSON(userBean);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("checkusername")
	public Response checkUserName(@QueryParam("username")  String username) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		UserViewBean userBean = DBHandler.checkUsername(username, dbManager);
		send = JSONCheckpoint.checkUsernameJSON(userBean);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("enable")
	public Response enable(	@QueryParam("userId")  int userId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.enableUser(userId,dbManager);
		send = JSONCheckpoint.enableJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("disable")
	public Response disable(	@QueryParam("userId")  int userId) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.disableUser(userId,dbManager);
		send = JSONCheckpoint.disableJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("changepassword")
	public Response changePassword(	@QueryParam("userId")  int userId,
			@QueryParam("oldPassword")  String oldPassword,
			@QueryParam("newPassword")  String newPassword) 
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		int flag = DBHandler.changePassword(userId,oldPassword,newPassword,dbManager);
		send = JSONCheckpoint.changePasswordJSON(flag);
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Produces(Constant.REST_RESPONSE_TYPE)
	@Path("forgetpassword")
	public Response forgetPassword(	@QueryParam("username")  String username)
		{
		
		String send = "";
		DBManager dbManager = new DBManager();
		UserViewBean userBean = DBHandler.forgetPassword(username,dbManager);
		send = JSONCheckpoint.forgetPasswordJSON(userBean);
		if(userBean == null || userBean.getUserId()==0 ) {
			System.out.println("LOGIN = " + "INVALID EMAIL" +" : User = " + userBean);
		}
		else {

			EmailSendingServlet mail =new EmailSendingServlet();
			
			String recipient =userBean.getEmail();
			String subject = "Password Recovered";
			String content = "Dear "+ userBean.getUserName() +",\n\n"
					+ "Your password has been recovered\n"
					+ "Email : "+userBean.getEmail()+"\n"
							+ "Password : "+userBean.getPassword();
			
			mail.setRecipient(recipient);
			mail.setSubject(subject);
			mail.setContent(content);
			
			MailThread sendMail = new MailThread(mail);
			sendMail.start();
			
			System.out.println("FORGET = " + "VALID EMAIL" +" : User = " + userBean);
					
		}
		
		
		return Response.ok(send)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

}
