<%@page import="br.unisul.banco.bean.ProdutoBean"%>
<%@page import="java.util.List"%>

<%

List carrinhoCompras = (List)request.getSession().getAttribute("lista");

%>


<html>
<head>
<title>Carrinho de Compras</title>
</head>
<body>

<h1>Carrinho de compras:</h1>

<table border="1">

<tr>
	<th>Código</th>
	<th>Descrição</th>
	<th>Gênero</th>
	<th>Valor</th>
	<th>Opções</th>
</tr>

<%

for (int i = 0; i < carrinhoCompras.size(); i++) {
	ProdutoBean produto = (ProdutoBean)carrinhoCompras.get(i);
%>
	<tr>
		<td><%=produto.getCodigo()%></td>
		<td><%=produto.getDescricao()%></td>
		<td><%=produto.getGenero()%></td>
		<td><%=produto.getValor()%></td>
		<td></td>	
	</tr>

<%}%>



</table>

</body>
</html>