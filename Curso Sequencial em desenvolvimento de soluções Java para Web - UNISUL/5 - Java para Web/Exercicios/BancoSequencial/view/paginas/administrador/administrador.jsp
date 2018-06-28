<%@page import="br.unisul.banco.bean.UsuarioBean"%>

<%
	UsuarioBean usuario = (UsuarioBean)request.getSession().getAttribute("logado");
	if (usuario == null || !usuario.getTipo().equals(1)) {
		response.sendRedirect("../restrito.jsp");
	}
%>
<html>
<head>
<title>Area Administrativa</title>
</head>
<body>
<h1>Você está logodo como administrador.</h1>

<a href="../logout">Logoff</a>
<br>
<br>



</body>
</html>