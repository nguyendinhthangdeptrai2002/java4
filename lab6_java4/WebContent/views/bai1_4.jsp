<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/lab6_java4/bai1_4" method="post">

<input type="radio" name="favorite" value="true" >Favorite
<input type="radio" name="not favorite" value="false"> not Favorite
<button>SHOW</button>
</form>
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
		<c:forEach var="item" items="${videos }">
		<tr>
		<td>${item.id}</td>
				<td>${item.title}</td>
				<td>${item.views}</td>
				<td>${item.active}</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
</body>
</html>