

$('document').ready(function()
{ 
     /* validation */
	 $("#village-form").validate({
      rules:
	  {
			
    	  villageCode: { required: true, },
    	  villageName: { required: true, },
	   },
       messages:
	   {
            
    	   villageCode:{
                required: "<p style='color:red'>Village Code Is Required</p>"
            },
            villageName:{
                required: "<p style='color:red'>Village Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#village-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingVillage.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-village").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-village").remove();
					$("#village-form").html('<div class="callout callout-info lead"><h4>Added Village Successfully..!</h4></div>');
					
					//setTimeout(' window.location.href = "adminBlock.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-village").html('Adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Village Name and Village Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-village").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Adding');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});