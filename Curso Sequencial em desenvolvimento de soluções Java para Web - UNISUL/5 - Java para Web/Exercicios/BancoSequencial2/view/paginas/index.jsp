<%@page import="br.unisul.banco.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./js/ajax.js" type="text/javascript"></script>

<title>SUPER CRUD!</title>
<link href="./css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./css/newTable.css" rel="stylesheet" type="text/css"/>
<link href="./css/tabelas.css" rel="stylesheet" type="text/css"/>

<%
UsuarioBean usuario = null;
String welcome="";
if(request.getSession().getAttribute("logado")==null ){
	response.sendError(response.SC_UNAUTHORIZED,"Acesso negado!");
}else{
	usuario =  (UsuarioBean)request.getSession().getAttribute("logado");
	welcome = "Bem vindo senhor " + usuario.getNome();
}


	String result = "";
	if(request.getSession().getAttribute("result")!=null){
		result = (String)request.getSession().getAttribute("result");
	}else{ 
		result = "./bemvindo.jsp"; 
	}
	
	String sc = "";
	if(request.getSession().getAttribute("sc")!=null){
		sc = (String)request.getSession().getAttribute("sc");
	}else{ 
		sc = "./bemvindo.jsp"; 
	}
	
	
%>
</head>
<body onload="ajaxAbre('<%=result %>','conteudo'); ajaxAbre('<%=sc %>','sc');">
<p class="msgDesc"><%=welcome %><a href="./logout" style="float:right;">Sair</a></p>
<table id="box-table-a">
	<tr>

	<% if(usuario!=null && usuario.getTipo()==1){ %><td><a onclick="ajaxAbre('/sequencial/usuario/cadastroUsuario.jsp','conteudo')" href="javascript:;">Cadastro de Usuários</a></td><%} %>
	<% if(usuario!=null && usuario.getTipo()==1){ %><td><a onclick="ajaxAbre('/sequencial/usuario/pesquisaUsuario.jsp','conteudo')" href="javascript:;">Usuários</a></td><%} %>
	<% if(usuario!=null && usuario.getTipo()==1){ %><td><a onclick="ajaxAbre('/sequencial/produto/cadastroProduto.jsp','conteudo')" href="javascript:;">Cadastro de Produtos</a></td><%} %>
	
	<% if(usuario!=null && usuario.getTipo()==1){ %><td><a onclick="ajaxAbre('/sequencial/noticia/cadastroNoticia.jsp','conteudo')" href="javascript:;">Cadastro de Notícias</a></td><%} %>
	<td><a onclick="ajaxAbre('/sequencial/noticia/pesquisaNoticia.jsp','conteudo')" href="javascript:;">Notícias</a></td>
	<td><a onclick="ajaxAbre('/sequencial/produto/pesquisaProduto.jsp','conteudo')" href="javascript:;">Produtos</a></td>
	
	</tr>
</table>


<div id="conteudo"></div>
<br/>
<br/>
<div id="sc"></div>

</body>
</html>