<%@page import="br.unisul.transportadora.bo.TransportadoraBo"%>
<%@page import="br.unisul.transportadora.bean.TransportadoraBean"%>
<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<%
	
	Integer cod = Integer.parseInt(request.getParameter("cod"));
	TransportadoraBo transpBo = new TransportadoraBo();
	TransportadoraBean transp = transpBo.findById(cod);

	request.getSession().setAttribute("transp", transp);
	
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

<h3>Alterar transportadora nº: <%=transp.getCodigo()%></h3>

<form method="post" action="alterarTransportadora" class="contato" name="form", onsubmit="return validaForm()">
<fieldset>
<legend>Alterar Transportadora</legend>

<label for="nome">Nome:(<span>*</span>)</label>
<input type="text" name="nome" id="nome" value="<%=transp.getNome()%>"> 

<br>
<br>
<input type="submit" value="Atualizar">

</fieldset>
</form>
