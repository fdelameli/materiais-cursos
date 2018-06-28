<%@page import="br.unisul.banco.bean.ProdutoBean"%>
<%@page import="br.unisul.banco.bo.ProdutoBo"%>

<%

boolean modoEdicao = false;
ProdutoBean bean = new ProdutoBean();

if (request.getParameter("alterar") != null) {
	modoEdicao = true;
	
	Integer id1 = Integer.parseInt(request.getParameter("alterar"));
	
	ProdutoBo bo = new ProdutoBo();
	bean = bo.buscarProdutoPorCodigo(id1);
}

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-9958-1" />
<%if (modoEdicao) {%>
	<title>Alterar Produto</title>
<%} else {%>
	<title>Cadastrar Produto</title>
<%}%>
</head>
<body>

<form method="post"
<%if (modoEdicao) {%>
	action="alterarProduto"
<%} else {%>
	action="cadastrarProduto">
<%}%>

	Código: <input type="text" name="codigo" value="<%if(modoEdicao){out.println(bean.getCodigo());}%>"><br>
	Descrição: <input type="text" name="descricao" value="<%if(modoEdicao){out.println(bean.getDescricao());}%>"><br>
	Gênero: <input type="text" name="genero" value="<%if(modoEdicao){out.println(bean.getGenero());}%>"><br>
	Valor: <input type="text" name="valor" value="<%if(modoEdicao){out.println(bean.getValor());}%>"><br>
	
	<input type="submit"
	<%if (modoEdicao) {%>
		value="Atualizar"
	<%} else {%>
		value="Cadastrar">
	<%}%>

</form>

</body>
</html>