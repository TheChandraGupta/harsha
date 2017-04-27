<%@ page import="com.harsha.app.database.*" %>
<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Harsha Trust | State Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">


  	<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
	<script type="text/javascript" src="pages/js/validation.min.js"></script>
    <script type="text/javascript" src="pages/js/updatestate.js"></script>

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
int stateId = Integer.parseInt(request.getParameter("stateId"));
int counter = 0;
DBManager dbManager = new DBManager();
StateBean state = DBHandler.getByState(stateId, dbManager);
//getByHouseholdId(householdDataId, dbManager);



%>

<body class="hold-transition skin-blue fixed sidebar-mini" ng-app="myApp1" ng-controller="myCtrl1">
<!-- Site wrapper -->  
					<div class="box">
            <div class="box-header">
            </div>
            <!-- /.box-header -->
            <div class="jumbotron">
            <div class="box-body">
             
					  <form method="post" id="state-updateform" >
					<div class="col-sm-offset-3 col-sm-8">
										<span class='msg' id="error"></span>
								</div>
								
					<label for="heading" class="col-sm-3 control-label">StateName</label>
					<div class="col-sm-8">
									<input type="hidden" name="stateId" id="stateId" value=<%=state.getStateId()%>>
					 	
									<input type="text" class="form-control" name="stateName" value="<%=state.getStateName() %>" >
					</div>
					<br><br><br>
						 <label for="heading" class="col-sm-3 control-label">StateCode</label>
					<div class="col-sm-8">
						 <input type="text" class="form-control" name="stateCode" id="stateCode" value="<%=state.getStateCode() %>" >
					</div>
					 
					<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8">
								
								<br>
									<button type="submit" class="btn btn-primary pull-right" name="btn-update" id="btn-update">Update</button>
								</div>
							</div>
						</form>
					    
			</div>
                  <!--=========end transactions row========-->
                  <!-- /.description-block -->
                </div>
              </div>
              <!-- /.row -->
           
         
<!-- ./wrapper -->



<script src="dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>

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