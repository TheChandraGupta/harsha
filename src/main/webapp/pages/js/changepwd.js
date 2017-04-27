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
			
			oldpassword: { required: true, },
			newpassword:{required: true, },
			conpassword: { required: true, },
	   },
       messages:
	   {
            
			oldpassword:{
                required: "<p style='color:red'>please enter your old password</p>"
            },
			newpassword:{
                required: "<p style='color:red'>please enter your new password no</p>"
            },
			conpassword:{
                required: "<p style='color:red'>please enter your confirm password</p>"
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
				
			type : 'POST',
			url  : 'changingpwd.php',
			data : data,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-login").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
			},
			success :  function(response){						
				if(response=='ok'){					
					$("#btn-login").html('<img src="btn-ajax-loader.gif" /> &nbsp; Signing In ...');
					$("#redirect").html('<div class="callout callout-info lead"><h4>Successfully Updated!</h4><p>Your password has been changed....</p></div>');
					setTimeout(' window.location.href = "profile.php"; ',3000);//this function is used to send to any page
				}
				else if(response=='nm'){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignUp');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Password not matched..!</div>');
					});
				}
				else if(response=='nk'){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignUp');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Error!</div>');
					});
				}
				else if(response=='np'){
					$("#error").fadeIn(1000, function(){	
					$("#btn-login").html('SignUp');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter your valid old password!</div>');
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