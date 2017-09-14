<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
	<head>
		<title>Main page</title>
		
		<style>
			.error {
				color: red
			}
		</style>
	</head>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	</head>
	
	<body>
		<form:form action="processSignupForm" modelAttribute="client">
			<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
				<a class="navbar-brand" href="#">
    				<img src="${pageContext.request.contextPath}/resources/images/logo.png" width="30" height="30"/>
  				</a>
	
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
	  				<ul class="navbar-nav mr-auto">
	    				<li class="nav-item active">
	      					<a class="nav-link" href="showRegistrationForm">Registration <span class="sr-only">(current)</span></a>
	    				</li>
					    <li class="nav-item active">
					      	<a class="nav-link" href="showClientsListPage">List of clients</a>
					    </li>
	  				</ul>
		  		</div>
			</nav>
		</form:form>	
	</body>
</html>




///////////////////////////////////////////////////

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<legend>List if clients</legend>
<font size = "4">
	<div class="row">
	    <div class=col-md-1>ID</div>
	    <div class=col-md-3>Name</div>
	    <div class=col-md-3>Surname</div>
	    <div class=col-md-3>Telephone</div>
	    <div class=col-md-3>Doctor</div>
    </div>
</font>

<c:forEach items="${clients}" var="client">
    <br>
    <div class="row">
        <form:form action="UpdateClient" modelAttribute="clients">
            <b>
                <div class=col-md-1>
                    <form:input class="form-control input-md" path="id"
                           value="${client.id}"/>
                </div>
                <div class=col-md-2>
                    <form:input class="form-control input-md" path="name"
                           value="${client.name}"/>
                </div>
                <div class=col-md-2>
                    <form:input class="form-control input-md" path="surname"
                           value="${client.surname}"/>
                </div>
                <div class=col-md-2>
                    <form:input class="form-control input-md" path="telephone"
                           value="${client.telephone}"/>
                </div>
                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-success">
                        Edit
                    </button>
                </div>

            </b>
        </form:form>
        <form:form action="RemoveClient" modelAttribute="client">
            <b>
                <form:input type="hidden" path="id" value="${client.id}"/>
                <div class=col-md-1>
                    <button id="removebrigade" name="removebrigade" class="btn btn-danger">
                        Remove
                    </button>
                </div>
            </b>
        </form:form>
    </div>

</c:forEach>