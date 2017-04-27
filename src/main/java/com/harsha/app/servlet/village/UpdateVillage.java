package com.harsha.app.servlet.village;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.UserViewBean;
import com.harsha.app.bean.VillageBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class UpdateVillage
 */
@WebServlet("/UpdateVillage")
public class UpdateVillage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVillage() {
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
		int villageId = Integer.parseInt(request.getParameter("villageId"));
		String villageName = request.getParameter("villageName");
		String villageCode = request.getParameter("villageCode");
		int blockId = Integer.parseInt(request.getParameter("blockId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession(false);
		UserViewBean user = (UserViewBean) session.getAttribute("userDetail");
		System.out.println(villageId+villageName+villageCode+blockId);
		int flag =DBHandler.updateVillage(villageId, villageCode, villageName, blockId, dbManager);
		if(flag == 0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminVillage1.jsp?villageId="+villageId);
			//session.setAttribute("userDetail", flag);
			request.setAttribute("msg", "Updation Unsuccessful");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminVillage1.jsp?villageId="+villageId);
			//session.setAttribute("userDetail", flag);
			request.setAttribute("msg", "Updation Successful");
			rd.forward(request, response);
		}
		
	}

}
