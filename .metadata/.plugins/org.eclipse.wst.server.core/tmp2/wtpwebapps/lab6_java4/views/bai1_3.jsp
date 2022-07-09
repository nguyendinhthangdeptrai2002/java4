<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
  <form action="/lab6_java4/bai1_3" method="post">
    <input name="videoid">
    <button>search</button>
  </form>
     <table border="1">
         <thead>
          <tr>
          <td>Username</td>
          <td>Fullname</td>
          <td>Email</td>
          <td>Role</td>
          </tr>
         </thead>
         
         <tbody>
         <c:forEach var="item" items="${videos}">
         
         <tr>
          <td>${item.id}</td>
          <td>${item.fullname}</td>
          <td>${item.email}</td>
          <td>${item.admin}</td>
          </tr>
          
         </c:forEach>
         </tbody>
     </table>
     
</body>
</html>