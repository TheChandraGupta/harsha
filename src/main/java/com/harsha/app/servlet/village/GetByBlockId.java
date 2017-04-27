package com.harsha.app.servlet.village;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.VillageBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class GetByBlockId
 */
@WebServlet("/GetByBlockId")
public class GetByBlockId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetByBlockId() {
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
		int blockId = Integer.parseInt(request.getParameter("blockId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		ArrayList<VillageBean> village=DBHandler.getByBlockId(blockId, dbManager);
		if(village.equals(null))
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminAnalysis.jsp");
			//request.setAttribute("user", userBean);
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminVillage.jsp");
			request.setAttribute("village", village);
			rd.forward(request, response);
			
		}
	}

}
