package com.harsha.app.servlet.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.MemberDataBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class GetByDistrictMemberdata
 */
@WebServlet("/GetByDistrictMemberdata")
public class GetByDistrictMemberdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetByDistrictMemberdata() {
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
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		ArrayList<MemberDataBean> memberBean=DBHandler.getByDistrictMemberData(districtId, dbManager);
	}

}