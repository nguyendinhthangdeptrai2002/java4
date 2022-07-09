<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2> 1. Hình : ${img.name}</h2>
<img src="/Lap3/files/${img.name}" height="100"/>
<h2> 2. Tài Liệu :${doc.name}</h2>	
<a href="/Lap3/files/${doc.name}"> tải về </a>
</body>
</html>