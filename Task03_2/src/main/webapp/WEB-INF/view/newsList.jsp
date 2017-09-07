<%@ include file="include/begin-html.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    News List
    </div>
    <br/>
    <br/>
	<br/>
	
<form:form action="deleteList">
	<c:forEach items="${newsList}" var="news" varStatus="status">		
		<div class = "containerNews">
		  <div class = "leftform">
		  		News Title <c:out value="${news.title}"/>
		  </div>
		  <br/>
		  <br/>
		  <div class = "righttop"  style = "text-decoration:underline">
		  		<c:out value="${news.getDateString()}"/>
		  </div>
		  <div class = "leftform">
		  		<textarea readonly rows="5" cols = "60" name="TxtA001" maxlength="500"><c:out value="${news.brief}"/></textarea>
  		  </div>
  		  <div class = "bottomright">
		  		<a class="astext" id="Lnk001" href="showNews?getId=${news.id}">view</a>	  		
		  		<a class="astext" id="Lnk002" href="addNewsForm?getId=${news.id}">edit</a>
		  		<input type="checkbox" name="Btn002" value="${news.id}" />
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
  <button>DELETE</button>
</form:form>
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