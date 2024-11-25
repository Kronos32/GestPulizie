<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.Optional"
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
	<jsp:include page="navbarGestOperaio.jsp"></jsp:include>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<% 
			Optional<Operaio> op = (Optional<Operaio>)request.getAttribute("opTrovato");
			List<Operaio> opList=(List<Operaio>)request.getAttribute("opList");
	%>
		<div class=insert>
		<h1>Ricerca Operaio</h1>
			<form method="post" action="ricercaOperaio">
		
		
				<div><input type="search" name=cfOperaio  placeholder="Codice Fiscale Operaio"></div>
				<p class=ric>O</p>
				<div> <input type="search" name=nomeOperaio  placeholder="Nome Operaio"></div>
				<div><input type="search" name=cognomeOperaio placeholder="Cognome Operaio"></div>
				<input class=submit type=submit value="Creca Operaio Da Modificare">
			</form>



	<%
			if(opList!=null && opList.size()>0)
			{
				for(int i=0;i<opList.size();i++)
				{
	%>

				<p class=stampa>Nome <input type=text value="<%=opList.get(i).getNomeOperaio() %>" name=nomeOperaio readonly></p>
				<p class=stampa>Cognome <input type=text value="<%=opList.get(i).getCognomeOperaio() %>" name=cognomeOperaio readonly></p>
				<p class=stampa>Codice Fiscale <input type=text value="<%=opList.get(i).getCfOperaio() %>" name=cfOperaio readonly></p>
				<p class=stampa><input type=text value=<%= opList.get(i).getOpCat().getNomeCategoria()%>></p>
	<%
				}
		}
		
			else if(op!=null && op.isPresent())
		{
	%>
	
			<p class=stampa>Nome<br> <input type=text value="<%=op.get().getNomeOperaio() %>" name=nomeOperaio readonly></p>
			<p class=stampa>Cognome<br> <input type=text value="<%=op.get().getCognomeOperaio() %>" name=cognomeOperaio readonly></p>
			<p class=stampa>Codice Fiscale<br> <input type=text value="<%=op.get().getCfOperaio() %>" name=cfOperaio readonly></p>
			<p class=stampa> Categoria<br> <input type=text value=<%= op.get().getOpCat().getNomeCategoria()%>></p>
	<%
		
		}
	
	
		else if(opList!=null && opList.size()==0 && op.isPresent()==false)
		{
	%>
			<p>Nessun operaio trovato</p>

	<%
		}
	%>


</div>


</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>