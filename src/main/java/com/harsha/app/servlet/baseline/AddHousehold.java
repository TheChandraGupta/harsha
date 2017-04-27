package com.harsha.app.servlet.baseline;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.HouseHoldBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddHousehold
 */
@WebServlet("/AddHousehold")
public class AddHousehold extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHousehold() {
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
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		int districtId = Integer.parseInt(request.getParameter("districtId"));
		int blockId = Integer.parseInt(request.getParameter("blockId"));
		int villageid = Integer.parseInt(request.getParameter("villageId"));
		int surveyOwnerUserId = Integer.parseInt(request.getParameter("surveyOwnerUserId"));
		String surveyPeriod = request.getParameter("surveyPeriod");
		int socialCategoryId = Integer.parseInt(request.getParameter("socialCategoryId"));
		int religionId = Integer.parseInt(request.getParameter("religionId"));
		String contactNo = request.getParameter("contactNo");
		int noOfFamilyMember = Integer.parseInt(request.getParameter("noOfFamilyMember"));
		int occupationId = Integer.parseInt(request.getParameter("occupationId"));
		int annualHHIncome = Integer.parseInt(request.getParameter("annualHHIncome"));
		String remarks = request.getParameter("remarks");
		
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.addHousehold(stateId, districtId, blockId, villageid, surveyOwnerUserId, surveyPeriod, 
				socialCategoryId, religionId, contactNo, noOfFamilyMember, occupationId, annualHHIncome, remarks, dbManager);
	}

}
