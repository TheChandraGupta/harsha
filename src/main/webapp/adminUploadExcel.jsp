<%@ page import="com.harsha.app.bean.*" %>
<%@ page import="com.harsha.app.database.*" %>
<%@ page import="com.harsha.app.constant.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.codehaus.jettison.json.JSONArray" %>
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
<%@ page import="org.codehaus.jettison.json.JSONException" %>
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
	
	JSONArray jArray = DataUpload.getAllUploadFileDetails(dbManager);
	
	dbManager.close();
	
	%>
	
  <body class="hold-transition skin-blue sidebar-mini" onload='display_ct();'>
  
 

    <div class="wrapper">

       <jsp:directive.include file="pages/include/admin_header.jsp"/>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Upload and Download Files
            
          </h1>
          <ol class="breadcrumb">
            <li><span id='ct' ></span></li>
            
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
			<div class="box">
                <div class="box-header">
                  <h3 class="box-title">Upload File</h3>
                  
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                		<table class="table table-bordered table-striped">
                			<tr>
                	<form action="DataFileUploadDownload" method="post" enctype="multipart/form-data" >
                				<td align="center" width="35%">
                					<select name="fileName" class="form-control">
                						<option value="Family">Family</option>
                						<option value="Member">Member</option>
                						<option value="Other">Other</option>
                					</select>
                				</td>
                				<td align="center" width="35%">
                					<input type="file" name="fileUpload" class="form-control"/>
                				</td>
                				<td align="center" width="30%">
                					<input type="submit" name="UPLOAD" value="UPLOAD" class="form-control btn btn-primary"/>
                				</td>
                	</form>
                			</tr>
                		</table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
              
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Files Available</h3>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                  <table id="example1" class="table table-bordered table-striped">
                    <thead>
					<tr>
                      <th>File Name Given</th>
                      <th>File Name Assigned</th>
					  <th>File Upload Date</th>
					  <th>Download</th>
					  <th>Delete</th>
					  </tr>
                    </thead>
                    <tbody>
                      <%
                      for(int i=0; i<jArray.length(); i++) {
                      	JSONObject jObj = jArray.getJSONObject(i);
                      %>
                      <tr>
                      	<td align="center"><%=jObj.getString("documentNameGiven") %></td>
                      	<td align="center"><%=jObj.getString("documentNameAssigned") %></td>
                      	<td align="center"><%=jObj.getString("uploadDateTime") %></td>
                      	<td align="center"><a class="btn btn-primary btn-small" href="<%=Constant.BASE_URL%>DataFileUploadDownload/<%=jObj.getString("documentNameAssigned")%>">Download</a></td>
                      	<td align="center">
                      		<form action="DataFileDelete" method="post" >
                      			<input type="hidden" name="serverDocumentsId" value="<%=jObj.getString("serverDocumentsId") %>"/>
                      			<input type="hidden" name="fileName" value="<%=jObj.getString("documentNameAssigned") %>"/>
                      			<input type="submit" class="btn btn-primary btn-small" name="DELETE" value="DELETE"/>
                      		</form>
                      	</td>
                      </tr>
                      <%} %>
                    </tbody>
                    <tfoot>
                      <tr>
                      <th>File Name Given</th>
                      <th>File Name Assigned</th>
					  <th>File Upload Date</th>
					  <th>Download</th>
					  <th>Delete</th>
					  </tr>
                    </tfoot>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->

        </section><!-- /.content -->
        
            </div><!-- /.col -->
          <!-- Your Page Content Here -->

        <!-- Main content -->
        

      <jsp:directive.include file="pages/include/admin_footer.jsp"/>
    
    </div><!-- ./wrapper -->
  
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
