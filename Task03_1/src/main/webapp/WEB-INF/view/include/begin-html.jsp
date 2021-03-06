<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
	<title>Main page</title>
	<style>
		.containerNews{
			position: relative;	
			float:top;
			float:bottom;
		}
	
		.containerTop {
		    position: relative;
		    border-style: solid solid none solid;
		    border-width: 2px;
		}
	
		.container {
		    position: relative;
		    border-style: solid solid solid solid;
		    border-width: 2px;
		}
				
		.containerBottom {
		    position: relative;
		    border-style: solid;
		    border-style: none solid solid solid;
		    border-width: 2px;
		}
		
		.explorer {
        	position: relative;
            left:3%;
            top:10px;
            float:left;
			width: 20%;
			hight: 20%;
		    background-color:grey;
		}
        
        .explorerTitle{
        	position: absolute;
            width: 90%;
            hight: 30px;
		    top:10px;
		    left:5%;
            text-align:center;
		    background-color:powderblue;
            text-color:white;
        }
        
        .explorerList{
        	position: absolute;
            width: 75%;
            hight: 150px;
		    top:35%;
		    left:20%;
            font-size:14px;
            text-align:center;
		    background-color:white;
        }
        
        .newsContainer{
        	position:relative;
            left:25%;
            top:10px;
            width:73%;
        	border-style: groove;
		    border-width: 2px;
		    border-color:grey;
        }
		
		.righttop{
			position: absolute;
			right:10%;
			top:0%;
		}
		
		.leftcenter {
			position: absolute;
   			left: 5%;
   			top: 8%;
		}
        
        .lefttop{
        	position: absolute;
   			left: 2%;
   			top: 2%;
            font-size:14px;
		}

		.bottomright {
		    position: absolute;
		    bottom: 10%;
		    right: 3%;
		}
        
        .center {
            position: absolute;
            left: 0;
            top: 50%;
            width: 100%;
            text-align: center;
            font-size: 18px;
		}
		
		.middle {
            position: absolute;
            left: 0;
            top: 63%;
            width: 100%;
            text-align: center;
            font-size: 18px;
		}
		
		.leftform{
			position: absolute;
			left: 8%;
			
		}
		
		.astext {
		    background:none;
		    border:none;
		    margin:0;
		    padding:0;
		}
		
		textarea { vertical-align: top; }
		
	</style>

	<div class = "containerTop">
		<div class = "leftcenter">
			<h2>News management</h2>
		</div>
           <br/>
           <br/>
           <br/>
           <br/>
		<div class="bottomright">
          <a class="nav-link" href="#">English</a>
          <a class="nav-link" href="#">Russian</a>
		</div>
	</div>
	<div class = "container">
      <div class = "explorer">
        <div class = "explorerTitle">
          News
        </div>
        <div class = "explorerList">
          <br/>
          <a class="nav-link" href="NewsListForm">News List</a>
          <br/>
          <a class="nav-link" href="addNewsForm">Add News</a>
          <h3/>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>

      </div>
      <div class = "newsContainer">
      	<div class = "lefttop">
        	<a class="nav-link" href="#">News</a>
            >>
            News List
	    </div>
	    <br/>
	    <br/>
	      