<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.DTO.ComprendeDto"
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
	<div class=mod>
	<h1>Elimina Lavorazione</h1>
			<form id="cancLav" method=post action=cancellaLavorazione>
		<%
			List<ComprendeDto> listLav=(List<ComprendeDto>)request.getAttribute("listLav");
			Long idLavDaVer=0L, idLavCorrente=1L;
			int i,j;
			if(listLav!=null && listLav.size()>0)
			{
				for(i=0;i<listLav.size();i++)
				{
					idLavDaVer=listLav.get(i).getIdLavorazione();
					if(idLavDaVer!=idLavCorrente)
					{
		%>
			
						<div><p class=stampa><input type="checkbox" name="idLavorazione" value=<%=listLav.get(i).getIdLavorazione() %>><%=listLav.get(i).getNomeSede()%> | <%=listLav.get(i).getCittaSede()%> <%=listLav.get(i).getViaSede()%></p></div>
		<%	
						idLavCorrente=listLav.get(i).getIdLavorazione();
					}
				}					
			}
			else
			{
		%>

		<%
			}
		%>
		
		
		<br><button class=submit type=submit>Elimina</button>
		</form>
	</div>
		<script src="js/Script.js"></script>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>