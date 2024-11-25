<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Squadra"
    import="it.rf.gestpulizie.model.Cliente"
    import="java.util.List"
    import="it.rf.gestpulizie.model.Eformata"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inserisci Sede </title>
	<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<jsp:include page="navbarGestSede.jsp"></jsp:include>
		<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=insert>
			<form action=inserisciSede method=Post>
				<h1>Inserisci Sede</h1>
				<div><input type=text name=nomeSede placeholder="Nome Sede" required></div>
				<div><input type=text name=cittaSede placeholder="Città Sede" required></div>
				<div><input type=text name=viaSede placeholder="Via Sede" required></div>
				<div><input type=number name=pianoSede placeholder="Piano Sede" required></div>
				<div><input type=submit value="Inserisci"></div>
			</form>
			<% 
				List<Cliente> elencoClienti=(List<Cliente>) request.getAttribute("elencoClienti");
				if(elencoClienti != null && elencoClienti.size()>0){
			%>
			<form action=associaClienti method=Post>
				<h1>Associa Cliente</h1>
				<% 
						int i;
						for(i=0;i<elencoClienti.size();i++){ 
					%>
					<div><p class=stampa><input type=radio name=cfOperaio[] value=<%= elencoClienti.get(i).getCfCliente() %>> <%= elencoClienti.get(i).getNomeCliente()%> <%= elencoClienti.get(i).getCognomeCliente()%></p></div>
					<%} %>
					<div><p class=stampa>Data Contratto<br><input type=date name=dataContratto></p></div>
				<input class=submit type=submit value="Assegna Cliente">
			</form>
			<%
				}
				else{
			%>
			<%} %>
		</div>
	</body>
	
	<jsp:include page="footer.jsp"></jsp:include>
</html>