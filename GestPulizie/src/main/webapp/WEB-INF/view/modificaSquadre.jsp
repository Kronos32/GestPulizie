<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.rf.gestpulizie.model.Squadra"
	import="it.rf.gestpulizie.model.Operaio"
	import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<jsp:include page="navbarGestSquadre.jsp"></jsp:include>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<div class=insert>
	<form method=post action=modificaSquadre>
		<%
			List <Squadra> listaSquadre = (List<Squadra>) request.getAttribute("listaSquadra");
		if(listaSquadre!=null && listaSquadre.size()>0)
		{
			for(int i=0; i<listaSquadre.size();i++)
			{
				if(listaSquadre.get(i).getSquadraFinta()==false)
				{
		%>
					<div><p class=stampa><input type=radio name=idSquadra value=<%=listaSquadre.get(i).getIdSquadra()%> required><%=listaSquadre.get(i).getNomeSquadra() %></p></div>
		<%
				}
			}
		%>
			<input class=submit type=submit value="Ricerca Squadra Da Modificare">
		<%
			}
		%>
		
	</form>
	</div>
	<div class=modOp>
	
	<form id="newOp" action=aggiungiNuoviOperatori method=post>
		<%
			List<Operaio> op =(List<Operaio>) request.getAttribute("opAll");
			if(op!=null)
			{
				for(int j=0;j<op.size();j++)
				{
		%>
				<div><p class=stampa><input type=checkbox name="cfOperaio" value=<%=op.get(j).getCfOperaio() %>><%=op.get(j).getNomeOperaio()%> <%=op.get(j).getCognomeOperaio() %> || <%=op.get(j).getCfOperaio() %></p></div>
				<button type="submit">Aggiungi Operatore</button>
		<%
				}
			}
		%>
		
	</form>
	</div>
	
	<script src="js/Script.js"></script>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>