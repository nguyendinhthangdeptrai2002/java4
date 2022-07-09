<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	.hmenu{
	    list-style: none;
	}
	.hmenu>li{
	    display: inline-block;
	    margin-right: 44px;
	    color: blue;
	}
	.hmenu>a{
        Font-variant:small-caps;
        color:blue;
        Text-decoration:none;
    }
    .hmenu>a:visited{
        Color:green;
    }
    .hmenu>a:hover{
        Color:red;
        Text-decoration:underline;
    }
</style>
</head>
<body>
	<form action="/menu.jsp">
		<ul class="hmenu">
	    	<li><a href="#1">Home</a></li>
	    	<li><a href="#2">About Us</a></li>
	    	<li><a href="#3">Contact Us</a></li>
	    	<li><a href="#4">Feedback</a></li>
	    	<li><a href="#5">FAQs</a></li>
   		</ul>
	</form>
</body>
</html>