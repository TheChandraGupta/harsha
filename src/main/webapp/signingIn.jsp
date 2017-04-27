
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
	    String username=request.getParameter("userName");
		String password=request.getParameter("password");
		try {
			DBManager dbManager=new DBManager();
			
	        ResultSet r = dbManager.getSt().executeQuery("select * from user where userName='"+username+"'and password='"+password+"'");
			r.last();
			
			UserViewBean userBean=DBHandler.login(username, password, dbManager);
			response.setContentType("text/html");  
	        if(r.getRow()>0)
	        {
	        	session = request.getSession(true);
				session.setAttribute("userDetail", userBean);
	        	if(userBean.getRole().equalsIgnoreCase("ADMIN"))
				{
					
					request.setAttribute("user", userBean);
					String result = "ad";
		        	response.getWriter().write(result);
				}	
	        	else if(userBean.getRole().equalsIgnoreCase("MANAGER"))
				{
	        		request.setAttribute("user", userBean);
	        		String result = "ma";
	        		response.getWriter().write(result);
				}
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