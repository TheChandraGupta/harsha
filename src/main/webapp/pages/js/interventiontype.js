

$('document').ready(function()
{ 
     /* validation */
	 $("#projecttype-form").validate({
      rules:
	  {
			
    	  projectTypeName: { required: true, },
    	  
	   },
       messages:
	   {
            
    	   projectName:{
                required: "<p style='color:red'>Project Type Name Is Required</p>"
            },
           
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#projecttype-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingInterventionType.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-projecttype").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-projecttype").remove();
					$("#projecttype-form").html('<div class="callout callout-info lead"><h4>Added Intervention Type Successfully..!</h4></div>');
					//setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminInterventionType.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-projecttype").html('Adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Project Type Name..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-projecttype").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Adding');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});