<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle Sales</title>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<%
	
	response.setHeader("cache-Control", "no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("username") == null) 
			response.sendRedirect("home.jsp");
	%>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #92d2ff;">
  <h2><a class="navbar-brand" href="user">VEHICLE SALES</a></h2>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="userSell">Sell</a>
      </li>
      <li class="nav-item">
       <a class="nav-link" href="userBought">Bought</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="userSold">Sold</a>
      </li>

      
    </ul>
    <form class="form-inline my-2 my-lg-0" style="margin-left:20px;" action="logout" method="post">
      <input type="hidden" value="admin" name="role">
      <button class="btn btn-danger my-2 my-sm-0" type="submit">Logout</button>
    </form>
  </div>
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
    	
		<h3 style="padding:20px; text-align:center">Sell Vehicle</h3>
		
	  <form method="post" action="userSell" autocomplete="off" name="myForm" onsubmit="return validateForm()">
		  <div class="form-group" style="margin-left: 50px; margin-right: 50px">
		    <label>Vehicle Number</label>
		    <input type="text" class="form-control" maxlength="10" minlength="3" placeholder="Enter Vehicle Number" name="vehicleNumber">
		  </div>

		  <div class="row">
			  <div class="col">
				<div class="form-group" style="margin-left: 50px;">
					<label>Vehicle Category</label>
					<select class="form-control" name="category">
						<option value="2">Two Wheeler</option>
						<option value="3">Three Wheeler</option>
						<option value="4">Four Wheeler</option>
						<option value="6">Six Wheeler</option>
					</select>
				  </div>
			  </div>
			  <div class="col">
				<div class="form-group" style=" margin-right: 50px">
					<label>Vehicle Brand</label>
					<select class="form-control" name="brand">
						<option value="1">Honda</option>
						<option value="2">Hero</option>
						<option value="3">TVS</option>
						<option value="4">Enfield</option>
						<option value="5">Bajaj</option>
						<option value="6">Suzuki</option>
					</select>
				  </div>
			  </div>
		  </div>
		  <div class="form-group" style="margin-left: 50px; margin-right: 50px">
		    <label>Vehicle Manufacture Year</label>
		    <input type="month" class="form-control" min="2012-01" name="year" value="2012-01">
		  </div>
		  <div class="form-group" style="margin-left: 50px; margin-right: 50px">
		    <label>Vehicle Price</label>
		    <input type="number" class="form-control" name="price" min="5000" max="100000" placeholder="Enter Vehicle Price">
		  </div>
		  
		  <div class="form-group" style="margin-left: 50px; margin-right: 50px">
					<label>Is Vehicle Insured</label>
					<select class="form-control" name="insured">
						<option value="1">Vehicle is Insured</option>
						<option value="0">Vehicle is Not Insured</option>
					</select>
				  </div>

		  <div style="text-align: center; margin-top: 20px; padding-bottom: 20px;">
			<button type="submit" style="width: 200px;" class="btn btn-primary">Sell Vehicle</button>
		  </div>  
	</form>
		
		
	</div>

</body>
</html>


<script>

	function validateForm() {
		let vehicleNumber = document.forms["myForm"]["vehicleNumber"].value;
		let price = document.forms["myForm"]["price"].value;
		
		if(vehicleNumber.trim() == "") {
			alert("Enter Vehicle Number correctly !");
			return false;
		}
		if(price.trim() == "") {
			alert("Enter Vehicle Price correctly !");
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
	margin-top: 20px;
	border-radius: 10px;
	box-shadow: 1px 1px 2px 1px #969696;
	margin-bottom: 30px;
}

body {
	background-color: whitesmoke;
}
</style>