<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>

<form method="post" action="calculadora.jsp">
Valor1: <input type="text" name="v1"><br/>
Operação: <select name="op">
				<option>Selecione...</option>
				<option>Somar</option>
				<option>Subtrair</option>
				<option>Multiplicar</option>
				<option>Dividir</option>
		  </select><br/>
Valor2: <input type="text" name="v2"><br/>
<input type="submit" value="Calcular"/>
</form>
<%

String v1 = request.getParameter("v1");
String v2 = request.getParameter("v2");
String op = request.getParameter("op");

if(v1 != null && v2 != null && op != null){
	Double res = 0D;
	
	if(op.equals("Somar")){
		res = Double.parseDouble(v1) + Double.parseDouble(v2);
	}else if(op.equals("Subtrair")){
		res = Double.parseDouble(v1) - Double.parseDouble(v2);
	}else if(op.equals("Multiplicar")){
		res = Double.parseDouble(v1) * Double.parseDouble(v2);
	}else if(op.equals("Dividir")){
		res = Double.parseDouble(v1) / Double.parseDouble(v2);
	}
	
	out.println("O resultado é: " + res);
}
%>




</body>
</html>