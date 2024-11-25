<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Cliente"
    import="it.rf.gestpulizie.model.Sede"
    import="it.rf.gestpulizie.model.Esegue"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.DTO.AppSedeDto"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<jsp:include page="navbarGestOrdini.jsp"></jsp:include>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<div class=insertSede>
	<h1>Crea Ordine</h1>
		<form method="post" action=Esegue>
			<% List<Cliente> cliList=(List<Cliente>) request.getAttribute("cliList");
			int i;
			if(cliList!=null && cliList.size()>0)
			{
				
				for(i=0;i<cliList.size();i++)
				{
			%>
				<input type=radio name=cfCliente value=<%=cliList.get(i).getCfCliente() %> required><%=cliList.get(i).getNomeCliente() %> <%=cliList.get(i).getCognomeCliente() %><br>
				
			<%
				}
			%>
			<div><input class=submit type=submit value="Cerca Sede"></div>
			<%
				
			}
			%>
				
			</form>
			</div>
			<div class=insertSede>
			
			<form method=post action=sceltaSede>
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
				<input type=radio name=idSede value=<%=sedeList.get(j).getIdSede() %> required><%=sedeList.get(j).getNomeSede()%>|<%=sedeList.get(j).getViaSede()%>|<%=sedeList.get(j).getCittaSede() %>|<%=sedeList.get(j).getPianoSede()%><br>
			<%
				}
			%>
			<h1>Dati Ordine</h1>
				<div><input type=text name=descrizione placeholder="Descrizione Prenotazione"></div>
				<div><p><input type=date name=dataPrevistaEsecuzione required><br> Data Prevista Esecuzione</p></div>
				<div><input type=text name=descrizioneLavorazione placeholder="Descrizione Lavorazione"></div>
				<div><input class=submit type=submit value="Aggiungi"></div>
			<%} %>
			</form>
			
			<% 
				AppSedeDto Lav=(AppSedeDto)request.getAttribute("appSedeDto");
				if(Lav!=null)
				{
			%>
			<h1>Ordine Appena Creato</h1>
			<form method=post action=stampaServizi>
			<table>
			
				<tr>
					<td><p class=stampa>N° Lavorazione</p></td>
					<td><p class=stampa>ID Sede</p></td>
					<td><p class=stampa>Nome Cliente</p></td>
					<td><p class=stampa>Cognome Cliente</p></td>
					<td><p class=stampa>Data Lavorazione</p></td>
				</tr>
				<tr>
					<td><input type=text name=idLavorazione value=<%=Lav.getIdLavorazione()%> readonly></td>
					<td><input type=text name=idSede value=<%=Lav.getIdSede() %> readonly></td>
					<td><input type=text name=nomeCliente value=<%=Lav.getNomeCliente()%> readonly></td>
					<td><input type=text name=cognomeCliente value=<%=Lav.getCognomeCliente() %> readonly></td>
					<td><input type=text name=DataPrevistaLavorazione value=<%=Lav.getDataPrevistaLavorazione()%> readonly></td>
				</tr>
			</table>		
			
			
				<input class=submit  type=submit value="Gestisci Ordine">
			</form>
			<%
			 }%>
			<p>${OrePiene}</p>
			</div>
			

	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>