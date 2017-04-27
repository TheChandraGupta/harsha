package com.harsha.app.constant;

public class Constant {

	/*
	 * Constant for Java Email Connection via SMTP
	 */
	public static final String EMAIL_HOST = "smtp.gmail.com";
	public static final String EMAIL_PORT = "587";
	public static final String EMAIL_USER = "harsha.trustproject@gmail.com";
	public static final String EMAIL_PASS = "harsha12345";
	//public static final String EMAIL_USER = "cbcs.cit@gmail.com";
	//public static final String EMAIL_PASS = "thedeciders";
	/*
	 * Constants for Database Connection
	 */
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static final String HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
	public static final String PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
	public static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/harsha";
	public static final String USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	public static final String PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"); 

	/*public static final String URL = "jdbc:mysql://localhost:3306/harsha";
	public static final String USER = "yushu";
	public static final String PASS = "yushu";
*/
	/*
	 * Constants for Web Services
	 */
	//public static final String REST_RESPONSE_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
	public static final String REST_RESPONSE_TYPE = "application/json";
	public static final String REST_REQUEST_TYPE = "MediaType.APPLICATION_JSON";

	public static final String DATA_DRIVE = System.getenv("OPENSHIFT_DATA_DIR");
	public static final String BASE_URL = "http://harsha-guptas.rhcloud.com/";
	public static final String REPLACE_URL = "/DataFileUploadDownload/";
	public static final String REPLACE_URL2 = "/TableDataDownload/";
	/*
	public static final String DATA_DRIVE = "/home/ec2-user/uploads";
	public static final String BASE_URL = "http://ec2-34-209-227-210.us-west-2.compute.amazonaws.com:8080/harsha";
	public static final String REPLACE_URL = "/harsha/DataFileUploadDownload/";
	public static final String REPLACE_URL2 = "/harsha/TableDataDownload/";*/
	

}
