<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.DTO.ComprendeDto"
	import="java.util.List"
%>
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
				Long idLavDaVer=0L, idLavCorrente=1L;
				if(listLav!=null && listLav.size()>0)
				{
					for(i=0;i<listLav.size();i++)
					{
						idLavDaVer=listLav.get(i).getIdLavorazione();
						if(listLav.get(i).getFineEsecuzioneServizio()==false)
					
						{
							if(idLavDaVer!=idLavCorrente)
							{
			%>
							<tr>
								<td><input type="radio" name="idLavorazione" value=<%=listLav.get(i).getIdLavorazione() %> required>
								<%=listLav.get(i).getNomeSede()%>
								<%=listLav.get(i).getViaSede() %></td>
								<td><%=listLav.get(i).getCittaSede()%></td>
							</tr>
			<%			
								idLavCorrente=listLav.get(i).getIdLavorazione();
							}
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
				<input class=submit type=submit value="Scegli Lavoro Da Modificare">
		</form>
		</div>
		
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>