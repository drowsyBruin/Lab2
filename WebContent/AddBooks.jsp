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
    .href{
        
        height: 100%;
        line-height: 30px;
        color: #56400f;
        text-decoration: none;
        font-weight: bold;
    }

    .button{
    	margin:20px 240px;
    	color: #16400f;
    	width:60px;	
    }
    
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Books</title>
</head>
<body>
<h3>Add Book</h3>
	<s:form action="AddBooks">
	</br>
	<table width="100%" border="0" cellspacing="10" cellpadding="0" align="left">
	<tr>
	     <td align="left">ISBN:</td><td align="left"> <s:textfield name="ISBN" theme="simple" /></td></tr>
         <td align="left">Title:</td><td align="left"><s:textfield name="Title" theme="simple" /></td></tr>
         <td align="left">AuthorID:</td><td align="left"><s:textfield name="AuthorID" theme="simple" /></td></tr>
         <td align="left">Publisher:</td><td align="left"><s:textfield name="Publisher" theme="simple" /></td></tr>
         <td width="14%" align="left">PublishDate:</td><td align="left"><s:textfield name="PublishDate" theme="simple" /></td></tr>
         <td align="left">Price:</td><td align="left"><s:textfield name="Price" theme="simple" /></td></tr>
	</table>
	&nbsp;
         <s:submit class="button" value="Add"/>
     </s:form>
     
<a href="index.jsp" class="href">Back to Home</a>
</body>
</html>