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
	
		<jsp:include page="navbarGestOrdini.jsp"></jsp:include>
		<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=insert>
		<h1>Associa Servizi</h1>
		<form id="associaServizio" method=post action=associaServzio>
		<%	List<Squadra> elencoSquadra=(List<Squadra>)request.getAttribute("elencoSq");
			List<Servizio> listaServizi=(List<Servizio>)request.getAttribute("elencoServizi");
			int i,j;
			if(listaServizi!=null && listaServizi.size()>0)
			{
				for(i=0;i<listaServizi.size();i++)
				{
		%>
			
			<p class=stampa><input type="checkbox" name="idServizio" value=<%=listaServizi.get(i).getIdServizio() %>><%=listaServizi.get(i).getNomeServizio()%><p>
			<%	
				}
				%>
				<input type=text placeholder="Descrizione" name=descrizioneComprende>
					
		<%
			}
			else
			{
		%>

		<%
			}
		%>
		<select name=idSquadra>
		<%
		if(elencoSquadra!=null && elencoSquadra.size()>0)
		{
			for(j=0;j<elencoSquadra.size();j++)
			{
				if(elencoSquadra.get(j).getIdSquadra()>1)
				{
	%>
		
		<option value=<%=elencoSquadra.get(j).getIdSquadra() %>> <%=elencoSquadra.get(j).getNomeSquadra()%></option>
		<%	
				}
			}
			%>
				
	<%
		}
		else
		{
	%>

	<%
		}
	%>
	</select>
		
		
		<br><button class=submit type=submit>Fine Modifiche</button>
		</form>
		<script src="js/Script.js"></script>
		</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>