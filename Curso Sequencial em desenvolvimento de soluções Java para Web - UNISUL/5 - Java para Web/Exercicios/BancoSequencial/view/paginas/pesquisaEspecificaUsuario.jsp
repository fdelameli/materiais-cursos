<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.unisul.banco.bean.UsuarioBean"%>

<%

List listaUsuarios = new ArrayList();
if (request.getSession().getAttribute("lista") != null) {
	listaUsuarios = (List) request.getSession().getAttribute("lista");
}

%>


<html>
<head>
<title>Pesquisa Específica</title>
</head>
<body>

<h1>Pesquisa Específica de Usuários</h1>

<form method="post" action="pesquisarUsuario">

	Código: <input type="text" name="codigo"><br>
	Nome: <input type="text" name="nome"><br>
	Login: <input type="text" name="login"><br>
	Email: <input type="text" name="email"><br>
	
	<input type="submit" value="Pesquisar">

</form>

<table border="1">

<tr>
	<th>Código</th>
	<th>Nome</th>
	<th>Login</th>
	<th>Senha</th>
	<th>Email</th>
	<th>Tipo</th>
</tr>

<%
	for (int i = 0; i < listaUsuarios.size(); i++) {
		UsuarioBean usuario = (UsuarioBean)listaUsuarios.get(i);
%>
	<tr>
		<td><%=usuario.getCodigo()%></td>
		<td><%=usuario.getNome()%></td>
		<td><%=usuario.getLogin()%></td>
		<td><%=usuario.getSenha()%></td>
		<td><%=usuario.getEmail()%></td>
		<td><%=usuario.getTipo()%></td>
	</tr>
		
<%}%>	



</table>

</body>
</html>