package com.harsha.constant;

public class Constant {
	
	/*
	 * Constants for Database Connection
	 */
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
	public static final String PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
	public static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/harsha";
	public static final String USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	public static final String PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"); 

	/*
	 * Constants for Web Services
	 */
	public static final String REST_RESPONSE_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
	public static final String REST_REQUEST_TYPE = "MediaType.APPLICATION_JSON";
		
}
