<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
            .column{
                width: 25%;
                float: left;
            }
            .san-pham{
                border-radius: 10px;
                box-shadow: 0px 0px 5px gray;
                padding: 10px;
                margin: 5px;
                text-align: center;
            }
            .san-pham>.ten{
                font-size: larger;
                font-variant: small-caps;
                color:black;
            }
            .san-pham>img{
                max-width: 95%;
                height: 200px;
            }
            .san-pham>.gia{
                color:rgb(44, 178, 240);
                font-weight: bold;
                font-size: larger;
            }
            .san-pham>.gia-moi{
                color: orange;
                font-weight: bold;
                font-size: larger;
            }
            .san-pham>.muc-gia{
                font-weight: bold;
            }
</style>
</head>
<body>
	<div class="container">
		<c:forEach var="item" items="${items}">
		<div class="column">
			<div class="san-pham">
			<div class="ten">${item.name}</div>
			<img src="views/image/${item.image}">
			<div class="gia"><strike>${item.price}</strike></div>
			<div class="gia-moi">${item.price*(1-item.discount)}</div>
			</div>
		</div>
		</c:forEach>
	</div>

	<div class="container">
		<div class="column">
			<div class="san-pham">
			<br/> <div class="ten">Tên sản phẩm: ${item.name}</div>
			<br/> <img src="views/image/${item.image}" />
			<br/> <div class="gia">Giá gốc: <strike>${item.price}</strike></div>
			<br/> <div class="gia-moi">Giá mới:
					<c:set var="newprice" value="${item.price*(1-item.discount)}" />
					<fmt:formatNumber value="${newprice}"/></div>
			<br/> <div class="muc-gia">Mức giá :
			<c:choose>
				<c:when test="${newprice < 10}">Giá thấp</c:when>
				<c:when test="${newprice > 100}">Giá cao</c:when>
				<c:otherwise>Bình thường</c:otherwise>
			</c:choose></div>
		 	</div>
		</div>
	</div>
</body>
</html>