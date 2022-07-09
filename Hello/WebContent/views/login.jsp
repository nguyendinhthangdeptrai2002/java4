<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>LOGIN PAGE</title>
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
    crossorigin="anonymous"></script>
    <style>
      #main{
        background-image: url(https://images.unsplash.com/photo-1442508748335-fde9c3f58fd9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1673&q=80);
      }
      #btn-login{
        background-color: #EF7127;
      }
      #btn-login:hover{
        background-color: #CC5E05;
      }
      a{
        color: #EF7127;
      }
      a:hover{
        color: #CC5E05;
      }
      #forgot-password{
        color:gray;
      }
      #forgot-password:hover{
        color: #EF7127;
      }
    </style>
  </head>
  
  <body class="row justify-content-center mt-3" id="main">
    <div class="col-sm-6 col-md-3 col-4">
      <div class="card border border-1">
        <!-- <div class="card-header text-center text-bold"><h4>LOGIN PAGE</h4></div> -->
        <div class="card-body">
          <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/FPT_logo_2010.svg/1200px-FPT_logo_2010.svg.png"
           alt="" class="w-50 offset-3 my-3">
           <!-- <img src="https://e7.pngegg.com/pngimages/72/808/png-clipart-youtube-vevo-logo-music-video-youtube-text-trademark.png"
            alt="" class="w-50 offset-3 my-3"> -->
          <form action="/account/signin" method="post">
            <div class="form-floating mb-3 mt-3">
              <input type="text" class="form-control" id="uname"    name="id"
                placeholder=" " required>
              <label for="uname">Username</label>
            </div>
    
            <div class="form-floating mb-3 mt-3">
              <input type="password" class="form-control" id="pswd" name="password"
              placeholder=" " required>
              <label for="pswd">Password</label>
            </div>
            <div class="pt-1 d-flex justify-content-between">
              <div class="form-check align-self-center">
                <input class="form-check-input" type="checkbox" id="remember"
                  name="remember" value="true">
                <label class="form-check-label" for="remember" style="color:#EF7127">Remember me</label>
              </div>
              <a href="/Hello/views/forgetPassword.jsp" class="text-decoration-none " id="forgot-password">Forgot password?</a>
            </div>
            
    
            <div class="row d-flex mt-4 justify-content-center pe-2">
             
              <button class="btn py-2 text-white col-8" id="btn-login" type="submit"  formaction="/Hello/account/signin">Login</button>
            </div>
            <h3>${message}</h3>
          </form>
          <div class=" py-2 mt-3 text-center text-muted">Don't have an account? <a href="/Hello/views/signup.jsp">Cick here</a></div>
        </div>
      </div>
      
      
      <!-- <%
      	if(request.getAttribute("error")!=null)
      %> <h3 class="alert alert-danger mt-3">${error }</h3> -->

    </div>
  </body>
  
</html>
