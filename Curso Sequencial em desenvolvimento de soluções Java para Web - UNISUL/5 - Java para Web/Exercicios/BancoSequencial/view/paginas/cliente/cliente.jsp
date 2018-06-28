<%@page import="br.unisul.banco.bean.UsuarioBean"%>

<%
UsuarioBean usuario = (UsuarioBean)request.getSession().getAttribute("logado");
if (usuario == null || !usuario.getTipo().equals(2)) {
	response.sendRedirect("../restrito.jsp");
}

%>
<html>
<head>
<title>Area do Cliente</title>
</head>
<body>
<h1>Você está logado como cliente.</h1>

<a href="../logout">Logoff</a>
</body>
</html>