<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registrazione</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<div class=insert>
		<form action=registrazione method=post>
			<div><input type=text name=nomeCliente placeholder="Nome" required></div>
			<div><input type=text name=cognomeCliente placeholder="Cognome" required></div>
			<div><input type=text name=cfCliente placeholder="Codice Fiscale" required></div>
			<div><input type=text name=usrenameCliente placeholder="Username" required></div>
			<div><input type=text name=pswCliente placeholder="Password" required></div>
			<div><input class=submit type=submit value=Registrati></div>
		</form>
		<br>
		<form action=loginClienteHome>
		<div class=insert><input class=submit type=submit value=Annulla></div>
		</form>
		<p>${registrazione}</p>
		</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>