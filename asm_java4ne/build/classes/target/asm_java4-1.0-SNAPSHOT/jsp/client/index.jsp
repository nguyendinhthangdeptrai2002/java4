<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Trang Chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- bootstrap-icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

    <link href="/ASM/css/index.css" rel="stylesheet">

</head>

<body>
<div class="container-fluid">
    <c:import url="nav-login.jsp"/>
    <div class="header">
        <!-- Background image -->
        <div class="p-5 text-center bg-image"
             style="background-image: url('data:image/jpeg;base64,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'); height: 400px;">
            <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
                <div class="d-flex justify-content-center align-items-center h-100">
                    <div class="text-white">
                        <h1>ONLINE ENTERTAINMENT</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="body">

        <div class="row container-fluid justify-content-around">
            <!-- Item -->
            <%--            <% for (int i = 0; i < 20; i++) { %>--%>
            <%--            <div class="col-md-3 col my-3">--%>
            <%--                <div class="card bg-light">--%>
            <%--                    <div class="card-img-top">--%>
            <%--                        <a href="detail"><img class="w-100" src="http://i3.ytimg.com/vi/ddaEtFOsFeM/hqdefault.jpg" alt=""></a>--%>
            <%--                    </div>--%>
            <%--                    <div class="card-body">--%>
            <%--                        <h5 class="card-title">Đen ft. MIN - Bài Này Chill Phết (M/V)</h5>--%>
            <%--                        <div class="card-text">Follow me for more videos like this</div>--%>
            <%--                    </div>--%>
            <%--                    <div class="card-body text-end">--%>
            <%--                        <button class="btn btn-warning mx-2" type="submit"><i class="bi bi-heart-fill"></i>--%>
            <%--                            Like</button>--%>
            <%--                        <button class="btn btn-dark" type="submit" data-bs-toggle="modal"--%>
            <%--                                data-bs-target="#share-modal"><i class="bi bi-share-fill px-1"></i> Share</button>--%>
            <%--                    </div>--%>
            <%--                    <div class="card-footer text-end">Last updated 20minutes ago</div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <% }%>--%>
        </div>

        <div class="row container-fluid justify-content-start">
            <!-- Item -->
            <jsp:useBean id="list" scope="request" type="java.util.List"/>
            <jsp:useBean id="fDAO" scope="request" class="dao.FavoriteDAO"/>
            <c:forEach items="${list}" var="video">
                <div class="col-md-3 col my-3">
                    <div class="card bg-light">
                        <div class="card-img-top">
                            <a href="detail?id=${video.id}"><img class="w-100"
                                                      src="http://i3.ytimg.com/vi/${video.id}/hqdefault.jpg" alt=""></a>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-truncate">${video.title}</h5>
                                <%--                            <div class="card-text">${video.description}</div>--%>
                        </div>
                            <%--                        <div class="card-body text-end">--%>
                        <form action="update-like/index" method="post" class="card-body text-end">
                            <input type="hidden" value="${video.id}" name="id">
                            <button class="btn btn-warning mx-2" type="submit"><i class="bi bi-heart-fill"></i>
                                <c:set value="${video.id}" var="idVideo" scope="request"/>

                                <c:choose>
                                    <c:when test="${auth != null}">
                                        <%=fDAO.findOne((entity.User) session.getAttribute("auth"), (String) request.getAttribute("idVideo")) != null ? "Unlike" : "Like"%>
                                    </c:when>
                                    <c:otherwise>
                                        Like
                                    </c:otherwise>
                                </c:choose>
                            </button>
                            <button class="btn btn-dark" data-bs-toggle="modal"
                                    data-bs-target="#share-modal-${video.id}" type="button"><i
                                    class="bi bi-share-fill px-1"></i> Share
                            </button>
                        </form>

                            <%--                        </div>--%>
                        <div class="card-footer text-end">Views: ${video.views}</div>
                    </div>
                </div>
                <div class="modal fade" id="share-modal-${video.id}" data-bs-backdrop="static" data-bs-keyboard="false"
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
                                    <input type="hidden" value="${video.id}" name="id">
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
        <%--        <div class="modal fade" id="share-modal" data-bs-backdrop="static" data-bs-keyboard="false"--%>
        <%--             tabindex="-1" aria-labelledby="shareModalLabel" aria-hidden="true">--%>
        <%--            <div class="modal-dialog modal-dialog-centered">--%>
        <%--                <div class="modal-content">--%>
        <%--                    <form action="" method="post">--%>
        <%--                        <div class="modal-header">--%>
        <%--                            <h5 class="modal-title" id="shareModalLabel">Share Videos</h5>--%>
        <%--                            <button class="btn-close" type="button" data-bs-dismiss="modal"--%>
        <%--                                    aria-label="Close"></button>--%>
        <%--                        </div>--%>
        <%--                        <div class="modal-body">--%>
        <%--                            <input type="email" name="email" placeholder="@Input email" class="form-control"--%>
        <%--                                   required>--%>
        <%--                        </div>--%>
        <%--                        <div class="modal-footer">--%>
        <%--                            <button type="button" class="btn btn-secondary"--%>
        <%--                                    data-bs-dismiss="modal">Close--%>
        <%--                            </button>--%>
        <%--                            <button type="submit" class="btn btn-primary">--%>
        <%--                                <i class="bi bi-send"></i> Share--%>
        <%--                            </button>--%>
        <%--                        </div>--%>
        <%--                    </form>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
    </div>
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
                <li class="page-item ${isLast? 'disabled':''}">
                    <a class="page-link" href="?page=${nextPage}"> >> </a>
                </li>
                <li class="page-item ${isLast? 'disabled':''}">
                    <a class="page-link" href="?page=${lastPage}"> >> </a>
                </li>
            </ul>
        </nav>
    </c:if>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>

</body>

</html>