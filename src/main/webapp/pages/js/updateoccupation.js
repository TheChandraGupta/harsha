

$('document').ready(function()
{ 
     /* validation */
	 $("#occupation-updateform").validate({
      rules:
	  {
			
    	  occupationName: { required: true, },
    	  occupationCode: { required: true, },
	   },
       messages:
	   {
            
    	   occupationName:{
                required: "<p style='color:red'>Occupation Name Is Required</p>"
            },
            occupationCode:{
                required: "<p style='color:red'> Occupation Code Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#occupation-updateform").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/updatingoccupation.jsp',
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
					$("#occupation-updateform").html('<div class="callout callout-info lead"><h4>Updated Occupation Data Successfully..!</h4></div>');
					setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminOccupation.jsp"; ',4000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-update").html('Update');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Occupation Name and Occupation Code..!</div>');
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