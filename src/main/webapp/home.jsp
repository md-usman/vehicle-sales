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
<title>Vehicle Sales</title>
</head>
<body>

<div class="back-color">


<div class="title">
	<h1>VEHICLE SALES</h1>
	<h5>We buy and sell vehicles</h5>
	<div class="description">
		<p><strong>Description : </strong> This project is made as a part of completion<br> of the Internship at <a style="color:white" target="_blank" href="https://e-box.co.in/">Amphisoft (Ebox)</a>.</p>
		<p>Link to repository : <a style="color:white" href="https://github.com/md-usman" target="_blank">Vehicles sales</a></p>
	</div>
</div>


<div class="row">
	<div class="col-md-10 col-lg-6 homeInfo">
		
	</div>
	<div class="col-md-10 col-lg-6 signIn">
		<div class="form-box">
			<c:if test="${message != null}">
				<div class="alert alert-info alert-dismissible fade show" role="alert">
			  		${message }
				  	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        	<span aria-hidden="true">&times;</span>
			      	</button>
	    		</div>
	    	</c:if>
			<h3 style="padding:20px; text-align:center">Login</h3>
			<form method="post" action="login" autocomplete="off">		  
		  		<div class="form-group" style="margin-left: 50px; margin-right: 50px">
				    <label>User Id</label>
				    <input type="text" class="form-control"  name="username" placeholder="Enter your UserId">
		  		</div>
		  		<div class="form-group" style="margin-left: 50px; margin-right: 50px">
		    		<label>Password</label>
		    		<input type="password" class="form-control" name="pass" placeholder="Enter your Password">
		  		</div>
		 		<div style="text-align: center; margin-top: 20px; padding-bottom: 20px;">
					<button type="submit" style="width: 200px;" class="btn btn-primary">Login</button>
		  		</div>    
			</form>
			<h6 style="text-align:center"><a href="signup" style="color: black">Not a user? SignUp</a></h6>
		</div>
	</div>
</div>

</div>
</body>
</html>

<style>

html {
  overflow-y: scroll; 
}

.back-color {
	background-color: rgba(0,0,0, 0.3);

}

.description {
	margin-top: 150px;
}

body {
	background-image: url('bike.jpg');
  	background-repeat: no-repeat;
  	background-attachment: fixed;  
  	background-size: cover;
	height: 100vh;
	position: relative;
}

.title{
	position: absolute;
	color: white;
	font-family: "Lucida Console", Courier, monospace;
	top: 18%;
	left: 10%;
}

.title h1 {
	font-weight: bold;
	font-size: 4rem;
}


.form-box {
	background-color: white;
	width: 60%;
	padding-bottom: 20px;
	border-radius: 10px;
	box-shadow: 1px 1px 2px 1px #969696;
}

.row {
	display: flex;
	height:100vh;
	align-items: center;
}

.homeInfo {
}
.signIn {
	display: flex;
	justify-content: center;
}

</style>