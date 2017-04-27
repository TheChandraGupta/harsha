

$('document').ready(function()
{ 
     /* validation */
	 $("#projectattribute-updateform").validate({
      rules:
	  {
			
    	  attributeType		: { required: true, },
    	  attributeName		: { required: true, },
    	  displaySequence	: { required: true, },
    	  fixedValue		: { required: true, },
    	  
	   },
       messages:
	   {
            
    	    attributeType:{
                required: "<p style='color:red'>Project Name Is Required</p>"
            },
            attributeName:{
                required: "<p style='color:red'> Donor Name Is Required</p>"
            },
            displaySequence:{
                required: "<p style='color:red'> Donor Name Is Required</p>"
            },
            fixedValue:{
                required: "<p style='color:red'> Donor Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#projectattribute-updateform").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/updatingInterventionAttribute.jsp',
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
					$("#project-updateform").html('<div class="callout callout-info lead"><h4>Updated Intervention Attribute Successfully..!</h4></div>');
					//setTimeout(' window.location.href = "adminIntervention.jsp"; ',4000);//this function is used to send to any page
					setTimeout('window.close();',4000);
					//window.close();
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-update").html('Update');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Details..!</div>');
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