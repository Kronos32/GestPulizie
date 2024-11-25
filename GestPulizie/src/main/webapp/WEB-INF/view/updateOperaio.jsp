<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Optional"
	import="it.rf.gestpulizie.model.Operaio" import="java.util.List"
	import="java.util.List"
	import="it.rf.gestpulizie.model.CategoriaOperaio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<jsp:include page="navbarGestOperaio.jsp"></jsp:include>
	<% Optional<Operaio> op= (Optional<Operaio>)request.getAttribute("opTrovato");
		List<Operaio> opList=(List<Operaio>)request.getAttribute("opList");
		List<CategoriaOperaio> catList= (List<CategoriaOperaio>) request.getAttribute("catTrovata");%>
	<form method="post" value="modificaOperaio">
		<br> Codice Fiscale<br> <input type="search" name=cfOperaio><br>
		<p>O</p>
		Nome<br> <input type="search" name=nomeOperaio><br>
		Cognome<br> <input type="search" name=cognomeOperaio><br>
		<input type=submit value="Creca Operaio Da Modificare"><br>
	</form>


	<%
			if(op!=null && op.isPresent())
			{
		%>
	<form method="post" action="updateOperaio">
		<div class=insert>
			<input type=hidden name=pswOperaio
				value="<%=op.get().getPswOperaio()%>"> <input type=hidden
				name=usernameOperaio value="<%=op.get().getUsernameOperaio()%>">
			<div>
				Nome<br> <input type=text
					value="<%=op.get().getNomeOperaio() %>" name=nomeOperaio><br>
			</div>
			<div>
				Cognome<br> <input type=text
					value="<%=op.get().getCognomeOperaio() %>" name=cognomeOperaio><br>
			</div>
			<div>
				Codice Fiscale<br> <input type=text
					value="<%=op.get().getCfOperaio() %>" name=cfOperaio readonly><br>
				Categoria<br>
				 <select name=opCat>
					<% 

					if(catList!=null && catList.size()>0)
					{
						int x;
						for(x=0; x<catList.size(); x++)
						{	
				%>
					<option value="<%= catList.get(x).getIdCategoria()%>"><%= catList.get(x).getNomeCategoria()%></option>
					<%
						}
					}
					%>
					</select>
				<%
					if(op.get().getStatoOperativita().equals(true))
					{
				%>
				 <br>Rimuovi Operatività<br> <input type="checkbox"
					value=0 name=statoOperativita><br>

				<%
				}
				if(op.get().getStatoOperativita().equals(false))
				{
		%>
				<br>Rendi Operativo<br> <input type="checkbox" value=1
					name=statoOperativita><br>

				<%
				}
		%>
				<input type=submit value="Modifica"><br>
	</form>
	<form method="post"
		action="eliminaOperaio?cfOperaio=<%=op.get().getCfOperaio() %>">
		<div class=insert>
			<input type=submit value="Elimina">
		</div>
	</form>

	<%
			}
					
			else if(opList!=null && opList.size()>0)
			{
				int i;
				for(i=0;i<opList.size();i++)
				{
		%>
	<form method="post" action="updateOperaio">
		<div class=insert>
			<input type=hidden name=pswOperaio
				value="<%=opList.get(i).getPswOperaio()%>"> <input
				type=hidden name=usernameOperaio
				value="<%=opList.get(i).getUsernameOperaio()%>">
			<div>
				Nome<br> <input type=text
					value="<%=opList.get(i).getNomeOperaio() %>" name=nomeOperaio><br>
			</div>
			<br>
			<div>
				Cognome Operaio<br> <input type=text
					value="<%=opList.get(i).getCognomeOperaio() %>" name=cognomeOperaio><br>
			</div>
			<div>
				Codice Fiscale<br> <input type=text
					value="<%=opList.get(i).getCfOperaio() %>" name=cfOperaio readonly><br>
			</div>
			Categoria<br> <select name=opCat>
				<% 	
						
						if(catList!=null && catList.size()>0)
						{
							int j;
							for(j=0; j<catList.size();j++)
							{	
						%>
				<option value="<%= catList.get(j).getIdCategoria()%>"><%= catList.get(j).getNomeCategoria()%></option>
				<%
						
							}%>
			</select>
			<%
					}
					int k;
				for(k=0;k<opList.size();k++)
				{
					if(opList.get(k).getStatoOperativita().equals(true))
					{
				%>

			<br>Rimuovi Operatività<br> <input type="checkbox" value=0
				name=statoOperativita><br>

			<%
				}
				if(opList.get(k).getStatoOperativita().equals(false))
				{
		%>
			<br>Rendi Operativo<br> <input type="checkbox" value=1
				name=statoOperativita><br>

			<%
					}
				}
			
		%>
			<input type=submit value="Modifica"><br>
	</form>
	<form method="post"
		action="eliminaOperaio?cfOperaio=<%=opList.get(i).getCfOperaio() %>">
		<div class=insert>
			<input type=submit value="Elimina">
		</div>
	</form>

	<%
				}
			}
			else if(op!=null && op.isPresent()==false && opList.size()==0)
			{
		%>

	<p>${esito}</p>

	<%
			}
		%>
</body>
</html>