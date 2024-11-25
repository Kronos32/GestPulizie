<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="it.rf.gestpulizie.model.CategoriaOperaio"
	import="java.util.List"%>
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
	
	<form method=post action=inserisciCategoria>
		<div class=insert>
		<h1>Inserisci Categoria</h1>
			<div>
				<p class=stampa>Nome categoria <input type=text name=nomeCategoria></p>
			</div>
			<div>
				<p class=stampa>Stipendio<input type="number" name=usernameOperaio>€</p>
			</div>
			 <div><input type=submit name=Inserisci></div>
			<p class=stampa>${esito}</p>
		</div>
	</form>


</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>