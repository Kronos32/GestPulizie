<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.model.Squadra"
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
		<div class=insert>
		<h1>Scelta Servizi</h1>
		<form id="associaServizio" method=post action=associaServzioCliente>
		<%
			List<Servizio> listaServizi=(List<Servizio>)request.getAttribute("elencoServizi");
			Long idLav=(Long) request.getAttribute("idLav");
			int i,j;
			if(listaServizi!=null && listaServizi.size()>0)
			{
				for(i=0;i<listaServizi.size();i++)
				{
		%>
			
			<div><p class=stampa><input type="checkbox" name="idServizio" value=<%=listaServizi.get(i).getIdServizio() %>><%=listaServizi.get(i).getNomeServizio()%></p></div>
			<%	
				}
				%>
				<div><input type=text name=idLavorazione value=<%=idLav %> readonly></div>
				<input type=text placeholder="Descrizione" name=descrizioneComprende>
					
		<%
			}
			else
			{
		%>

		<%
			}
		%>
		
		
		<br><button class=submit type=submit>Fine Modifiche</button>
		</form>
		</div>
		<script src="js/Script.js"></script>
	</body>
</html>