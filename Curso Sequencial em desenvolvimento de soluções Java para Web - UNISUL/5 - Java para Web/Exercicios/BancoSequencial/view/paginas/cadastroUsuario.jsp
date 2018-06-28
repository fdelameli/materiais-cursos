<%@page import="br.unisul.banco.bo.UsuarioBo"%>
<%@page import="br.unisul.banco.bean.UsuarioBean"%>

<%

boolean modoEdicao = false;
UsuarioBean bean = new UsuarioBean();

if (request.getParameter("alterar") != null) {
	modoEdicao = true;
	
	Integer id1 = Integer.parseInt(request.getParameter("alterar"));
	
	UsuarioBo bo = new UsuarioBo();
	bean = bo.buscarUsuarioPorCodigo(id1);
}

%>


<html>
<head>
<%if (modoEdicao) {%>
	<title>Alterar Usuário</title>
<%} else {%>
	<title>Cadastrar Usuário</title>
<%}%>
</head>
<body>

<form method="post" 
<%if (modoEdicao) {%>
	action="alterarUsuario"
<%} else {%>
	action="cadastrarUsuario">
<%}%>


	Código: <input type="text" name="codigo" value="<%if(modoEdicao){out.println(bean.getCodigo());}%>"><br>
	Nome: <input type="text" name="nome" value="<%if(modoEdicao){out.println(bean.getNome());}%>"><br>
	Login: <input type="text" name="login" value="<%if(modoEdicao){out.println(bean.getLogin());}%>"><br>
	Senha: <input type="password" name="senha" value="<%if(modoEdicao){out.println(bean.getSenha());}%>"><br>
	Email: <input type="text" name="email" value="<%if(modoEdicao){out.println(bean.getEmail());}%>"><br>
	Tipo: <input type="text" name="tipo" value="<%if(modoEdicao){out.println(bean.getTipo());}%>"><br>
	
	<input type="submit"
	<%if (modoEdicao) {%>
		value="Atualizar"
	<%} else {%>
		value="Cadastrar">
	<%}%>
	

</form>

</body>
</html>