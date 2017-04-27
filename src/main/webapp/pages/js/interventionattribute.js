

$('document').ready(function()
{ 
     /* validation */
	 $("#projectattribute-form").validate({
      rules:
	  {
			
    	  attributeName: { required: true, },

	   },
       messages:
	   {
            
    	   attributeName:{
                required: "<p style='color:red'>Intervention Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#projectattribute-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingInterventionAttribute.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-projectattribute").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-projectattribute").remove();
					$("#projectattribute-form").html('<div class="callout callout-info lead"><h4>Added intervention Attribute Successfully..!</h4></div>');
					//setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminInterventionAttribute.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-projectattribute").html('Adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Project Name and Donor Name..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-projectattribute").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Adding');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});