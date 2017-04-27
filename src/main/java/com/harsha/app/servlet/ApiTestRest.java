package com.harsha.app.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class ApiTestRest
 */
@WebServlet("/ApiTestRest")
public class ApiTestRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiTestRest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String regd = request.getParameter("regd");
		DBManager dbManager = new DBManager();
		String counter = "" + DBHandler.testingrest(regd, dbManager);
		RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
		request.setAttribute("counter", counter);
		rd.forward(request, response);
		
	}

}
