<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="com.harsha.app.database.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
  
  	 <jsp:directive.include file="pages/include/admin_head.jsp"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
 <script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="pages/js/validation.min.js"></script>
    <script type="text/javascript" src="pages/js/profile.js"></script>
   
	
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
                  <h3 class="box-title">Profile Information</h3>
                  <!-- MODAL BUTTON -->
                  
                  	 <br><br><br>
  					
  					 <!-- MODAL ENDS HERE -->
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                    <form method="post" id="profile-form" >
					<div class="col-sm-offset-3 col-sm-8">
										<span class='msg' id="error"></span>
								</div>
								
					<label for="heading" class="col-sm-3 control-label">First Name</label>
					<div class="col-sm-8">
							<input type="text" class="form-control" name="firstName" id="firstName" value="<%=user.getFirstName()%>">
					</div>
					<br><br><br>
					
					<label for="heading" class="col-sm-3 control-label">Last Name</label>
					<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"  name="lastname" value="<%=user.getLastName()%>">
                    </div>
					<br><br><br>
					<label for="heading" class="col-sm-3 control-label">Email Id</label>
					<div class="col-sm-8">
					  <input type="email" class="form-control" id="email" name="email" value="<%=user.getEmail()%>">
                  </div>
					<br><br><br>
					<label for="heading" class="col-sm-3 control-label">Phone Number</label>
					<div class="col-sm-8">
					  <input type="number" class="form-control" id="phonenumber" name="phonenumber" value="<%=user.getPhone()%>">
                  </div>
					<br><br><br>
					<label for="heading" class="col-sm-3 control-label">Address</label>
					<div class="col-sm-8">
					<input type="text" class="form-control" id="address" name="address"  value="<%=user.getAddress()%>" >
                   </div>
					<br><br><br> 
					
					<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8">
								
								<br>
									<button type="submit" class="btn btn-primary pull-right" name="btn-update" id="btn-update">OK</button>
								</div>
							</div>
						</form>
					
                   <br><br><br><br><br><br><br><br><br><br>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          <!-- Your Page Content Here -->

        </section><!-- /.content -->

        <!-- Main content -->
        
      </div><!-- /.content-wrapper -->

      <jsp:directive.include file="pages/include/manager_footer.jsp"/>
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
