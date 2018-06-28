<%@page import="br.unisul.transportadora.bo.DuvidaBo"%>
<%@page import="br.unisul.transportadora.bean.DuvidaBean"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<h3>Menssagens enviadas:</h3>

<%
	DuvidaBo duvBo = new DuvidaBo();
	List listaDuv = duvBo.findAllDuvida();

	if (listaDuv.size() > 0) {
		
		for (int i = 0; i < listaDuv.size(); i++) {
			DuvidaBean duvida = (DuvidaBean)listaDuv.get(i);
			
			%>
			
			<table cellspacing="0"	summary="Tabela com duas colunas contendo na coluna direita os cabeçalhos e na esquerda a decrição">
				<tr class="impar">
					<th>Código:</th>
					<td><%=duvida.getCodigo()%></td>
				</tr>
				<tr>
					<th>Nome:</th>
					<td><%=duvida.getNome()%></td>
				</tr>
				<tr class="impar">
					<th>Email:</th>
					<td><%=duvida.getEmail()%></td>
				</tr>	
				<tr>
					<th>Empresa:</th>
					<td><%=duvida.getEmpresa()%></td>
				</tr>	
				<tr class="impar">
					<th>Telefone:</th>
					<td><%=duvida.getDdd()%>  <%=duvida.getFone()%></td>
				</tr>
				<tr>
					<th>Assunto:</th>
					<td><%=duvida.getAssunto()%></td>
				</tr>
				<tr class="impar">
					<th>Mensagem:</th>
					<td><%=duvida.getMenssagem()%></td>
				</tr>
				<tr>
					<th></th>
					<td align="right">
						<a href="mailto:<%=duvida.getEmail()%>"><img src="imagens/resp.gif" alt="responder"></a>
						<a href="excluirDuvida?id=<%=duvida.getCodigo()%>"><img src="imagens/excluir.gif" alt="excluir"></a>
					</td>
				</tr>
			</table>
		<%
		}
	} else {
		%>
			<p>Nenhuma dúvida foi recebida.</p>
			<a href="index.jsp?id=home-admin">Início</a>
		<%
	}
%>
