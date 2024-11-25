<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.model.Sede"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.DTO.AppSedeDto"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<jsp:include page="navbarClienti.jsp"></jsp:include>
		<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=insert>
					<form method=post action=sceltaSedeCliente>
				<% List<Sede> sedeList=(List<Sede>) request.getAttribute("sediCliente");
				int j;
				if(sedeList!=null && sedeList.size()>0)
			{
			%>
				<h1>Scegli la sede</h1>
			<%
			
				for(j=0;j<sedeList.size();j++)
				{
			%>
				<div><p class=stampaRidotta><input type=radio name=idSede value=<%=sedeList.get(j).getIdSede() %> required><%=sedeList.get(j).getNomeSede()%>|<%=sedeList.get(j).getViaSede()%>|<%=sedeList.get(j).getCittaSede() %>|<%=sedeList.get(j).getPianoSede()%></p></div>
			<%
				}
			%>
			<h1>Dati Ordine</h1>
				<div><p class=stampaRidotta><input type=text name=descrizione placeholder="Descrizione Prenotazione"></p></div>
				<div><p class=stampaRidotta><input type=date name=dataPrevistaEsecuzione required> Data Prevista Esecuzione</p></div>
				<div><p class=stampaRidotta><input type=text name=descrizioneLavorazione placeholder="Descrizione Lavorazione"></p></div>
				<div><input type=submit class=submit value="Aggiungi"></div>
			<%} %>
			</form>
			
			<% 
				AppSedeDto Lav=(AppSedeDto)request.getAttribute("appSedeDto");
				if(Lav!=null)
				{
			%>
			</div>
			<div class=insertOrd>
			<h1>Ordine Appena Creato</h1>
			<form method=post action=stampaServiziCliente>
			<table>
			
				<tr>
					<td><p class=stampaRidotta>Numero Lavorazione</p></td>
					<td><p class=stampaRidotta>ID Sede</p></td>
					<td><p class=stampaRidotta>Nome Cliente</p></td>
					<td><p class=stampaRidotta>Cognome Cliente</p></td>
					<td><p class=stampaRidotta>Data Prevista Lavorazione</p></td>
				</tr>
				<tr>
					<td><input type=text name=idLavorazione value=<%=Lav.getIdLavorazione()%> readonly></td>
					<td><input type=text name=idSede value=<%=Lav.getIdSede() %> readonly></td>
					<td><input type=text name=nomeCliente value=<%=Lav.getNomeCliente()%> readonly></td>
					<td><input type=text name=cognomeCliente value=<%=Lav.getCognomeCliente() %> readonly></td>
					<td><input type=text name=DataPrevistaLavorazione value=<%=Lav.getDataPrevistaLavorazione()%> readonly></td>
				</tr>
			</table>		
			
			
				<input type=submit class=submit value="Gestisci Ordine">
			</form>
			<%
			 }%>
			 </div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>