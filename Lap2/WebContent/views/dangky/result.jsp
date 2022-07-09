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
      <li>Tên đăng nhập :<b>${param.username}</b></li>
      <li> Mật khẩu :<b>${param.password}</b></li>
      <li>Giới Tính  :<b>${gender}</b></li>
      <li>Tình trạng hôn nhân  :<b>${married}</b></li>
      <li>Quốc Tịch  :<b>${param.country}</b></li>
      <li> Sở Thích: <b>  ${paramValues.hobbies}</b>
     <li>Ghi Chú :<b>${param.notes}</b></li>
   </ul>
   
  
</body>
</html>