<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
h2{
 font-size: 20px;
 text-align: center;
 font-weight:bold;
 text-transform: uppercase;

}
.dangnhap{
text-align: center;
border: ridge;
width :300px;
height: 300px;
position:relative;
margin: 0 auto;




box-shadow: 0px 0px 5px 1px;
margin-top: 50px;
background-color:#EEEEEE;
border-radius: 10px;

}
.no1{

}
.no1 input{
width:200px;
height:20px;
 border: ridge;
margin-top: 20px;
margin-bottom: 10px;
}
.dangnhap input hover{
 border-color:blue;
 border: ridge;
}
.gui{
 background-color: #DDDDDD;
 height: 20px;
 width:100px;
 margin-top: 30px;
 border-radius: 1px;
}
.gui hover{
border-color: #AAAAAA;
}
.ghinho{

width: 200px;
text-align: left;
margin-left: 45px;
}
</style>
</head>
<body>
<div class="dangnhap">

<h2> đăng nhập</h2>
<form action="/hoc/user/login" method="post">
 <div class="no1">
  <input type="text" name="username" /><br>


  <input type="password" name="password" /><br>
  </div>
  <div class=" ghinho">
  <input type="checkbox" name="remember"> Ghi Nhớ!
 </div>
 <button formaction="/hoc/login" class="gui">Đăng Nhập</button>


</form>


<div> ${error }</div>
</div>
</body>
</html>