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
        font-size:13px;
        line-height:30px;
    }
    
    
    .href{
    	float:left;
    	margin:270px 0px 0px 0px;
        line-height: 30px;
        color: #56400f;
        text-decoration: none;
        font-weight: bold;
    }
</style>
    <head>
        <title>View Book</title>
    </head>
    <body>
    	<h3>View Book</h3>
    	</br>
    	<div id="table">
			<s:property escapeHtml="false" value="Output" />
		</div>	
			 <a href="ViewBooks.action" class="href">Click Back</a>
    </body>
   
</html>
