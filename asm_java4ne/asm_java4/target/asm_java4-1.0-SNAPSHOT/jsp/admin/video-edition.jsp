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
    <title>Video Management</title>
</head>

<body class="d-flex">
<c:import url="side-bar.jsp"/>
<main class="mt-3 container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="video-list">Video List</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Video Edition</a>
        </li>
    </ul>
    <form action="#" method="post" class="">
        <div class="row col-auto mt-2 mx-2">
            <div class="col bg-light border-rounded border-secondary border">
                <img class="w-100" src="http://i3.ytimg.com/vi/${video.id}/hqdefault.jpg" alt="">
            </div>
            <div class="col mt-3">
                <div class="mb-3">
                    <label for="yt-id" class="form-label">Youtube ID</label>
                    <input type="text" class="form-control" name="id" id="yt-id" placeholder=""
                           value="${video.id}" ${video != null? "readonly":""} required>
                </div>

                <div class="mb-3">
                    <label for="title" class="form-label">Video Title</label>
                    <input type="text" class="form-control" name="title" id="title" placeholder=""
                           value="${video.title}" required>
                </div>

                <div class="mb-3">
                    <label for="views" class="form-label">View Count</label>
                    <input type="number" class="form-control" name="views" id="views" placeholder="" min="0" readonly
                           value="${video eq 'null'? 0: video.views}">
                </div>

                <div class="mb-3 form-check form-switch mx-1">
                    <input class="form-check-input" type="checkbox" name="active" role="switch" id="active" value="true"
                           style="font-size: larger;" ${video.active || video eq null? "checked":""}>
                        <label class="form-check-label" for="active">Active</label>
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="3"
                              autocomplete="on">${video.description}</textarea>
                </div>
            </div>
        </div>

        <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-primary mx-1" formaction="video-edition/create" ${video != null? "disabled":""}>Create</button>
                <button type="submit" class="btn btn-primary mx-1" formaction="video-edition/update" ${video == null? "disabled":""}>Update</button>
                <button type="submit" class="btn btn-danger mx-1" formaction="video-edition/delete" ${video == null? "disabled":""}>Delete</button>
                <button type="submit" class="btn btn-warning mx-1" formaction="video-edition/reset">Reset</button>
        </div>
    </form>
</main>
</body>
</html>
