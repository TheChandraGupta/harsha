

$('document').ready(function()
{ 
     /* validation */
	 $("#signup-form").validate({
      rules:
	  {
			
			password: { required: true, },
			userName: { required: true, },
	   },
       messages:
	   {
            
			password:{
                required: "<p style='color:red'>please enter your Password</p>"
            },
			userName:{
                required: "<p style='color:red'>please enter your User Name</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#signup-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'signingIn.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-login").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Signing In ...');
			},
			success :  function(response){	
				var s = $.trim(response);

				if(s=="ma"){					
					$("#btn-login").html('<img src="btn-ajax-loader.gif" /> &nbsp; Signing In ...');
					setTimeout(' window.location.href = "managerHome.jsp"; ',1000);//this function is used to send to any page
					
				
				}
				else if(s=="ad"){					
					$("#btn-login").html('<img src="btn-ajax-loader.gif" /> &nbsp; Signing In ...');
					setTimeout(' window.location.href = "adminHome.jsp"; ',1000);//this function is used to send to any page
								
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignIn');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid user name and password..!</div>');
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