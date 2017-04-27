package com.harsha.app.servlet.checkpoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.UserViewBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String photo=request.getParameter("photo");
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		DBHandler.signup(firstName, lastName, username, password, email, phone, address, photo, roleId, dbManager);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(roleId);
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(address);
		System.out.println(photo);
	}

}
