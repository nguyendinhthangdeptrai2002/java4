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


<!-- Form -->
	<form action="/baove_lan2/bai1" method="post">
	<input value="${form.id}" name="id" placeholder="Username?"><br>
	<input value="${form.name}" name="name" placeholder="Password?"><br>
	<input value="${form.salary}" name="salary" placeholder="Fullname?"><br>
	<input value="${form.department}" name="department" placeholder="Email Address?"><br>
	<input value="${form.address}" name="address" placeholder="Fullname?"><br>
	<input ${form.position?'checked':''} name="admin" type="radio" value="true">trưởng phòng
	<input ${form.position?'':'checked'} name="admin" type="radio" value="false">nhanvien
	<hr>
	
	<button formaction="/baove_lan2/user/update">Update</button>
	
</form>

<table border="1">
<thead>
<tr>
<td>id</td>
<td>name</td>
<td>salary</td>
<td>department</td>
<td>address</td>
<td>position</td>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${nhanvien }">
	<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.salary}</td>
		<td>${item.department}</td>
		<td>${item.address}</td>
		<td>${item.position?'trưởng phòng':'nhân viên'}</td>
		<td> <a href="/baove_lan2/user/edit/${item.id}">Edit</a> </td>
	</tr>
	</c:forEach>
	</tbody>
	
</table>



</body>
</html>