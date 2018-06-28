<%@page import="br.unisul.transportadora.bo.CaminhaoBo"%>
<%@page import="br.unisul.transportadora.bean.CaminhaoBean"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<h3>Caminhões cadastrados:</h3>
<p>Para cadastrar um novo caminhão <a href="index.jsp?id=cad-caminhao">clique aqui! </a></p>

<%
	CaminhaoBo camBo = new CaminhaoBo();
	List listaCam = camBo.findAllCaminhao();

	if (listaCam.size() > 0) {
		
		for (int i = 0; i < listaCam.size(); i++) {
			CaminhaoBean cam = (CaminhaoBean)listaCam.get(i);
			
			%>
			
			<table cellspacing="0"	summary="Tabela com duas colunas contendo na coluna direita os cabeçalhos e na esquerda a decrição">
				<tr class="impar">
					<th>Código:</th>
					<td><%=cam.getCodigo()%></td>
				</tr>
				<tr>
					<th>Descrição:</th>
					<td><%=cam.getDescricao()%></td>
				</tr>
				<tr class="impar">
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td align="right">
						<a href="index.jsp?id=editar-cam&cod=<%=cam.getCodigo()%>"><img src="imagens/editar.gif" alt="editar"></a>
						<a href="excluirCaminhao?id=<%=cam.getCodigo()%>"><img src="imagens/excluir.gif" alt="excluir"></a>
					</td>
				</tr>
			</table>
		<%
		}
	} else {
		%>
			<p>Não há caminhões cadastrados.</p>
			<a href="index.jsp?id=home-admin">Início</a>
		<%
	}
%>
