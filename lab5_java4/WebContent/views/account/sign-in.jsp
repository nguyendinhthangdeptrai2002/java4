<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form  method="post" action="/lab5_java4/account">

<input name="id"><br>
 <input name="password" type="password">

	<button type="submit" class="btn btn-primary btn-block" formaction="/lab5_java4/account/signin">
										Login
									</button>
									<a href="/lab5_java4/views/account/sign-up.jsp">Sign Up ?</a>
									<a href="/lab5_java4/views/account/edit-profile.jsp">edit</a>
</form>

${message}

</body>
</html>