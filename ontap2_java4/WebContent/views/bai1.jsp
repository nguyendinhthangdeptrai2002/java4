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
<form action="/ontap_java4/index" method="post"><br>
<input type="text" name="id" placeholder="id"><br>
<input type="text" name="name" placeholder="tên của bạn"><br>
<input type="text" name="email" placeholder="nhập email"><br>
<input type="text" name="birt" placeholder="ngày sinh nhật"><br>
<input type="radio" name="chucvu" value="true">giam doc
<input type="radio" name ="chucvu" value="false">nhanvien
<button formaction="/ontap_java4/user/create">đăng ký</button>
<button formaction="/ontap_java4/user/create">update</button>
<button formaction="/ontap_java4/user/create">delete</button>

</form>
      <table border="1" >
        <thead>
           <tr>
             <th>id</th>
              <th>name</th>
              <th>email</th>
              <th>birt</th>
             <th>chucvu</th>
           </tr>
        </thead>
        <tbody>
       <c:forEach var="item" items="${items}">
          <tr>
          <td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.email}</td>
		<td>${item.birt}</td>
		<td>${item.chucvu?'chucvu':'User'}</td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
</body>
</html>