<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.DTO.ComprendeDto"
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
	<jsp:include page="navbarGestOrdini.jsp"></jsp:include>
		<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<div class=mod>
	<h1>Modifica Ordine</h1>
	<form  method=post action=modificaOrdini>
		<table>
			<%
				List<ComprendeDto> listLav=(List<ComprendeDto>)request.getAttribute("listLav");
				int i,j;
				if(listLav!=null && listLav.size()>0)
				{
					for(i=0;i<listLav.size();i++)
					{
						if(listLav.get(i).getFineEsecuzioneServizio()==false)
					
						{
			%>
							<tr>
								<td><input type="radio" name="idLavorazione" value=<%=listLav.get(i).getIdLavorazione() %> required>
								<%=listLav.get(i).getNomeSede()%>
								<%=listLav.get(i).getViaSede() %></td>
								<td><%=listLav.get(i).getCittaSede()%></td>
							</tr>
							<tr>
								<td><input class=submit type=submit value="Scegli Lavoro Da Modificare"></td>
							</tr>
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
			</table>
		</form>
		</div>
		<div class=mod>
		<form id=associaServizio method=post action=>
		<%
			List<Servizio> servi=(List<Servizio>) request.getAttribute("servi");
			List<Squadra> sq=(List<Squadra>) request.getAttribute("sq");
			List<Comprende> comp=(List<Comprende>) request.getAttribute("comp");
			Date data=(Date) request.getAttribute("dataEsecuzione");
			Long idLav=(Long) request.getAttribute("idLavorazione");
			String descrizione=(String) request.getAttribute("descrizione");
			if(servi!=null && sq!=null && comp!=null && data!=null && idLav!=null && descrizione!=null)
			{
		%>
				<input name=idLavorazione type=text <%=idLav %> readonly>
				<input name=dataPrevistaEsecuzione type=date <%=data %> >
				<input name=descrizione type=text <%=descrizione %> >
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