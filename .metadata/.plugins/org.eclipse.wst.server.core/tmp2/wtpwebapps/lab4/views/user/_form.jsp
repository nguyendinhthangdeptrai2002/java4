<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<mark>${message}</mark>
	<h3>User Edition</h3>
	<form action="/lab4/user.php" method="post">
		Username: 
		<input name="username" value="${form.username}"><br> 
		Password: 
		<input name="password" value="${form.password }"><br> 
		<input name="remember"type="checkbox" checked="${form.remember }"> 
		Remember me? 
		<br>
		<button>Create</button>
	</form>
</body>
</html>