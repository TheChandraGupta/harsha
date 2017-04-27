package com.harsha.app.servlet.district;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.DistrictBean;
import com.harsha.app.bean.UserViewBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class UpdateDistrict
 */
@WebServlet("/UpdateDistrict")
public class UpdateDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDistrict() {
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
		int districtId = Integer.parseInt(request.getParameter("districtId"));
		String districtName = request.getParameter("districtName");
		String districtCode = request.getParameter("districtCode");
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession(false);
		UserViewBean user = (UserViewBean) session.getAttribute("userDetail");
		int flag =DBHandler.updateDistrict(districtId, districtCode, districtName, stateId, dbManager);
		if(flag == 0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminDistrict1.jsp?districtId="+districtId);
			//session.setAttribute("userDetail", flag);
			request.setAttribute("msg", "Updation Successful");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminDistrict1.jsp?districtId="+districtId);
			//session.setAttribute("userDetail", flag);
			request.setAttribute("msg", "Updation Unsuccessful");
			rd.forward(request, response);
		}
	}

}
