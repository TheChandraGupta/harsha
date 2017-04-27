package com.harsha.app.servlet.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;

import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.util.ExcelRead;

/**
 * Servlet implementation class TableDataDownload
 */
@WebServlet(name = "TableDataDownload",urlPatterns = {"/TableDataDownload/*"})
public class TableDataDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
int BUFFER_LENGTH = 4096;

String fileNameAssigned = "";
String fileNameGiven = "";
String excelType = "";
   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableDataDownload() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public JSONArray agricultureImpactReport() {
		DBManager dbManager=new DBManager();
		JSONArray jsonArray = DBHandler.getAgricultureImpactReport(0, new Date().getTime()/1000, dbManager);
		dbManager.close();
		return jsonArray;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = request.getRequestURI();
		System.out.println(filePath);
		
		String impactName = filePath.replace(Constant.REPLACE_URL2,"");
		System.out.println(impactName);
		
		JSONArray jsonArray = new JSONArray();
		
		if(impactName.equals("agriculture.xls")) {
			jsonArray = agricultureImpactReport();
			filePath = ExcelRead.generateExcelReport(jsonArray, impactName);
		}			
		System.out.println(jsonArray.toString());
		System.out.println("filepath=" + filePath);
		String path = Constant.DATA_DRIVE + filePath;
		System.out.println("path=" + path);
		 
		File file = new File(path);
	    InputStream input = new FileInputStream(file);
	 
	    response.setContentLength((int) file.length());
	    response.setContentType(new MimetypesFileTypeMap().getContentType(file));
	 
	    OutputStream output = response.getOutputStream();
	    byte[] bytes = new byte[BUFFER_LENGTH];
	    int read = 0;
	    while ((read = input.read(bytes, 0, BUFFER_LENGTH)) != -1) {
	        output.write(bytes, 0, read);
	        output.flush();
	    }
	 
	    input.close();
	    output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
