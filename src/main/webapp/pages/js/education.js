

$('document').ready(function()
{ 
     /* validation */
	 $("#education-form").validate({
      rules:
	  {
			
			educationCode: { required: true, },
			educationName: { required: true, },
	   },
       messages:
	   {
            
    	   educationCode:{
                required: "<p style='color:red'>Education Code Is Required</p>"
            },
            educationName:{
                required: "<p style='color:red'>Education Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#education-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingEducation.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-education").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-education").remove();
					$("#education-form").html('<div class="callout callout-info lead"><h4>Added Education Successfully..!</h4></div>');
					//setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminEducation.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-education").html('adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Education Name and Education Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-education").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});