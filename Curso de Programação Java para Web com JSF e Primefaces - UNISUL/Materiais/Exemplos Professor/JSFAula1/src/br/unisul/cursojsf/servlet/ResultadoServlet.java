package br.unisul.cursojsf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "resultado", urlPatterns = "/resultado")
public class ResultadoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Double d = (Double)req.getSession().getAttribute("resultado");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>                        ");
		out.println("<head>                        ");
		out.println("	<title>Calculadora</title> ");
		out.println("</head>                       ");
		out.println("<body>                        ");
		out.println("	O resultado é " + d);
		out.println("</body>                       ");
		out.println("</html>                       ");
	
	}
	
}
