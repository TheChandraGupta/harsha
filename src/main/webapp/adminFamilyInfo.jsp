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
  <title>Harsha Trust | BaselineInfo Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.js"></script>
  <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
  <link href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
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

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
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
long familyId = Long.parseLong(request.getParameter("familyId"));
System.out.println(familyId);
int counter = 0;
DBManager dbManager = new DBManager();

ArrayList<FamilyMember> familyMember =DBHandler.getByfamilymember(familyId,dbManager);

//FamilyMember familyMember =DBHandler.getByfamilymember(familyId,dbManager);


//DistrictBean districtBean=DBHandler.getByDistrictId(memberId, dbManager);
//System.out.println(FamilyMemberBean.);
//getByHouseholdId(householdDataId, dbManager);



%>

<body class="hold-transition skin-blue fixed sidebar-mini" >
<!-- Site wrapper -->


  
   
					<div class="box">
            <div class="box-header">
            </div>
            <!-- /.box-header -->
            <div class="jumbotron">
            <div class="box-body">
              <table class="table table-bordered table-striped">
					<thead>
					<form name="form" method="post" id="form" >
					<tr>
							<th colspan="6">
							<%
							if(msg==null || msg.equals("")) {
								
							}
							else
							{
								%>
								<%=msg %>
								<%} %>
							</th>
					</tr>
					<tr>
                      <th align="center">Head Name</th>
					  <th align="center">Date Of Birth</th>
					  <th align="center">VoterId Card</th>
					  <th align="center">Aadhar Card</th>
					  <th align="center">Job Card</th>
					  <th align="center">Approval Status</th>
					  
					</tr>
					
					</thead>
					
					<tbody><tr>
	       				<%
						int i =0;
						while(i<familyMember.size()) {
							FamilyMember familyMemberBean = familyMember.get(i);
							i++;
						%>
						
					     <td ><%=familyMemberBean.getName() %></td>
					 	
					     <td ><%=familyMemberBean.getDob() %></td>
					 	
					     <td ><%=familyMemberBean.getVoterId() %></td>
					 	
					     <td ><%=familyMemberBean.getAadhaarCardId() %></td>
					     
					     <td ><%=familyMemberBean.getJobCard()%></td>
					     
					     <td >
							<% if(familyMemberBean.getApprovalStatus().equals("-1")){ %>
										<span class="text-warning">pending</span>	
							<%} else if(familyMemberBean.getApprovalStatus().equals("0")){ %>
										<span class="text-primary">accepted</span>	
							<%} else{ %>
										<span class="text-danger">reject</span>	
							<%} %>
						 </td>
						
					 	</tr>
					 	
					 <%
					}
					%>
					</tbody>
					</form>
				</table>
				 
			</div>
                  <!--=========end transactions row========-->
                  <!-- /.description-block -->
                </div>
              </div> 
              <!-- /.row -->
           
         
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script>
var app = angular.module('myApp1', []);
app.controller('myCtrl1', function($scope, $http) {
$scope.sortType     = 'name'; // set the default sort type
$scope.sortReverse  = false;  // set the default sort order
$scope.searchFish   = '';     // set the default search/filter term

 
$http.get('http://10.1.1.117:8085/HarshaProject/api/household/getallhousehold')



  .success(function(data) {
  $scope.countries = data;
  console.log("countries:" + $scope.countries );
  console.log("Length:" + $scope.countries.length );
  $scope.viewby = 10;
  $scope.length1=$scope.countries.length;
  console.log("Length:" +  $scope.length1 );
  $scope.totalItems = $scope.length1;
  $scope.currentPage = 4;
  $scope.itemsPerPage = $scope.viewby;
  $scope.maxSize = 5; //Number of pager buttons to show

	  
  });
  $scope.setPage = function (pageNo) {
    $scope.currentPage = pageNo;
  };

  $scope.pageChanged = function() {
    console.log('Page changed to: ' + $scope.currentPage);
  };

$scope.setItemsPerPage = function(num) {
  $scope.itemsPerPage = num;
  $scope.currentPage = 1; //reset to first paghe
}
});
</script>
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