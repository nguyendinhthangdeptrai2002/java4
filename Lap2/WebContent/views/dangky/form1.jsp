<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  
  <form class="col-md-4">
    <div class="form-group">
      <label for="email">Tên đăng nhập :</label>
      <input type="text" name="username" class="form-control" id="" placeholder="uername">
    </div>
    <div class="form-group">
      <label for="pwd">Mật khẩu:</label>
      <input type="password" name="password"class="form-control" id="pwd" placeholder=" password">
    </div>
 
 <div class="gioitinh" style="display: flex;"> 
    <div class="form-check form-check-inline">
    Giới tính:
  <input class="form-check-input" name="gender" type="radio" value="true" id="inlineRadio1" >
  <label class="form-check-label" for="inlineRadio1">nam</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" name="gender" type="radio" value="true" id="inlineRadio2" >
  <label class="form-check-label" for="inlineRadio2">  nu</label>
</div>
</div>

    <div class="checkbox">
      <label><input name="married" type="checkbox"> đã có gia đình </label>
    </div>
    Quốc Tịch:
    <select class="form-select" name="country" aria-label="Default select example">
  
  <option value="VN">Việt Nam</option>
  <option value="US">Mỹ</option>
  
</select><br>
Sở Thích : <div class="form-check">
  
 
</div>
<div class="sothich" style="display: flex;">

<div class="form-check form-check">
  <input class="form-check-input" name="hobbies"type="checkbox" id="inlineCheckbox1" value="R">
  <label class="form-check-label" for="inlineCheckbox1">nghe nhạc</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" name="hobbies"type="checkbox" id="inlineCheckbox2" value="T">
  <label class="form-check-label" for="inlineCheckbox2">Đọc sách </label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" name="hobbies"type="checkbox" id="inlineCheckbox2" value="M">
  <label class="form-check-label" for="inlineCheckbox2">Bơi Lội</label>
</div>
</div>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Ghi Chú</label>
  <textarea name="notes"class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
    <button type="submit" class="btn btn-default">Submit</button>

</div>
</body>
</html>