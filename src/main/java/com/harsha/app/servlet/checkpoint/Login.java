package com.harsha.app.servlet.checkpoint;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.UserViewBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession(true);
		UserViewBean userBean=DBHandler.login(username, password, dbManager);
		if(userBean == null || userBean.getUserId() == 0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Invalid UserName or Password");
			rd.forward(request, response);
		}
		else
		{
			if(userBean.getRole().equalsIgnoreCase("ADMIN"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("adminAnalysis.jsp");
				session.setAttribute("userDetail", userBean);
				request.setAttribute("user", userBean);
				rd.forward(request, response);
			}
			else if(userBean.getRole().equalsIgnoreCase("DONER"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("donerDonation.jsp");
				session.setAttribute("userDetail", userBean);
				request.setAttribute("user", userBean);
				rd.forward(request, response);
			}
			else if(userBean.getRole().equalsIgnoreCase("MANAGER"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("managerBaselineInfo.jsp");
				session.setAttribute("userDetail", userBean);
				request.setAttribute("user", userBean);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", userBean);
				rd.forward(request, response);
			
			}
			
		}
		
		
	}

	

}
