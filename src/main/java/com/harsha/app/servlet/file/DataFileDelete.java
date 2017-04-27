package com.harsha.app.servlet.file;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBManager;
import com.harsha.app.database.DataUpload;

/**
 * Servlet implementation class DataFileDelete
 */
@WebServlet("/DataFileDelete")
public class DataFileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataFileDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = Constant.DATA_DRIVE + request.getParameter("fileName");
		String serverDocumentsId = request.getParameter("serverDocumentsId");

		DBManager dbManager = new DBManager();
		System.out.println(filePath);
		RequestDispatcher rd = request.getRequestDispatcher("adminUploadExcel.jsp");
		File file = new File(filePath);
		if(file.delete()) {
			DataUpload.deleteFileFromServer(serverDocumentsId, dbManager);
			System.out.println("Done");
		    request.setAttribute("msg", "Data Delete Successful");
		}
		else {
			request.setAttribute("msg", "Data Delete Unsuccessful");
			System.out.println("Not Done");
		}
		dbManager.close();
	    rd.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
