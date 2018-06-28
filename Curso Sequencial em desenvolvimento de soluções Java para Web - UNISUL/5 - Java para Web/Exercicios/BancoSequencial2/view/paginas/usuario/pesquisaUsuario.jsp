<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.unisul.banco.bo.UsuarioBo" %>
<%@page import="java.util.List"%>
<%@page import="br.unisul.banco.bean.UsuarioBean"%>
<%

if(request.getSession().getAttribute("logado")==null ){
	response.sendError(response.SC_UNAUTHORIZED,"Acesso negado!");
}

List resultado;
if(request.getSession().getAttribute("refresh") == "normal"){
	resultado = (List)request.getSession().getAttribute("listaUsuario");
}else{
	UsuarioBo bo = new UsuarioBo();
	resultado = bo.listarUsuario();
}
%>



<html>
<head><title>Pesquisa de Usuários</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head>
<body>

<h1>Consulta</h1>

<form method="post" action="../../sequencial/pesquisarUsuario">
Codigo: <input type="text" name="codigo"><br>
Nome: <input type="text" name="nome"><br>
Login: <input type="text" name="login"><br>
Email: <input type="text" name="email"><br>

<input type="submit" value="Pesquisar">
</form>

<table border="1" id="box-table-a">
<tr>
	<th>Código</th>
	<th>Nome</th>
	<th>Login</th>
	<th>Senha</th>
	<th>Email</th>
	<th>Tipo</th>
	<th colspan="2" width="200px">Opcões</th>
	
</tr>
<%
	if(resultado!=null){
	for(int i = 0; i < resultado.size(); i++){
		UsuarioBean	usuario = (UsuarioBean)resultado.get(i);	
%>
	<tr>
		<td><%=usuario.getCodigo()%></td>
		<td><%=usuario.getNome()%></td>
		<td><%=usuario.getLogin()%></td>
		<td><%out.println(usuario.getSenha());%></td>
		<td><%=usuario.getEmail()%></td>
		<td><%=usuario.getTipo()%></td>
		<td align="center"><a href="../../sequencial/excluirUsuario?id=<%=usuario.getCodigo()%>&tela=2">Excluir</a></td>
		<td align="center"><a href="../../sequencial/usuario/cadastroUsuario.jsp?alterar=<%=usuario.getCodigo()%>">Alterar</a></td>
				
	</tr>
<%}} %>
</table>
</body>
</html>
