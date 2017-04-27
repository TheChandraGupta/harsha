

$('document').ready(function()
{ 
     /* validation */
	 $("#occupation-form").validate({
      rules:
	  {
			
    	  occupationCode: { required: true, },
    	  occupationName: { required: true, },
	   },
       messages:
	   {
            
    	   occupationCode:{
                required: "<p style='color:red'>Education Code Is Required</p>"
            },
            occupationName:{
                required: "<p style='color:red'>Education Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#occupation-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingOccupation.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-occupation").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-occupation").remove();
					$("#occupation-form").html('<div class="callout callout-info lead"><h4>Added Occupation Successfully..!</h4></div>');
					//setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminOccupation.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-occupation").html('adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Occupation Name and Occupation Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-occupation").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});