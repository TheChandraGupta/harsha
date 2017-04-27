package com.harsha.app.servlet.district;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.BlockBean;
import com.harsha.app.bean.DistrictBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddDistrict
 */
@WebServlet("/AddDistrict")
public class AddDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDistrict() {
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
		String districtName = request.getParameter("districtName");
		String districtCode = request.getParameter("districtCode");
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.addDistrict(districtName, districtCode, stateId, dbManager);
		RequestDispatcher rd;
		if(flag==0) {
			rd = request.getRequestDispatcher("adminDistrict.jsp");
			request.setAttribute("msg", "Error While Adding District");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("adminDistrict.jsp");
			request.setAttribute("msg", "Successful Adding District");
			rd.forward(request, response);
		}
	}

}
