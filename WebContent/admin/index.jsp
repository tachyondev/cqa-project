<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0">            
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather Prediction Admin</title>
<style>

.gridPostion{
margin-top:150px;
}
.chipPosition
{
margin-top:10px;
}
.cardPosition{
margin-left: 100px;
}
.demo-card-wide.mdl-card {
  width: 400px;
  height:250px;
}


</style>
</head>
<body style=" background: url('./images/background.jpg') center / cover;">
		<!-- Always shows a header, even in smaller screens. -->
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		  <header class="mdl-layout__header">
		    <div class="mdl-layout__header-row">
		      <!-- Title -->
		      <span class="mdl-layout-title">Weather Prediction Admin</span>
		      <!-- Add spacer, to align navigation to the right -->
		      <div class="mdl-layout-spacer"></div>
		      <!-- Navigation. We hide it in small screens. -->
		      <nav class="mdl-navigation mdl-layout--large-screen-only">
		        <a class="mdl-navigation__link" href="">Home</a>
		        <a class="mdl-navigation__link" href="">Module Settings</a>
		        <a class="mdl-navigation__link" href="">Evaluations</a>
		        <a class="mdl-navigation__link" href="">Log Out</a>
		        
		      </nav>
		    </div>
		  </header>
		  <div class="mdl-layout__drawer">
		    <span class="mdl-layout-title">Weather Prediction Admin</span>
		    <nav class="mdl-navigation">
		    
		    </nav>
		  </div>
		  <main class="mdl-layout__content">
		    <div class="page-content">
		    
		    <div class="mdl-grid gridPostion">
			   <div class="mdl-cell mdl-cell--4-col"></div>
			  
			  <div class="mdl-cell mdl-cell--4-col">
				 <div class="demo-card-wide mdl-card mdl-shadow--2dp cardPosition">
				<center>
				<span class="mdl-chip chipPosition">
				    <span class="mdl-chip__text">Training</span>
				</span>
				</center>
				<hr>
				<div>
				<ul class="demo-list-control mdl-list">
				  <li class="mdl-list__item">
				    <span class="mdl-list__item-primary-content">
				    	Module for PM10
				    </span>
				    <span class="mdl-list__item-secondary-action">
						<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" onclick="trainModulePM10();">
						  Train
						</button>	      
				    </span>
				  </li>
				  <li class="mdl-list__item">
				    <span class="mdl-list__item-primary-content">
				    Module for O3
				    </span>
				    <span class="mdl-list__item-secondary-action">
				    	<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" onclick="trainModuleO3();">
						  Train
						</button>	      
				    </span>
				  </li>
				</ul>  
				</div>
			</div>
				
				
			  </div>
			  <div class="mdl-cell mdl-cell--4-col"></div>
			</div>
		    
		    
		    
		    </div>
		  </main>
		</div>

</body>
<script>
function trainModulePM10()
{
	
	window.swal({
	     title: "Linear Regression",
	     text: "PM10 Module Training Started Plese Wait",
	     icon: "https://i.imgur.com/TZcL7Cc.gif",
	     allowOutsideClick: false
	   });
	 
	 	$.ajax
	    ({
	        type: "POST",
	        data: "train=PM10",
	        url: "../trainworker",
	    success:function(content)
	    {

	    	if(content != "")	 
	    		{
	    		 swal({
	       		  title: "Training Succsfully Done !!!",
	       		  text: content,
	       		  icon: "success",
	       		  button: "Done !",
	       		});		
	    		}else
	    			{
	    			 swal({
	    	    		  title: "Error In module training!!!",
	    	    		  text: "Please contact Developer",
	    	    		  icon: "error",
	    	    		  button: "OK !",
	    	    		});
	    			}
	    
	    	 
	    },
	    
	    });

}

function trainModuleO3()
{
	
	window.swal({
	     title: "Linear Regression",
	     text: "O3 Module Training Started Plese Wait",
	     icon: "https://i.imgur.com/TZcL7Cc.gif",
	     allowOutsideClick: false
	   });
	 
	 	$.ajax
	    ({
	        type: "POST",
	        data: "train=O3",
	        url: "../trainworker",
	    success:function(content)
	    {

	    	if(content != "")	 
	    		{
	    		 swal({
	       		  title: "Training Succsfully Done !!!",
	       		  text: content,
	       		  icon: "success",
	       		  button: "Done !",
	       		});		
	    		}else
	    			{
	    			 swal({
	    	    		  title: "Error In module training!!!",
	    	    		  text: "Please contact Developer",
	    	    		  icon: "error",
	    	    		  button: "OK !",
	    	    		});
	    			}
	    
	    	 
	    },
	    
	    });

}
</script>
</html>