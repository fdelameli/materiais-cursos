<%@page import="br.unisul.banco.bean.UsuarioBean"%>

<%

if (request.getSession().getAttribute("logado") == null) {
	response.sendRedirect("restrito.jsp");
}
UsuarioBean usuario = (UsuarioBean)request.getSession().getAttribute("logado");

%>


<html>
<head>
<title>Sucesso</title>
</head>
<body>
<h1>Foi foi logado com sucesso!</h1>
<h2>Bem vindo, <%if(usuario != null){out.println(usuario.getNome());}%></h2>

<a href="logout">Logoff</a>

</body>
</html>