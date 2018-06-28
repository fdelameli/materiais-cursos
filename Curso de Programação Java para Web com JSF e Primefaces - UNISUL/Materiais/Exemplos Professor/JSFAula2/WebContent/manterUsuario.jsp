<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>

<h:form>
Nome: <h:inputText value="#{cadastroUsuario.usuario.nome}"/><br/>
Login: <h:inputText value="#{cadastroUsuario.usuario.login}"/><br/>
Senha: <h:inputSecret value="#{cadastroUsuario.usuario.senha}"/><br/>
Email: <h:inputText value="#{cadastroUsuario.usuario.email}"/><br/>

<h:commandButton value="Cadastrar" action="#{cadastroUsuario.cadastrar}"/>

</h:form>

</f:view>
</body>
</html>