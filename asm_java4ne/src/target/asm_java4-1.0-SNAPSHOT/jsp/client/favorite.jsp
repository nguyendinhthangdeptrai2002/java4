<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VIDEOS YÊU THÍCH</title>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- bootstrap-icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>

<body>
<c:import url="nav-login.jsp"/>
    <main>
        <div class="row container-fluid justify-content-start">
            <!-- Item -->
            <jsp:useBean id="favList" scope="request" type="java.util.List"/>
            <c:forEach items="${favList}" var="fav">
                <c:set var="vid" value="${fav.video}"/>
                <div class="col-md-3 col my-3">
                    <div class="card bg-light">
                        <div class="card-img-top">
                            <a href="detail?id=${vid.id}"><img class="w-100" src="http://i3.ytimg.com/vi/${vid.id}/hqdefault.jpg" alt=""></a>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-truncate">${vid.title}</h5>
<%--                            <div class="card-text">${video.description}</div>--%>
                        </div>
<%--                        <div class="card-body text-end">--%>
                            <form action="update-like/favorite" method="post" class="card-body text-end">
                                <input type="hidden" value="${vid.id}" name="id">
                            <button class="btn btn-warning mx-2" type="submit"><i class="bi bi-heart-fill"></i>
                                Unlike</button>
                                <button class="btn btn-dark" data-bs-toggle="modal"
                                        data-bs-target="#share-modal-${vid.id}" type="button"><i class="bi bi-share-fill px-1"></i> Share</button>
                            </form>

<%--                        </div>--%>
                        <jsp:useBean id="likeDate" class="java.util.Date"/>
                        <jsp:setProperty name="likeDate" property="time" value="${fav.likeDate}"/>
                        <div class="card-footer text-end">Liked on <%= new java.text.SimpleDateFormat("hh:mm:ss dd/MM/yyyy").format(likeDate)%></div>
                    </div>
                </div>
                <div class="modal fade" id="share-modal-${vid.id}" data-bs-backdrop="static" data-bs-keyboard="false"
                     tabindex="-1" aria-labelledby="shareModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <form action="share-mail/favorite" method="post">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="shareModalLabel">Share Videos</h5>
                                    <button class="btn-close" type="button" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <input type="email" name="email" placeholder="@Input email" class="form-control"
                                           required>
                                    <input type="hidden" value="${vid.id}" name="id">
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Close
                                    </button>
                                    <button type="submit" class="btn btn-primary">
                                        <i class="bi bi-send"></i> Share
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>



        </div>

        <footer class="d-flex justify-content-center">
            <c:if test="${lastPage != 0}">
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
            </c:if>
        </footer>
    </main>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</html>