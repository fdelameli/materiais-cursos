package br.unisul.cursojsf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "hello2", urlPatterns = "/hello2")
public class Hello2Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		out.println("<html>                            ");
		out.println("<head>                            ");
		out.println("	<title>Exemplo Servlet</title> ");
		out.println("</head>                           ");
		out.println("<body>                            ");
		out.println("	<h1>Hello Servlet!</h1>        ");
		out.println("</body>                           ");
		out.println("</html>                           ");
		
		
	}
}
