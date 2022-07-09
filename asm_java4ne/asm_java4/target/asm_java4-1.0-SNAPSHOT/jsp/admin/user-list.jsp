<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"/>
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
    <title>User Management</title>
</head>

<body class="d-flex">
<c:import url="side-bar.jsp"/>
<main class="mt-3 container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="#">User List</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="user-edition">User Edition</a>
        </li>
    </ul>
    <div class="">
        <table class="table table-hover table-striped ">
            <thead class="table-warning">
            <tr>
                <th scope="col">Username</th>
                <th scope="col">Full name</th>
                <th scope="col">Email</th>
                <th scope="col">Role</th>
                <th scope="col">&nbsp&nbsp&nbsp&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="list" scope="request" type="java.util.List"/>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.fullName}</td>
                    <td>${user.email}</td>
                    <td>${user.admin? "Admin":"User"}</td>
                    <td><a href="user-edition?id=${user.id}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="bg-light d-flex justify-content-between py-2">
        <div class="d-flex align-items-center">
            <span class="">${totalSize} records</span>
        </div>
        <div class="d-flex justify-content-end">
            <c:set var="isFirst" value="${currentPage == 0}"/>
            <c:set var="isLast" value="${currentPage eq lastPage}"/>
            <nav aria-label="...">
                <ul class="pagination">
                    <li class="page-item ${isFirst? 'disabled':''}">
                        <a class="page-link" href="?page=0"> |< </a>
                    </li>
                    <li class="page-item ${isFirst? 'disabled':''}">
                        <a class="page-link" href="?page=${prevPage}"> << </a>
                    </li>
                    <li class="page-item ${isLast? 'disabled':''}" >
                        <a class="page-link" href="?page=${nextPage}"> >> </a>
                    </li>
                    <li class="page-item ${isLast? 'disabled':''}" >
                        <a class="page-link" href="?page=${lastPage}"> >> </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</main>
</body>
</html>
