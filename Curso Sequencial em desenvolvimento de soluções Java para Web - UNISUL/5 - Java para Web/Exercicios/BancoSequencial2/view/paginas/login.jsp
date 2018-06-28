<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
String temp = "";
if(request.getParameter("erro") != null){
	temp = String.valueOf(request.getParameter("erro"));
}

%>
<html>
<head><title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<form method="post" action="../../sequencial/autenticar">

Login: <input type="text" name="login"><br/>
Senha: <input type="password" name="senha"><br/>

<input type="submit" value="Logar">
</form>

<% 
	if(temp.length()>1){ 
		out.println("<p class=\"msgErro\">"+temp+"</p>"); 
	} 
%>
</body>
</html>