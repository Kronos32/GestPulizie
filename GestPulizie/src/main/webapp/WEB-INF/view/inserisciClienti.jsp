<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.model.Cliente"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Inserisci Clienti</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<jsp:include page="navbarGestClienti.jsp"></jsp:include>
			<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=insert>
			<h1>Inserisci Cliente</h1>
			<form action="inserisciClienti" method="post">
				<div><input type=text name=nomeCliente placeholder="Nome Cliente"></div>
				<div><input type=text name=cognomeCliente placeholder="Cognome Cliente"></div>
				<div><input type=text name=cfCliente placeholder="Codice Fiscale Cliente"></div>
				<div><input type=text name=usernomeCliente placeholder="Username Cliente"></div>
				<div><input type=text name=pswCliente placeholder="Password Cliente"></div>
				<div><input class=submit type=submit value=Inserisci></div>
			</form>
		<p class=stapaRidotta>${insCliente}</p>
		</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>