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
 * Servlet implementation class UpdateManager
 */
@WebServlet("/UpdateManager")
public class UpdateManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManager() {
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
		 int userId=Integer.parseInt(request.getParameter("userId"));
		 int roleId=Integer.parseInt(request.getParameter("roleId"));
		 String userName= request.getParameter("userName");
		 String password= request.getParameter("password");
		 String statusCode= request.getParameter("statusCode");
		 String firstName= request.getParameter("firstName");
		 String lastName= request.getParameter("lastName");
		 String email= request.getParameter("email");
		 String phone= request.getParameter("phone");
		 String address= request.getParameter("address");
		 
		 System.out.println(userId);
		 DBManager dbManager=new DBManager();
		 HttpSession session=request.getSession();
		 int flag=0;
		 flag =DBHandler.updateUser(userId, userName, password, roleId, statusCode, firstName, lastName, email, phone, address, dbManager);
		 
		 if(flag>0)
		 {
			 RequestDispatcher rd= request.getRequestDispatcher("adminManager1.jsp?userId="+userId);
			 rd.forward(request, response);
		 }
		 else
		 {
			 RequestDispatcher rd= request.getRequestDispatcher("adminManager1.jsp?userId="+userId);
			 rd.forward(request, response);
		 }
		}
	}


