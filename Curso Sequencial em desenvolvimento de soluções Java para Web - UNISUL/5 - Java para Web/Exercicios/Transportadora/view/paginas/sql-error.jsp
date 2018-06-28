<%
	String erro = request.getParameter("msg");
%>

<h3>Erro!</h3>
<p>Não é possível efetuar a operação de exclusão:
<br><%=erro%></p>
<br>
<a href="javascript:history.back()">Voltar</a>
