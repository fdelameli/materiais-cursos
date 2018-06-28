<%@page import="br.unisul.transportadora.bean.FreteBean"%>
<%@page import="br.unisul.transportadora.bo.FreteBo"%>
<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>
<%@page import="br.unisul.transportadora.bean.TransportadoraBean"%>
<%@page import="br.unisul.transportadora.bo.TransportadoraBo"%>
<%@page import="br.unisul.transportadora.bo.CaminhaoBo"%>
<%@page import="br.unisul.transportadora.bean.CaminhaoBean"%>
<%@page import="br.unisul.transportadora.bo.UsuarioBo"%>
<%@page import="java.util.List"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<h3>Fretes solicitados:</h3>

<%
	TransportadoraBo transpBo = new TransportadoraBo();
	CaminhaoBo camBo = new CaminhaoBo();
	UsuarioBo userBo = new UsuarioBo();
	FreteBo freBo = new FreteBo();
	
	List listaFretes = freBo.findAllFrete();

	if (listaFretes.size() > 0) {
		
		for (int i = 0; i < listaFretes.size(); i++) {
			FreteBean frete = (FreteBean)listaFretes.get(i);
			TransportadoraBean transp = transpBo.findById(frete.getCodigoTransportadora());
			CaminhaoBean cam = camBo.findById(frete.getCodigoCaminhao());
			UsuarioBean user = userBo.findById(frete.getCodigoCliente());
			
			%>
			
			<table cellspacing="0"	summary="Tabela com duas colunas contendo na coluna direita os cabeçalhos e na esquerda a decrição">
				<tr class="impar">
					<th>Código:</th>
					<td><%=frete.getCodigo()%></td>
				</tr>
				<tr>
					<th>Quilometragem:</th>
					<td><%=frete.getQuilometragem()%></td>
				</tr>
				<tr class="impar">
					<th>Valor:</th>
					<td><%=frete.getValor()%></td>
				</tr>	
				<tr>
					<th>Transportadora:</th>
					<td><%=transp.getNome()%></td>
				</tr>	
				<tr class="impar">
					<th>Caminhão:</th>
					<td><%=cam.getDescricao()%></td>
				</tr>
				<tr>
					<th>Cliente:</th>
					<td><%=user.getNome()%></td>
				</tr>
				<tr class="impar">
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td align="right"><a href="excluirFrete?id=<%=frete.getCodigo()%>"><img src="imagens/excluir.gif"></a></td>
				</tr>
			</table>
		<%
		}
	} else {
		%>
			<p>Não há fretes solicitados.</p>
			<a href="index.jsp?id=home-admin">Início</a>
		<%
	}
%>
