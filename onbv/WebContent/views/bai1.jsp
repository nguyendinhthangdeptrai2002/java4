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

<table border="1">
 <thead>
 <tr>
  <th>id</th>
  <th>name</th>
  <th>sodt</th>
  <th>email</th>

  <th>ngaysinh</th>
  <th>chucvu</th>
 </tr>
 </thead>
<tbody>


<c:forEach var="item" items="${nhanvien}">
<tr>
<td>${item.id}</td>
<td>${item.name}</td>
<td>${item.sodt}</td>
<td>${item.email}</td>
<td>${item.ngaysinh }</td>
<td>${item.chucvu?'giamdoc':'nhanvien'})</td>
</tr>
</c:forEach>
</tbody>

</table>
</body>
</html>