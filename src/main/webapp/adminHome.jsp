<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="com.harsha.app.database.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.codehaus.jettison.json.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
  <link rel="stylesheet" type="text/css"
  href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0-rc2/css/bootstrap-glyphicons.css">
  	 <jsp:directive.include file="pages/include/admin_head.jsp"/>
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
	int totalStaff = DBHandler.displayStaff(dbManager);
	//int totalProject = DBHandler.displayProject(dbManager);
	//int totalVillages = DBHandler.displayVillages(dbManager);
	//int totalFamily = DBHandler.displayFamily(dbManager);
	int totalManager = DBHandler.displayManager(dbManager);
	int totalSupervisor = DBHandler.displaySupervisor(dbManager);
	JSONObject jObj = DBHandler.getAnalysisCount(dbManager);

	int totalState = jObj.getInt("state");
	int totalDistrict = jObj.getInt("district");
	int totalBlock = jObj.getInt("block");
	int totalVillages = jObj.getInt("village");
	int totalFamily = jObj.getInt("family");
	int totalMember = jObj.getInt("member");
	int totalProject = jObj.getInt("project");
	int totalProjectType = jObj.getInt("projecttype");
	int totalServerDocuments = jObj.getInt("serverdocuments");

	%>
  <body class="hold-transition skin-blue sidebar-mini" onload='display_ct();'>
    <div class="wrapper">

       <jsp:directive.include file="pages/include/admin_header.jsp"/>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>Welcome</h1>
          	<ol class="breadcrumb">
            		<li><span id='ct' ></span></li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
        	<div class="row">
        		<div class="col-xs-12">
          			<div class="box box-solid">
						<div class="box-header">
						<br>
           			<div class="box-tools pull-right">
                		<button type="button" class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-minus"></i>
                		</button>
                		<button type="button" class="btn btn-default btn-sm" data-widget="remove"><i class="fa fa-times"></i>
                		</button>
               		</div>
            			</div>
     
        <!-- /.col -->
       <div class="box-body">
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box bg-blue">
              <span class="info-box-icon"><h1><%=totalState %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">STATE</span>
              <span class="info-box-number"><span class="fa fa-globe fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
    
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box bg-blue">
            <span class="info-box-icon"><h1><%=totalDistrict %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">DISTRICT</span>
              <span class="info-box-number"><span class="fa fa-globe fa-3x" aria-hidden="true"></span></span>
              
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>

        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box  bg-blue">
            <span class="info-box-icon"><h1><%=totalBlock %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">BLOCK</span>
              <span class="info-box-number"><span class="fa fa-globe fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box  bg-blue">
            <span class="info-box-icon"><h1><%=totalVillages %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">VILLAGE</span>
              <span class="info-box-number"><span class="fa fa-globe fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
      </div>
    </div>
        </div>
  </div>
  
  <div class="row">
        		<div class="col-xs-12">
          			<div class="box box-solid">
						<div class="box-header">
						<br>
           			<div class="box-tools pull-right">
                		<button type="button" class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-minus"></i>
                		</button>
                		<button type="button" class="btn btn-default btn-sm" data-widget="remove"><i class="fa fa-times"></i>
                		</button>
               		</div>
            			</div>
     
        <!-- /.col -->
       <div class="box-body">
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box bg-blue">
              <span class="info-box-icon"><h1><%=totalFamily %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">FAMILY</span>
              <span class="info-box-number"><span class="fa fa-home fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
    
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box bg-blue">
            <span class="info-box-icon"><h1><%=totalMember %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">FAMILY MEMBER</span>
              <span class="info-box-number"><span class="fa fa-users fa-3x" aria-hidden="true"></span></span>
              
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>

        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box  bg-blue">
            <span class="info-box-icon"><h1><%=totalProjectType %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">INTERVENTION TYPE</span>
              <span class="info-box-number"><span class="glyphicon glyphicon-briefcase fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box  bg-blue">
            <span class="info-box-icon"><h1><%=totalProject %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">INTERVENTION</span>
              <span class="info-box-number"><span class="glyphicon glyphicon-briefcase fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
      </div>
    </div>
        </div>
  </div>
  
  <div class="row">
        		<div class="col-xs-12">
          			<div class="box box-solid">
						<div class="box-header">
						<br>
           			<div class="box-tools pull-right">
                		<button type="button" class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-minus"></i>
                		</button>
                		<button type="button" class="btn btn-default btn-sm" data-widget="remove"><i class="fa fa-times"></i>
                		</button>
               		</div>
            			</div>
     
        <!-- /.col -->
       <div class="box-body">
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box bg-blue">
              <span class="info-box-icon"><h1><%=totalStaff %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">Staff</span>
              <span class="info-box-number"><span class="fa fa-user-circle-o fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
    
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box bg-blue">
            <span class="info-box-icon"><h1><%=totalManager %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">MANAGER</span>
              <span class="info-box-number"><span class="fa fa-male fa-3x" aria-hidden="true"></span></span>
              
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>

        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box  bg-blue">
            <span class="info-box-icon"><h1><%=totalSupervisor %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">SUPERVISOR</span>
              <span class="info-box-number"><span class="fa fa-male fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box  bg-blue">
            <span class="info-box-icon"><h1><%=totalServerDocuments %></h1></span>

            <div class="info-box-content">
              <span class="info-box-text">SERVER DOCUMENTS</span>
              <span class="info-box-number"><span class="fa fa-server fa-3x" aria-hidden="true"></span></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
      </div>
    </div>
        </div>
  </div>
             
       </section><!-- /.content -->
</div>

        <!-- Main content -->
        

      <jsp:directive.include file="pages/include/admin_footer.jsp"/>
    <!-- REQUIRED JS SCRIPTS -->
	
   <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="dist/js/app.min.js"></script>
	<script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
    <!-- jQuery Knob -->
<script src="plugins/knob/jquery.knob.js"></script>
<!-- Sparkline -->
<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- page script -->
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
