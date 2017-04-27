
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<jsp:directive.include file="pages/include/admin_head.jsp"/>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="pages/js/jquery-1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="pages/js/validation.min.js"></script>
<script type="text/javascript" src="pages/js/signin.js"></script>
<script>
function autotab(original,destination){
if (original.getAttribute&&original.value.length==original.getAttribute("maxlength"))
destination.focus()
}</script>
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
			<div class="col-md-4">
			</div>
			<div class="col-md-5" id="redirect">
				<div class="body register-box-body">
				
				<center>
					<h2>Forgot Password</h2>
					<img src="pages/image/harsha.png" height='100' width='100'/>
				</center>
				
				<br>
				
				<form method="post" name="formName" >
					<div id="error">
							<!-- error will be shown here ! -->
					</div>
					<label for="heading" class="col-sm-3 control-label">Enter Pin</label>
					<div class="form-group col-sm-2">
						<input type="text" class="form-control" onKeyup="autotab(this, document.formName.number2)" maxlength=1 name="number1" id="number1"/>
						
					</div>
					<div class="form-group col-sm-2">
						<input type="text" class="form-control" onKeyup="autotab(this, document.formName.number3)" maxlength="1" name="number2" id="number2"/>
						
					</div>
					<div class="form-group  col-sm-2">
						<input type="text" class="form-control" onKeyup="autotab(this, document.formName.number4)" maxlength="1"  name="number3" id="number3"/>
						
					</div>
					<div class="form-group  col-sm-2">
						<input type="text" class="form-control" minlength="1" maxlength="1"  name="number4" id="number4"/>
						
					</div>
					
					<div class="row">
						<div class="col-xs-8"></div><!-- /.col -->
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat" name="btn-login" id="btn-login">Next</button>
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
	        <strong>Copyright &copy; 2016-2017 <a href="#">Yushu Consultancy</a>.</strong> All rights reserved.
      </footer>
      	
      <div class="control-sidebar-bg"></div>
    	</div><!-- ./wrapper -->  
				<script src="bootstrap/js/bootstrap.min.js"></script>
				<!-- AdminLTE App -->
    		<script src="dist/js/app.min.js"></script>

</body>
</html>