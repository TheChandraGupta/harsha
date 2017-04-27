package com.harsha.app.servlet.occupation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.OccupationBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class UpdateOccupation
 */
@WebServlet("/UpdateOccupation")
public class UpdateOccupation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOccupation() {
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
		int occupationId = Integer.parseInt(request.getParameter("occupationId"));
		String occupationName = request.getParameter("occupationName");
		int occupationCode = Integer.parseInt(request.getParameter("occupationCode"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.updateOccupation(occupationId, occupationCode, occupationName, dbManager);
		if(flag>0)
		{
			RequestDispatcher rd= request.getRequestDispatcher("adminOccupation1.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("adminOccupation1.jsp");
			request.setAttribute("occupationId",occupationId );
			rd.forward(request, response);
		}
	}

}
