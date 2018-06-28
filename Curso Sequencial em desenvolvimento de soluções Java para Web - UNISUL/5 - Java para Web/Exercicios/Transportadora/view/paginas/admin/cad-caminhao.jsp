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
		if (d.descricao.value == "") {
			alert("O campo \"Descrição\" deve ser preenchido!");
			return false;
		}
		return true;
	}
</script>

<h3>Cadastrar novo caminhão:</h3>

<form method="post" action="cadastrarCaminhao" class="contato" name="form" onsubmit="return validaForm()">
<fieldset>
<legend>Cadastrar Caminhão</legend>

<label for="descricao">Descrição:(<span>*</span>)</label>
<input type="text" name="descricao" id="descricao"> 

<br>
<br>
<input type="submit" value="Cadastrar">

</fieldset>
</form>
