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
		<table border="2px">

	
		<%
			List<ComprendeDto> lavData=(List<ComprendeDto>) request.getAttribute("lavData"); 
			
			
			if((lavData!=null))
			{ 
				int i;
				Long idLavDaVer=0L, idLavConf=1L;
				for(i=0;i<lavData.size();i++)
				{
					idLavDaVer=lavData.get(i).getIdLavorazione();
						if(idLavConf!=idLavDaVer)
						{
		%>

							<tr>
								<td><p class=stampaRidotta>ID Lavorazione</p></td>
								<td><input type=text name=idLavorazione value="<%=lavData.get(i).getIdLavorazione()%>" readonly></td>
							</tr>	
							<tr>
								<td><p class=stampaRidotta>Nome Sede</p></td>	
								<td><input type=text value="<%=lavData.get(i).getNomeSede()%>" readonly></td>
							</tr>
							<tr>	
								<td><p class=stampaRidotta>Città Sede</p></td>
								<td><input type=text value="<%=lavData.get(i).getCittaSede()%>" readonly></td>
							</tr>
							<tr>
								<td><p class=stampaRidotta>Via Sedee</p></td>
								<td><input type=text value="<%=lavData.get(i).getViaSede()%>" readonly></td>
							</tr>
							<tr>
								<td><p class=stampaRidotta>Piano Sede</p></td>
								<td><input type=text value="<%=lavData.get(i).getPianoSede()%>" readonly></td>
							</tr>
							<tr>		
								<td><p class=stampaRidotta>Data Esecuzione </p></td>	
								<td><input type=date name=dataPrevistaEsecuzione value="<%=lavData.get(i).getDataPrevistaEsecuzione()%>" readonly></td>
							</tr>	
						

		<%
							idLavConf=lavData.get(i).getIdLavorazione();
						}
		%>
							<tr>
								<td><p class=stampaRidotta>Nome Servizio</p></td>
								<td><input type=text value="<%=lavData.get(i).getNomeServizio()%>" readonly></td>
							</tr>
		<%
					}
				}
			
		%>
		</table>
				</div>					

	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>