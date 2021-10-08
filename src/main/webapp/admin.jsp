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
	
		if(session.getAttribute("username") == null || session.getAttribute("username") != "admin") 
			response.sendRedirect("home.jsp");
	%>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #92d2ff;">
  <h2><a class="navbar-brand" href="admin">VEHICLE SALES</a></h2>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="adminAdd">Add</a>
      </li>
      <li class="nav-item">
       <a class="nav-link" href="adminSold">Sold</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="adminUsers">Users</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="adminApprove">Approve</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Vehicles
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <form action="admin" method="post">
            <input type="hidden" name="wheels" value="two">
          	<input type="submit" value="Two Wheeler" class="dropdown-item">
          </form>
          <form action="admin" method="post">
            <input type="hidden" name="wheels" value="three">
          	<input type="submit" value="Three Wheeler" class="dropdown-item">
          </form>
          <form action="admin" method="post">
          <input type="hidden" name="wheels" value="four">
          	<input type="submit" value="Four Wheeler" class="dropdown-item">
          </form>
          <form action="admin" method="post">
          <input type="hidden" name="wheels" value="six">
          	<input type="submit" value="Six Wheeler" class="dropdown-item">
          </form>
          <div class="dropdown-divider"></div>
          <form action="admin" method="post">
          <input type="hidden" name="wheels" value="all">
          	<input type="submit" value="All Vehicles" class="dropdown-item">
          </form>
        </div>
      </li>
      
    </ul>
    <form class="form-inline my-2 my-lg-0" method="post" action="admin">
    	<input type="hidden" value="vNumber" name="wheels">
      <input class="form-control mr-sm-2" type="search" placeholder="Search Vehicles" aria-label="Search" name="number">
      <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <form class="form-inline my-2 my-lg-0" style="margin-left:20px;" action="logout" method="post">
      <input type="hidden" value="admin" name="role">
      <button class="btn btn-danger my-2 my-sm-0" type="submit">Logout</button>
    </form>
  </div>
</nav>

<div class="toast">
		<c:if test="${list.size() == 0}">
		<div class="alert alert-info alert-dismissible fade show" role="alert">
		  There are no Vehicles that you are looking for
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        <span aria-hidden="true">&times;</span>
	      </button>
    	</div>
    	</c:if>
	</div>
	
	<c:if test="${message != null}">
		<div class="toast">
			<div class="alert alert-info alert-dismissible fade show" role="alert">
		  ${message }
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        <span aria-hidden="true">&times;</span>
	      </button>
    	</div>
		</div>
	</c:if>
	
	<c:if test="${list.size() != 0}">
		<h2 class="heading">Vehicles List </h2><h5 class="secondaryHeading">${type }</h5>
		
		<div class="accordion" id="accordionExample">
			<c:forEach var="v" items="${list }">
				<div class="card" >
		    		<div class="card-header" id="headingTwo" data-toggle="collapse" data-target="${v.getIdForHTML()}" aria-expanded="false" aria-controls="${v.vehicleNumber }">
		      			<h5 class="mb-0">
		         			Vehicle : ${v.vehicleNumber }
		      			</h5>
		      			<div>
		      				&#9660
		      			</div>
		    		</div>
		    		<div id="${v.vehicleNumber }" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
		      			<div class="card-body">
		      			<table class="table table-bordered">
		      				<tbody>
    							<tr>
      								<th scope="row">Vehicle Type</th>
      								<td> ${v.vehicleType }  </td>
      							</tr>
      							<tr>
      								<th scope="row">Vehicle Brand</th>
      								<td> ${v.vehicleBrand }  </td>
      							</tr>
      							<tr>
      								<th scope="row">Vehicle Year</th>
      								<td> ${v.vehicleYear }  </td>
      							</tr>
      							<tr>
      								<th scope="row">Vehicle Insurance</th>
      								<td> ${v.getVehicleInsurance() }  </td>
      							</tr>
      							<tr>
      								<th scope="row">Vehicle Rating</th>
      								<td> ${v.vehicleRating } / 10</td>
      							</tr>
      							<tr>
      								<th scope="row">Vehicle Price</th>
      								<td> ${v.vehiclePrice }</td>
      							</tr>
      						</tbody>
		      			</table>
		      			<div class="delete-section">
		      				<form action="adminDeleteVehicle" method="post">
		      					<input type="hidden" name="vNumber" value="${v.vehicleNumber}">
		      					<input type="submit" class="btn btn-danger" value="Delete Vehicle">
		      				</form>
		      			</div>
		      			</div>
		    		</div>
		  		</div>
	  		</c:forEach>
		</div>
	</c:if>

</body>
</html>

<style>
html {
  overflow-y: scroll; 
}
body {
	background-color: whitesmoke;
}

.card {
	width:50%; 
	margin:auto; 
	margin-top:15px;
}

.card-header {
	background-color: white; 
	display:flex; 
	justify-content:space-between
}

.toast {
	width:50%;
	margin:auto;
	margin-top: 20px;
	margin-bottom: 20px;
}

.heading {
	text-align:center;
	margin-top: 20px;
	margin-bottom: 10px;
}

.accordion {
	margin-bottom: 70px;
}

.delete-section {
	display:flex;
	justify-content:flex-end;
}

.table {
	background-color: #fcfcfc;
}

.secondaryHeading {
	text-align:center;
	margin-top: 0px;
	margin-bottom: 20px;
}

</style>