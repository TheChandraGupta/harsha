package com.harsha.app.servlet.religion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.OccupationBean;
import com.harsha.app.bean.ReligionBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddReligion
 */
@WebServlet("/AddReligion")
public class AddReligion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReligion() {
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
		String religionName = request.getParameter("religionName");
		int religionCode = Integer.parseInt(request.getParameter("religionCode"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.addReligion(religionName, religionCode, dbManager);
		RequestDispatcher rd;
		if(flag==0) {
			rd = request.getRequestDispatcher("adminReligion.jsp");
			request.setAttribute("msg", "Error While Adding Religion");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("adminReligion.jsp");
			request.setAttribute("msg", "Successful Adding Religion");
			rd.forward(request, response);
		}
	}

}
