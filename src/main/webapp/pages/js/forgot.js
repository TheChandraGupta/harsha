

$('document').ready(function()
{ 
     /* validation */
	 $("#forgot-form").validate({
      rules:
	  {
			
			email: { required: true, },
			
	   },
       messages:
	   {
            
			email:{
                required: "<p style='color:red'>please enter your Email</p>"
            },
			
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#forgot-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/forgot.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-forgot").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Checking ...');
			},
			success :  function(response){	
				var s = $.trim(response);

				if(s=="ad"){					
					$("#btn-forgot").html('<img src="btn-ajax-loader.gif" /> &nbsp; Checked ...');
					$("#forgot-form").html('<div class="callout callout-info lead"><h4>Checked Successfully..!</h4></div>');
					
					//setTimeout(' window.location.href = "forgotpassword1.jsp"; ',1000);//this function is used to send to any page
					setTimeout('window.close();',4000);			
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-forgot").html('SignIn');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Email..!</div>');
					});
				}
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-forgot").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});