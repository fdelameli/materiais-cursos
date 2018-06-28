<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.unisul.banco.bo.ProdutoBo"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.banco.bean.ProdutoBean"%>
<%@page import="br.unisul.banco.bean.UsuarioBean"%>
<%

UsuarioBean usuario=null;
if(request.getSession().getAttribute("logado")==null ){
	response.sendError(response.SC_UNAUTHORIZED,"Acesso negado!");
}else{
	usuario =  (UsuarioBean)request.getSession().getAttribute("logado");
}

List resultado;
if(request.getSession().getAttribute("refresh") == "normal"){
	resultado = (List)request.getSession().getAttribute("listaProduto");
}else{
	ProdutoBo bo = new ProdutoBo();
	resultado = bo.listarProduto();
}
%>

<html>
<head><title>Pesquisa de Produtos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<h1>Consulta</h1>

<form method="post" action="../../sequencial/pesquisarProduto">
<table id="box-table-a">
<tr><td>Codigo: <input type="text" name="codigo"></td>
<td>Nome: <input type="text" name="nome"></td>
<td>Preço: <input type="text" name="preco"></td></tr>
<tr><td colspan="3" align="center"><input type="submit" value="Pesquisar"></td></tr>
</table>
<br/>

</form>
<br/>

<table border="1" id="box-table-a">
<tr>
	<th>Código</th>
	<th>Nome</th>
	<th>Preço</th>
	<th>Tipo</th>
	<th colspan="2">Opcões</th>
	<th width="120px">Adicionar ao Shopping Cart</th>
	
</tr>
<%
	if(resultado!=null){
	for(int i = 0; i < resultado.size(); i++){
		ProdutoBean	produto = (ProdutoBean)resultado.get(i);	
%>
	<tr>
		<td><%=produto.getCodigo()%></td>
		<td><%=produto.getNome()%></td>
		<td><%=produto.getPreco()%></td>
		<td><%=produto.getTipo()%></td>
		<% if(usuario!=null && usuario.getTipo()==1){ %><td align="center"><a href="../../sequencial/excluirProduto?id=<%=produto.getCodigo()%>">Excluir</a></td><%} %>
		<% if(usuario!=null && usuario.getTipo()==1){ %><td align="center"><a href="../../sequencial/produto/cadastroProduto.jsp?alterar=<%=produto.getCodigo()%>">Alterar</a></td><%} %>
		<td align="center"><a href="../../sequencial/atualizarCart?id=<%=produto.getCodigo()%>" ><img src="../../sequencial/images/download-green.png" alt="Adicionar ao Carrinho de Compras"/></a></td>
				
	</tr>
<%}} %>
</table>
</body>
</html>
