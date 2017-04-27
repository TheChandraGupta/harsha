<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="com.harsha.app.database.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
  	
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	 -->
  	 <jsp:directive.include file="pages/include/manager_head.jsp"/>
  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="pages/js/validation.min.js"></script>
    <script type="text/javascript" src="pages/js/intervention.js"></script>
    <script type="text/javascript" src="pages/js/user.js"></script> 
    <script>
		function assignVillage(userId,villageId) {
		 alert(villageId);
		  if (userId=="") {
			document.getElementById("msg-"+villageId).innerHTML="";
			return;
		  } 
			  
		 
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			document.getElementById("msg-"+villageId).innerHTML="assigning...";
			xmlhttp=new XMLHttpRequest();
		  } else { // code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		  xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			  document.getElementById("msg-"+villageId).innerHTML=xmlhttp.responseText;
			}
		  }
		  xmlhttp.open("GET","pages/admin/assigningVillage.jsp?userId="+userId+"&villageId="+villageId,true);
		  xmlhttp.send();
		  
		  }
	</script>
	
  
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
	
	int counter = 0;
	ArrayList<DistrictBean> allDistrict = DBHandler.getAllDistrict(dbManager);
	ArrayList<StateBean> allState = DBHandler.getAllState(dbManager);
	ArrayList<BlockBean> allBlock = DBHandler.getAllBlock(dbManager);
	ArrayList<VillageBean> allVillage = DBHandler.getAllVillage(user.getUserId(), dbManager);
	ArrayList<UserViewBean> supervisor = DBHandler.getAllSupervisorByManagerId(user.getUserId(), dbManager);

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
                  <h3 class="box-title">Village Information</h3>
                  <button class="btn btn-primary btn-xs pull-right" data-toggle="modal"  data-toggle="tooltip" data-target="#myModal" title="Add New Village"> <span class="glyphicon glyphicon-plus"></span></button>
                               
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                  <table id="example1" class="table table-bordered table-striped">
                    <thead>
					<tr>
                      <th align="center">State Code</th>
                      <th align="center">State Name</th>
					  <th align="center">District Code</th>
					  <th align="center">District Name</th>
					  <th align="center">Block Code</th>
					  <th align="center">Block Name</th>
					  <th align="center">Village Code</th>
					  <th align="center">Village Name </th>
					  <th align="center">Supervisor </th>
					  <th align="center">Assign</th>
					  </tr>
                    </thead>
                    <tbody>
                     <%
						int i =0;
						while(i<allVillage.size()) {
							VillageBean village = allVillage.get(i);
							counter++;
						%>
						
							<tr>
						    <td ><%=village.getStateCode() %></td>
						    <td ><%=village.getStateName() %></td>
							<td ><%=village.getDistrictCode() %></td>
							<td ><%=village.getDistrictName() %></td>
							<td ><%=village.getBlockCode() %></td>
							<td ><%=village.getBlockName() %></td>
							<td ><%=village.getVillageCode() %></td>
							<td ><%=village.getVillageName() %>
								
       						</td>
							<td> 
							 <select class="form-control select2" name="userId" id="userId" onchange=assignVillage(this.value,<%=village.getVillageId() %>)>  
           							 				 <%if(village.getUserId()<1) {%>
           							 				 <option value="0">---Assign---</option>
									    		<%} %>
           							 				 <%
													int l =0;
													while(l<supervisor.size()) {
															UserViewBean managerUser = supervisor.get(l);
													%>
									    		<option value="<%=managerUser.getUserId() %>"
									    		<%if(village.getUserId() == managerUser.getUserId()) {%>
									    		selected
									    		<%} %>
									    		><%=managerUser.getUserName() %></option>
            			           					<%
            			           						l++;
														}
								   					%>
           										</select>  
							
								
							</td>
							<td> 
									
									<span id='msg-<%=village.getVillageId() %>'></span><input type="hidden" id="<%=i %>" value="<%=village.getVillageId() %>"/>
									 
							
							</td>
							</tr>
							<% 
							i++;
							
							} 
							%> 	
                    </tbody>
                    <tfoot>
                      <tr>
                     <th align="center">State Code</th>
                      <th align="center">State Name</th>
					  <th align="center">District Code</th>
					  <th align="center">District Name</th>
					  <th align="center">Block Code</th>
					  <th align="center">Block Name</th>
					  <th align="center">Village Code</th>
					  <th align="center">Village Name </th>
					  <th align="center">Supervisor </th>
					  <th align="center">Assign</th>
                      	</tr>
                    </tfoot>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
        </section><!-- /.content -->
            </div><!-- /.col -->
          <!-- Your Page Content Here -->


      <jsp:directive.include file="pages/include/manager_footer.jsp"/>
   
 
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
