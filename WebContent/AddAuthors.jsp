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
        margin:200px 0;
        height: 100%;
        line-height: 30px;
        color: #56400f;
        text-decoration: none;
        font-weight: bold;
    }

    .button{
    	margin:20px 188px;
    	color: #16400f;
    	width:60px;	
    }
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Authors</title>
</head>
<body>
<h3>Add Author</h3>
	</br>
	<s:form action="AddAuthors">
	<table width="100%" border="0" cellspacing="10" cellpadding="0" align="left">
	<tr>
	     <td width=10% align="left">AuthorID:</td><td align="left"> <s:textfield name="AuthorID" theme="simple" /></td></tr>
         <td align="left">Name:</td><td align="left"><s:textfield name="Name" theme="simple" /></td></tr>
         <td align="left">Age:</td><td align="left"><s:textfield name="Age" theme="simple" /></td></tr>
         <td align="left">Country:</td><td align="left"><s:textfield name="Country" theme="simple" /></td></tr>
	</table>
         <s:submit value="Add" class="button"/>
     </s:form>
     </br></br></br></br></br>
<a href="index.jsp" class="href">Back to Home</a>
</body>
</html>