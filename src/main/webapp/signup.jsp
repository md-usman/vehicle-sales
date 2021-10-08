<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>SignUp</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #92d2ff;">
  <h2><a class="navbar-brand" href="home">VEHICLE SALES</a></h2>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
</nav>

<div class="form-box">
	
		<c:if test="${message != null}">
		<div class="alert alert-info alert-dismissible fade show" role="alert">
		  ${message }
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        <span aria-hidden="true">&times;</span>
	      </button>
    	</div>
    	</c:if>
    	
    	<%
		request.removeAttribute("message");
	%>
		
		
		<h3 style="padding:20px; text-align:center">User SignUp</h3>
		
	  <form method="post" action="signup" autocomplete="off" name="myForm" onsubmit="return validateForm()">		  
		  <div class="row">
		  	<div class="col">
		  		<div class="form-group" style="margin-left: 50px;">
		    		<label>First Name</label>
		    		<input type="text" class="form-control" maxlength="15" minlength="3" placeholder="Enter First Name" name="firstName">
		  		</div>
		  	</div>
		  	<div class="col">
		  		<div class="form-group" style=" margin-right: 50px">
		    		<label>Last Name</label>
		    		<input type="text" class="form-control" maxlength="15" minlength="3" placeholder="Enter Last Name" name="lastName">
		  		</div>		  	
		  	</div>
		  </div>
		  <div class="row">
		  	<div class="col">
		  		<div class="form-group" style="margin-left: 50px;">
		    		<label>User Id</label>
		    		<input type="text" class="form-control" maxlength="10" minlength="3" placeholder="Enter User Id" name="userId">
		  		</div>
		  	</div>
		  	<div class="col">
		  		<div class="form-group" style=" margin-right: 50px">
		    		<label>Password</label>
		    		<input type="password" class="form-control" maxlength="15" minlength="3" placeholder="Enter Password" name="password">
		  		</div>		  	
		  	</div>
		  </div>
		  <div class="form-group" style="margin-left: 50px; margin-right: 50px">
		    <label>Phone Number</label>
		    <input type="number" class="form-control" min="1000000000" max="9999999999"  name="phNo" placeholder="Enter Phone Number">
		  </div>
		  <div class="form-group" style="margin-left: 50px; margin-right: 50px">
		    <label>Address</label>
		    <input type="text" class="form-control" name="address" placeHolder="Enter Your Address">
		  </div>
		 <input type="hidden" value="user" name="role">
		 
		 <div style="text-align: center; margin-top: 20px; padding-bottom: 20px;">
			<button type="submit" style="width: 200px;" class="btn btn-primary">SignUP</button>
		  </div>	    
	</form>
		
		
	</div>

</body>
</html>


<script>

	function validateForm() {
		let fname = document.forms["myForm"]["firstName"].value;
		let lname = document.forms["myForm"]["lastName"].value;
		let userId = document.forms["myForm"]["userId"].value;
		let password = document.forms["myForm"]["password"].value;
		let phNo = document.forms["myForm"]["phNo"].value;
		let address = document.forms["myForm"]["address"].value;
		
		if(fname.trim() == "" || lname.trim() == "") {
			alert("Enter your name correctly !");
			return false;
		}
		if(userId.trim() == "" || password.trim() == "") {
			alert("Enter username and password correctly !");
			return false;
		}
		if(phNo.trim() == "" || phNo.length != 10) {
			alert("Enter your phoneNumber Correctly !");
			return false;
		}
		if(address.trim() == "") {
			alert("Enter your address correctly");
			return false;
		}
	}
</script>


<style>
html {
  overflow-y: scroll; 
}
.form-box {
	background-color: white;
	margin-top: 20px;
	width: 50%;
	margin: auto;
	margin-top: 40px;
	border-radius: 10px;
	box-shadow: 1px 1px 2px 1px #969696;
	margin-bottom: 30px;
}

body {
	background-color: whitesmoke;
}
</style>