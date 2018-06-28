<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.unisul.banco.bo.ProdutoBo"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.banco.bean.ProdutoBean"%>
<%

if(request.getSession().getAttribute("logado")==null ){
	response.sendError(response.SC_UNAUTHORIZED,"Acesso negado!");
}

	List resultado = null;
	if (request.getSession().getAttribute("ShoppingCart") != null) {
		resultado = (List) request.getSession().getAttribute(
				"ShoppingCart");
	}
	
	if(resultado.isEmpty()){
		return;
	}
%>

<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carrinho de Compras</title>
</head>
<body>
<h3>Shopping Cart</h3>
<table border="1" id="box-table-a">
	<tr>
		<th>Código</th>
		<th>Nome</th>
		<th>Preço</th>
		<th>Tipo</th>
		<th colspan="2">Opcões</th>

	</tr>
	<%
		if (resultado != null) {
			for (int i = 0; i < resultado.size(); i++) {
				ProdutoBean produto = (ProdutoBean) resultado.get(i);
	%>
	<tr>
		<td><%=produto.getCodigo()%></td>
		<td><%=produto.getNome()%></td>
		<td><%=produto.getPreco()%></td>
		<td><%=produto.getTipo()%></td>
		<td align="center"><a href="../../sequencial/atualizarCart?id=<%=produto.getCodigo()%>&acao=<%=i %>">Retirar</a></td>
		
	</tr>
	<%
			}

		} else {
			out.println("Este carrinho ainda não possui produtos.");
		}
	%>
</table>
</body>
</html>
