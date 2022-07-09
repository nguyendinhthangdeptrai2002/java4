<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	.vmenu{
                padding: 0px;
                margin: 5px;
                list-style: none;
                border-radius: 3px;
                box-shadow:0 0 2px gray;
                list-style: none;
            }
            .vmenu a{
                background: url("#1") no-repeat 2px center;
                display: block;
                border-bottom: 1px solid rgb(71, 188, 241);
                color: blue;
                font-variant: small-caps;
                font-size: larger;
                text-decoration: none;
                padding: 8px 5px 8px 30px;
            }
            .vmenu a:hover{
                background: url("#1") no-repeat 2px center;
                border-bottom: 1px dotted white;
                background-color: orangered;
                color: white;
                font-weight: bold;
            }
</style>
</head>
<body>
	<form action="/category.jsp">
		<ul class="vmenu">
            <li><a href="#">LOẠI SẢN PHẨM 1</a></li>
            <li><a href="#">LOẠI SẢN PHẨM 2</a></li>
            <li><a href="#">LOẠI SẢN PHẨM 3</a></li>
        </ul>
	</form>
</body>
</html>