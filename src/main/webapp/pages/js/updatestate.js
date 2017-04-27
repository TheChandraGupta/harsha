

$('document').ready(function()
{ 
     /* validation */
	 $("#state-updateform").validate({
      rules:
	  {
			
    	  stateName: { required: true, },
    	  stateCode: { required: true, },
	   },
       messages:
	   {
            
    	   stateName:{
                required: "<p style='color:red'>State Name Is Required</p>"
            },
            stateCode:{
                required: "<p style='color:red'> State Code Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#state-updateform").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/updatingstate.jsp',
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
					$("#state-updateform").html('<div class="callout callout-info lead"><h4>Updated State Data Successfully..!</h4></div>');
					setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminState.jsp"; ',4000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-update").html('Update');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid State Name and State Code..!</div>');
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