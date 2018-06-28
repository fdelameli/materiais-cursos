<%@page import="br.unisul.transportadora.bo.CaminhaoBo"%>
<%@page import="br.unisul.transportadora.bean.CaminhaoBean"%>
<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<%
	
	Integer cod = Integer.parseInt(request.getParameter("cod"));
	CaminhaoBo camBo = new CaminhaoBo();
	CaminhaoBean cam = camBo.findById(cod);

	request.getSession().setAttribute("cam", cam);
	
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

<h3>Alterar caminhão nº: <%=cam.getCodigo()%></h3>

<form method="post" action="alterarCaminhao" class="contato" name="form" onsubmit="return validaForm()">
<fieldset>
<legend>Alterar Caminhão</legend>

<label for="descricao">Descrição:(<span>*</span>)</label>
<input type="text" name="descricao" id="descricao" value="<%=cam.getDescricao()%>"> 

<br>
<br>
<input type="submit" value="Atualizar">

</fieldset>
</form>
