package br.unisul.exemplo.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TesteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter print = response.getWriter();
	
		print.println("<HTML>");
		print.println("<HEAD>");
		print.println("<TITLE>Teste de Servlet</TITLE>");
		print.println("</HEAD>");
		print.println("<BODY>");
		print.println("<BLINK>Testando um Servlet</BLINK>");
		print.println("</BODY>");
		print.println("</HTML>");
		
	}
}
