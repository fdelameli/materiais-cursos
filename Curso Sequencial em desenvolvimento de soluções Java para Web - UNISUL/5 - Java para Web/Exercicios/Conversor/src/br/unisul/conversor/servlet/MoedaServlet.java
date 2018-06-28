package br.unisul.conversor.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MoedaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String option = (String) request.getSession().getAttribute("option");
		double value = (Double)(request.getSession().getAttribute("value"));
		String tipoConversao = "";
		double result = 0.0;
		
		if (option.equals("real-dolar")) {
			result = value/2.30;
			tipoConversao = "Conversão de Real para Dólar: ";
			
		} else if (option.equals("real-euro")) {
			result = value/2.90;
			tipoConversao = "Conversão de Real para Euro: ";
			
		} else if (option.equals("real-libra")) {
			result = value/4.10;
			tipoConversao = "Conversão de Real para Libra: ";
		}
		
		request.getSession().setAttribute("tipoConversao", tipoConversao);
		request.getSession().setAttribute("result", result);
		response.sendRedirect("resultado.jsp");
		
	}

}
