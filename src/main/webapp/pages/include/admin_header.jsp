<header class="main-header">
		
		<!-- Logo -->
        <a href="index2.html" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>H</b>T</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>Harsha Trust</b></span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button -->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less--
              <li class="dropdown messages-menu">
                <!-- Menu toggle button --
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-envelope-o"></i>
                  <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 4 messages</li>
                  <li>
                    <!-- inner menu: contains the messages --
                    <ul class="menu">
                      <li><!-- start message --
                        <a href="#">
                          <div class="pull-left">
                            <!-- User Image --
                            <img src="user.png" class="img-circle" alt="User Image">
                          </div>
                          <!-- Message title and timestamp --
                          <h4>
                            Support Team
                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                          </h4>
                          <!-- The message --
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li><!-- end message --
                    </ul><!-- /.menu --
                  </li>
                  <li class="footer"><a href="#">See All Messages</a></li>
                </ul>
              </li><!-- /.messages-menu -->

              <!-- Notifications Menu --
              <li class="dropdown notifications-menu">
                <!-- Menu toggle button --
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-bell-o"></i>
                  <span class="label label-warning">10</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 10 notifications</li>
                  <li>
                    <!-- Inner Menu: contains the notifications --
                    <ul class="menu">
                      <li><!-- start notification --
                        <a href="#">
                          <i class="fa fa-users text-aqua"></i> 5 new members joined today
                        </a>
                      </li><!-- end notification --
                    </ul>
                  </li>
                  <li class="footer"><a href="#">View all</a></li>
                </ul>
              </li>
              <!-- Tasks Menu --
              <li class="dropdown tasks-menu">
                <!-- Menu Toggle Button --
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-flag-o"></i>
                  <span class="label label-danger">9</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 9 tasks</li>
                  <li>
                    <!-- Inner menu: contains the tasks --
                    <ul class="menu">
                      <li><!-- Task item --
                        <a href="#">
                          <!-- Task title and progress text --
                          <h3>
                            Design some buttons
                            <small class="pull-right">20%</small>
                          </h3>
                          <!-- The progress bar --
                          <div class="progress xs">
                            <!-- Change the css width attribute to simulate progress --
                            <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                              <span class="sr-only">20% Complete</span>
                            </div>
                          </div>
                        </a>
                      </li><!-- end task item --
                    </ul>
                  </li>
                  <li class="footer">
                    <a href="#">View all tasks</a>
                  </li>
                </ul>
              </li>
              <!-- User Account Menu -->
              <li class="dropdown user user-menu">
                <!-- Menu Toggle Button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <!-- The user image in the navbar-->
                  <img src="user.png" class="user-image" alt="User Image">
                  <!-- hidden-xs hides the username on small devices so only the image appears. -->
                  <span class="hidden-xs">
                  
                 <%=user.getUserName() %></span>
                
                </a>
                <ul class="dropdown-menu">
                  <!-- The user image in the menu -->
                  <li class="user-header">
                    <img src="user.png" class="img-circle" alt="User Image">
                    <p>
                      <%=user.getUserName() %>
                      <small>   <a href="adminProfile.jsp" class="btn btn-default btn-flat">Profile</a>
                    </small>
                    </p>
                  </li>
                  <!-- Menu Body --
                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">Followers</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Sales</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Friends</a>
                    </div>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                   </div>
                    <div class="pull-left">
                      <a href="adminChangePassword.jsp" class="btn btn-default btn-flat">Change password</a>
                    </div>
                    <div class="pull-right">
                      <a href="index.jsp" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
		
		<!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

          <!-- Sidebar user panel (optional) -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="user.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p><%=user.getUserName() %></p>
              <!-- Status -->
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>

          <!-- search form (Optional) -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->

          <!-- Sidebar Menu -->
          <ul class="sidebar-menu">
            <li>
            	<a href="adminHome.jsp"><i class="fa fa-link"></i> <span>Home</span></a>
            </li>
			<li class="treeview">
              <a href="#"><i class="fa fa-link"></i> <span>Location</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
			  <li><a href="adminState.jsp">State</a></li>
                <li><a href="adminDistrict.jsp">District</a></li>
                <li><a href="adminBlock.jsp">Block</a></li>
                <li><a href="adminVillage.jsp">Village</a></li>
              </ul></li>
             <li >
            	<a href="adminFamily.jsp"><i class="fa fa-link"></i> <span>Family</span></a>
             </li>
             
            
		 	 <li class="treeview">
             	<a href="#">
             		<i class="fa fa-link"></i> 
              			<span>Report</span>
              				<i class="fa fa-angle-left pull-right"></i>
              	</a>
             
            	<ul class="treeview-menu">
			  		<li>
			  			<a href="adminAgricultureReport.jsp">Agriculture Report </a>
			  		</li>
               </ul>
            </li>
             <li><a href="adminUploadExcel.jsp"><i class="fa fa-link"></i> <span>Upload Excel</span> </a></li>
             <li class="treeview">
              <a href="#"><i class="fa fa-link"></i> 
              <span>Intervention</span> <i class="fa fa-angle-left pull-right"></i></a>
             
            <ul class="treeview-menu">
			  <li><a href="adminIntervention.jsp">Intervention </a></li>
                <li><a href="adminInterventionType.jsp">Intervention Type</a></li>
                <li><a href="adminInterventionAttribute.jsp">Intervention Attributes</a></li>
                
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-link"></i> 
              <span>Staff</span> <i class="fa fa-angle-left pull-right"></i></a>
             
            <ul class="treeview-menu">
			  <li><a href="adminManager.jsp">Manager </a></li>
			  <li><a href="adminFieldAgent.jsp">Field Agent </a></li>
			  <li > <a href="adminAddUser.jsp">Add User</a> </li>
             </ul>
            </li>
            
             <li class="treeview">
              <a href="#"><i class="fa fa-link"></i> 
              <span>Master Data</span> <i class="fa fa-angle-left pull-right"></i></a>
             
            <ul class="treeview-menu">
			  <li><a href="adminReligion.jsp">Religion </a></li>
			  <li><a href="adminSocialCategory.jsp">Social Category </a></li>
			  <li><a href="adminScheme.jsp">Scheme </a></li>
			  <li><a href="adminEducation.jsp">Education </a></li>
			  <li><a href="adminOccupation.jsp">Occupation </a></li>
             </ul>
            </li>
           
            <!-- 
			<li class="treeview">
              <a href="#"><i class="fa fa-link"></i> <span>Details</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="studentDetail.php">Student</a></li>
				<li><a href="instituteDetail.php">Institute</a></li>
              </ul>
            </li>-->
			<!-- <li><a href="schedule.php"><i class="fa fa-link"></i> <span>Schedule Test</span></a></li> --
			
            <li class="treeview">
              <a href="#"><i class="fa fa-link"></i> <span>Schedule Test</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="new_schedule.php">New</a></li>
                <li><a href="old_schedule.php">Old</a></li>
              </ul>
            </li>
			<li class="treeview">
              <a href="#"><i class="fa fa-link"></i> <span>Report</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="new_schedule.php">Time Table</a></li>
                <li><a href="old_schedule.php">Duty Done</a></li>
				<li><a href="old_schedule.php">Duty Not Done</a></li>
              </ul>
            </li>
          </ul><!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
      </aside>