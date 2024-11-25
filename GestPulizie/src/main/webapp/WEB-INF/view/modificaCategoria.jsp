<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.Optional"
	import="it.rf.gestpulizie.model.Operaio"
	import="it.rf.gestpulizie.model.CategoriaOperaio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<jsp:include page="navbarGestCategoria.jsp"></jsp:include>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<form method="post" action="modificaCategoria">
		<div class=insert>
			<h1>Modifica Categoria</h1>
			<div>
				<div><p class=stampa>Nome Categoria<br> <input type="search" name=nomeCategoria></p></div>
			</div>

			<input type=submit value="Creca Categoria Da Modificare">
		</div>
	</form>

<br><br>
<br>
	<%
		Optional<CategoriaOperaio> catTrovata=(Optional<CategoriaOperaio>) request.getAttribute("catTrovata");
			if(catTrovata!=null && catTrovata.isPresent() && catTrovata.get().getIdCategoria()!=1)
			{
		%>
	<form method="post" action="updateCategoria">
		<div class=insert>
				<div><p class=stampa>Nome Categoria <input type=text
					value="<%=catTrovata.get().getNomeCategoria() %>" name=nomeCategoria></p></div>
			
			<div>
				<p class=stampa>Stipendio<input type=number
					value="<%=catTrovata.get().getStipendioCategoria() %>" name=stipendioCategoria></p>
			</div>
			<div>
				<p class=stampa>ID Categoria <input type=text
					value="<%=catTrovata.get().getIdCategoria() %>" name=idCategoria readonly></p></div>
				<div><input class=submit type=submit value="Modifica"><br></div>
		</div>
	</form>

		<%
			}
			 if(catTrovata!=null && catTrovata.isPresent()==false)
			{
		%>

	<p>Nessuna categoria trovata o la categoria selezionata è admin</p>

	<%
			}
		%>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>