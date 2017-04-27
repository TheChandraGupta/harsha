package com.harsha.app.servlet.checkpoint;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.UserViewBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;
import com.harsha.app.util.EmailSendingServlet;
import com.harsha.app.util.MailThread;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
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
		String username=request.getParameter("username");
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		RequestDispatcher rd=null;
		UserViewBean userBean=DBHandler.forgetPassword(username, dbManager);
		if(userBean.equals(null))
		{
			System.out.println("LOGIN = " + "INVALID EMAIL" +" : User = " + userBean);
			request.setAttribute("msg", "INVALID EMAIL, PLEASE ENTER VALID EMAIL");
			rd = request.getRequestDispatcher("forgotpassword.jsp");
			rd.forward(request, response);
		}
		else
		{
			EmailSendingServlet mail =new EmailSendingServlet();
			String recipient = userBean.getEmail();
				String subject = "Password Recovered";
				String content = "Dear "+ userBean.getUserName() +",\n\n"
						+ "Your password has been recovered\n"
						+ "Email : "+userBean.getEmail()+"\n"
								+ "Password : "+userBean.getPassword();
				
				mail.setRecipient(recipient);
				mail.setSubject(subject);
				mail.setContent(content);
				
				MailThread sendMail = new MailThread(mail);
				sendMail.start();
				
				System.out.println("FORGET = " + "VALID EMAIL" +" : User = " + userBean);
				request.setAttribute("msg", "Check Mail for Password Recovery, Else Please try After 15 Minutes.");
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			}

			dbManager.close();		
	}

}
