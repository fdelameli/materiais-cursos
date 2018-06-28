<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.unisul.transportadora.bean.UsuarioBean"%><html>

<%
	UsuarioBean usuario = (UsuarioBean)request.getSession().getAttribute("logado");
%>

<head>
	<title>ADM Transportadoras</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="title" content="ADM Transportadoras">
	<meta name="description" content="A ADM Transportadoras é uma empresa especializada na administração de transportadoras">
	<meta name="keywords" content="Administração, transportadora">
	<meta name="language" content="pt-br">
	<meta name="robots" content="All">
	<meta name="copyright" content="Sequencial Java para Web">	
	<meta name="abstract" content="Sistema de administração de transportadoras">
	<meta name="MSSmartTagsPreventParsing" content="true">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>

<div id="tudo">


	<div id="topo">
		<h1>ADM <span>Transportadoras</span></h1>
		<%
			if (usuario == null) {
				%>
				<%@include file="menu-index.jsp" %>
				<form action="" method="get" id="busca">
					<label>Buscar <input type="text" name="busca" /></label>
					<input type="submit" value="OK" id="submit" />
				</form>
				<%		
			} else if (usuario.getTipo().equals(1)) {
				%>
				<%@include file="usuario/menu-user.jsp" %>
				<form action="" method="get" id="busca">
					<label>Buscar <input type="text" name="busca" /></label>
					<input type="submit" value="OK" id="submit" />
				</form>
				<%
			} else if (usuario.getTipo().equals(2)) {
				%>
				<%@include file="admin/menu-admin.jsp" %>
				<%
			}
		%>

	</div> <!-- Fim da div#topo -->
	
	
	<div id="principal">
		<%
		String id = request.getParameter("id");
		
		if (id == null) {
			%>
			<%@include file="home.jsp" %>
			<%
		} else if (id.equals("cad-user")) {
			%>
			<%@include file="cadastro-user.jsp" %>
			<%			
		} else if (id.equals("contato")) {
			%>
			<%@include file="contato.jsp" %>
			<%			
		} else if (id.equals("sucesso")) {
			%>
			<%@include file="sucesso-form.jsp" %>
			<%			
		} else if (id.equals("sucesso-cad")) {
			%>
			<%@include file="sucesso-cad.jsp" %>
			<%			
		} else if (id.equals("falha-login")) {
			%>
			<%@include file="falha-login.jsp" %>
			<%			
		} else if (id.equals("home-cliente")) {
			%>
			<%@include file="usuario/home-user.jsp" %>
			<%					
		} else if (id.equals("update-perfil-user")) {
			%>
			<%@include file="sucesso-update-perfil.jsp" %>
			<%	
		} else if (id.equals("perfil-cliente")) {
			%>
			<%@include file="usuario/perfil-user.jsp" %>
			<%			
		} else if (id.equals("meus-fretes")) {
			%>
			<%@include file="usuario/meusfretes.jsp" %>
			<%			
		} else if (id.equals("alt-frete")) {
			%>
			<%@include file="usuario/alterar-frete.jsp" %>
			<%			
		} else if (id.equals("cad-frete")) {
			%>
			<%@include file="usuario/solicitar-frete.jsp" %>
			<%			
		} else if (id.equals("home-admin")) {
			%>
			<%@include file="admin/home-admin.jsp" %>
			<%	 
		} else if (id.equals("listar-fretes")) {
			%>
			<%@include file="admin/fretes.jsp" %>
			<%	 
		} else if (id.equals("listar-users")) {
			%>
			<%@include file="admin/clientes.jsp" %>
			<%	 
		} else if (id.equals("perfil-admin")) {
			%>
			<%@include file="admin/perfil-admin.jsp" %>
			<%	 
		} else if (id.equals("duvidas")) {
			%>
			<%@include file="admin/duvidas.jsp" %>
			<%	 
		} else if (id.equals("listar-transp")) {
			%>
			<%@include file="admin/transportadoras.jsp" %>
			<%	 
		} else if (id.equals("listar-caminhoes")) {
			%>
			<%@include file="admin/caminhoes.jsp" %>
			<%	 
		} else if (id.equals("cad-transp")) {
			%>
			<%@include file="admin/cad-transportadora.jsp" %>
			<%	 
		} else if (id.equals("cad-caminhao")) {
			%>
			<%@include file="admin/cad-caminhao.jsp" %>
			<%	 
		} else if (id.equals("erro-sql")) {
			%>
			<%@include file="sql-error.jsp" %>
			<%	 
		} else if (id.equals("editar-transp")) {
			%>
			<%@include file="admin/alterar-transp.jsp" %>
			<%	 
		} else if (id.equals("editar-cam")) {
			%>
			<%@include file="admin/alterar-caminhao.jsp" %>
			<%	 
		} else if (id.equals("restrito")) {
			%>
			<%@include file="restrito.jsp" %>
			<%	 
		} else if (id.equals("info")) {
			%>
			<%@include file="info.jsp" %>
			<%	 
		}
		
		%>

	</div> <!-- Fim da div#principal -->
		
		
	<div id="auxiliar">
		<%
			if (usuario == null) {
				%>
				<%@include file="auxiliar.jsp" %>
				<%		
			} else if (usuario.getTipo().equals(1)) {
				%>
				<%@include file="usuario/auxiliar-user.jsp" %>
				<%
			} else if (usuario.getTipo().equals(2)) {
				%>
				<%@include file="admin/auxiliar-admin.jsp" %>
				<%
			}
		%>
	</div> <!-- Fim da div#auxiliar -->
	
	<div id="rodape">
		<p>Copyright &copy; 2009 - <b>ADM</b> <span>Transportadoras</span></p>
	</div> <!-- Fim da div#rodape -->
	
	
</div> <!-- Fim da div#tudo -->

</body>

</html>