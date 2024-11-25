<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Operaioe</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=login>
			<h1>Login Operaio</h1>
			<form  method="post" action=loginOperaio>
				<div><input type=text placeholder="Username" name=usernameOperaio required></div>
				<div><input type=password placeholder="Password" name=pswOperaio required></div>
				<div><input class=submit type=submit value=Login></div>
			</form>
			<p>${errore}</p>
		
		</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>