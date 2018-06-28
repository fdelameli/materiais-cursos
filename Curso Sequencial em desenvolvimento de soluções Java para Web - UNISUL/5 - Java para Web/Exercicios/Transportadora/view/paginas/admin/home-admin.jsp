<%@page import="br.unisul.transportadora.bean.UsuarioBean"%>

<%
	UsuarioBean usuarioTemp1 = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuarioTemp1 == null || !usuarioTemp1.getTipo().equals(2)) {
		response.sendRedirect("index.jsp?id=restrito");
	}
%>

<h3>Área administrativa</h3>
<p>Logado como administrador, você tem acesso total ao sistema. 
É possível listar todos os clientes cadastrados, além das 
transportadoras, dos caminhões, dos fretes solicitados 
e também das dúvidas que as pessoas que acessam os site enviam.</p>
<p>Você ainda pode cadastrar novos caminhões e transportadoras.</p>