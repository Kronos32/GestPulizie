<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    	
	import="it.rf.gestpulizie.model.Comprende"
	import="it.rf.gestpulizie.model.Squadra"
	import="it.rf.gestpulizie.model.Servizio"
    import="java.util.List"
    import="java.sql.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class=mod>
<jsp:include page="navbarGestOrdini.jsp"></jsp:include>
			<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<form id=associaServizio method=post action=visOrdDaMod>
		<%
			List<Servizio> servi=(List<Servizio>) request.getAttribute("servi");
			List<Squadra> sq=(List<Squadra>) request.getAttribute("sq");
			Date data=(Date) request.getAttribute("dataEse");
			Long idLav=(Long) request.getAttribute("idLavorazione");
			String descrizione=(String) request.getAttribute("descrizione");
			 if(servi!=null && sq!=null&& data!=null && idLav!=null && descrizione!=null)
			{
		%>
				<input name=idLavorazione type=text value=<%=idLav %> readonly>
				<input name=dataPrevistaEsecuzione type=date value=<%=data %> >
				<input name=descrizione type=text value=<%=descrizione %> >
				<select name=idSquadra>
		<%
				
				for(int k=0; k<sq.size();k++)
				{
					if(sq.get(k).getIdSquadra()!=1 && sq.get(k).getDataOperativita().equals(data) )
					{
		%>
						<option value=<%=sq.get(k).getIdSquadra() %>><%=sq.get(k).getNomeSquadra() %></option>
		<%			
					}
				}
		%>
				</select>
		<%
				for(int l=0; l<servi.size();l++)
				{
		%>
					<input type=checkbox name=idServizio value=<%=servi.get(l).getIdServizio()%>><%=servi.get(l).getNomeServizio() %>
		<%			
				}
		%>
				<button class=submit type=submit>Modifica Ordine</button>
		<%
			}
				
		%>
				
				
		</form>
		</div>
		<script src="js/Script.js"></script>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>