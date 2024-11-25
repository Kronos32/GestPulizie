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
		<form action=lavori method=post>
			<input type=date name=dataPrevistaEsecuzione required>
			<input type=submit value=Cerca class=submit>
		</form>
		
		
			<%List<ComprendeDto> listDto=(List<ComprendeDto>) request.getAttribute("compDto"); 
				Date dataDaRic=(Date) request.getAttribute("dataDaRic");
	if(listDto!=null && listDto.size()>0)
	{
		int j, count=0;
		for(j=0;j<listDto.size();j++)
		{
			if(listDto.get(j).getDataPrevistaEsecuzione().equals(dataDaRic))
			{
				count++;
			}
		}
		if(count>0)
		{
			int i;
			Long idLavDaVer=0L, idLavConf=1L;
			for(i=0;i<listDto.size();i++)
			{
				idLavDaVer=listDto.get(i).getIdLavorazione();
				if(listDto.get(i).getDataPrevistaEsecuzione().equals(dataDaRic))
				{
					if(listDto.get(i).getFineEsecuzioneServizio()==false)
					{
						if(idLavConf!=idLavDaVer)
						{
	%>
							<form action="visualizzaLavori" method=post>
								<table>
									<tr>
										<td><input name=idLavorazione type=text value="<%=listDto.get(i).getIdLavorazione()%>" readonly></td>
										<td><input type=text value="<%=listDto.get(i).getNomeSede()%>" readonly></td>
										<td><input type=text value="<%=listDto.get(i).getCittaSede()%>" readonly></td>
										<td><input type=text value="<%=listDto.get(i).getViaSede()%>" readonly></td>
										<td><input type=text value="<%=listDto.get(i).getPianoSede()%>" readonly></td>
										<td><input type=date name=dataPrevistaEsecuzione value="<%=listDto.get(i).getDataPrevistaEsecuzione()%>" readonly></td>
										<td><input type=submit value=Visualizza class=submit></td>
									</tr>	
								</table>
								
							</form>
	<%
							idLavConf=listDto.get(i).getIdLavorazione();
						}
					}
				}
			}
		}
		else
		{
	%>
			<p>Non ci sono lavorazioni previste in questa data</p>
	<%
		}
	}
	else if(listDto!=null && listDto.size()==0)
	{
	%>
	<p class=stampa>Non ci sono lavorazioni programmate</p>
	<%
	}
	%>
	</div>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>