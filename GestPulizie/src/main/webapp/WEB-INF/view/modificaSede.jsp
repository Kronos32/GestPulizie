<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.model.Sede"
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
	<jsp:include page="navbarGestSede.jsp"></jsp:include>
	<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	
	<div class=ric>
	
		<h1>Modifica Sede</h1>
		<form method=post action="modificaSede">
			<div><input type=text name=nomeSede placeholder="Nome Sede"></div>
			<div><input class=submit value="Ricerca Sede" type=submit></div>
		</form>
		
		<form method=post action=modSed>
			<%
				List<Sede> sede =(List<Sede>) request.getAttribute("sede");
				if(sede!=null && sede.size()>0)
				{
					int i;
					for(i=0;i<sede.size();i++)
					{	
			%>
						<div><p class=stampa> Nome <input type=text value="<%=sede.get(i).getNomeSede() %>" name=nomeSede></p></div>
						<div><p class=stampa>Città<input type=text value="<%=sede.get(i).getCittaSede() %>" name=cittaSede></p></div>
						<div><p class=stampa>Via<input type=text value="<%=sede.get(i).getViaSede() %>" name=viaSede></p></div>
						<div><p class=stampap>Piano<input type=text value="<%=sede.get(i).getPianoSede() %>" name=pianoSede></p></div>
						<div><p class=stampa>ID Sede<input type=text value="<%=sede.get(i).getIdSede()%>" name=idSede readonly></p></div>
						<div><input class=submit type=submit value=Modifica></div>
			<%			
					}
				
				}
				else
				{
			%>
			<p class=stampa> Nessuna Sede Trovata</p>
			<%} %>
			
		</form>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>