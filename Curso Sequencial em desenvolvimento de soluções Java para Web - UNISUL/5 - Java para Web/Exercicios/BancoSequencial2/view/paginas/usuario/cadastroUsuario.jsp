<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.unisul.banco.bo.UsuarioBo"%>
<%@page import="br.unisul.banco.bean.UsuarioBean"%>
<%

boolean modoEdicao = false;
UsuarioBean usuario = new UsuarioBean();

if(request.getSession().getAttribute("logado")==null || request.getSession().getAttribute("admin")==null){
	response.sendError(response.SC_UNAUTHORIZED,"Acesso negado!");
}


if(request.getParameter("alterar") != null){
	modoEdicao = true;
	
	Integer id = Integer.parseInt(request.getParameter("alterar"));
	
	UsuarioBo bo = new UsuarioBo();	
	usuario = bo.buscarUsuarioPorCodigo(id);
}

%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%if(modoEdicao){ %>
<title>Alterar Usuario</title>
<% }else{ %>
<title>Cadastrar Usuario</title>
<% } %>
</head>
<body>

<form method="post" 
<%if(modoEdicao){ %>
action="../../sequencial/alterarUsuario"
<% }else{ %>
action="../../sequencial/cadastrarUsuario"
<% } %>
>

<input type="hidden" name="codigo" value="<%if(modoEdicao){out.println(usuario.getCodigo());}%>"><br>
Nome: <input type="text" name="nome" value="<%if(modoEdicao){out.println(usuario.getNome());}%>"><br>
Login: <input type="text" name="login" value="<%if(modoEdicao){out.println(usuario.getLogin());}%>"><br>
Senha: <input type="password" name="senha" value="<%if(modoEdicao){out.println(usuario.getSenha());}%>"><br>
Email: <input type="text" name="email" value="<%if(modoEdicao){out.println(usuario.getEmail());}%>"><br>
Tipo: <input type="text" name="tipo" value="<%if(modoEdicao){out.println(usuario.getTipo());}%>"><br>

<input type="submit" 
<%if(modoEdicao){ %>
value="Alterar"
<% }else{ %>
value="Cadastrar"
<% } %> >
</form>
</body>
</html>






