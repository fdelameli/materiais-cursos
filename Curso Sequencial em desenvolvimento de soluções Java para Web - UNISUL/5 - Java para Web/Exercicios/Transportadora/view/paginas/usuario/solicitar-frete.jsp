<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>
<%@page import="br.unisul.transportadora.bean.FreteBean"%>
<%@page import="br.unisul.transportadora.bo.FreteBo"%>
<%@page import="br.unisul.transportadora.bo.TransportadoraBo"%>
<%@page import="br.unisul.transportadora.bean.TransportadoraBean"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.transportadora.bean.CaminhaoBean"%>
<%@page import="br.unisul.transportadora.bo.CaminhaoBo"%><html>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(1)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<%
	CaminhaoBo camBo = new CaminhaoBo();
	TransportadoraBo transpBo = new TransportadoraBo();
	List listaCam = camBo.findAllCaminhao();
	List listaTransp = transpBo.findAllTransportadora();
%>

<script type="text/javascript">
	function validaForm() {
		d = document.form;
		if (d.km.value == "") {
			alert("O campo \"Quilometragem\" deve ser preenchido!");
			return false;
		} else if (d.transportadora.value == "") {
			alert("Você deve selecionar uma transportadora!");
			return false;
		} else if (d.caminhao.value == "") {
			alert("Você deve selecionar um caminhão!");
			return false;
		}
		return true;
	}
</script>

<h3>Solicitar novo frete:</h3>

<form method="post" action="cadastrarFrete" class="contato" name="form" onSubmit="return validaForm()">
<fieldset>
<legend>Solicitar Frete</legend>

<label for="km">Quilometragem:(<span>*</span>)</label>
<input type="text" name="km" id="km"> 

<label for="transportadora">Transportadora:(<span>*</span>)</label>
<select name="transportadora" id="transportadora">
	<option value="">Selecione uma opção</option>
	<% 
		for(int i = 0; i < listaTransp.size(); i++) {
			TransportadoraBean transp = (TransportadoraBean)listaTransp.get(i);
			%>
				<option value="<%=transp.getCodigo()%>"><%=transp.getNome()%></option>
			<%
		}
	 %>
</select>

<label for="caminhao">Caminhão:(<span>*</span>)</label>
<select name="caminhao" id="caminhao">
	<option value="">Selecione uma opção</option>
	<% 
		for(int i = 0; i < listaCam.size(); i++) {
			CaminhaoBean cam = (CaminhaoBean)listaCam.get(i);
			%>
				<option value="<%=cam.getCodigo()%>"><%=cam.getDescricao()%></option>
			<%
		}
	 %>
</select>
<br>
<br>
<input type="submit" value="Cadastrar">

</fieldset>
</form>
