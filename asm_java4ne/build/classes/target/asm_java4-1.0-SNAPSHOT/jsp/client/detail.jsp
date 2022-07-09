<%@ page import="entity.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VIDEO PAGE</title>
    <style>
        #main-video {
            width: 70%;
            height: 590px;
        }

        #side-bar {
            width: 25%;
        }
    </style>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- bootstrap-icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>

<body>
<c:import url="nav-login.jsp"/>

<main class="container-fluid  d-flex">
    <div class="container-fluid mx-2 sticky-top mt-2" id="main-video">
        <div class="h-75">
            <iframe width="100%" height="100%" src="https://www.youtube.com/embed/${video.id}"
                    title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>
        </div>
        <div class="h-25">
            <div class="py-1 bg-light mt-2 border px-2 rounded-3">
                <h2>${video.title}</h2>
            </div>
            <div class="bg-light border  mt-1 h-50">
                <p class="text-dark mt-1 mx-2">${video.description} </p>
            </div>
            <div class="container-fluid d-flex justify-content-end mt-2">
                <div class=" py-1 px-1">
                    <form action="update-like/detail" method="post">
                        <input type="hidden" value="${video.id}" name="id">
                        <button class="btn btn-warning border rounded" type="submit"><i class="bi bi-hand-thumbs-up-fill px-1"></i>
                            <% entity.User auth = (User) session.getAttribute("auth");
                             dao.FavoriteDAO fDAO = new dao.FavoriteDAO();
                            %>
                            <%=fDAO.findOne(auth, ((entity.Video)request.getAttribute("video"))) != null? "Unlike" : "Like"%>
<%--                            <%=auth.getFavoriteList().stream().anyMatch((v)->v.getVideo().getId().equals(((entity.Video)request.getAttribute("video")).getId()))? "Unlike": "Like"%>--%>
                    </button></form>
                </div>
                <div class="py-1 px-1">
                    <button class="btn btn-dark border rounded" type="submit" data-bs-toggle="modal"
                            data-bs-target="#share-modal"><i class="bi bi-share-fill px-1"></i> Share</button>
                </div>
            </div>
        </div>
    </div>
    <div class="mx-3" id="side-bar">
        <% if (request.getAttribute("list") != null) {%>
        <h4 class="bg-light py-3 text-center">WATCH MORE VIDEOS</h4>
        <jsp:useBean id="list" scope="request" type="java.util.List"/>
        <c:forEach items="${list}" var="v">
            <div class="row mt-2 border rounded py-1">
                <div class="col">
                    <a href="detail?id=${v.id}"><img class="img-fluid"
                                                     src="http://i3.ytimg.com/vi/${v.id}/hqdefault.jpg" alt="">

                    </a>
                </div>
                <div class="col-7  d-flex align-items-center"><a href="detail?id=${v.id}" class="nav-link text-black"><h6>${v.title}</h6></a></div>

            </div>
        </c:forEach>
        <%}%>
    </div>
</main>
<footer></footer>
<div class="modal fade" id="share-modal" data-bs-backdrop="static" data-bs-keyboard="false"
     tabindex="-1" aria-labelledby="shareModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form action="share-mail/detail" method="post">
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
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>