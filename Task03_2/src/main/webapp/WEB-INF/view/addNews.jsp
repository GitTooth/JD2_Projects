<%@ include file="include/begin-html.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    Add News
    </div>
    <br/>
    <br/>
	    
<c:set var = "news" value = "${news}"/>
	<form:form action = "update" modelAttribute = "news">
		<form:hidden path="id" value="${news.id}"/>
		  <div class = "leftform">
		  		News Title
		  		<form:input path = "title" size="60" value = "${news.title}"/>
		  </div>
		  <br/>
		  <br/>
		  <div class = "leftform">
		  		News Date
		  		<form:input path = "date" size="20" value = "${news.getDateString()}"/>
		  </div>
		  <br/>
		  <br/>
		  <div class = "leftform">
		  		<label for = "Brief">Brief&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
		  		<form:textarea path = "brief" rows="5" cols = "60" name="TxtA001" maxlength="500" value = "${news.brief}"/>
	 		  </div>
		  <br/>
		  <br/>
		  <br/>
		  <br/>
		  <br/>
		  <br/>
		  <div class = "leftform">
		  		<label for = "Content">Content&nbsp&nbsp&nbsp&nbsp&nbsp</label>
		  		<form:textarea path = "content" rows="10" cols = "60" name="TxtA002" maxlength="2048" value = "${news.content}"/>
	 	  </div>
	 		  
 		  <div>
	  		  <div style = "position: absolute; bottom: 10%;right: 55%;"> 		
	  		  		<button>Save</button>
	  		  </div>
 		  </div>
	  </form:form>
	  <form:form action = "cancel">
	  	  <div style = "position: absolute; bottom: 10%;right: 45%;">
	  		<button>Cancel</button>	 
  		  </div> 
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
      </div>
     <br/>
	</div>
<%@ include file="include/end-html.jsp" %>