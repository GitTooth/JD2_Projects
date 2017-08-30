<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<%@ page import="by.htp.webpr.domain.Messages" %>
<legend>List of clients</legend>

<c:set var="MESSAGE" value="<%=Messages.message%>" />
<c:set var="RESULT" value="<%=Messages.result%>" />

<c:if test = "${MESSAGE != ''}">
	<c:choose>
	    <c:when test = "${RESULT == 'success'}">
	        <div class="alert alert-success" style="display:block;" role="alert">
				${MESSAGE}
			</div>
	     </c:when>
	    <c:when test = "${(RESULT == 'danger')}">
	        <div class="alert alert-danger" style="display:block;" role="alert">
				${MESSAGE}
			</div>
	     </c:when>
	</c:choose>
</c:if>


<font size = "4">
	<div class="row">
	    <div class=col-md-1>ID</div>
	    <div class=col-md-2>Name</div>
	    <div class=col-md-2>Surname</div>
	    <div class=col-md-2>Telephone</div>
	    <div class=col-md-2>Doctor</div>
    </div>
</font>

<c:forEach items="${clients}" var="client">
	    <form:form action="update" commandName="client">
		    <div class="row">
		        <div class="col-md-1">
		            <form:input cssClass="form-control" path="id"
		                   value="${client.id}"/>
		        </div>
		        <div class="col-md-2">
		            <form:input cssClass="form-control" path="name"
		                   value="${client.name}"/>
		        </div>
		        <div class="col-md-2">
		            <form:input cssClass="form-control" path="surname"
		                   value="${client.surname}"/>
		        </div>
		        <div class="col-md-2">
		            <form:input cssClass="form-control" path="telephone"
		                   value="${client.telephone}"/>
		        </div>
		        <div class="col-md-2">
		            <button id="Update" name="Update" class="btn btn-success">
		                Save
		            </button>
		        </div>
	        </div>
    	</form:form>
    	<form:form action="delete" commandName="client">
	        <div class="col-md-2">
	        	<form:hidden cssClass="form-control" path="id" value="${client.id}"/>
	            <button id="delete" name="delete" class="btn btn-danger">
	                Remove
	            </button>
	        </div>
        </form:form>   
	<br/>
</c:forEach>
<%@ include file="include/end-html.jsp" %>