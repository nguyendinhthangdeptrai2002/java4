<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/lab6_java4/index" method="post">
		<input name="username"/><button>Search</button>
	</form>
	<div>
		<p>Fullname: ${user.fullname}</p>
		<p>Email: ${user.email}</p>
	</div>
	
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>VIEWS</th>
				<th>ACTIVE</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${favorites}">
			<tr>
				<td>${item.id}</td>
				<td>${item.video.title}</td>
				<td>${item.video.views}</td>
				<td>${item.video.active}</td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
	
</body>
</html>