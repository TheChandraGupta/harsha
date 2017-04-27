package com.harsha.app.servlet.asset;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.AssetInfoBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class UpdateAssetInfo
 */
@WebServlet("/UpdateAssetInfo")
public class UpdateAssetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAssetInfo() {
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
		int assetId = Integer.parseInt(request.getParameter("assetId"));
		int householdDataId = Integer.parseInt(request.getParameter("householdDataId"));
		String description = request.getParameter("description");
		int assetInfoId = Integer.parseInt(request.getParameter("assetInfoId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag = DBHandler.updateAsset(assetId, householdDataId, description, assetInfoId, dbManager);
	}

}
