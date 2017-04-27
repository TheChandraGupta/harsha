

$('document').ready(function()
{ 
     /* validation */
	 $("#religion-form").validate({
      rules:
	  {
			
			religionCode: { required: true, },
			religionName: { required: true, },
	   },
       messages:
	   {
            
    	   religionCode:{
                required: "<p style='color:red'>Religion Code Is Required</p>"
            },
            religionName:{
                required: "<p style='color:red'>Religion Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#religion-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingReligion.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-religion").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-religion").remove();
					$("#religion-form").html('<div class="callout callout-info lead"><h4>Added Religion Successfully..!</h4></div>');
					setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminReligion.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-religion").html('adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Religion Name and Religion Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-religion").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});