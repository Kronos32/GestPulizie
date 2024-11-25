<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<nav class=navAdmin>
		<div class=gestione>
			<a href="admin" class=link>Home</a>
		</div>
		<div class=gestione>
			<a href="gestioneClienti" class=link>Gestione Cliente</a>
		</div>
		<div class=gestione>
			<a href="gestioneOperaio" class=link>Gestione Operaio</a>
		</div>
		<div class=gestione>
			<a href="gestioneSede" class=link>Gestione Sede</a>
		</div>
		<div class=gestione>
			<a href="gestioneOrdini" class=link>Gestione Ordini</a>
		</div>
		<div class=gestione>
			<a href="gestioneCategoria" class=link>Gestione Categoria</a>
		</div>
		<div class=gestione>
			<a href="gestioneSquadre" class=link>Gestione Squadre</a>
		</div>
		<div class=gestione>
			<a href="gestioneServizi" class=link>Gestione Servizi</a>
		</div>
		<div class=gestione>
			<a href="logout" class=link>LogOut</a>
		</div>
	</nav>
	<div class=divLogoHome><img class=logoHome alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>