<%@ include file="include/begin-html.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "news" value = "${news}"/>
	<div class = "leftform">
		  		News Title
		  		<c:out value = "${news.title}"/>
		  </div>
		  <br/>
		  <br/>
		  <div class = "leftform">
		  		News Date
		  		<c:out value="${news.date.getDay()}/${news.date.getMonth()}/${news.date.getYear()}"/>
		  </div>
		  <br/>
		  <br/>
		  <div class = "leftform">
		  		<label for = "Brief">Brief&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
		  		<textarea rows="5" cols = "60" name="TxtA001" maxlength="500"><c:out value = "${news.brief}"/></textarea>
  		  </div>
		  <br/>
		  <br/>
		  <br/>
		  <br/>
		  <br/>
		  <br/>
		  <div class = "leftform">
		  		<label for = "Content">Content&nbsp&nbsp&nbsp&nbsp&nbsp</label>
		  		<textarea rows="10" cols = "60" name="TxtA002" maxlength="2048"><c:out value = "${news.content}"/></textarea>
  		  </div>
  		  <div>
	  		  <div class = "bottomright">
	  		  		<button>EDIT</button>
	  		  		<button>DELETE</button>
	  		  </div>
		  </div>
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
<%@ include file="include/end-html.jsp" %>