<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="navbarGestServizi.jsp"></jsp:include>
		<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=insert>
			<h1>Inserisci Serviazio</h1>
			<form method=post action=insertServizi>
				<div><input type=text name=nomeServizio placeholder="Nome Servizio" required></div>
				<div><input type=text name=descrizioneServizio placeholder="Descrizione Servizio" required></div>
				<div><input type=number name=minServizio placeholder="Durata Servizio" required></div>
				<div><input type=number name=prezzoServizio placeholder="Prezzo Servizio" required></div>
				<div></div><input type=submit value=Inserisci></
			</form>
		</div>
		<p>${inserimento}</p>
		
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>