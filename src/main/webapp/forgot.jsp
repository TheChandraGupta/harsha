
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     %>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.harsha.app.bean.UserViewBean" %>
<%@page import="com.harsha.app.database.DBHandler" %>
<%@page import="com.harsha.app.database.DBManager" %>
    
    <%
	    
		String email=request.getParameter("email");
		try {
			DBManager dbManager=new DBManager();
			
	        ResultSet r = dbManager.getSt().executeQuery("select email from user where email='"+email+"'");
			r.last();
			response.setContentType("text/html");  
	        if(r.getRow()>0)
	        {
	        	
								
	        		 String result = "ad";
		        	response.getWriter().write(result);
				
	        }
	        else{
	        	String result = "na";
	        	response.getWriter().write(result);
	        }
	        //con.close();
	   } catch (Exception e) {
	        e.printStackTrace();
	   }
		
		
    %>