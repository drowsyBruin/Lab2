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
	#form{
		padding-left:10px;
	}
	.button{
    	margin:20px 140px;
    	color: #16400f;
    	width:60px;	
    }
    .href{
        display: block;
        height: 100%;
        line-height: 30px;
        color: #56400f;
        text-decoration: none;
        font-weight: bold;
    }
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Authors</title>
</head>
<body>
<h3>Search Author</h3>
	</br></br></br>
	<div id="form" >
	<s:form action="CheckAuthor" >

	Name:&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="Name" theme="simple" /></br>
	&nbsp;
    <s:submit value="Search" class="button"/>
    </s:form>
	</div>
     
</br></br></br></br></br></br></br></br><a href="index.jsp" class="href">Back to Home</a>
</body>
</html>