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
	<jsp:include page="navbarClienti.jsp"></jsp:include>
	<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
			<form id="cancLav" method=post action=cancellaPrenotazione>
		<%
			List<ComprendeDto> listLavCli=(List<ComprendeDto>)request.getAttribute("listLavCli");
			int i,j;
			if(listLavCli!=null && listLavCli.size()>0)
			{
				for(i=0;i<listLavCli.size();i++)
				{
		%>
			
			<br><input type="checkbox" name="idLavorazione" value=<%=listLavCli.get(i).getIdLavorazione() %>><%=listLavCli.get(i).getNomeSede()%>
		<%	
				}
		%>
				<br><button class=submit type=submit>Elimina</button>
		<%

			}
			else
			{
		%>
				<p class=stampa>Non ci sono lavorazioni</p>
		<%
			}
		%>
		
		
		
		</form>
		<script src="js/Script.js"></script>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>