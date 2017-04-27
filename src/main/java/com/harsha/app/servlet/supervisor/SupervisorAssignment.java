package com.harsha.app.servlet.supervisor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class SupervisorAssignment
 */
@WebServlet("/SupervisorAssignment")
public class SupervisorAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		int districtId = Integer.parseInt(request.getParameter("districtId"));
		int blockId = Integer.parseInt(request.getParameter("blockId"));
		//int villageId = Integer.parseInt(request.getParameter("villageId"));
		 String villageId[]=request.getParameterValues("villageId");
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag=0;
		for(String villageId1:villageId)
		 {
			 flag =DBHandler.addSupervisorAssignment(userId, stateId, districtId, blockId, Integer.parseInt(villageId1), dbManager);
		 }
		
		if(flag>0)
		{
			RequestDispatcher rd= request.getRequestDispatcher("adminSupervisor2.jsp?userId="+userId);
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("adminSupervisor.jsp");
			rd.forward(request, response);
		}
	}

}
