<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(1)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>


<h3>Área restrita ao cliente</h3>

<p>Agora que você já esta logado em nosso site,
você tem acesso a funcionalidades exclusívas que
só nossos clientes têm, como por exemplo, solicitar fretes.</p>
<p>Fique à vontade para explorar ao máximo nosso site!</p>