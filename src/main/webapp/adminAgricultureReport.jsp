<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="com.harsha.app.database.*" %>
<%@ page import="com.harsha.app.constant.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.format.*" %>
<%@ page import="java.time.*" %>
<%@ page import="org.codehaus.jettison.json.JSONArray" %>
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
  
  	 <jsp:directive.include file="pages/include/admin_head.jsp"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">	
    
<script type="text/javascript" src="js/fusioncharts.js"></script>
<script type="text/javascript" src="js/themes/fusioncharts.theme.fint.js"></script>

<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="pages/js/validation.min.js"></script>
    <script type="text/javascript" src="pages/js/intervention.js"></script>
    <script type="text/javascript" src="pages/js/user.js"></script> 
   
	

  
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
	
	//ArrayList<UserViewBean> supervisor = DBHandler.getAllSupervisorByManagerId(user.getUserId(), dbManager);
	
	JSONArray jsonArray = DBHandler.getAgricultureImpactReport(0, new Date().getTime()/1000, dbManager);
	
	System.out.println(jsonArray.toString());

	//ArrayList<UserViewBean> manager = DBHandler.getAllManager(dbManager);
	%>
	
  <body class="hold-transition skin-blue sidebar-mini" onload='display_ct();'>
  	<script type="text/javascript">
  FusionCharts.ready(function(){
    var revenueChart = new FusionCharts({
        "type": "column2d",
        "renderAt": "chartContainer",
        "width": "500",
        "height": "300",
        "dataFormat": "json",
        "dataSource":  {
          "chart": {
            "caption": "Monthly revenue for last year",
            "subCaption": "Harry's SuperMart",
            "xAxisName": "Month",
            "yAxisName": "Revenues (In USD)",
            "theme": "fint"
         },
         "data": [
            {
               "label": "Jan",
               "value": "420000"
            },
            {
               "label": "Feb",
               "value": "810000"
            },
            {
               "label": "Mar",
               "value": "720000"
            },
            {
               "label": "Apr",
               "value": "550000"
            },
            {
               "label": "May",
               "value": "910000"
            },
            {
               "label": "Jun",
               "value": "510000"
            },
            {
               "label": "Jul",
               "value": "680000"
            },
            {
               "label": "Aug",
               "value": "620000"
            },
            {
               "label": "Sep",
               "value": "610000"
            },
            {
               "label": "Oct",
               "value": "490000"
            },
            {
               "label": "Nov",
               "value": "900000"
            },
            {
               "label": "Dec",
               "value": "730000"
            }
          ]
      }

  });
revenueChart.render();
})
</script>
 

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
                  <h3 class="box-title">Supervisor Information</h3>
                  <!-- MODAL BUTTON -->
                  <%String urll = "agriculture.xls"; %>
                   <a href="<%=Constant.BASE_URL%>TableDataDownload/<%=urll %>" class="btn btn-primary btn-xs pull-right" data-toggle="tooltip" title="Download Agriculture Impact"> <span class="fa fa-download"></span></a>
             
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
                    		<th>Village Name</th>
                    		<th>Family ID</th>
                    		<th>Family Head Name</th>
                    		<th>Project Name</th>
                    		<th>Area in Cents</th>
                    		<th>Crop Weight</th>
                    		<th>Period Income</th>
                    		<th>Family Expense</th>
                    		<th>Harsha Expense</th>
                    		<th>Date Time</th>
                    	</tr>
					<%-- <tr>
					<%
						
							JSONObject jObj1 = jsonArray.getJSONObject(0);
							Iterator<String> keys = jObj1.keys();
							while(keys.hasNext()) {
								String key = keys.next();
								%>
						<th align="center"><%=key %></th>
								<%
							}
					%>
					
                      	 <!-- <th align="center">Username</th>
					     <th align="center">Full Name</th>
					     <th align="center">Phone No.</th>
					     <th align="center">Email ID</th>
					     <th align="center">Address</th>
					    <th align="center">Edit</th> -->
					  </tr> --%>
                    </thead>
                    <tbody>
                    <%
                      	for(int i=0; i<jsonArray.length(); i++) {             
                    		JSONObject jObj = jsonArray.getJSONObject(i);
                    %>
                    	<tr>
                    		<td><%=jObj.getString("villageName") %></td>
                    		<td><%=jObj.getString("familyId") %></td>
                    		<td><%=jObj.getString("memberName") %></td>
                    		<td><%=jObj.getString("projectName") %></td>
                    		<td><%=jObj.getString("acrage") %></td>
                    		<td><%=jObj.getString("cropWeight") %></td>
                    		<td><%=jObj.getString("periodIncome") %></td>
                    		<td><%=jObj.getString("familyExpense") %></td>
                    		<td><%=jObj.getString("harshaExpense") %></td>
                    		<%
                    		/* final DateTimeFormatter formatter = 
                    	    DateTimeFormatter.ofPattern("dd-mm-yyyy");

                    	final long unixTime = jObj.getLong("entryDate");
                    	final String formattedDtm = Instant.ofEpochSecond(unixTime)
                    	        .atZone(ZoneId.of("GMT+5"))
                    	        .format(formatter); */
                    		java.util.Date time=new java.util.Date(jObj.getLong("entryDate")*1000);
                    		%>
                    		<td><%=time.toString() %></td>
                    	</tr>
                    <%
                      	}
                    %>
                    <%-- <%
                      	for(int i=0; i<jsonArray.length(); i++) {             
                    		JSONObject jObj = jsonArray.getJSONObject(i);
                    		Iterator<String> it = jObj.keys();
                    		%>
                    		<tr>
                    		<%
                    		while(it.hasNext()) {
								String key = it.next();
                    %>
                    	<td><%=jObj.getString(key) %></td>
                    <%
                    		}
                    %>
                    	</tr>
                    <%} %>
                      --%>
                    </tbody>
                    <tfoot>
                    	<tr>
                    		<th>Village Name</th>
                    		<th>Family ID</th>
                    		<th>Family Head Name</th>
                    		<th>Project Name</th>
                    		<th>Area in Cents</th>
                    		<th>Crop Weight</th>
                    		<th>Period Income</th>
                    		<th>Family Expense</th>
                    		<th>Harsha Expense</th>
                    		<th>Date Time</th>
                    	</tr>
                      <%-- <tr>
					<%
						
					JSONObject jObj2 = jsonArray.getJSONObject(0);
					Iterator<String> keys1 = jObj2.keys();
							while(keys1.hasNext()) {
								String key = keys1.next();
								%>
						<th align="center"><%=key %></th>
								<%
							}
					%>
					
                      	 <!-- <th align="center">Username</th>
					     <th align="center">Full Name</th>
					     <th align="center">Phone No.</th>
					     <th align="center">Email ID</th>
					     <th align="center">Address</th>
					    <th align="center">Edit</th> -->
					  </tr> --%>
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
        
        </section><!-- /.content -->
        
        <section class="content">
        <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Supervisor Information</h3>
                  <!-- MODAL BUTTON -->
                  
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
                   <!--  <tr>
                    		<th>Village Name</th>
                    		<th>Family ID</th>
                    		<th>Family Head Name</th>
                    		<th>Project Name</th>
                    		<th>Acrage</th>
                    		<th>Crop Weight</th>
                    		<th>Period Income</th>
                    		<th>Family Expense</th>
                    		<th>Harsha Expense</th>
                    	</tr> -->
					<tr>
					<%
						
							JSONObject jObj1 = jsonArray.getJSONObject(0);
							Iterator<String> keys = jObj1.keys();
							while(keys.hasNext()) {
								String key = keys.next();
								%>
						<th align="center"><%=key %></th>
								<%
							}
					%>
					
                      	 <!-- <th align="center">Username</th>
					     <th align="center">Full Name</th>
					     <th align="center">Phone No.</th>
					     <th align="center">Email ID</th>
					     <th align="center">Address</th>
					    <th align="center">Edit</th> -->
					  </tr>
                    </thead>
                    <tbody>
