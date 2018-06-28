<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<%
	UsuarioBean usuarioPerfil = (UsuarioBean)request.getSession().getAttribute("logado");
%>

<script type="text/javascript">
	function validaForm() {
		d = document.form;
		if (d.nome.value == "") {
			alert("O campo \"Nome\" deve ser preenchido!");
			return false;
		} else if (d.email.value == "") {
			alert("O Campo \"E-mail\" deve ser preenchido!");
			return false;
		} else if (d.senha.value == "") { 
			alert("O Campo \"Senha\" deve ser preenchido!");
			return false;
		}
		return true;
	}
</script>

<h3>Perfil do usuário: <span><%=usuarioPerfil.getNome()%></span></h3>

<form method="post" action="editarPerfilUser" class="contato" name="form" onsubmit="return validaForm()">
<fieldset>
<legend>Editar Perfil</legend>

<label for="nome">Nome:(<span>*</span>)</label>
<input type="text" name="nome" id="nome" value="<%=usuarioPerfil.getNome()%>"> 

<label for="email">E-mail:(<span>*</span>)</label>
<input type="text" name="email" id="email" value="<%=usuarioPerfil.getEmail()%>">

<label for="senha">Senha:(<span>*</span>)</label>
<input type="text" name="senha" id="senha" value="<%=usuarioPerfil.getSenha()%>">

<label for="endereco">Endereço:</label>
<input type="text" name="endereco" id="endereco" value="<%=usuarioPerfil.getEndereco()%>">

<label for="cidade">Cidade:</label>
<input type="text" name="cidade" id="cidade" value="<%=usuarioPerfil.getCidade()%>">

<label for="uf">UF:</label>
<input type="text" name="uf" id="uf" value="<%=usuarioPerfil.getUf()%>">
<br>
<br>
<br>
<input class="botao" type="submit" value="Atualizar">

</fieldset>
</form>
