<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Thông báo -->
	${message}
	<c:url var="url" value="/user" />

	<!-- Form -->
	<form action="${url}/index" method="post">
	<input value="${form.id}" name="id" placeholder="Username?"><br>
	<input value="${form.password}" name="password" placeholder="Password?"><br>
	<input value="${form.fullname}" name="fullname" placeholder="Fullname?"><br>
	<input value="${form.email}" name="email" placeholder="Email Address?"><br>
	<input ${form.admin?'checked':''} name="admin" type="radio" value="true">Admin
	<input ${form.admin?'':'checked'} name="admin" type="radio" value="false">User<br>
	<hr>
	<button formaction="${url}/create">Create</button>
	<button formaction="${url}/update">Update</button>
	<button formaction="${url}/delete">Delete</button>
	<a href="${url}/index">Reset</a>
</form>

	<!-- Bảng -->
	<table border="1" style="width: 100%">
	<c:forEach var="item" items="${items }">
	<tr>
		<td>${item.id}</td>
		<td>${item.password}</td>
		<td>${item.fullname}</td>
		<td>${item.email}</td>
		<td>${item.admin?'Admin':'User'}</td>
		<td> <a href="${url}/edit/${item.id}">Edit</a> </td>
	</tr>
	</c:forEach>
</table>
</body>
</html>