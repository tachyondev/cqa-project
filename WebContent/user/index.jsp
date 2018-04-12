<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.green-blue.min.css" />
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather Predication</title>
<style>
.demo-layout-transparent {
  background: url('./images/background_new.jpg') center / cover;
}
.demo-layout-transparent .mdl-layout__header,
.demo-layout-transparent .mdl-layout__drawer-button {
  /* This background is dark, so we set text to white. Use 87% black instead if
     your background is light. */
  color: white;
}
.cardPostion{
margin-left: 50px;
}
.gridPostion{
margin-top:150px;
}
.chipPosition{
margin-top: 20px;
}
.demo-card-square.mdl-card {
  width: 400px;
  height:300px;
}

</style>

</head>
<body>

<div class="demo-layout-transparent mdl-layout mdl-js-layout">
  <header class="mdl-layout__header mdl-layout__header--transparent">
    <div class="mdl-layout__header-row">
      <!-- Title -->
      <span class="mdl-layout-title">Weather Prediction</span>
      <!-- Add spacer, to align navigation to the right -->
      <div class="mdl-layout-spacer"></div>
      <!-- Navigation -->
      <nav class="mdl-navigation">
        <a class="mdl-navigation__link" style="color: white;" href="">Home</a>
        <a class="mdl-navigation__link" style="color: white;" href="">Graph</a>
        <a class="mdl-navigation__link" style="color: white;" href="">Admin Panel</a>
        <a class="mdl-navigation__link" style="color: white;" href="">Logout</a>
      </nav>
    </div>
  </header>
  <div class="mdl-layout__drawer">
    <span class="mdl-layout-title">Weather Prediction</span>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="">Home</a>
    </nav>
  </div>
  <main class="mdl-layout__content">
  
  <div class="mdl-grid gridPostion">
			  
			  <div class="mdl-cell mdl-cell--4-col">
		
		  	<div class="demo-card-square mdl-card mdl-shadow--2dp cardPostion">
			  	<center>
				 		<span class="mdl-chip chipPosition">
						    <span class="mdl-chip__text">Predict</span>
						</span>
						<hr>
				   
				  	  <div class="mdl-textfield mdl-js-textfield">
					    <input class="mdl-textfield__input" type="text" id="mRate" name="mRate">
					    <label class="mdl-textfield__label" for="mRate">Mortality Rate</label>
					  </div>
					  <br/>
					  <div class="mdl-textfield mdl-js-textfield">
					    <input class="mdl-textfield__input" type="text" id="T2M" name="T2M">
					    <label class="mdl-textfield__label" for="T2M">T2M</label>
					  </div>
					<br/><br/>
					<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" onclick="predict();">
					  Predict
					</button>
				  </center>
				</div>
			  </div>
			 <div class="mdl-cell mdl-cell--4-col"></div>
			  <div class="mdl-cell mdl-cell--4-col"></div>
			</div>
	</main>
</div>
</body>
<script>

function predict()
{
	var mRate= document.getElementById("mRate").value;
	var T2M = document.getElementById("T2M").value;
	
	window.swal({
	     title: "Predication Started",
	     text: "Plese Wait",
	     icon: "https://i.imgur.com/TZcL7Cc.gif",
	     allowOutsideClick: false
	   });
	 
	 	$.ajax
	    ({
	        type: "POST",
	        data: "mRate="+mRate+"&&T2M="+T2M+"&&test=start",
	        url: "../testworker",
	    success:function(content)
	    {

	    	if(content != "")	 
	    		{
	    			if(content == "error 1")
	    				{
	    				 swal({
		    	    		  title: "Error In Building Test Set!!!",
		    	    		  text: content,
		    	    		  icon: "error",
		    	    		  button: "OK !",
		    	    		});
	    				}else if(content == "-1")
	    					{

		    				 swal({
			    	    		  title: "Error In Predication!!!",
			    	    		  text: content,
			    	    		  icon: "error",
			    	    		  button: "OK !",
			    	    		});
	    					
	    					}else if(content == "-13")
	    						{
	    						
	    						 swal({
				    	    		  title: "Error In Predication of O3!!!",
				    	    		  text: content,
				    	    		  icon: "error",
				    	    		  button: "OK !",
				    	    		});
		    					
	    						}else if(content == "-110")
	    							{
	    							 swal({
					    	    		  title: "Error In Predication of PM10!!!",
					    	    		  text: content,
					    	    		  icon: "error",
					    	    		  button: "OK !",
					    	    		});
			    						
	    							}else 
	    								{
	    								 swal({
	   				    	    		  title: "Predication Done!!!",
	   				    	    		  text: content,
	   				    	    		  icon: "success",
	   				    	    		  button: "OK !",
	   				    	    		});
	   		    					
	    								
	    								}
	    		
	    		
	    		}else
	    			{
	    			 swal({
	    	    		  title: "Error In Predications!!!",
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