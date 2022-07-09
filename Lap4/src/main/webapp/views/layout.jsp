<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
        header{
            width: 100%;
            height: 100px;
            background-color: rgb(220, 241, 250);
            padding-top: 20px;
        }
        header>h1{
            padding-left: 20px;
            color: rgb(71, 188, 241);
        }
        nav{
            background: rgb(243, 251, 253);
            color: azure;
            box-shadow: gray;
            width: 100%;
            height: 40px;
            padding-top: 1px;
            border-top: 2px solid rgb(71, 188, 241);
    		border-bottom: 2px solid rgb(71, 188, 241);
        }
        article{
            min-height: 400px;
            width: 75%;
            float: left;
        }
        aside{
            min-height: 200px;
            width: 25%;
            float: right;
        }
        aside>.login{
            margin: 10px 0px 10px 20px;
            text-align: center;
            padding: 20px 0px 20px 0px;
            border: 3px solid rgb(71, 188, 241);
            color: rgb(71, 188, 241);
            border-radius: 10px;
        }
        aside>.category{
            margin: 10px 0px 10px 20px;
            padding: 20px 0px 20px 0px;
            border: 3px solid rgb(71, 188, 241);
            border-radius: 10px;
        }
        footer{
            width: 100%;
            height: 50px;
            padding-top: 5px;
            background: gainsboro;
            text-align: center;
            clear: both;
        }
</style>
</head>
<body>
	<div class="container">
        <header>
            <h1>Online Shopping Mall</h1>
            
        </header>
        <nav>
			<%@include file="menu.jsp" %>
        </nav>
        <article>
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="laptop Microsoft Surface"/>
				<jsp:param name="image" value="lap1.jpg"/>
			</jsp:include>
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="laptop Microsoft Surface"/>
				<jsp:param name="image" value="lap1.jpg"/>
			</jsp:include>
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="laptop Microsoft Surface"/>
				<jsp:param name="image" value="lap1.jpg"/>
			</jsp:include>
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="laptop Microsoft Surface"/>
				<jsp:param name="image" value="lap1.jpg"/>
			</jsp:include>
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="laptop Microsoft Surface"/>
				<jsp:param name="image" value="lap1.jpg"/>
			</jsp:include>
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="laptop Microsoft Surface"/>
				<jsp:param name="image" value="lap1.jpg"/>
			</jsp:include>
        </article>
        <aside>
            <div class="login">
            	<%@include file="login.jsp" %>
            </div>
            <div class="category">
            	<%@include file="category.jsp" %>
            </div>
        </aside>
        <footer>
            <p>FPT Polytechnic @2020. All right reserved.</p>
        </footer>
    </div>
</body>
</html>