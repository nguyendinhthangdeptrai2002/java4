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
          <form action="/Java4Lab5/thongtinservlet" method="post">
              <div class="form-group">
                <label for="Id">User ID:</label>
                <input value="${nguoi.id}" type="text" name="id" class="form-control">
              </div>
              <div class="form-group">
                <label for="Password">Password:</label>
                <input value="${nguoi.password}" type="password" name="password"  class="form-control">
              </div>
              <div class="form-group">
                <label for="Fullname">FullName:</label>
                <input value="${nguoi.fullname}" type="text" name="fullname" class="form-control" >
              </div>
              <div class="form-group">
                <label for="Email">Email:</label>
                <input type="text" name="email" class="form-control" value="${nguoi.email}">
              </div>
              <div class="form-check form-check-inline">
                <label for="">Role: </label><br>
                <label class="ml-2"><input ${nguoi.admin?'checked':''} type="radio" name="admin" value="true" 
                class="form-check-input">Admin</label><br>
                <label class="ml-2"><input ${!nguoi.admin?'checked':''} type="radio" name="admin" 
                 value="false" class="form-check-input">User</label>
              </div>
              <div class="form-group">
                <button formaction="/Java4Lab5/thongtinservlet/insert" class="btn btn-primary">Insert</button>
                <button formaction="/Java4Lab5/thongtinservlet/update" class="btn btn-danger">Update</button>
                <button formaction="/Java4Lab5/thongtinservlet/reset" class="btn btn-primary">Reset</button>
               
              </div>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col">
          <table class="table table-stripe">
          
            <tr> 
              <td>User</td>
              <td>Fullname</td>
              <td>Password</td>
              <td>Email</td>
              <td>Role</td>
              <td>Click</td>
            </tr>
            <c:forEach var="item" items="${items}">
            <tr>
              <td>${item.id}</td>
              <td>${item.fullname}</td>
              <td>${item.password}</td> 
              <td>${item.email}</td>
              <td>${item.admin? 'Admin':'User'}</td>
              <td><a href="/Java4Lab5/thongtinservlet/edit?id=${item.id}">Edit</a>
              	<a href="/Java4Lab5/thongtinservlet/delete?id=${item.id}">Delete</a>
              </td>
            </tr>
            </c:forEach>
          </table>
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