<html>

<head>
<title>Exemplo Menu</title>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>

<body>

<h1>Exemplo Menu</h1>

<%
	String id = request.getParameter("id");
	if (id == null) {
		%>
		Nenhuma pagina
		<%
	} else if (id.equals("1")) {
		%>
		<%@include file="pagina1.jsp" %>
		<%
	} else if (id.equals("2")) {
		%>
		<%@include file="pagina2.jsp" %>
		<%
	} else if (id.equals("3")) {
		%>
		<%@include file="pagina3.jsp" %>
		<%
	} else if (id.equals("4")) {
		%>
		<%@include file="pagina4.jsp" %>
		<%
	} else {
		%>
		Pagina desconhecida
		<%
	}
%>


    	<div id="content-wrapper">
    		<div id="main">
    			

			</div>
    	</div>
    
    	<div id="footer">
    		<p>
				
Design by  
<a href="mailto:">Fabio Dela Bruna</a> and  <a href="http://www.dotemplate.com">doTemplate</a>
&nbsp;|&nbsp;
Web template created with <a href="http://www.dotemplate.com">doTemplate</a>

       		</p>
    	</div>	
    </div>



</body>
</html>