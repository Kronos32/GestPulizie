<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Optional"
	import="it.rf.gestpulizie.model.Operaio" import="java.util.List"
	import="it.rf.gestpulizie.model.CategoriaOperaio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<jsp:include page="navbarGestOperaio.jsp"></jsp:include>
		<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<% Optional<Operaio> op= (Optional<Operaio>)request.getAttribute("opTrovato");
		List<Operaio> opList=(List<Operaio>)request.getAttribute("opList");
		List<CategoriaOperaio> catList= (List<CategoriaOperaio>) request.getAttribute("catTrovata");%>
	<form method="post" action="modificaOperaio">
		
		<div class=insert>
		<h1>Modifica Operaio</h1>
			<div><input type="search" name=cfOperaio  placeholder="Codice Fiscale Operaio"></div>
			<p class=ric>O</p>
			<div> <input type="search" name=nomeOperaio  placeholder="Nome Operaio"></div>
			<div><input type="search" name=cognomeOperaio placeholder="Cognome Operaio"></div>
			<input type=submit value="Creca Operaio Da Modificare">
		</div>
	</form>



	<%
			if(op!=null && op.isPresent())
			{
		%>
	<form method="post" action="updateOperaio">
		<div class=insert>
			<input type=hidden name=pswOperaio
				value="<%=op.get().getPswOperaio()%>"> <input type=hidden
				name=usernameOperaio value="<%=op.get().getUsernameOperaio()%>">
			
				<p class=stampa>Nome <input type=text value="<%=op.get().getNomeOperaio() %>" name=nomeOperaio></p>
	
				<p class=stampa>Cognome <input type=text value="<%=op.get().getCognomeOperaio() %>" name=cognomeOperaio></p>
				<p class=stampa>Codice Fiscale <input type=text value="<%=op.get().getCfOperaio() %>" name=cfOperaio readonly></p>
				<p class=stampa>Categoria <select name=opCat>
					<% 

					if(catList!=null && catList.size()>0)
					{
						int x;
						for(x=0; x<catList.size(); x++)
						{	
				%>
					<option value="<%= catList.get(x).getIdCategoria()%>"><%= catList.get(x).getNomeCategoria()%></option>
					<%
						}
					}
				%>
				</select> </p>
				<%
					if(op.get().getStatoOperativita().equals(true))
					{
				%>
				
				<p class=stampa>Rimuovi Operatività 
				<input type="checkbox" value=0 name=statoOperativita></p>

				<%
				}
				if(op.get().getStatoOperativita().equals(false))
				{
		%>
				<p class=stampa>Rendi Operativo 
				<input type="checkbox" value=1 name=statoOperativita></p>

				<%
				}
		%>
				<input class=submit type=submit value="Modifica">
			</div>
	</form>
	<form method="post"
		action="eliminaOperaio?cfOperaio=<%=op.get().getCfOperaio() %>">
		<div class=insert>
			<input class=submit type=submit value="Elimina">
		</div>
	</form>

	<%
			}
			else if(op!=null && op.isPresent()==false && opList.size()==0)
			{
		%>

	<p>Nessun operaio trovato</p>

	<%
			}
		%>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>