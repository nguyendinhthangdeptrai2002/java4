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
        <div class="row container-fluid justify-content-around">
            <!-- Item -->
            <% for (int i = 0; i < 20; i++) { %>
            <div class="col-md-3 col my-3">
                <div class="card bg-light">
                    <div class="card-img-top">
                        <a href="detail.jsp"><img class="w-100" src="http://i3.ytimg.com/vi/ddaEtFOsFeM/hqdefault.jpg" alt=""></a>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Đen ft. MIN - Bài Này Chill Phết (M/V)</h5>
                        <div class="card-text">Follow me for more videos like this</div>
                    </div>
                    <div class="card-body text-end">
                        <button class="btn btn-warning mx-2" type="submit"><i class="bi bi-heart-fill"></i>
                            Unlike</button>
                        <button class="btn btn-dark" type="submit" data-bs-toggle="modal"
                                data-bs-target="#share-modal"><i class="bi bi-share-fill px-1"></i> Share</button>
                    </div>
                    <div class="card-footer text-end">Last updated 20minutes ago</div>
                </div>
            </div>
           <% }%>

        </div>
        <div class="modal fade" id="share-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
            aria-labelledby="shareModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <form action="" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="shareModalLabel">Share Videos</h5>
                            <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="email" name="email" placeholder="@Input email" class="form-control" required>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary"><i class="bi bi-send"></i> Share</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <footer class="d-flex justify-content-center">
            <nav aria-label="...">
                <ul class="pagination">
                  <li class="page-item disabled">
                    <a class="page-link">Previous</a>
                  </li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item active" aria-current="page">
                    <a class="page-link" href="#">2</a>
                  </li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                  </li>
                </ul>
              </nav>
        </footer>
    </main>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</html>