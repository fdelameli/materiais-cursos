package br.unisul.cursojsf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calc", urlPatterns = "/calculadora")
public class CalculadoraServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String v1 = req.getParameter("v1");
		String v2 = req.getParameter("v2");
		String op = req.getParameter("op");
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
		
		req.getSession().setAttribute("resultado", res);
		
		Double d = (Double)req.getSession().getAttribute("resultado");
		
		RequestDispatcher reqDispatcher = getServletContext()
								.getRequestDispatcher("/resultado");
		
		reqDispatcher.forward(req, resp);
		
		
//		Redirecionamento utilizando send redirect
//		resp.sendRedirect("resultado");
		
//		Escreve resultado na tela
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<html>                        ");
//		out.println("<head>                        ");
//		out.println("	<title>Calculadora</title> ");
//		out.println("</head>                       ");
//		out.println("<body>                        ");
//		out.println("	O resultado é " + res);
//		out.println("</body>                       ");
//		out.println("</html>                       ");
	}
}








