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
<input type="text"  value="${form.id}" name="id" placeholder="id"><br>
<input type="text"  value="${form.name}" name="name" placeholder="tên của bạn"><br>
<input type="text"  value="${form.email}" name="email" placeholder="nhập email"><br>
<input type="text"  value="${form.birt}" name="birt" placeholder="ngày sinh nhật"><br>
<input type="radio"  ${form.chucvu?'checked':''} name="chucvu" value="true">giam doc
<input type="radio"  ${form.chucvu?'':'checked'} name ="chucvu" value="false">nhanvien
<button formaction="/ontap_java4/user/create">đăng ký</button>
<button formaction="/ontap_java4/user/update">update</button>
<button formaction="/ontap_java4/user/delete">delete</button>
<a href="/ontap_java4/user/index">Reset</a>
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
		<td>${item.chucvu?'giam doc':'nhanvien'}</td>
		<td> <a href="/ontap_java4/user/edit/${item.id}">Edit</a></td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
</body>
</html>