<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List"
	import="it.rf.gestpulizie.DTO.ComprendeDto"
	import="java.sql.Date"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="navbarOperaio.jsp"></jsp:include>
		<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	
		<div class=insert>
			<h1>Trova Lavorazioni </h1>
			<form method=post action=operaio>
				<div><p class=stampa>Dal</p><input type=date name=primaData required></div>
				<div><p class=stampa>Al</p><input type=date name=secondaData required></div>
				<div><input type=submit value=Ricerca></div>
			</form>
		</div> 
		<div>
		<%
			List<ComprendeDto> intervalliDate = (List<ComprendeDto>) request.getAttribute("lavIntervalloDate");
			if(intervalliDate!=null && intervalliDate.size()>0)
			{
		%>
				
					<form method=post action=viewLavInt>
						<table>
		<%
				Long lavDaVer=0L, lavCorrente=27L;
				for(int i=0; i<intervalliDate.size(); i++)
				{
					lavDaVer=intervalliDate.get(i).getIdLavorazione();
					if(lavDaVer!=lavCorrente)
					{
		%>				
						<tr>
							<td><input type=text name=idLavorazione value="<%=intervalliDate.get(i).getIdLavorazione() %>" readonly></td>
							<td><input type=text value="<%=intervalliDate.get(i).getNomeSede() %>" readonly></td>
							<td><input type=text value="<%=intervalliDate.get(i).getViaSede() %>" readonly></td>
							<td><input type=text value="<%=intervalliDate.get(i).getCittaSede() %>" readonly></td>
							<td><input type=submit value=Visualizza></td>
						</tr>
						
		<%	
						lavCorrente=intervalliDate.get(i).getIdLavorazione();
					}
				} 
		%>
					</table>
				</form>
				
		<%
			}
			else
			{
		%>
				<p>${nonPresenti}</p>
		<%
				
			}
		%>
		
		</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>