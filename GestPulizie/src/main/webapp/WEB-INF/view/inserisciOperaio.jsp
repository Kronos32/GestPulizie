<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.rf.gestpulizie.model.CategoriaOperaio"
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
	<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	
	<form method=post action=inserisciOperaio>
		<div class=insert>
		<h1>Inserisci Operaio</h1>
			<div>
				 <input type=text name=nomeOperaio placeholder="Nome Operaio">
			</div>
			<div>
				 <input type=text name=cognomeOperaio placeholder="Cognome Operaio">
			</div>
			<div>
				 <input type=text name=cfOperaio placeholder="Codice Fiscale Operaio">
			</div>
			<div>
				 <input type=text name=usernameOperaio placeholder="Username Operaio">
			</div>
			<div>
				 <input type=password name=pswOperaio placeholder="Password Operaio">
			</div>
			<div>
				<p class=op>Operativo <input type=checkbox value=1 name=statoOperativita></p>
			</div>
			<select name=opCat>
				<option>---Seleziona una categoria---</option>
				<% 
					List<CategoriaOperaio> catList= (List<CategoriaOperaio>) request.getAttribute("catTrovata");
					if(catList!=null && catList.size()>0)
					{
						int i;
						for(i=0; i<catList.size();i++)
						{	
				%>
				<option value="<%= catList.get(i).getIdCategoria()%>"><%= catList.get(i).getNomeCategoria()%></option>
				<%
						}
					}
				%>
			</select> <input type=submit name=Inserisci>
			<p>${esito}</p>
		</div>
	</form>



</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>