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
              <div class="form-group">
                <label for="Id">User ID:</label>
                <input value="${user.id}" type="text" name="id" class="form-control">
              </div>
              <div class="form-group">
                <label for="Password">Password:</label>
                <input value="${user.password}" type="password" name="password"  class="form-control">
              </div>
              <div class="form-group">
                <label for="Fullname">FullName:</label>
                <input value="${user.fullname}" type="text" name="fullname" class="form-control" >
              </div>
              <div class="form-group">
                <label for="Email">Email:</label>
                <input type="text" name="email" class="form-control" value="${user.email}">
              </div>
              <div class="form-check form-check-inline">
                <label for="">Role: </label><br>
                <label class="ml-2"><input ${user.admin?'checked':''} type="radio" name="admin" value="true" 
                class="form-check-input">Admin</label><br>
                <label class="ml-2"><input ${!user.admin?'checked':''} type="radio" name="admin" 
                 value="false" class="form-check-input">User</label>
              <div class="form-group">
              
                <button formaction="/lab5_java4/account/edit" class="btn btn-primary">Update</button>     
                <a href="/lab5_java4/views/account/sign-in.jsp">Đăng xuất</a>         
              </div>
              <h3>${message}</h3>
          </form>
          <h3>${message}</h3>
</body>

</html>