

$('document').ready(function()
{ 
     /* validation */
	 $("#user-form").validate({
      rules:
	  {
    	      	userName  	: { required: true, },
    		    password 	: { required: true, },
    		    role 		: { required: true, },
    		    firstName 	: { required: true, },
    		    lastName  	: { required: true, },
    		    email 		: { required: true, },
    		    phone 		: { required: true, },
    		    address 	: { required: true, },
    		    photo	 	: { required: true, },
			
	   },
       messages:
	   {
            
    	   userName:{
                required: "<p style='color:red'>UserName Is Required</p>"
            },
            password:{
                required: "<p style='color:red'>Password Is Required</p>"
            },
            role:{
                required: "<p style='color:red'>Role Is Required</p>"
            },
            firstName:{
                required: "<p style='color:red'>First Name Is Required</p>"
            },
            lastName:{
                required: "<p style='color:red'>Last Name Is Required</p>"
            },
            email:{
                required: "<p style='color:red'>Email Is Required</p>"
            },
            phone:{
                required: "<p style='color:red'>Phone Number Is Required</p>"
            },
            address:{
                required: "<p style='color:red'>Address Is Required</p>"
            },
            photo:{
                required: "<p style='color:red'>Photo Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#user-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingUser.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-user").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-user").html('<img src="btn-ajax-loader.gif" /> &nbsp; Adding ...');
					setTimeout(' window.location.href = "adminManager.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-user").html('adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Details..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-user").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});