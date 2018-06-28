<script type="text/javascript">
	function validaForm() {
		d = document.form;
		if (d.nome.value == "") {
			alert("O campo \"Nome\" deve ser preenchido!");
			return false;
		} else if (d.email.value == "") {
			alert("O campo \"E-mail\" deve ser preenchido!");
			return false;
		} else if (d.assunto.value == "") {
			alert("Selecione um opção no campo \"Assunto\"!");
			return false;
		} else if (d.mensagem.value == "") {
			alert("O campo \"Mensagem\" deve ser preenchido!");
			return false;
		}
		return true;
	}
</script>

<h2>Fale conosco</h2>

<dl>
	<dt>Matriz</dt>
	<dd>Rua: Rua Teste do Sequencial, 368</dd>
	<dd>Bairro Industrial de Tubarão</dd>
	<dd>48000-000 Tubarão,SC</dd>
	<dd>Tel: 48 4800-480000</dd>
	<dd>E-mail: <a
		href="mailto:endereco_nao_funciona@admtranspotadoras.com.br">suporte@admtransportadoras.com.br</a></dd>
</dl>

<form method="post" action="enviarDuvida" class="contato" name="form" onsubmit="return validaForm()">
<fieldset>
	<legend>Contato</legend>
	
	<label for="nome">Nome:(<span>*</span>)</label>
	<input type="text" name="nome" id="nome">
	
	<label for="email">E-mail:(<span>*</span>)</label>
	<input type="text" name="email" id="email">
	
	<label for="empresa">Empresa:</label>
	<input type="text" name="empresa" id="empresa">
	
	<div id="ddd-telefone">
	<div class="um">
		<label for="ddd">DDD:</label>
		<input type="text" name="ddd" id="ddd">
	</div>
	
	<div class="dois">
		<label for="telefone">Telefone:</label>
		<input type="text" name="telefone" id="telefone">
	</div>
	</div>
	
	<label for="assunto">Assunto:(<span>*</span>)</label> 
	<select	name="assunto" id="assunto">
		<option value="">Escolha um assunto</option>
		<option value="comercial">Comercial</option>
		<option value="tecnico">Técnico</option>
		<option value="social">Social</option>
		<option value="outros">Outros</option>
	</select>

	<label for="mensagem">Mensagem:(<span>*</span>)</label>
	<textarea name="mensagem" id="mensagem" cols="" rows="">Digite aqui sua menssagem:</textarea>

	<br>
	<input type="submit" value="Enviar">

</fieldset>
</form>
