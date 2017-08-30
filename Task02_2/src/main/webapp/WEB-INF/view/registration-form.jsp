<%@ include file="include/begin-html.jsp" %>
<form:form action="processRegistrationForm" modelAttribute="client">
	<div class="row">
		<div class="col-md-4 col-md-offset-3">
			<label>Name*</label>
			<br/>
			<form:input path="name" cssClass="form-control"/>
			<form:errors path="name" cssClass="error" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-3">
			<label>Surname*</label>
			<br/>
			<form:input path="surname" cssClass="form-control"/>
			<form:errors path="surname" cssClass="error" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-3">
			<label>Telephone*</label>
			<br/>
			<form:input path="telephone" cssClass="form-control" placeholder="***-**-**"/>
			<form:errors path="telephone" cssClass="error" />
		</div>
	</div>
	
	<!--form:select path="doctor" items="${doctors}"/-->

	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>
<%@ include file="include/end-html.jsp" %>
