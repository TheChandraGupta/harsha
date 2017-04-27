package com.harsha.app.servlet.state;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.OccupationBean;
import com.harsha.app.bean.StateBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddState
 * 
 */
@WebServlet("/AddState")
public class AddState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddState() {
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
	protected void doPost
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String stateName = request.getParameter("stateName");
		String stateCode = request.getParameter("stateCode");
		DBManager dbManager=new DBManager();
		//HttpSession session=request.getSession();
		int flag =DBHandler.addState(stateName, stateCode, dbManager);
		RequestDispatcher rd;
		if(flag==0) {
			rd = request.getRequestDispatcher("adminState.jsp");
			request.setAttribute("msg", "Error While Adding State");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("adminState.jsp");
			request.setAttribute("msg", "Successful Adding State");
			rd.forward(request, response);
		}
	}

}
