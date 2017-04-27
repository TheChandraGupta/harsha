

$('document').ready(function()
{ 
     /* validation */
	 $("#scheme-form").validate({
      rules:
	  {
			
			schemeCode: { required: true, },
			schemeName: { required: true, },
	   },
       messages:
	   {
            
    	   schemeCode:{
                required: "<p style='color:red'>Scheme Code Is Required</p>"
            },
            schemeName:{
                required: "<p style='color:red'>Scheme Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#scheme-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingScheme.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-scheme").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-scheme").remove();
					$("#scheme-form").html('<div class="callout callout-info lead"><h4>Added Scheme Successfully..!</h4></div>');
					//setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminScheme.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-scheme").html('adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Scheme Name and Scheme Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-scheme").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});