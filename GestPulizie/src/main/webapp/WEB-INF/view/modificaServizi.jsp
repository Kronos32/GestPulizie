<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.model.Servizio"
	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<jsp:include page="navbarGestServizi.jsp"></jsp:include>
		<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=insert>
			<form method=post action= modificaServizi>
				<input type=search name=nomeServizio placeholder="Nome Servizio" required>
				<input class=submit type=submit value="Ricerca Servizio">
			</form>
		</div>
		<%
			Servizio servizio = (Servizio) request.getAttribute("servizio");
			if(servizio!=null)
			{
		%>
		<div class=modServ>
			<form action=modSer method=post>
				<div>
					<div><p class=stampa>ID Servizio<input type=text value="<%= servizio.getIdServizio()%>" readonly></p></div>
					<div><p class=stampa>Nome Servizio <input type=text value="<%= servizio.getNomeServizio() %>"></p></div>
					<div><p class=stampa>Descrizione Servizio <input type=text value="<%= servizio.getDescrizioneServizio() %>"></p></div>
					<div><p class=stampa>Prezzo Servizio <input type=number value="<%= servizio.getPrezzoServizio() %>"> €</p></div>
					<div><p class=stampa>Durata Servizio<input type=number value="<%= servizio.getMinServizio()%>"> min</p></div>
					<div><input class=submit type=submit value=Modifica></div>
				</div>
			</form>
		</div>
			<%} %>
		
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>