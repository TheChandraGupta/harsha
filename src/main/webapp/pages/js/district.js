

$('document').ready(function()
{ 
     /* validation */
	 $("#district-form").validate({
      rules:
	  {
			
			districtCode: { required: true, },
			districtName: { required: true, },
	   },
       messages:
	   {
            
    	   districtCode:{
                required: "<p style='color:red'>District Code Is Required</p>"
            },
            districtName:{
                required: "<p style='color:red'>District Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#district-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingDistrict.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-district").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-district").remove();
					$("#district-form").html('<div class="callout callout-info lead"><h4>Added District Successfully..!</h4></div>');
					
					//setTimeout(' window.location.href = "adminDistrict.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-district").html('Adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid District Name and District Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-district").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});