<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		Tên sản phẩm: ${item.name} <br/>
		<img src="views/image/${item.image}" width="200px" height="250px"/> <br/>
		Giá gốc: <strike>${item.price}</strike> <br/>
		Giá mới: 
			<c:set var="newprice" value="${item.price*(1-item.discount)}" />
			<fmt:formatNumber value="${newprice}" /> <br/>
		Mức giá:
		<c:choose>
			<c:when test="${newprice< 10}">Giá thấp</c:when>
			<c:when test="${newprice> 100}">Giá cao</c:when>
			<c:otherwise>Bình thường</c:otherwise>
		</c:choose>
		<div class="itemdate">Ngày: 14-02-2022</div>
	</center>
</body>
</html>