

$('document').ready(function()
{ 
     /* validation */
	 $("#project-form").validate({
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
			var data = $("#project-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingIntervention.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-project").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-project").remove();
					$("#project-form").html('<div class="callout callout-info lead"><h4>Added Intervention Successfully..!</h4></div>');
				
					//setTimeout(' window.location.href = "adminIntervention.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-project").html('Add');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Project Name and Donor Name..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-project").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Add');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});