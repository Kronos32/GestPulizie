<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Cliente</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=login>
			<h1>Login Cliente</h1>
			<form  method="post" action=loginCliente>
				<div><input type=text placeholder="Username" name=usernameCliente required></div>
				<div><input type=password placeholder="Password" name=pswCliente required></div>
				<div><input class=submit type=submit value=Login></div>
			</form>
			<div class=registrazione><a href="registrazioneHome">Registrati</a></div>
		</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>