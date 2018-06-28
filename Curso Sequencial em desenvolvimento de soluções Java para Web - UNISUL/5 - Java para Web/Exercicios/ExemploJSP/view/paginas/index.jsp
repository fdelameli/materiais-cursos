

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>Web site</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-9958-1" />
	<meta name="title" content="Web site" />
	<meta name="description" content="Site description here" />
	<meta name="keywords" content="keywords here" />
	<meta name="language" content="en" />
 	<meta name="subject" content="Site subject here" />
	<meta name="robots" content="All" />
	<meta name="copyright" content="Your company" />	
	<meta name="abstract" content="Site description here" />
	<meta name="MSSmartTagsPreventParsing" content="true" />

	<link rel="stylesheet" type="text/css" href="css/styles.css" />


</head>




<body>




    <div id="wrapper">
    	<div id="header"></div>
    	<div id="nav1">
	<%@include file="menu.jsp" %>
	<BR>
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
</div>
 
    	<div id="content-wrapper">
    		<div id="main">
    			

    		</div>	
			<div id="sidebar">
				<h3>Categories</h3>
<ul class="sidemenu">
	<li><a href="#">Category 1</a></li>
	<li><a href="#">Category 2</a></li>
	<li><a href="#">Category 3</a></li>					
	<li><a href="#">Category 4</a></li>
	<li><a href="#">Category 5</a></li>
</ul>

<p>&nbsp;</p>
<h3>News</h3>
<p>
As boas noticias e que acabo de conseguir terminar esta pagina. 
</p>

			</div>
    	</div>
    
    	<div id="footer">
    		<p>
				
<!-- Keep these links or make a $10 donation  -->
Design by  
<a href="http://www.styleshout.com">StyleShout</a> and  <a href="http://www.dotemplate.com">doTemplate</a>
&nbsp;|&nbsp;
Web template created with <a href="http://www.dotemplate.com">doTemplate</a>
       		</p>
    	</div>	
    </div>
</body>


</html>
