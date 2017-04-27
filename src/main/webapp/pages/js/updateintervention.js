

$('document').ready(function()
{ 
     /* validation */
	 $("#project-updateform").validate({
      rules:
	  {
			
    	  projectName: { required: true, },
    	  donerName: { required: true, },
	   },
       messages:
	   {
            
    	   projectName:{
                required: "<p style='color:red'>Project Name Is Required</p>"
            },
            donerName:{
                required: "<p style='color:red'> Donor Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#project-updateform").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/updatingIntervention.jsp',
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
					$("#project-updateform").html('<div class="callout callout-info lead"><h4>Updated Intervention Successfully..!</h4></div>');
					//setTimeout(' window.location.href = "adminIntervention.jsp"; ',4000);//this function is used to send to any page
					setTimeout('window.close();',4000);
					//window.close();
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-update").html('Update');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Project Name and Donor Name..!</div>');
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