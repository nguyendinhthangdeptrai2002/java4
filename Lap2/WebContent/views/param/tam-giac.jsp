<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Lap2/tamgiac" method="post">
 <input name ="a" placeholder="cạnh a?"> <br>
 <input name ="b" placeholder="cạnh b?"><br>
 <input name ="c" placeholder ="cạnh c?"><br>
 <button formaction="/Lap2/dien-tich">Tính diện tích </button>
 <button formaction="/Lap2/chu-vi">Tính chu vi </button>
</form>
<h3>${message }</h3>
</body>
</html>