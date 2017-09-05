<%@ include file="include/begin-html.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<br/>
	<c:forEach items="${newsList}" var="news">
		<div class = "containerNews">
		  <div class = "leftform">
		  		News Title <c:out value="${news.title}"/>
		  </div>
		  <br/>
		  <br/>
		  <div class = "righttop"  style = "text-decoration:underline">
		  		<c:out value="${news.date.getDay()}/${news.date.getMonth()}/${news.date.getYear()}"/>
		  </div>
		  <div class = "leftform">
		  		<textarea readonly rows="5" cols = "60" name="TxtA001" maxlength="500"><c:out value="${news.brief}"/></textarea>
  		  </div>
  		  <div class = "bottomright">
  		  		<form:form action = "showNews" modelAttribute = "news">
  		  			<form:hidden path="id" value="${news.id}"/>
  		  			<button class = "astext">view</button>
  		  		</form:form>
  		  		<form:form action = "addNewsForm" modelAttribute = "news">
  		  			<form:hidden path="id" value="${news.id}"/>
  		  			<button class = "astext">edit</button>
  		  		</form:form>
  		  		<input type="checkbox" name="Cb001" value="a2"/>
  		  </div>
  		  <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	  </div>
  </c:forEach>	  
		  <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
	      <br/>
      </div>
     <br/>
	</div>


<%@ include file="include/end-html.jsp"%>