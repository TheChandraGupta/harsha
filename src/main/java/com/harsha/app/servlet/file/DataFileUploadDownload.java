package com.harsha.app.servlet.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jettison.json.JSONArray;

import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBManager;
import com.harsha.app.database.DataUpload;
import com.harsha.app.util.ExcelRead;

@WebServlet(name = "DataFileUploadDownload",urlPatterns = {"/DataFileUploadDownload/*"})
public class DataFileUploadDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int BUFFER_LENGTH = 4096;

	String fileNameAssigned = "";
	String fileNameGiven = "";
	String excelType = "";
       
    public DataFileUploadDownload() {
        super();
    }

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = request.getRequestURI();
		 
		File file = new File(Constant.DATA_DRIVE + filePath.replace("/uploads/",""));
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    PrintWriter out = response.getWriter();
	    String q = null;
	    String n = "";
	    for (Part part : request.getParts()) {
	    	n = request.getPart(part.getName()).getName();
	        InputStream is = request.getPart(part.getName()).getInputStream();
	        String fileName = getFileName(part);
	        fileNameGiven = fileName;
	        fileNameAssigned = "" + DataUpload.getCurrentTime();
	        FileOutputStream os = new FileOutputStream(Constant.DATA_DRIVE + fileName);
	        byte[] bytes = new byte[BUFFER_LENGTH];
	        int read = 0;
	        while ((read = is.read(bytes, 0, BUFFER_LENGTH)) != -1) {
	            os.write(bytes, 0, read);
	        }
	        os.flush();
	        is.close();
	        os.close();
	        out.println(fileName + " was uploaded to " + Constant.DATA_DRIVE);
	        q = fileName;
	    }
	    RequestDispatcher rd = request.getRequestDispatcher("adminUploadExcel.jsp");
	    request.setAttribute("msg", "Data Upload Successful");
	    rd.forward(request, response);
	    //response.sendRedirect("img.jsp?q="+q+"&n="+n);
	}
	
	private String getFileName(Part part) {
		String givenName = null;
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				givenName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	      	}
	    }
		return givenName;
	}*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String filePath = request.getRequestURI();
		 
		File file = new File(Constant.DATA_DRIVE + filePath.replace(Constant.REPLACE_URL,""));
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DBManager dbManager = new DBManager();
		out.println("Hello<br/>");

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			out.println("You are not trying to upload<br/>");
			return;
		}
		out.println("You are trying to upload<br/>");

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			out.println("Number of fields: " + fields.size() + "<br/><br/>");
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				out.println("No fields found");
				return;
			}
			out.println("<table border=\"1\">");
			while (it.hasNext()) {
				out.println("<tr>");
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					out.println("<td>regular form field</td><td>FIELD NAME: " + fileItem.getFieldName() + 
							"<br/>STRING: " + fileItem.getString()
							);
					out.println("</td>");
					if(fileItem.getFieldName().equals("fileName"))
						excelType = fileItem.getString();
				} else {
					out.println("<td>file form field</td><td>FIELD NAME: " + fileItem.getFieldName() +
							//"<br/>STRING: " + fileItem.getString() +
							"<br/>NAME: " + fileItem.getName() +
							"<br/>CONTENT TYPE: " + fileItem.getContentType() +
							"<br/>SIZE (BYTES): " + fileItem.getSize() +
							"<br/>TO STRING: " + fileItem.toString()
							);
					  fileNameGiven = fileItem.getName();
					 fileNameAssigned = DataUpload.getCurrentTime() + "" + getFileName(fileNameGiven);
					String path = Constant.DATA_DRIVE + ""+ fileNameAssigned;
					System.out.println(path);
					File fileUpload = new File(path);
					fileItem.write(fileUpload);
					out.println("</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			DataUpload.insertNewUploadFileDetails(fileNameGiven, fileNameAssigned, dbManager);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		uploadExcelData(Constant.DATA_DRIVE + ""+ fileNameAssigned, excelType, dbManager);
		dbManager.close();
	    RequestDispatcher rd = request.getRequestDispatcher("adminUploadExcel.jsp");
	    request.setAttribute("msg", "Data Upload Successful");
	    rd.forward(request, response);
	}
	
	private String getFileName(String fileName) {
		return fileName.substring(fileName.indexOf('.')).trim();
	}
	
	private void uploadExcelData(String fileNameAssigned, String excelType, DBManager dbManager) throws IOException {
		ExcelRead er = new ExcelRead();
		if(excelType.equals("Family")) {
			JSONArray jArray = er.readBooksFromExcelFile(fileNameAssigned, excelType);
			DataUpload.uploadFamilyArchieve(jArray, dbManager);
		}			
		else if(excelType.equals("Member")) {
			JSONArray jArray = er.readBooksFromExcelFile(fileNameAssigned, excelType);
			DataUpload.uploadMemberArchieve(jArray, dbManager);
		}			
	}

}
