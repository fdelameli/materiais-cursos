<%@page import="br.unisul.banco.bo.UsuarioBo"%>
<%@page import="br.unisul.banco.bean.UsuarioBean"%>
<%@page import="java.util.List"%>

<%

UsuarioBo bo = new UsuarioBo();
List resultado = bo.listarUsuarios();

%> 


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-9958-1" />
<title>Pesquisa de Usuário</title>
</head>
<body>

<h1>Resultado:</h1>

<table border="1">
<tr>
	<th>Código</th>
	<th>Nome</th>
	<th>Login</th>
	<th>Senha</th>
	<th>Email</th>
	<th>Tipo</th>
	<th colspan="2">Opções</th>
</tr>

<%
	for (int i = 0; i < resultado.size(); i++) {
		UsuarioBean usuario = (UsuarioBean)resultado.get(i);
%>
	<tr>
		<td><%=usuario.getCodigo()%></td>
		<td><%=usuario.getNome()%></td>
		<td><%=usuario.getLogin()%></td>
		<td><%out.println(usuario.getSenha());%></td>
		<td><%=usuario.getEmail()%></td>
		<td><%=usuario.getTipo()%></td>
		<td><a href="excluirUsuario?id=<%=usuario.getCodigo()%>">Excluir</a></td>
		<td><a href="index.jsp?id=cadastro-user&alterar=<%=usuario.getCodigo()%>">Alterar</a></td>
	</tr>
	
<%}%>

</table>

</body>
</html>