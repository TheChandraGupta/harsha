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
    
<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="pages/js/validation.min.js"></script>
    <script type="text/javascript" src="pages/js/intervention.js"></script>
    <script type="text/javascript" src="pages/js/user.js"></script> 
   
	
	<script>
		function assignSupervisor(managerId,userId) {
		  alert(managerId);
		  if (userId=="") {
			document.getElementById("msg-"+userId).innerHTML="";
			return;
		  } 
			  
		 
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			document.getElementById("msg-"+userId).innerHTML="assigning...";
			xmlhttp=new XMLHttpRequest();
		  } else { // code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		  xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			  document.getElementById("msg-"+userId).innerHTML=xmlhttp.responseText;
			}
		  }
		  xmlhttp.open("GET","pages/admin/assigningSupervisor.jsp?userId="+userId+"&managerId="+managerId,true);
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
	int counter=0;
	UserViewBean user = (UserViewBean) session.getAttribute("userDetail");
	DBManager dbManager=new DBManager();
	
	ArrayList<UserViewBean> supervisor = DBHandler.getAllSupervisorByManagerId(user.getUserId(), dbManager);

	//ArrayList<UserViewBean> manager = DBHandler.getAllManager(dbManager);
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
                  <h3 class="box-title">Supervisor Information</h3>
                  <!-- MODAL BUTTON -->
                  
                   <button class="btn btn-primary btn-xs pull-right" data-toggle="modal" data-toggle="tooltip" title="Add New User" data-target="#myModal"> <span class="glyphicon glyphicon-plus"></span></button>
             
               		  <!-- MODAL STARTS HERE -->
               		<!-- <div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
			Modal content
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"><b>Add New User</b></h4>
				</div>

				<div class="modal-body">
					<div class="panel-body" id="afterinsertingheading">
							<div class="form-group">
							<form method="post" id="user-form" >
								<div class="col-sm-offset-3 col-sm-8">
										<span class='msg' id="error"></span>
								</div>
								
															
								<label for="heading" class="col-sm-3 control-label">First Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="firstName" id="firstName" placeholder="First Name">
								</div>
								
								<br><br>
								
								<label for="heading" class="col-sm-3 control-label">Last Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last Name">
								</div>
								
								<br><br>
								
								<label for="heading" class="col-sm-3 control-label">Email :</label>
								<div class="col-sm-8">
								<input class="form-control"  id="email" name="email" type="text" placeholder="Email" >
                   				</div>
                   				<br><br>
                   				
                   				<label for="heading" class="col-sm-3 control-label">Phone :</label>
								<div class="col-sm-8">
								<input class="form-control" id="phonenumber" name="phone" type="text" placeholder="Phone Number">
                   				</div>
                   				<br><br>
                   				
                   				<label for="heading" class="col-sm-3 control-label">Address :</label>
								<div class="col-sm-8">
								<input class="form-control" id="address" name="address" type="text" placeholder="Address" >
                   				</div>
                   				<br><br>
                   				
                   				<label for="heading" class="col-sm-3 control-label">Role :</label>
								<div class="col-sm-8">
									 <select class="form-control select2" name="roleId" id="roleId">  
           							 	<option value="2">Manager</option>
           							 	<option value="4">Supervisor</option>
            			           	 </select>  
								</div>
								
								<input class="form-control" id="photo" name="photo" type="hidden" value="user.jpg" >
                   			</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8">
								
								<br>
									<button type="submit" class="btn btn-primary pull-right" name="btn-user" id="btn-user">Add</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				
			</div>
	</div>
</div> 
  					 MODAL ENDS HERE -->
  					
  					
  					 <!-- MODAL ENDS HERE -->
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                  <table id="example1" class="table table-bordered table-striped">
                    <thead>
					<tr>
                      	 <th align="center">Username</th>
					     <th align="center">Full Name</th>
					     <th align="center">Phone No.</th>
					     <th align="center">Email ID</th>
					     <th align="center">Address</th>
					    <th align="center">Edit</th>
					  </tr>
                    </thead>
                    <tbody>
                     <%
						int i =0;
						while(i<supervisor.size()) {
							UserViewBean managerUser = supervisor.get(i);
						%>
						<tr>
							<input type="hidden" id="<%=i%>" value=<%=managerUser.getUserId() %> />
							<td ><%=managerUser.getUserName() %>
									 
       						</td>
							<td ><%=managerUser.getFirstName() + " " + managerUser.getLastName() %></td>
							<td ><%=managerUser.getPhone() %></td>
							<td ><%=managerUser.getEmail() %></td>
							<td ><%=managerUser.getAddress() %></td>
													
							<%-- <input type="hidden" id="<%=i %>" value="<%=manager1.getUserId() %>"/>
							 --%><td align="center">
								<span id='msg-<%=managerUser.getUserId() %>'></span><span class="glyphicon glyphicon-edit pull-right" onclick="myFunction1('<%=i%>')" data-toggle="tooltip"  title="Edit"></span>
							</td>
						
						
						</tr>
								
							<%
								
						i++;
								}
	                 		%>
                    </tbody>
                    <tfoot>
                      <tr>
                       <th align="center">Username</th>
					     <th align="center">Full Name</th>
					     <th align="center">Phone No.</th>
					     <th align="center">Email ID</th>
					     <th align="center">Address</th>
					    <th align="center">Edit</th>
					  
                      	</tr>
                    </tfoot>
                  </table>
                   <script>
			    function myFunction1(ur)
			    {
			    	var myWindow = window.open("adminFieldAgentInfo.jsp?userId="+document.getElementById(ur).value,"", "width=1000, height=500");
			    	
			    }
			    </script>
			    
			    
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          <!-- Your Page Content Here -->

        </section><!-- /.content -->

        <!-- Main content -->
        
      </div><!-- /.content-wrapper -->

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
    <script>
		function assignManager(id) {
		 
		  if (id=="") {
			document.getElementById("msg").innerHTML="";
			return;
		  } 
			  
		 
		if (window.XMLHttpRequest) {
			document.getElementById("msg").innerHTML="assigning...";
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
		  xmlhttp.open("GET","pages/admin/assigningManager.jsp?id="+id,true);
		  xmlhttp.send();
		  
		  }
	</script>
	
  
  </body>
</html>
