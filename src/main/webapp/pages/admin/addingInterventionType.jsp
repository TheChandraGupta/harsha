
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
<%@page import=" com.harsha.app.bean.ProjectBean"%>
<%@page import="com.harsha.app.bean.ProjectTypeBean"%>
    <%

    String projectTypeName = request.getParameter("projectTypeName");
	DBManager dbManager=new DBManager();
	try {
	        response.setContentType("text/html");
	        int flag =DBHandler.addInterventionType(projectTypeName, dbManager);
	        RequestDispatcher rd;
			if(flag==1) {
				String result = "ok";
	        	response.getWriter().write(result);
			
			}
			else {
				String result = "na";
	        	response.getWriter().write(result);
			
			}
	   } 
		catch (Exception e) {
	        e.printStackTrace();
	   }
		
		
    %>