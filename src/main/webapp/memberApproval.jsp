
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
	    String memberId=request.getParameter("id");
    	String approval=request.getParameter("approvalStatus");
    	String remarks=request.getParameter("remark");
    	System.out.println(memberId + "-" + approval+ "-"+remarks);
    	DBManager dbManager=new DBManager();
	try {
	       	response.setContentType("text/html");
	       	String query = "update member set approvalStatus="+approval+",approvalRemark='"+remarks+"', lastUpdated=unix_timestamp() where memberId="+memberId;
	        int r = dbManager.getSt().executeUpdate(query);
			System.out.println("R="+r + "----" + query);
			
			dbManager.close();
	       
	   } 
		catch (Exception e) {
	        e.printStackTrace();
	   }
		
		
    %>