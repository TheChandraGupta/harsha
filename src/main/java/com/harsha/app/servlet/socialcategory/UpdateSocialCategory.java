package com.harsha.app.servlet.socialcategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.SocialCategoryBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class UpdateSocialCategory
 */
@WebServlet("/UpdateSocialCategory")
public class UpdateSocialCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSocialCategory() {
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
		int socialcategoryId = Integer.parseInt(request.getParameter("socialCategoryId"));
		String socialCategoryName = request.getParameter("socialCategoryName");
		String socialCategoryCode = request.getParameter("socialCategoryCode");
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag = DBHandler.updateSocialCategory(socialcategoryId, socialCategoryCode, socialCategoryName, dbManager);
		System.out.println(socialcategoryId+socialCategoryCode+socialCategoryName);
		if( flag>0)
		{
			RequestDispatcher rd= request.getRequestDispatcher("adminSocialCategory1.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("adminSocialCategory1.jsp");
			request.setAttribute("socialcategoryId",socialcategoryId );
			rd.forward(request, response);
		}
	}

}
