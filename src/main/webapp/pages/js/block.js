

$('document').ready(function()
{ 
     /* validation */
	 $("#block-form").validate({
      rules:
	  {
			
    	  blockCode: { required: true, },
    	  blockName: { required: true, },
	   },
       messages:
	   {
            
    	   blockCode:{
                required: "<p style='color:red'>Block Code Is Required</p>"
            },
            blockName:{
                required: "<p style='color:red'>Block Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#block-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingBlock.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-block").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-block").remove();
					$("#block-form").html('<div class="callout callout-info lead"><h4>Added Block Successfully..!</h4></div>');
					
					//setTimeout(' window.location.href = "adminBlock.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-block").html('Adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Block Name and Block Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-block").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Adding');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});