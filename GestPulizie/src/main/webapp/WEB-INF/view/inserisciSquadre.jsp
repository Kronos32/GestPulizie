<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Squadra"
    import="it.rf.gestpulizie.model.Operaio"
    import="java.util.List"
    import="it.rf.gestpulizie.model.Eformata"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Crea Squadra </title>
	</head>
<body>
	<jsp:include page="navbarGestSquadre.jsp"></jsp:include>
	<div class=divLogoNav><img id=Logo class=logoNav alt="Logo CleanUp" src="image/CleanUpLogo.png"></div>
	<div class=insert>
	<form action=inserisciSquadre method=Post>
		<h1>Crea una Squadra</h1>
		<div><input type=text name=nomeSquadra placeholder="Nome Squadra" required></div>
		<div><input type=text name=descrizioneSquadra placeholder="Descrizione"></div>
		<br>Data operatività della squadra: <input type=date name=dataOperativita required>
		<div><input class=submit type=submit value="Crea Squadra"></div>
	</form>
	</div>
	<% 
		Boolean esito=(Boolean)request.getAttribute("esito");
		if(esito != null){
	%>
	<div class=insertOp>
	<form action=associaSquadra method=Post>
		<br>Operai Disponibili: <br>
		<% 
			List<Operaio> elencoDisp=(List<Operaio>) request.getAttribute("elencoDisponibili");
				int i;
				for(i=0;i<elencoDisp.size();i++){ 
			%>
			<input type=checkbox name=cfOperaio[] value=<%= elencoDisp.get(i).getCfOperaio() %>> <%= elencoDisp.get(i).getNomeOperaio() %> <%= elencoDisp.get(i).getCognomeOperaio() %>
			<%} %>
		<div><input class=submit type=submit value="Associa Operai"></div>
	</form>
	</div>
	<%
		}
		else{
	%>
	
	<%
		}
		List<Eformata> ListSquad=(List<Eformata>) request.getAttribute("ListSquad");
		if(ListSquad!=null && ListSquad.size()>0 )
		{
	%>
	<div class=insertOp>
	<form action="associaResponsabile" method=post>
				<select name=setResp>
			
			<option value="">---Scegli Responsabile---</option>
		<% 

				int j;
				for(j=0;j<ListSquad.size();j++)
				{
		%>
			<option value=<%= ListSquad.get(j).getOpF().getCfOperaio()%>> <%= ListSquad.get(j).getOpF().getNomeOperaio() %></option>

		<%		}
				%>
						</select>
			<div><input class=submit type=submit value="Associa Responsabile"></div>
		<%
			}
			else
			{
		%>
		<%} %>


	</form>
	</div>
	
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>