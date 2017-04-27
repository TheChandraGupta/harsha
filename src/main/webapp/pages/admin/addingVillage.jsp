
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
<%@page import="com.harsha.app.bean.VillageBean"%>
    <%
    String villageName = request.getParameter("villageName");
	String villageCode = request.getParameter("villageCode");
	int blockId = Integer.parseInt(request.getParameter("blockId"));
	DBManager dbManager=new DBManager();
	try {
	        
	        response.setContentType("text/html");
	        int flag =DBHandler.addVillage(villageName, villageCode, blockId, dbManager);
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