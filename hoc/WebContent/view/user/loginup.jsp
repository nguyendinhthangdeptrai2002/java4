<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<Style>
h2{
 font-size: 20px;
 text-align: center;
 font-weight:bold;
 text-transform: uppercase;

}
.dangky{
text-align: center;
border: ridge;
width :300px;
height: 350px;
position:relative;
margin: 0 auto;
box-shadow: 0px 0px 5px 1px;
margin-top: 50px;
background-color:#EEEEEE;
border-radius: 10px;

}
.input1{

height: 180px;
}
.input1 input{
  width:200px;
  height:20px;
  margin-bottom: 20px;
  border: ridge;
}
.dangky input hover{
 border-color:blue;
 border: ridge;
}
.gui{
 background-color: #DDDDDD;
 height: 20px;
 width:100px;
 margin-top: 20px;
 border-radius: 1px;
}
.gui hover{
border-color: #AAAAAA;
}

.gioitinh input{
margin: 0px;
}
.gioitinh{
margin-left: 45px;

width: 200px;
text-align: left;
}
</Style>
</head>

<body>
<div class="dangky">
<h2> Đăng Ký</h2>
<form action="/hoc/user/loginup" method="post">


  <div class="input1">
  <input type="text" name="username" placeholder="nhập tài khoản"/><br>
  <input type="password" name="password"placeholder="mật khẩu" /><br>
  <input type="password" name="confim-pass"placeholder="xác nhận mật khẩu"/><br>
  <input type="email" name="email" placeholder="email"/> <br><br>
  </div>
  <div class="gioitinh">Giới Tính : 
  <input type="radio" name="gioitinh" value="nam">Nam
   <input type="radio" name="gioitinh" value="nu">Nữ<br>
   </div>
  <button formaction="/hoc/loginup" class="gui">Đăng Ký</button>


</form>


<div> ${error }</div>
</div>

</body>
</html>