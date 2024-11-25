<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.Optional"
	import="it.rf.gestpulizie.model.CategoriaOperaio"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<jsp:include page="navbarGestCategoria.jsp"></jsp:include>
	
	<form method="post" action="updateCategoria">
		<br>
		<div class=insert>
			<div>
				Nome Categoria<br> <input type="search" name=nomeCategoria><br>
			</div>

			<input type=submit value="Creca Categoria Da Modificare">
		</div>
	</form>



	<%
		Optional<CategoriaOperaio> catTrov=(Optional<CategoriaOperaio>) request.getAttribute("catTrov");
			if(catTrov!=null && catTrov.isPresent())
			{
		%>
	<form method="post" action="updateCategoria">
		<div class=insert>
				Nome Categoria<br> <input type=text
					value="<%=catTrov.get().getNomeCategoria() %>" name=nomeCategoria><br>
			</div>
			<div>
				Stipendio<br> <input type=number
					value="<%=catTrov.get().getStipendioCategoria() %>" name=stipendioCategoria><br>
			</div>
			<div>
				ID Categoria<br> <input type=text
					value="<%=catTrov.get().getIdCategoria() %>" name=idCategoria readonly><br>
					<% 
				
		%>
				<input type=submit value="Modifica"><br>
	</form>
	<form method="post"
		action="eliminaCategoria?idCategoria=<%=catTrov.get().getIdCategoria() %>">
		<div class=insert>
			<input type=submit value="Elimina">
		</div>
	</form>
		<%
			}
			 if(catTrov!=null && catTrov.isPresent()==false)
			{
		%>

	<p>Nessun operaio trovato</p>

	<%
			}
		%>

</body>
</html>