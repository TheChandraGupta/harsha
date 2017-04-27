package com.harsha.app.servlet.baseline;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class VerificationHousehold
 */
@WebServlet("/VerificationHousehold")
public class VerificationHousehold extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationHousehold() {
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
		doGet(request, response);
		int householddataId=Integer.parseInt(request.getParameter("householddataId"));
		String statusCode = request.getParameter("statusCode");
		System.out.println(statusCode);
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.verificationHousehold(householddataId, statusCode, dbManager);
		if(flag == 0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("managerBaselineInfo.jsp");
			//session.setAttribute("userDetail", flag);
			request.setAttribute("msg", "Updation Successful");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("managerBaselineInfo.jsp");
			//session.setAttribute("userDetail", flag);
			request.setAttribute("msg", "Updation Unsuccessful");
			rd.forward(request, response);
		}
		
	}

}
