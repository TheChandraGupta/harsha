package com.harsha.app.servlet.block;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.AssetBean;
import com.harsha.app.bean.BlockBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddBlock
 */
@WebServlet("/AddBlock")
public class AddBlock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlock() {
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
		String blockName = request.getParameter("blockName");
		String blockCode = request.getParameter("blockCode");
		int districtId = Integer.parseInt(request.getParameter("districtId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.addBlock(blockName, blockCode, districtId, dbManager);
		RequestDispatcher rd;
		if(flag==0) {
			rd = request.getRequestDispatcher("adminBlock.jsp");
			request.setAttribute("msg", "Error While Adding Block");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("adminBlock.jsp");
			request.setAttribute("msg", "Successful Adding Block");
			rd.forward(request, response);
		}
	}

}
