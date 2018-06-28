<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuario2 = (UsuarioBean)request.getSession().getAttribute("logado");
%>

<h3>Acesso restrito</h3>

<table>
	<tr><td><p>Olá <span><%=usuario2.getNome()%></span>,</p><td></tr>
	<tr><td><p>Você está logado como administrador.</p><td></tr>
	<tr><td><a href="/transportadora/logout">Logout</td></tr>
</table>