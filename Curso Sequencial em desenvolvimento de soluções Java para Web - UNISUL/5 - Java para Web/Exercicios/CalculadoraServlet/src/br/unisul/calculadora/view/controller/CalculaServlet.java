package br.unisul.calculadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int valor1 = 0;
		int valor2 = 0;
		int resultado = 0;
		
		
		if (request.getParameter("valor1") != null) {
			valor1 = Integer.parseInt(request.getParameter("valor1"));
		}
		
		if (request.getParameter("valor2") != null) {
			valor2 = Integer.parseInt(request.getParameter("valor2"));
		}
		
		
		if (request.getParameter("opcao").equals("+")) {
			resultado = valor1 + valor2;
		}
		if (request.getParameter("opcao").equals("-")) {
			resultado = valor1 - valor2;
		}
		if (request.getParameter("opcao").equals("/")) {
			resultado = valor1 / valor2;
		}
		if (request.getParameter("opcao").equals("*")) {
			resultado = valor1 * valor2;
		}
		
		
		request.getSession().setAttribute("resultado", resultado);
		response.sendRedirect("resultado");
		
	}
}
