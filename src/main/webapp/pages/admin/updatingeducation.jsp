
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
<%@page import="com.harsha.app.bean.EducationBean"%>
    <%
  	
    String educationName = request.getParameter("educationName");
	int educationCode = Integer.parseInt(request.getParameter("educationCode"));
	int educationId = Integer.parseInt(request.getParameter("educationId"));
	DBManager dbManager=new DBManager();
	try {
	       	response.setContentType("text/html");
	       
	        int flag  = DBHandler.updateEducation(educationId,educationCode,educationName,  dbManager);
	        RequestDispatcher rd;
			if(flag==1) {
				
				String result = "ok";
	        	response.getWriter().write(result);
	        	System.out.println(flag);
			
			}
			else {
				
				String result = "na";
	        	response.getWriter().write(result);
	        	System.out.println(flag);
			
			}
	   } 
		catch (Exception e) {
	        e.printStackTrace();
	   }
		
		
    %>