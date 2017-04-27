<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="com.harsha.app.database.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
  
  	 <jsp:directive.include file="pages/include/manager_head.jsp"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
  </head>
  <%
	
	HttpSession nSession = request.getSession(false);
	if(nSession.isNew()) {
		System.out.println("SESSION = " + "SESSION EXPIRED, TRY LOGGING AGAIN");
		request.setAttribute("msg", "SESSION EXPIRED, TRY LOGGING AGAIN");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	} 
	
	String msg = null;
	msg = (String) request.getAttribute("msg");
	
	UserViewBean user = (UserViewBean) session.getAttribute("userDetail");
	DBManager dbManager=new DBManager();
	ArrayList<FamilyMember> familyMember =DBHandler.getAllFamilyMember(user.getUserId(), dbManager);


	%>
  <body class="hold-transition skin-blue sidebar-mini" onload='display_ct();'>
    <div class="wrapper">

       <jsp:directive.include file="pages/include/manager_header.jsp"/>

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
                  <h3 class="box-title">Family Information</h3>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                  <table id="example1" class="table table-bordered table-striped">
                    <thead>
					<tr>
                      <th>Head Name</th>
					  <th>Income</th>
					  <th>Saving</th>
					  <th>Village</th>
					  <th>Status</th>
					  <th>Accept</th>
					  <th>Reject</th>
					  </tr>
                    </thead>
                    <tbody>
                      <%
						int i =0;
						while(i<familyMember.size()) {
							FamilyMember familyMemberBean = familyMember.get(i);
							i++;
						%>
						<tr>
							<input type="hidden" id="<%=i %>" value=<%=familyMemberBean.getFamilyId() %> />
							<td onclick="myFunction1('<%=i%>')">
								
								<%=familyMemberBean.getName() %>
							</td>
							<td ><%=familyMemberBean.getIncome() %></td>
							<td ><%=familyMemberBean.getSavings() %></td>
						    <td ><%=familyMemberBean.getVillageId() %></td>
						    
							<td ><p id='status-<%=familyMemberBean.getMemberId() %>' >
							<% if(familyMemberBean.getApprovalStatus().equals("-1")){ %>
									<span class="text-warning">pending</span>	
							<%} else if(familyMemberBean.getApprovalStatus().equals("0")){ %>
								<span class="text-primary">accepted</span>	
								
							<%} else{ %>
								<span class="text-danger">reject</span>	
								<%} %>
								</p></td>
							<td>
								<button class="btn btn-info btn-xs" value="<%=familyMemberBean.getMemberId() %>" onclick="accept(<%=familyMemberBean.getMemberId() %>)" id='accept-<%=familyMemberBean.getMemberId() %>' name="accept">
          							<span class="glyphicon glyphicon-thumbs-up"></span> 
								</button>
							</td>
							<td>
								<button class="btn btn-info btn-xs" value="<%=familyMemberBean.getMemberId() %>" onclick="reject(<%=familyMemberBean.getMemberId() %>)" id='reject-<%=familyMemberBean.getMemberId() %>' name="reject">
          								<span class="glyphicon glyphicon-thumbs-down"></span> 
								</button>
							</td>
							
							</tr>
							<% } %>	
                    </tbody>
                    <tfoot>
                      <tr>
                       	<th>Head Name</th>
					  	<th>Income</th>
					  	<th>Saving</th>
					  	<th>Village</th>
					  	<th>Status</th>
					  	<th>Accept</th>
					  	<th>Reject</th>
					  </tr>
                    </tfoot>
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
	<script>
	    function myFunction1(ur){
	    	var myWindow = window.open("managerHomeInfo.jsp?familyId="+document.getElementById(ur).value,"", "width=1000, height=600");
	    }
	</script>
	<script>
function accept(idd) {
	
	var id = idd;
    
     if (id=="") {
		document.getElementById("msg").innerHTML="";
		return;
	} 
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
			document.getElementById("accept-"+id).disabled = true;
    		document.getElementById("reject-"+id).disabled = false;
    		document.getElementById("status-"+id).innerHTML = "accepting...";
		xmlhttp=new XMLHttpRequest();
	  } else { // code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		  document.getElementById("status-"+id).innerHTML=xmlhttp.responseText;
		}
	  }
		alert("memberApproval.jsp?id="+id+"&approvalStatus=0&remark=ACCEPTED");
	  xmlhttp.open("GET","memberApproval.jsp?id="+id+"&approvalStatus=0&remark=ACCEPTED",true);
	  xmlhttp.send();
}

function reject(idd) {
	
	var id = idd;
    
    if (id=="") {
		document.getElementById("msg").innerHTML="";
		return;
	} 
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		document.getElementById("reject-"+id).disabled = true;
    document.getElementById("accept-"+id).disabled = false;
    document.getElementById("status-"+id).innerHTML = "reject";
		xmlhttp=new XMLHttpRequest();
	  } else { // code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		  document.getElementById("status-"+id).innerHTML=xmlhttp.responseText;
		}
	  }
		alert("memberApproval.jsp?id="+id+"&approvalStatus=0&remark=ACCEPTED");
	  xmlhttp.open("GET","memberApproval.jsp?id="+id+"&approvalStatus=1&remark=REJECTED",true);
	  xmlhttp.send();
	
}
</script>
   <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="dist/js/app.min.js"></script>
	<script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script>
      $(function () {
        $("#example1").DataTable();
        $('#example2').DataTable({
          "paging": true,
          "lengthChange": false,
          "searching": false,
          "ordering": true,
          "info": true,
          "autoWidth": false
        });
      });
    </script>
  </body>
</html>
