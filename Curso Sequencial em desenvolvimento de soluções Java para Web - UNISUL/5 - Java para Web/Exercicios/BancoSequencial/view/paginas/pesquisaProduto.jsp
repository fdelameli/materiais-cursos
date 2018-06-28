<%@page import="br.unisul.banco.bo.ProdutoBo"%>
<%@page import="br.unisul.banco.bean.ProdutoBean"%>
<%@page import="java.util.List"%>

<%

ProdutoBo bo = new ProdutoBo();
List resultado = bo.listarProdutos();

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
	<th>Descrição</th>
	<th>Gênero</th>
	<th>Valor</th>
	<th colspan="3">Opções</th>

</tr>

<%
	for (int i = 0; i < resultado.size(); i++) {
		ProdutoBean produto = (ProdutoBean)resultado.get(i);
%>
	<tr>
		<td><%=produto.getCodigo()%></td>
		<td><%=produto.getDescricao()%></td>
		<td><%=produto.getGenero()%></td>
		<td><%=produto.getValor()%></td>
		<td><a href="excluirProduto?id=<%=produto.getCodigo()%>">Excluir</a></td>
		<td><a href="index.jsp?id=cadastro-pro&alterar=<%= produto.getCodigo()%>">Alterar</a></td>
		<td><a href="adicionaCarrinho?id=<%=produto.getCodigo()%>">Add Carrinho</a></td>
	</tr>
	
<%}%>

</table>

</body>
</html>