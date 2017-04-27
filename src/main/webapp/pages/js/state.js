

$('document').ready(function()
{ 
     /* validation */
	 $("#state-form").validate({
      rules:
	  {
			
			stateCode: { required: true, },
			stateName: { required: true, },
	   },
       messages:
	   {
            
    	   stateCode:{
                required: "<p style='color:red'>State Code Is Required</p>"
            },
            stateName:{
                required: "<p style='color:red'>State Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#state-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingState.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-state").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-state").remove();
					$("#state-form").html('<div class="callout callout-info lead"><h4>Added State Data Successfully..!</h4></div>');
					//setTimeout(' window.location.href = "adminState.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-state").html('Add');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid State Name and StateCode..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-state").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Add');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});