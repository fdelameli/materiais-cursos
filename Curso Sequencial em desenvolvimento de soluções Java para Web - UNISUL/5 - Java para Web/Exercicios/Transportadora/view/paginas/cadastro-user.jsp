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
		} else if (d.tipo.value == "") {
			alert("Selecione um opção no campo \"Tipo\"!");
			return false;
		}
		return true;
	}
</script>

<h2>Cadastrar novo usuário:</h2>

<form method="post" action="cadastrarUser" class="contato" name="form" onsubmit="return validaForm()">
<fieldset>
<legend>Cadastrar</legend>

<label for="nome">Nome:(<span>*</span>)</label>
<input type="text" name="nome" id="nome"> 

<label for="email">E-mail:(<span>*</span>)</label>
<input type="text" name="email" id="email">

<label for="senha">Senha:(<span>*</span>)</label>
<input type="password" name="senha" id="senha">

<label for="endereco">Endereço:</label>
<input type="text" name="endereco" id="endereco">

<label for="cidade">Cidade:</label>
<input type="text" name="cidade" id="cidade">

<label for="uf">UF:</label>
<input type="text" name="uf" id="uf">

<label for="tipo">Tipo:(<span>*</span>)</label>
<select name="tipo" id="tipo">
	<option value="">Escolha um tipo</option>
	<option value="cliente">Cliente</option>
	<option value="admin">Administrador</option>
</select>
<br>
<br>
<input type="submit" value="Cadastrar">

</fieldset>
</form>
