<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf_8">
<title>Insert title here</title>
<style>
            .column{
                width: 33%;
                float: left;
            }
            .san-pham{
                border-radius: 10px;
                box-shadow: 0px 0px 5px gray;
                padding: 10px;
                margin: 5px;
                text-align: center;
            }
            .san-pham .ten{
                font-size: larger;
                font-variant: small-caps;
                color:black;
            }
            .san-pham img{
                max-width: 95%;
                height: 200px;
            }
            .san-pham .gia{
                color:red;
                font-weight: bold;
                font-size: larger;
            }
</style>
</head>
<body>
	<form action="/item">
		<div class="column">
            <div class="san-pham">
            <div class="ten">${param.name}</div>
            <img src="${param.image}" />
            <div class="gia">
             30.000.000₫
            </div>
            </div>
        </div>
	</form>
</body>
</html>