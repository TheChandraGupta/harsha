package com.harsha.app.servlet.manager;

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
 * Servlet implementation class ManagerAssignment
 */
@WebServlet("/ManagerAssignment")
public class ManagerAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAssignment() {
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
	 String supervisors[]=request.getParameterValues("supervisorId");
	 System.out.println(supervisors);
	 int userId=Integer.parseInt(request.getParameter("userId"));
	 System.out.println(userId);
	 DBManager dbManager=new DBManager();
	 HttpSession session=request.getSession();
	 int flag=0;
	 for(String supervisorId:supervisors)
	 {
		 System.out.println(Integer.parseInt(supervisorId));
		 flag =DBHandler.addManagerAssignment(userId, Integer.parseInt(supervisorId), dbManager);
	 }
	 if(flag>0)
	 {
		 RequestDispatcher rd= request.getRequestDispatcher("adminManager2.jsp?userId="+userId);
		 rd.forward(request, response);
	 }
	 else
	 {
		 RequestDispatcher rd= request.getRequestDispatcher("adminManager2.jsp?userId="+userId);
		 rd.forward(request, response);
	 }
	}

}
