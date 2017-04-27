

$('document').ready(function()
{ 
     /* validation */
	 $("#village-updateform").validate({
      rules:
	  {
			
    	  villageName: { required: true, },
    	  villageCode: { required: true, },
	   },
       messages:
	   {
            
    	   villageName:{
                required: "<p style='color:red'>Village Name Is Required</p>"
            },
            villageCode:{
                required: "<p style='color:red'> Village Code Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#village-updateform").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/updatingvillage.jsp',
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
					$("#village-updateform").html('<div class="callout callout-info lead"><h4>Updated Village Data Successfully..!</h4></div>');
					setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminVillage.jsp"; ',4000);//this function is used to send to any page
					
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-update").html('Update');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Village Name and Village Code..!</div>');
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