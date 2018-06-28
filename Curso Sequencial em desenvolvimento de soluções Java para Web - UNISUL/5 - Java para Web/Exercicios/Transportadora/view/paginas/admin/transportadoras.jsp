<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>
<%@page import="br.unisul.transportadora.bo.TransportadoraBo"%>
<%@page import="br.unisul.transportadora.bean.TransportadoraBean"%>
<%@page import="java.util.List"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>


<h3>Transportadoras cadastradas:</h3>
<p>Para cadastrar uma nova transportadora <a href="index.jsp?id=cad-transp">clique aqui! </a></p>

<%
	TransportadoraBo transpBo = new TransportadoraBo();
	List listaTransp = transpBo.findAllTransportadora();

	if (listaTransp.size() > 0) {
		
		for (int i = 0; i < listaTransp.size(); i++) {
			TransportadoraBean transp = (TransportadoraBean)listaTransp.get(i);
			
			%>
			
			<table cellspacing="0"	summary="Tabela com duas colunas contendo na coluna direita os cabeçalhos e na esquerda a decrição">
				<tr class="impar">
					<th>Código:</th>
					<td><%=transp.getCodigo()%></td>
				</tr>
				<tr>
					<th>Nome:</th>
					<td><%=transp.getNome()%></td>
				</tr>
				<tr class="impar">
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td align="right">
						<a href="index.jsp?id=editar-transp&cod=<%=transp.getCodigo()%>"><img src="imagens/editar.gif" alt="editar"></a>
						<a href="excluirTransportadora?id=<%=transp.getCodigo()%>"><img src="imagens/excluir.gif" alt="excluir"></a>
					</td>
				</tr>
			</table>
		<%
		}
	} else {
		%>
			<p>Não há transportadoras cadastradas.</p>
			<a href="index.jsp?id=home-admin">Início</a>
		<%
	}
%>
