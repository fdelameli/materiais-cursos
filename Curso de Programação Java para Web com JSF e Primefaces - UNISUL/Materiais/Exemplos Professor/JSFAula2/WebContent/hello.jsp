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

<h:outputText value="Hello JSF!"/>

<h:outputText value="#{hello.msg}"/>

<h:form>

	<h:commandLink action="#{hello.redirecionar}">
		Hello 1
	</h:commandLink>

	<h:commandLink action="retorno2">
		Hello 2
	</h:commandLink>

</h:form>


</f:view>
</body>
</html>




