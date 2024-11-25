<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="org.springframework.web.servlet.view.RedirectView"%>
<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="ch.qos.logback.core.net.SyslogOutputStream"%>
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
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<jsp:include page="navbarOperaio.jsp"></jsp:include>
		<div class=divLogoNav><img class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
		<div class=insert>
		<form action="aggiornaServizio" method=post>
			<table>

		
			<%
				List<ComprendeDto> listDto=(List<ComprendeDto>) request.getAttribute("compDto"); 
				Date dataDaRic=(Date) request.getAttribute("dataDaRic");
				Long idLav = (Long) request.getAttribute("lavori");
				
				
				if((listDto!=null) && (dataDaRic!=null) && (idLav!=null))
				{ 
					int i;
					Long idLavDaVer=0L, idLavConf=1L;
					for(i=0;i<listDto.size();i++)
					{
						idLavDaVer=listDto.get(i).getIdLavorazione();
						if(listDto.get(i).getDataPrevistaEsecuzione().equals(dataDaRic) && (idLav==listDto.get(i).getIdLavorazione()))
						{
							if(listDto.get(i).getFineEsecuzioneServizio()==false)
							{
								if(idLavConf!=idLavDaVer)
								{
			%>
	
						<tr>
								<td><p class=stampaRidotta>ID Lavorazione</p></td>
								<td><input type=text name=idLavorazione value="<%=listDto.get(i).getIdLavorazione()%>" readonly></td>
							</tr>	
							<tr>
								<td><p class=stampaRidotta>Nome Sede</p></td>	
								<td><input type=text value="<%=listDto.get(i).getNomeSede()%>" readonly></td>
							</tr>
							<tr>	
								<td><p class=stampaRidotta>Città Sede</p></td>
								<td><input type=text value="<%=listDto.get(i).getCittaSede()%>" readonly></td>
							</tr>
							<tr>
								<td><p class=stampaRidotta>Via Sedee</p></td>
								<td><input type=text value="<%=listDto.get(i).getViaSede()%>" readonly></td>
							</tr>
							<tr>
								<td><p class=stampaRidotta>Piano Sede</p></td>
								<td><input type=text value="<%=listDto.get(i).getPianoSede()%>" readonly></td>
							</tr>
							<tr>		
								<td><p class=stampaRidotta>Data Esecuzione </p></td>	
								<td><input type=date name=dataPrevistaEsecuzione value="<%=listDto.get(i).getDataPrevistaEsecuzione()%>" readonly></td>
							</tr>	
								
	
			<%
									idLavConf=listDto.get(i).getIdLavorazione();
								}
			%>
									<tr>
										<td><p class=stampaRidotta>Nome Servizio </p></td>
										<td><input type=text value="<%= listDto.get(i).getNomeServizio()%>" readonly></td>
			<% 
									if(listDto.get(i).getResponsabileSquadra()==true)
									{
			%>
			
										<td><input type=text name=idComprende value="<%=listDto.get(i).getIdComprende()%>" readonly></td>
										<td><input class=submit type=submit value="Completato" ></td>
									</tr>
			<%
									}
							}
							else
							{
								response.sendRedirect("lavori");
							}
									
						}
					}
				}
				
			%>							
			</table>
			
		</form>
		</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>