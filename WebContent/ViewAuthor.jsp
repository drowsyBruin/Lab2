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
	#table{
		margin:0px 100px;
		
	}
	
	body{
		margin:50px 80px;
	}
	form{
		margin:100px 0;
	}
	
    table tr td{
        height: 25px;
        background: white;
        text-align: center;
        font-size:13px;
    }
    
    .href{
        display: block;
        height: 100%;
        margin:230px 0 0 0;
        line-height: 30px;
        color: #56400f;
        text-decoration: none;
        font-weight: bold;
    }
    
    
</style>
    <head>
        <title>View Author</title>
    </head>
    <body>
       <h3>View Author</h3>
       </br></br>
       <div id="table">
       <s:property escapeHtml="false" value="Output" />
		</div>
    </body>
    </br>
   <a href="CheckAuthor.jsp" class="href">Click Back</a>
</html>

