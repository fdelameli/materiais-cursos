<%!

	String nome = "Java";
	public void toUpper() {
		nome = nome.toUpperCase();
	}

%>

<html>
<head>
<title>Exemplo JSP</title>
</head>
<body>

<%toUpper();%>
Java em maíusculo é: <%=nome%>

</body>
<html>