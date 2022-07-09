<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SIGNUP PAGE</title>
    <!-- bootstrap -->
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
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <style>
      #main {
        background-image: url(https://images.unsplash.com/photo-1442508748335-fde9c3f58fd9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1673&q=80);
      }
      #btn-login {
        background-color: #ef7127;
      }
      #btn-login:hover {
        background-color: #cc5e05;
      }
      a {
        color: #ef7127;
      }
      a:hover {
        color: #cc5e05;
      }
      #forgot-password {
        color: gray;
      }
      #forgot-password:hover {
        color: #ef7127;
      }
    </style>
  </head>

  <body class="row justify-content-center mt-3" id="main">
    <div class="col-md-5 col-lg-3 col-sm-6">
      <div class="card border border-1">
        <div class="card-body">
          <img
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/FPT_logo_2010.svg/1200px-FPT_logo_2010.svg.png"
            alt=""
            class="w-50 offset-3 my-3"
          />
          <form action="signup" method="post">
            <input type="hidden" name="admin" value="false">
            <div class="mb-3">
              <label for="uname" class="form-label">Username</label>
              <input name="id" type="text" class="form-control" id="uname" placeholder="">
            </div>

            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input name="password" type="password" class="form-control" id="password" placeholder="">
            </div>

            <div class="mb-3">
              <label for="fname" class="form-label">Full name</label>
              <input name="fullName" type="text" class="form-control" id="fname" placeholder="">
            </div>

            <div class="mb-3">
              <label for="email" class="form-label">Email address</label>
              <input name="email" type="email" class="form-control" id="email" placeholder="name@example.com">
            </div>

            <div class="row d-flex mt-4 justify-content-center pe-2">
              <button class="btn py-2 text-white col-8" id="btn-login" type="submit"> Signup
              </button>
            </div>
          </form>
          <div class="py-2 mt-3 text-center text-muted">
            Already have an account? <a href="login">Log-in</a>
          </div>
          <div class=" py-2 mt-3 text-center text-muted"><%
            if (request.getAttribute("error") != null)
          %> <h3 class=" mt-3">${error }</h3></div>
        </div>
      </div>
    </div>
  </body>
</html>