<%--                     <%
                      	for(int i=0; i<jsonArray.length(); i++) {             
                    		JSONObject jObj = jsonArray.getJSONObject(i);
                    %>
                    	<tr>
                    		<td><%=jObj.getString("villageName") %></td>
                    		<td><%=jObj.getString("familyId") %></td>
                    		<td><%=jObj.getString("memberName") %></td>
                    		<td><%=jObj.getString("projectName") %></td>
                    		<td><%=jObj.getString("acrage") %></td>
                    		<td><%=jObj.getString("cropWeight") %></td>
                    		<td><%=jObj.getString("periodIncome") %></td>
                    		<td><%=jObj.getString("familyExpense") %></td>
                    		<td><%=jObj.getString("harshaExpense") %></td>
                    	</tr>
                    <%
                      	}
                    %> --%>
                    <%
                      	for(int i=0; i<jsonArray.length(); i++) {             
                    		JSONObject jObj = jsonArray.getJSONObject(i);
                    		Iterator<String> it = jObj.keys();
                    		%>
                    		<tr>
                    		<%
                    		while(it.hasNext()) {
								String key = it.next();
                    %>
                    	<td><%=jObj.getString(key) %></td>
                    <%
                    		}
                    %>
                    	</tr>
                    <%} %>
                    </tbody>
                    <tfoot>
                    	<!-- <tr>
                    		<th>Village Name</th>
                    		<th>Family ID</th>
                    		<th>Family Head Name</th>
                    		<th>Project Name</th>
                    		<th>Acrage</th>
                    		<th>Crop Weight</th>
                    		<th>Period Income</th>
                    		<th>Family Expense</th>
                    		<th>Harsha Expense</th>
                    	</tr> -->
                      <tr>
					<%
						
					JSONObject jObj2 = jsonArray.getJSONObject(0);
					Iterator<String> keys1 = jObj2.keys();
							while(keys1.hasNext()) {
								String key = keys1.next();
								%>
						<th align="center"><%=key %></th>
								<%
							}
					%>
					
                      	 <!-- <th align="center">Username</th>
					     <th align="center">Full Name</th>
					     <th align="center">Phone No.</th>
					     <th align="center">Email ID</th>
					     <th align="center">Address</th>
					    <th align="center">Edit</th> -->
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
        
        </section><!-- /.content -->
        <!-- 
        <section class="content">
        
        <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Chart</h3>
                  
  					 MODAL ENDS HERE
                </div>/.box-header
                <div class="box-body">
                  <div class="chart">
                    <canvas id="barChart" style="height:250px"></canvas>
                    <canvas id="myChart" width="400" height="400"></canvas>
                  <div id="chartContainer">FusionCharts XT will load here!</div>
                  </div>
                </div>/.box-body
              </div>/.box
        
        </section>/.content
			 -->
            </div><!-- /.col -->
          <!-- Your Page Content Here -->
          
          

        
      

        <!-- Main content -->
        
      </div><!-- /.content-wrapper -->

      <jsp:directive.include file="pages/include/admin_footer.jsp"/>
    <!-- REQUIRED JS SCRIPTS -->
	<!-- <script>
	    function myFunction1(ur){
	    	var myWindow = wsindow.open("managerBaselineinformation.jsp?householdDataId="+document.getElementById(ur).value,"", "width=1000, height=600");
	    }
	</script> -->
  
    <!-- Bootstrap 3.3.5 -->

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
