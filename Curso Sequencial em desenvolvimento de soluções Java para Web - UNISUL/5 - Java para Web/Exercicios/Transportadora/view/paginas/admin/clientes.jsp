<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>
<%@page import="br.unisul.transportadora.bo.UsuarioBo"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<h3>Clientes cadastrados:</h3>

<%
	UsuarioBo userBo = new UsuarioBo();
	List listaUsers = userBo.findAllById(1); // 1 porque é para mostrar apenas os clientes.

	if (listaUsers.size() > 0) {
		
		for (int i = 0; i < listaUsers.size(); i++) {
			UsuarioBean user = (UsuarioBean)listaUsers.get(i);
			
			%>
			
			<table cellspacing="0"	summary="Tabela com duas colunas contendo na coluna direita os cabeçalhos e na esquerda a decrição">
				<tr class="impar">
					<th>Código:</th>
					<td><%=user.getCodigo()%></td>
				</tr>
				<tr>
					<th>Nome:</th>
					<td><%=user.getNome()%></td>
				</tr>
				<tr class="impar">
					<th>Email:</th>
					<td><%=user.getEmail()%></td>
				</tr>	
				<tr>
					<th>Endereço:</th>
					<td><%=user.getEndereco()%></td>
				</tr>	
				<tr class="impar">
					<th>Cidade:</th>
					<td><%=user.getCidade()%></td>
				</tr>
				<tr>
					<th>UF:</th>
					<td><%=user.getUf()%></td>
				</tr>
				<tr class="impar">
					<th> </th>
					<td align="right"><a href="excluirUser?id=<%=user.getCodigo()%>"><img src="imagens/excluir.gif"></a></td>
				</tr>
			
			</table>
		<%
		}
	} else {
		%>
			<p>Não há clientes cadastrados.</p>
			<a href="index.jsp?id=home-admin">Início</a>
		<%
	}
%>
