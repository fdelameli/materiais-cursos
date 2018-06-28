package br.unisul.calculadora.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultadoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	public void doGet (HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int resultado = (Integer) request.getSession().getAttribute("resultado");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Resultado: " + resultado);
		out.println("</body></html>");
		
		
	}
}
