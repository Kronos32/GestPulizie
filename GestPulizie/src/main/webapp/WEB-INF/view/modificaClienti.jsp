<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List"
	import="it.rf.gestpulizie.model.Cliente"
	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<jsp:include page="navbarGestClienti.jsp"></jsp:include>
			<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=mod>
			<h1>Modifica Cliente</h1>
			<form action=modificaClienti method=post>
				<%
					List<Cliente> clienti=(List<Cliente>) request.getAttribute("cliente");
					if(clienti!=null && clienti.size()>0)
					{
						for(int i=0; i<clienti.size();i++)
						{	
				%>
							<input type=radio name=cfCliente value=<%=clienti.get(i).getCfCliente() %> required><%=clienti.get(i).getNomeCliente() %> <%=clienti.get(i).getCognomeCliente() %> <%=clienti.get(i).getCfCliente() %><br>
							
				<%			
						}
				%>
						<input class=submit type=submit value=Seleziona>
				<%
					}
				%>
				
				</form>
				
				<form method=post action=modCli>
				<%
					Cliente cli = (Cliente) request.getAttribute("clienteDaMod");
					if(cli!=null )
					{
				%>
						<div><input type=text name=cfCliente value="<%=cli.getCfCliente() %>" readonly></div>
						<div><input type=text name=nomeCliente value="<%=cli.getNomeCliente() %>"></div>
						<div><input type=text name=cognomeCliente value="<%=cli.getCognomeCliente() %>"></div>
						<div><input type=text name=usernameCliente value="<%=cli.getUsernameCliente() %>"></div>
						<div><input type=text name=pswCliente value="<%=cli.getPswCliente() %>"></div>
						<div><input class=submit type=submit value=Modifica></div>
				<%
					}
				%>
				</form>
			</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>