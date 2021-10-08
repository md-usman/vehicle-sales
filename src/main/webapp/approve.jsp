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
    </form>
    <form class="form-inline my-2 my-lg-0" style="margin-left:20px;" action="logout" method="post">
      <input type="hidden" value="admin" name="role">
      <button class="btn btn-danger my-2 my-sm-0" type="submit">Logout</button>
    </form>
  </div>
</nav>


<h3 class="heading">Approve Pending Vehicles</h3>

	<div class="toast">
		<c:if test="${message != null}">
		<div class="alert alert-info alert-dismissible fade show" role="alert">
		  ${message }
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        <span aria-hidden="true">&times;</span>
	      </button>
    	</div>
    	</c:if>
	</div>
	
	<%
		request.removeAttribute("message");
	%>

<c:if test="${pendingVehicles.size() == 0 }">
`	<div class="card">
		<h5 class="card-title">There are no Pending Vehicles to Approve, Visit Again later.</h5>
	</div>
</c:if>
	

	<c:forEach items="${pendingVehicles}" var="s">
		<div class="card" >
	      <div class="card-body">
	        <h5 class="card-title">Vehicle Number : ${s.vehicleNumber}</h5>
	        <p class="card-text">Vehicle Type : ${s.vehicleType }</p>
	        <p class="card-text">Vehicle Brand : ${s.vehicleBrand}</p>
	        <p class="card-text">Vehicle Year : ${s.vehicleYear }</p>
	        <p class="card-text">Vehicle Price : ${s.vehiclePrice }</p>
			<p class="card-text">Vehicle Insurance : ${s.isVehicleInsured() }</p>
			<div class="row">
				<div class="col">
						<form action="adminApprove" method="post">
			        	<input type="hidden" name="type" value="delete">
			        	<input type="hidden" name="vehicleNumber" value="${s.vehicleNumber }">
			        	<input type="submit" class="btn btn-danger" value="Delete Vehicle">
	        		</form>		
				</div>

				<div class="col">
					<form action="adminApprove" method="post">
					<div class="form-row">
						<input type="hidden" name="type" value="approve">
						<input type="hidden" name="vehicleNumber" value="${s.vehicleNumber }">
						<div class="col">
						<select class="form-control" name="rating">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
						</div>
						<div class="col" style="margin-right:0">
						<input type="submit" class="btn btn-success" value="Approve Vehicle">
						</div>
					</div>
					</form>
				</div>
			</div>
	      </div>
		</div>
	</c:forEach>

</body>
</html>

<style>
html {
  overflow-y: scroll; 
}

.card {
	background-color: white;
	width:50%;
	margin:auto;
	margin-bottom: 20px;
}

.toast {
	width:50%;
	margin:auto;
}

body {
	background-color: whitesmoke;
}

.heading {
	text-align:center;
	padding: 25px;
}

</style>