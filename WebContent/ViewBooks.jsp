<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
	html{
		background-image:url("/21.jpg");
		background-size:1300px 800px;
    	background-repeat: no-repeat;
    	padding: 15px;
	}
	body{
		margin:50px 80px;
	}

    table tr td{
        background: white;
        text-align: center;
        font-size:15px;
    }

    
    
    .href{
    	float:left;
    	margin:270px 30px 0px 0px;
        line-height: 30px;
        color: #56400f;
        text-decoration: none;
        font-weight: bold;
    }
    
        .href1{
        line-height: 30px;
        color: black; 
        text-decoration: none;
        font-size:13px;
        font-weight: bold;
    }
    
        .href2{
        line-height: 30px;
        color: #F2400f;
        text-decoration: none;
        font-size:13px;
    }
</style>
    <head>
        <title>View Books</title>
    </head>
    <body>
    	<h3>View Books</h3>
		</br>
		<div id="table">
		<s:property escapeHtml="false" value="Output" />
		</div>
		<a href="index.jsp" class="href">Back to Home</a>
    </body>
    
</html>
