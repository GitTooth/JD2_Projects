<%@ include file="include/begin-html.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="Lbl.AddNews" />
</div>
<br />
<br />

<c:set var="news" value="${news}" />
<form:form action="http://localhost:8080/web/${localeCode}/update"
	modelAttribute="news">
	<form:hidden path="id" value="${news.id}" />
	<div class="leftform">
		<spring:message code="Lbl.Title" />
		<form:input path="title" size="60" name="Txt001" maxlength="100"
			value="${news.title}" />
		<br />
		<form:errors path="title" cssClass="error" />
	</div>
	<br />
	<br />
	<div class="leftform">
		<spring:message code="Lbl.Date" />
		<form:input path="date" size="20" name="Txt003" maxlength="10"
			value="${news.getDateString()}" />
		<br />
		<form:errors path="date" cssClass="error" />
	</div>
	<br />
	<br />
	<div class="leftform">
		<label for="Brief"><spring:message code="Lbl.Brief" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
		<form:textarea path="brief" rows="5" cols="60" name="TxtA001"
			maxlength="500" value="${news.brief}" />
		<br />
		<form:errors path="brief" cssClass="error" />
	</div>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div class="leftform">
		<label for="Content"><spring:message code="Lbl.Content" />&nbsp&nbsp&nbsp&nbsp&nbsp</label>
		<form:textarea path="content" rows="10" cols="60" name="TxtA002"
			maxlength="2048" value="${news.content}" />
		<br />
		<form:errors path="content" cssClass="error" />
	</div>

	<div>
		<div style="position: absolute; bottom: 10%; right: 55%;">
			<button>
				<spring:message code="Lbl.SAVE" />
			</button>
		</div>
	</div>
</form:form>
<form:form action="http://localhost:8080/web/${localeCode}/NewsListForm">
	<div style="position: absolute; bottom: 10%; right: 45%;">
		<button>
			<spring:message code="Lbl.CANCEL" />
		</button>
	</div>
</form:form>

<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
</div>
<br />
</div>
<%@ include file="include/end-html.jsp"%>