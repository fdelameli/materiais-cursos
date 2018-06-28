<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.unisul.banco.bo.ProdutoBo"%>
<%@page import="br.unisul.banco.bean.ProdutoBean"%>
<%

boolean modoEdicao = false;
ProdutoBean produto = new ProdutoBean();

if(request.getSession().getAttribute("logado")==null || request.getSession().getAttribute("admin")==null){
	response.sendError(response.SC_UNAUTHORIZED,"Acesso negado!");
}

if(request.getParameter("alterar") != null){
	modoEdicao = true;
	
	Integer id = Integer.parseInt(request.getParameter("alterar"));
	
	ProdutoBo bo = new ProdutoBo();	
	produto = bo.buscarProdutoPorCodigo(id);
}

%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%if(modoEdicao){ %>
<title>Alterar Produto</title>
<% }else{ %>
<title>Cadastrar Produto</title>
<% } %>

</head>
<body>

<form method="post" <%if(modoEdicao){ %> action="../../sequencial/alterarProduto" <% }else{ %> action="../../sequencial/cadastrarProduto" <% } %>>

<input type="hidden" name="codigo" value="<%if(modoEdicao){out.println(produto.getCodigo());}%>"><br>
Nome: <input type="text" name="nome" value="<%if(modoEdicao){out.println(produto.getNome());}%>"><br>
Preço: <input type="text" name="preco" value="<%if(modoEdicao){out.println(produto.getPreco());}%>"><br>
Tipo: <input type="text" name="tipo" value="<%if(modoEdicao){out.println(produto.getTipo());}%>"><br>

<input type="submit" <%if(modoEdicao){ %> value="Alterar" <% }else{ %> value="Cadastrar" <% } %> >
</form>
</body>
</html>






