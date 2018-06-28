<html>
<head>
<LINK REL=stylesheet HREF="css/style.css" TYPE="text/css">
<title>Resultado da Conversão</title>
</head>
<body>

<h3>Resultado:</h3>

<%
	String tipoConversao = (String)request.getSession().getAttribute("tipoConversao");
	Double result = (Double)request.getSession().getAttribute("result");
	
	%><p><%=tipoConversao%> <%=result%></p><%
	
%>

</body>
</html>