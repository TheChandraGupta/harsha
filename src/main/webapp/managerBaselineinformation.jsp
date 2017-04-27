<%@ page import="com.harsha.app.database.*" %>
<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
  
  	 <jsp:directive.include file="pages/include/manager_head.jsp"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
   
	
	<script>
		function assigncourse(id,slot,day,course) {
		 
		  if (id=="") {
			document.getElementById("msg").innerHTML="";
			return;
		  } 
			  
		 
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		  } else { // code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		  xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			  document.getElementById("msg").innerHTML=xmlhttp.responseText;
			}
		  }
		  xmlhttp.open("GET","assigning_course.php?id="+id+"&slot="+slot+"&day="+day+"&course="+course,true);
		  xmlhttp.send();
		  
		  }
	</script>
	
  
  </head>
  <%
	/*HttpSession nSession = request.getSession(false);
	if(nSession.isNew()) {
		System.out.println("SESSION = " + "SESSION EXPIRED, TRY LOGGING AGAIN");
		request.setAttribute("msg", "SESSION EXPIRED, TRY LOGGING AGAIN");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}*/
	
	String msg = null;
	msg = (String) request.getAttribute("msg");
	int householdDataId = Integer.parseInt(request.getParameter("householdDataId"));
	int counter = 0;
	DBManager dbManager = new DBManager();
	HouseHoldBean household = DBHandler.getByHouseholdId(householdDataId, dbManager);

%>
  <body class="hold-transition skin-blue sidebar-mini" onload='display_ct();'>
    <div class="wrapper">

       

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Welcome
            
          </h1>
          <ol class="breadcrumb">
            <li><span id='ct' ></span></li>
            
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
			<div class="box">
                <div class="box-header">
                  <h3 class="box-title">BaseLine Information</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table class="table table-bordered table-striped">
					<thead>
					
					<tr>
					     <th align="center">stateName</td>
					     <td ><%=household.getStateName() %></td>
					 </tr>
					 <tr>
					     <th align="center">stateCode</td>
					     <td ><%=household.getStateCode() %></td>
					  </tr>
					  <tr>
					     <th align="center">districtName</td>
					     <td ><%=household.getDistrictname() %></td>
					  </tr>
					  <tr>
					     <th align="center">districtCode</td>
					     <td ><%=household.getDistrictCode() %></td>
					  </tr>
					  <tr>
					     <th align="center">blockName</td>
					     <td ><%=household.getBlockName() %></td>
					  </tr>
					  <tr>
					     <th align="center">blockCode</th>
					     <td ><%=household.getBlockCode() %></td>
					  </tr>
					  <tr>
					     <th align="center">VillageName</th>
					     <td ><%=household.getVillageName() %></td>
					  </tr>
					  <tr>
					     <th align="center">VillageCode</th>
					     <td ><%=household.getVillageCode() %></td>
					 </tr>
					 <tr>
					     <th align="center">SurveyOwner UserName</th>
					     <td ><%=household.getSurveyOwnerUserName() %></td>
					 </tr>
					 <tr>
					     <th align="center">Number Of Family Member</th>
					     <td ><%=household.getNoOfFamilyMember() %></td>
					 </tr>
					 <tr>
					     <th align="center">Survey Period</th>
					     <td ><%=household.getSurveyPeriod() %></td>
					 </tr>
					 <tr>
					     <th align="center">Social Category Name</th>
					     <td ><%=household.getSocialCategoryName() %></td>
					 </tr>
					 <tr>
					     <th align="center">Religion Name</th>
					     <td ><%=household.getReligionName() %></td>
					  </tr>
					  <tr>
					     <th align="center">Contact No</th>
					     <td ><%=household.getContactNo() %></td>
					 </tr>
					 <tr>
					     <th align="center">Occupation Name</th>
					     <td ><%=household.getOccupationName() %></td>
					 </tr>
					 <tr>
					     <th align="center">AnnualHouseholdIncome</th>
					     <td ><%=household.getAnnualHHIncome() %></td>
					 </tr>
					 <tr>
					     <th align="center">statusCode</th>
					     <td ><%=household.getStatusCode() %></td>
					  </tr>
					  <tr>
					     <th align="center">remarks</th>
					     <td ><%=household.getRemarks() %></td>
					 </tr>
					</thead>
					<tbody>
	       				
					   		
					</tbody>
				</table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          <!-- Your Page Content Here -->

        </section><!-- /.content -->

        <!-- Main content -->
        
      </div><!-- /.content-wrapper -->

      <jsp:directive.include file="pages/include/manager_footer.jsp"/>
    <!-- REQUIRED JS SCRIPTS -->
	
   <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/app.min.js"></script>
	<script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
	
  </body>
</html>
