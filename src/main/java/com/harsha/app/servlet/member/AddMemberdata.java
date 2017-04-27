package com.harsha.app.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.app.bean.EducationBean;
import com.harsha.app.bean.MemberDataBean;
import com.harsha.app.database.DBHandler;
import com.harsha.app.database.DBManager;

/**
 * Servlet implementation class AddMemberdata
 */
@WebServlet("/AddMemberdata")
public class AddMemberdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemberdata() {
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
		int houseHoldDataId = Integer.parseInt(request.getParameter("houseHoldDataId"));
		int stateId = Integer.parseInt(request.getParameter("houseHoldDataId"));
		int districtId = Integer.parseInt(request.getParameter("districtId"));
		int blockId = Integer.parseInt(request.getParameter("blockId"));
		int villageId = Integer.parseInt(request.getParameter("villageId"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int relationshipId = Integer.parseInt(request.getParameter("relationshipId"));
		String dob = request.getParameter("houseHoldDataId");
		int age = Integer.parseInt(request.getParameter("age"));
		int maritalStatusId = Integer.parseInt(request.getParameter("maritalStatusId"));
		int educationId = Integer.parseInt(request.getParameter("educationId"));
		int educationStatusId = Integer.parseInt(request.getParameter("educationStatusId"));
		String aadharCard = request.getParameter("aadharCard");
		String electionCard = request.getParameter("electionCard");
		String addressPermanent = request.getParameter("addressPermanent");
		String pincodePermanent = request.getParameter("pincodePermanent");
		String addressCurrent = request.getParameter("addressCurrent");
		String pincodeCurrent = request.getParameter("pincodeCurrent");
		int disabilityId = Integer.parseInt(request.getParameter("disabilityId"));
		int schemeId = Integer.parseInt(request.getParameter("schemeId"));
		int incomeAnnual = Integer.parseInt(request.getParameter("incomeAnnual"));
		String emailId = request.getParameter("emailId");
		String mobileNumber = request.getParameter("mobileNumber");
		String alternateNumberWith = request.getParameter("alternateNumberWith");
		int occupationId = Integer.parseInt(request.getParameter("occupationId"));
		DBManager dbManager=new DBManager();
		HttpSession session=request.getSession();
		int flag =DBHandler.addMemberDataService(houseHoldDataId, stateId, districtId, blockId, villageId, 
				name, gender, relationshipId, dob, age, maritalStatusId, educationId, educationStatusId, aadharCard, electionCard, 
				addressPermanent, pincodePermanent, addressCurrent, pincodeCurrent, disabilityId, schemeId, incomeAnnual, emailId, 
				mobileNumber, alternateNumberWith, occupationId, dbManager);
	}

}
