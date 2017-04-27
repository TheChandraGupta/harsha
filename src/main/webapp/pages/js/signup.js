/*
Author: Pradeep Khodke
URL: http://www.codingcage.com/
*/

$('document').ready(function()
{ 
     /* validation */
	 $("#signup-form").validate({
      rules:
	  {
			
			password: { required: true, },
			repassword:{required: true, },
			regno: { required: true, },
			firstname:{ required:true, },
			lastname:{ required:true,},
			branch:{ required:true,},
			desg:{ required:true,},
			email: { required: true, email: true, },
			phoneno : {required: true, number:true, },
	   },
       messages:
	   {
            
			password:{
                required: "<p style='color:red'>please enter your Password</p>"
            },
			regno:{
                required: "<p style='color:red'>please enter your Emp id</p>"
            },
			repassword:{
                required: "<p style='color:red'>please enter your Re-Password</p>"
            },
			firstname:{
                required: "<p style='color:red'>please enter your First name</p>"
            },
			lastname:{
                required: "<p style='color:red'>please enter your Last name</p>"
            },
			branch:{
                required: "<p style='color:red'>please enter your Branch</p>"
            },
			desg:{
                required: "<p style='color:red'>please choose your Designation</p>"
            },
			email: "<p style='color:red'>please enter your Email address</p>",
			phoneno:"<p style='color:red'>please enter your valid Phone no</p>",
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#signup-form").serialize();
				
			$.ajax({
				
			type : 'POST',
			url  : 'pages/faculty/signingup.php',
			data : data,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-login").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
			},
			success :  function(response){						
				if(response=='ok'){					
					$("#btn-login").html('<img src="btn-ajax-loader.gif" /> &nbsp; Signing In ...');
					$("#redirect").html('<div class="callout callout-info lead"><h4>Successfully Registered!</h4><p>Now we are redirecting you to home page....</p></div>');
					setTimeout(' window.location.href = "index.php"; ',6000);//this function is used to send to any page
				}
				else if(response=='nm'){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignUp');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Password not matched..!</div>');
					});
				}
				else if(response=='ra'){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignUp');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Your Registration no is already registered..!</div>');
					});
				}
				else if(response=='ea'){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignUp');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Your email id is already registered..!</div>');
					});
				}
				else if(response=='pa'){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignUp');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Your phone no is already registered..!</div>');
					});
				}
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-login").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});