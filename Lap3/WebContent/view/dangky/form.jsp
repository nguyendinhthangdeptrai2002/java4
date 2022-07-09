
<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

  <form action="/Lap3/bai2" method="post" enctype="multipart/form-data">
  Tên Đăng Nhập :<input name="fullname"><br><br>
  
  Hình Ảnh :   <input type="file" name="photo_file"><br>
  ngày sinh  : <input name="birthday" type="Date"><br>
  
  
  Giới Tính :
  <input name="gender" type="radio" value="true">Nam
  <input name="gender" type="radio"value="false">Nữ<br>
  <input name="married" type="checkbox">Đã Có Gia Đình ?<br>
  Quốc Tịch:<select name="country">
  <option value="VN">viet nam</option>
  <option value="TQ"> trung quốc</option>
  </select><br>
  
  Sở thích:
<input name="hobbies" type="checkbox" value="R">Đọc sách
<input name="hobbies" type="checkbox" value="T">Du lịch
<input name="hobbies" type="checkbox" value="M">Âm nhạc
<input name="hobbies" type="checkbox" value="O">Khác<br>
  Ghi chú : <textarea name="notes" rows="3" cols="30" ></textarea>
  <hr>
  <button > Đăng Ký</button>
       
      </form>
      <h3> ${error}</h3>
</body>
</html>