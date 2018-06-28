<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<script type="text/javascript">
	function validaForm() {
		d = document.form;
		if (d.nome.value == "") {
			alert("O campo \"Nome\" deve ser preenchido!");
			return false;
		}
		return true;
	}
</script>

<h3>Cadastrar nova transportadora:</h3>

<form method="post" action="cadastrarTransportadora" class="contato" name="form" onsubmit="return validaForm()">
<fieldset>
<legend>Cadastrar Transportadora</legend>

<label for="nome">Nome:(<span>*</span>)</label>
<input type="text" name="nome" id="nome"> 

<br>
<br>
<input type="submit" value="Cadastrar">

</fieldset>
</form>
