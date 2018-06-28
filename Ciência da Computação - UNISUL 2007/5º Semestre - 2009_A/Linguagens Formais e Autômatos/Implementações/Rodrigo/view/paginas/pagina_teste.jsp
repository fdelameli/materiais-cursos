<%

	String logado = (String)request.getSession().getAttribute("logado");
	if (logado.equals("false")) {
		response.sendRedirect("error.jsp?erro=auth");
	}

%>

<html>
<head>
	<title>Rodrigo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="title" content="">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="language" content="pt-br">
	<meta name="robots" content="All">
	<meta name="copyright" content="">	
	<meta name="abstract" content="">
	<meta name="MSSmartTagsPreventParsing" content="true">
</head>
<body>

<h1>Está funcionando!</h1>
<br>
<a href="logout">Logout</a>

</body>
</html>