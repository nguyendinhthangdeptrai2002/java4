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
                <iframe width="100%" height="100%" src="https://www.youtube.com/embed/ddaEtFOsFeM"
                    title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>
            </div>
            <div class="h-25">
                <div class="py-1 bg-light mt-2 border px-2 rounded-3">
                    <h2>Đen ft. MIN - Bài Này Chill Phết (M/V)</h2>
                </div>
                <div class="bg-light border  mt-1 h-50">
                    <p class="text-dark mt-1 mx-2">Follow me for more videos like this </p>
                </div>
                <div class="container-fluid d-flex justify-content-end mt-2">
                    <div class=" py-1 px-1"><button class="btn btn-warning border rounded"><i class="bi bi-hand-thumbs-up-fill px-1"></i> Like</button></div>
                    <div class="py-1 px-1"><button class="btn btn-dark border rounded"><i class="bi bi-share-fill px-1"></i> Share</button></div>
                </div>
            </div>
        </div>
        <div class="mx-3" id="side-bar">
            <h4 class="bg-light py-3 text-center">WATCH MORE VIDEOS</h4>
            <% for (int i = 0; i < 20; i++) { %>
            <div class="row mt-2 border rounded py-1">
<%--                https://www.youtube.com/watch?v=UVbv-PJXm14--%>
                <div class="col">
                    <a href="detail"><img class="img-fluid" src="http://i3.ytimg.com/vi/UVbv-PJXm14/hqdefault.jpg" alt=""></a>
                </div>
                <div class="col-7  d-flex align-items-center"><h6>Mang tiền về cho mẹ <br><br> Đen Vâu</h6>
                </div>
            </div>
            <% }%>
        </div>
    </main>
    <footer></footer>
   
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
crossorigin="anonymous"></script>
</html>