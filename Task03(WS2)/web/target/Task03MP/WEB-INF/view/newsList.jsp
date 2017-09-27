<%@ include file="include/begin-html.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.epam.testapp.model.Messages"%>

<spring:message code="Lbl.NewsList" />
</div>
<c:set var="MESSAGE" value="<%=Messages.message%>" />
<c:set var="RESULT" value="<%=Messages.result%>" />
<c:if test="${MESSAGE != ''}">
	<c:choose>
		<c:when test="${RESULT == 'success'}">
			<div style="background-color: #5cb85c; color: white;">
				${MESSAGE}</div>
		</c:when>
		<c:when test="${(RESULT == 'error')}">
			<div style="background-color: #d9534f; color: white;">
				${MESSAGE}</div>
		</c:when>
	</c:choose>
</c:if>
<br />
<br />
<br />

<form:form action="deleteList">
	<input type="hidden" name="Btn002" value="0" />
	<c:forEach items="${newsList}" var="news" varStatus="status">
		<div class="containerNews">
			<div class="leftform">
				<label for="Title"><spring:message code="Lbl.Title" /></label>
				<c:out value="${news.title}" />
			</div>
			<br /> <br />
			<div class="righttop" style="text-decoration: underline">
				<c:out value="${news.getDateString()}" />
			</div>
			<div class="leftform">
				<textarea class="areaBorderless" readonly rows="5" cols="60"
					name="TxtA001" maxlength="500"><c:out value="${news.brief}"/></textarea>
			</div>
			<div class="bottomright">
				<a class="astext" id="Lnk001" href="NewsListForm/${news.id}"><spring:message
						code="Lbl.view" /></a> <a class="astext" id="Lnk002"
					href="addNewsForm/${news.id}"><spring:message code="Lbl.edit" /></a>
				<input type="checkbox" name="Btn002" value="${news.id}" />
			</div>
			<br /> <br /> <br /> <br /> <br /> <br /> <br />
		</div>
	</c:forEach>
	<div class="bottomright">
		<button
			onclick="return confirm('<spring:message code="Lbl.Confirm"/>')">
			<spring:message code="Lbl.Delete" />
		</button>
	</div>
</form:form>
<br />
<br />
<br />
<br />

</div>
<br />
</div>


<%@ include file="include/end-html.jsp"%>