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
</style>
</head>
<body>
	<div class="container">
		<c:forEach var="item" items="${items}">
		<div class="column">
			<div class="san-pham">
			<div class="ten">${item.name}</div>
			<a href="/lab4/views/item/detail.jsp"><img src="views/image/${item.image}"></a>
			<div class="gia"><strike>${item.price}</strike></div>
			<div class="gia-moi">${item.price*(1-item.discount)}</div>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>