<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

   <ul>
      <li>Tên đăng nhập :<b>${bean.fullname}</b></li>
      <li>Hình ảnh: <b>${bean.photo}</b></li>
      <li> Ngày Sinh :<b>${bean.birthday}</b></li>
      <li>Giới Tính  :<b>${bean.gender}</b></li>
      <li>Tình trạng hôn nhân  :<b>${bean.married}</b></li>
      <li>Quốc Tịch  :<b>${bean.country}</b></li>
      <li> Sở Thích: <b>  ${bean.hobbies}</b>
     <li>Ghi Chú :<b>${bean.notes}</b></li>
   </ul>
   
  
</body>
</html>