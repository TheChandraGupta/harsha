
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<jsp:directive.include file="pages/include/admin_head.jsp"/>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" href="dist/img/discoverislam.jpg">
<title>EBS</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="pages/js/validation.min.js"></script>
<script type="text/javascript" src="pages/js/forgot.js"></script>
<link href="style.css" rel="stylesheet" type="text/css" media="screen">
<link rel="stylesheet" href="dist/font-awesome-4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
</head>

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
				<center><h2>Forgot Password</h2>
				<img src="pages/image/harsha.png" height=100 width=100></center><br>
				<form method="post" id="forgot-form">
					<div id="error">
					<!-- error will be shown here ! -->
					</div>
					
					<div class="form-group has-feedback">
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<input type="text" class="form-control" name="email" id="email" placeholder="Email Id"/>
					</div>
					
					
					<div class="row">
						<div class="col-xs-8"></div><!-- /.col -->
						<div class="col-xs-4">
							<input type="submit" class="btn btn-primary btn-block btn-flat" name="btn-forgot" id="btn-forgot" value="Next"/>
							
						</div><!-- /.col -->
					</div>
			</form>
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