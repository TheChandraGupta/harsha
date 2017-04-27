
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<jsp:directive.include file="pages/include/admin_head.jsp"/>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
<link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
<link rel="stylesheet" href="dist/font-awesome-4.5.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="dist/css/AdminLTE.min.css"/>
<link rel="stylesheet" href="dist/css/skins/skin-blue.min.css"/>

<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="pages/js/validation.min.js"></script>
<script type="text/javascript" src="pages/js/signin.js"></script>
</head>
<%
session.invalidate();
%>
<body class="hold-transition skin-blue layout-top-nav">
    <div class="wrapper">
      <!-- Main Header -->
     <header class="main-header">
        <nav class="navbar navbar-static-top">
          <div class="container">
            <div class="navbar-header">
               <a href="#" class="logo">
					<!-- logo for regular state and mobile devices -->
					<span class="logo-lg" style="font-family:Lucida Handwriting"><b>Harsha Trust</b></span>
				</a>
            </div>
          </div><!-- /.container-fluid -->
        </nav>
      </header>
		<!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
		<div class="container">
			<div class="col-md-3">
			</div>
			<div class="col-md-6" id="redirect">
			<div class="body register-box-body">
				<center><h2>Sign In to Harsha Trust</h2>
				<img src="pages/image/harsha.png" height=100 width=100></center><br>
				<form method="post" id="signup-form">
					<div id="error">
					<!-- error will be shown here ! -->
					</div>
					
					<div class="form-group has-feedback">
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<input type="text" class="form-control" name="userName" id="userName" placeholder="User Name">
					</div>
					
					<div class="form-group has-feedback">
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<input type="password" class="form-control" name="password" id="password" placeholder="Password">
					</div>
					<div class="row">
						<div class="col-xs-8"></div><!-- /.col -->
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat" name="btn-login" id="btn-login">Sign In</button>
						</div><!-- /.col -->
					</div>
			</form>
         <a href="forgotpassword.jsp" class="text-center">Don't Remember Password--Click Here</a><!-- address -->
      </div><!-- /.form-box -->
    </div><!-- /.register-box -->
			</div>
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
	  <!-- Main Footer -->
      <footer class="main-footer">
        <!-- To the right -->
        
        <!-- Default to the left -->
        <strong>Copyright &copy; 2016-2017 <a href="#">Yushu Consultancy</a>.</strong> All rights reserved.
      </footer>
      <div class="control-sidebar-bg"></div>
    </div><!-- ./wrapper -->  
	<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
    <script src="dist/js/app.min.js"></script>

</body>
</html>