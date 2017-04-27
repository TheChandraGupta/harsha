

$('document').ready(function()
{ 
     /* validation */
	 $("#socialcategory-form").validate({
      rules:
	  {
			
			socialCategoryCode: { required: true, },
			socialCategoryName: { required: true, },
	   },
       messages:
	   {
            
    	   socialCategoryCode:{
                required: "<p style='color:red'>socialCategory Code Is Required</p>"
            },
            socialCategoryName:{
                required: "<p style='color:red'>socialCategory Name Is Required</p>"
            },
       },
	   submitHandler: submitForm	
       });  
	   /* validation */
	   
	   /* login submit */
	   function submitForm()
	   {		
			var data = $("#socialcategory-form").serialize();
				
			$.ajax({
			type: "POST",
			url: 'pages/admin/addingSocialCategory.jsp',
			data: data,
			cache: false,
			beforeSend: function()
			{	
				$("#error").fadeOut();
				$("#btn-socialcategory").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; Adding ...');
			},
			success :  function(response){	

				var s = $.trim(response);

				if(s=="ok"){					
					$("#btn-socialcategory").remove();
					$("#socialcategory-form").html('<div class="callout callout-info lead"><h4>Added Social Category Successfully..!</h4></div>');
					//setTimeout('window.close();',1000);
					//setTimeout(' window.location.href = "adminSocialCategory.jsp"; ',1000);//this function is used to send to any page
				}
				else if(s=="na"){
					$("#error").fadeIn(1000, function(){	
					$("#btn-socialcategory").html('adding');
					$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Please enter valid Social Category Name and Social Category Code..!</div>');
					});
				}
				
				else{		
					$("#error").fadeIn(1000, function(){						
						$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+response+' !</div>');
						$("#btn-socialcategory").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
					});
				}
			  }
			});
				return false;
		}
	   /* login submit */
});