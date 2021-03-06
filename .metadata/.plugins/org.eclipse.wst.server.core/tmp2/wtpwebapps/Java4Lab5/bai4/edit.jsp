<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
  <!doctype html>
  <html lang="en">

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Lab 5</title>
  </head>    

  <body>
	<div class="row">
		<div class="col">
			<c:if test="${not empty message}">
			<div class= "alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
			<div class= "alert alert-danger">${error}</div>
			</c:if>
		</div>
	</div>
    <main class="container">
      <div class="row">
        <div class="col">
          <form action="/Java4Lab5/quanlyservlet" method="post">
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
                <button formaction="/Java4Lab5/taikhoan/edit" class="btn btn-primary">Update</button>     
                <a href="/Java4Lab5/bai4/signin.jsp">????ng xu???t</a>         
              </div>
          </form>
        </div>
      </div>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
      integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
      integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
      crossorigin="anonymous"></script>
  </body>

  </html>