<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<mark>${message}</mark>
<form action="/Lap3/bai4" method="post">
UserName: <input type="text" name="user" value="${username}"><br>
Pass: <input type="password" name="pass" value="${password}">
<br>
<input type ="checkbox" name="remember"><br> remember me?
<hr>
<button>Login</button>
</form>
</body>
</html>