

$('document').ready(function()
{ 
     /* validation */
	 $("#changepassword-form").validate({
      rules:
	  {
			
    	  	oldpassword: { required: true, },
			newpassword:{required: true, },
			conpassword: { required: true, },
	   },
       messages:
	   {
            
    	   oldpassword:{
                required: "<p style='color:red'>Old Password Is Required</p>"
            },
            newpassword:{
                required: "<p style='color:red'>New Password Is Required</p>"
            },
            conpassword:{
                required: "<p style='color:red'>Confirm Password  Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#changepassword-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/updatingPassword.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-update").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Updating ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-update").html('<img src="btn-ajax-loader.gif" /> &nbsp; Updated');
					$("#changepassword-form").html('<div class="callout callout-info lead"><h4>Password Chnaged Successfully..!</h4></div>');
					setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminProfile.jsp"; ',4000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-update").html('Update');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Passwords..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-update").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Adding');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});