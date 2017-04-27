package com.harsha.app.servlet.village;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.StateBean;
import com.harsha.app.bean.VillageBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddVillage
 */
@WebServlet("/AddVillage")
public class AddVillage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVillage() {
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
		
		String villageName = request.getParameter("villageName");
		String villageCode = request.getParameter("villageCode");
		int blockId = Integer.parseInt(request.getParameter("blockId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.addVillage(villageName, villageCode, blockId, dbManager);
		RequestDispatcher rd;
		if(flag==0) {
			rd = request.getRequestDispatcher("adminVillage.jsp");
			request.setAttribute("msg", "Error While Adding Village");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("adminVillage.jsp");
			request.setAttribute("msg", "Successful Adding Village");
			rd.forward(request, response);
		}
	}

}
