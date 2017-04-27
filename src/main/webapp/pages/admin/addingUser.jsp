
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import=" javax.servlet.RequestDispatcher"%>
<%@page import ="javax.servlet.ServletException"%>
<%@page import ="javax.servlet.http.HttpServlet"%>
<%@page import ="javax.servlet.http.HttpServletRequest"%>
<%@page import ="javax.servlet.http.HttpServletResponse"%>
<%@page import ="javax.servlet.http.HttpSession"%>
<%@page import ="com.harsha.app.bean.StateBean"%>
<%@page import=" com.harsha.app.database.DBHandler"%>
<%@page import=" com.harsha.app.database.DBManager"%>
<%@page import=" com.harsha.app.bean.BlockBean"%>
<%@page import="com.harsha.app.bean.DistrictBean"%>
    <%
    String userName = "";
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	int    roleId = Integer.parseInt(request.getParameter("roleId"));
	String password = "";
	String email = request.getParameter("email");
	String address= request.getParameter("address");
	String phone =request.getParameter("phone");
	String photo =request.getParameter("photo");
	
	DBManager dbManager=new DBManager();
	try {
	       	response.setContentType("text/html");
	        DBHandler.signup(userName,lastName,firstName,password,email,phone,address,photo,roleId,dbManager);
	        String result = "ok";
        	response.getWriter().write(result);
	        RequestDispatcher rd;
			
	   } 
		catch (Exception e) {
	        e.printStackTrace();
	   }
		
		
    %>