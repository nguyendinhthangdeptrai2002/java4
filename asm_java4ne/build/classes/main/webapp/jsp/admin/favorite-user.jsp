<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <!-- bootstrap-icons -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"
    />
    <!-- bootstrap-js -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <title>Document</title>
  </head>

  <body class="d-flex">
  <c:import url="side-bar.jsp"/>
    <main class="mt-3 container-fluid">
        <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="favorite">Favorites</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#">Favorite Users</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="share-user">Shared Friends</a>
        </li>
      </ul>
      <form action="favorite-user" class="">
        <label for="video" class="form-label mx-2 my-1">Video Title</label>
<input class="form-control" list="videoList" id="video" placeholder="Type to search..." name="title" value="${title}">
<datalist id="videoList">
  <c:forEach items="${videoList}" var="video">
    <option value="${video.title}">
  </c:forEach>
</datalist>
      </form>
      <div class="mt-3">
        <table class="table table-hover table-striped ">
          <thead class="table-warning">
            <tr>
              <th scope="col">Username</th>
              <th scope="col">Fullname</th>
              <th scope="col">Email</th>
              <th scope="col">Favorite Date</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${favList}" var="favorite">
            <tr>
              <td>${favorite.user.id}</td>
              <td>${favorite.user.fullName}</td>
              <td>${favorite.user.email}</td>
              <jsp:useBean id="date" class="java.util.Date"/>
              <jsp:setProperty name="date" property="time" value="${favorite.likeDate}"/>
              <td><fmt:formatDate value="${date}" type="date"/></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <!-- <div class="bg-light d-flex justify-content-between py-2">
        <div class="d-flex align-items-center">
          <span class="">4 records</span>
        </div>
        <div class="d-flex justify-content-end">
          <button type="submit" class="btn btn-outline-primary mx-1"> |< </button>
          <button type="submit" class="btn btn-outline-primary mx-1"> << </button>
          <button type="submit" class="btn btn-outline-primary mx-1"> >> </button>
          <button type="submit" class="btn btn-outline-primary mx-1"> >| </button>
        </div>
      </div> -->
    </main>
  </body>
</html>
