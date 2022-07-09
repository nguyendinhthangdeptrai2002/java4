<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

		<form action="/lab5_java4/account" method="post">
		<label>ID:</label>
		<input name="id" value="${nguoi.id}" type="text"><br>
		<label>Password:</label>
		<input name="password" type="password" value="${nguoi.password}"><br>
		<label>Fullname:</label>
		<input name="fullname" value="${nguoi.fullname}" type="text"><br>
		<label>Email:</label>
		<input name="email" value="${nguoi.email}" type="text"><br>
		<label>Role:</label>
		<label><input ${nguoi.admin?'checked':''} name="admin" type="radio" value="true">Admin</label>
		<label><input ${!nguoi.admin?'checked':''} name="admin" type="radio" value="false">User</label><br>
		<button formaction="/lab5_java4/account/signup">Sign Up</button>
		
          </form>
          <h3>${message}</h3>
</body>
</html>