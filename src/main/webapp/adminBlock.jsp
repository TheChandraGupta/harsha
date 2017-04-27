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
  	 --><jsp:directive.include file="pages/include/admin_head.jsp"/>
  		<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
		<script type="text/javascript" src="pages/js/validation.min.js"></script>
    <script type="text/javascript" src="pages/js/block.js"></script>
    
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

	%>
  <body class="hold-transition skin-blue sidebar-mini" onload='display_ct();'>
    <div class="wrapper">

       <jsp:directive.include file="pages/include/admin_header.jsp"/>

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
                  <h3 class="box-title">Block Information</h3>
                  <button class="btn btn-primary btn-xs pull-right" data-toggle="modal"  data-toggle="tooltip" data-target="#myModal" title="Add New Block"> <span class="glyphicon glyphicon-plus"></span></button>
                 <!-- MODAL STARTS HERE -->
               		<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"><b>Add New Block</b></h4>
				</div>

				<div class="modal-body">
					<div class="panel-body" id="afterinsertingheading">
							<div class="form-group">
								<form method="post" id="block-form">
									<div class="col-sm-offset-3 col-sm-8">
										<span class='msg' id="error"></span>
									</div>
								  		<label for="heading" class="col-sm-3 control-label">State Name: </label>
            								<div class="col-sm-8">
           										 <select class="form-control select2" name="stateId" id="stateId">  
           							 				<%
														int j =0;
														while(j<allState.size()) {
														StateBean state = allState.get(j);
														counter++;
													%>
									    		<option value="<%=state.getStateId() %>"><%=state.getStateName() %></option>
            			           					<%
            			           						j++;
														}
								   					%>
           										</select>  
           									</div>
           						<br><br><br>
           						<label for="heading" class="col-sm-3 control-label">District Name: </label>
           						<div class="col-sm-8">
           										<select class="form-control select2" name="districtId" id="districtId">  
           							 				 <%
						 int k=0;
						while(k<allDistrict.size()) {
							DistrictBean district = allDistrict.get(k);
							
						%>
									    		<option value="<%=district.getDistrictId() %>"><%=district.getDistrictName() %></option>
            			           					<%
            			           						k++;
														}
								   					%>
           										</select>
           									</div>
           						<br><br><br>
           						
								<label for="heading" class="col-sm-3 control-label">Block Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="blockName" id="blockName" placeholder="Block Name">
								</div>
							
								<br><br><br>
							
							
								<label for="heading" class="col-sm-3 control-label">Block code</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="blockCode" id="blockCode" placeholder="Block Code">
								</div>
							
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8">
								<br>
									<button type="submit" class="btn btn-primary pull-right" name="btn-block" id="btn-block">Add</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				
			</div>
	</div>
</div> 
  					 <!-- MODAL ENDS HERE -->
               
               
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                  <table id="example1" class="table table-bordered table-striped">
                    <thead>
					<tr>
                      <th align="center">State Name</th>
					  <th align="center">State Code</th>
					  <th align="center">District Name</th>
					  <th align="center">District Code</th>
					  <th align="center">Block Name</th>
					  <th align="center">Block Code</th>
					  <th align="center">Edit</th>
					  </tr>
                    </thead>
                    <tbody>
                      <%
						int l =0;
						while(l<allBlock.size()) {
							BlockBean block1 = allBlock.get(l);
							counter++;
						%>
							<tr>
						    <td ><%=block1.getStateName() %>
							<td ><%=block1.getStateCode() %>
							<td ><%=block1.getDistrictName() %></td>
							<td ><%=block1.getDistrictCode() %></td>
							<td ><%=block1.getBlockName() %></td>
							<td ><%=block1.getBlockCode() %></td>
							<td> 
								<input type="hidden" id="<%=l %>" value="<%=block1.getBlockId() %>"/>
							<%System.out.print(block1.getBlockId()); %>
         							 <span class="glyphicon glyphicon-edit" onclick="myFunction1('<%=l%>')"></span>
       							</td>
							</tr>
							<% 
							l++;
							} %> 	
                    </tbody>
                    <tfoot>
                      <tr>
                     	<th align="center">State Name</th>
					  <th align="center">State Code</th>
					  <th align="center">District Name</th>
					  <th align="center">District Code</th>
					  <th align="center">Block Name</th>
					  <th align="center">Block Code</th>
					  <th align="center">Edit</th>
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

      <jsp:directive.include file="pages/include/admin_footer.jsp"/>
    <!-- REQUIRED JS SCRIPTS -->
	  <script>
			    function myFunction1(ur)
			    {
			    	var myWindow = window.open("adminBlockInfo.jsp?blockId="+document.getElementById(ur).value,"", "width=600, height=450");
			    	
			    }
			    </script>  
 
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
