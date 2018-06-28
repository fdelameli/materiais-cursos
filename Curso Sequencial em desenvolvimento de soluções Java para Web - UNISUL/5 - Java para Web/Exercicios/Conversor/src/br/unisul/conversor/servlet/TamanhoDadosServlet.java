package br.unisul.conversor.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TamanhoDadosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String option = (String) request.getSession().getAttribute("option");
		double value = (Double)(request.getSession().getAttribute("value"));
		String tipoConversao = "";
		double result = 0.0;
		
		if (option.equals("byte-kb")) {
			result = value/1024;
			tipoConversao = "Conversão de bytes para kbytes: ";
			
		} else if (option.equals("kb-mb")) {
			result = value/1024;
			tipoConversao = "Conversão de kbytes para megabytes: ";
			
		} else if (option.equals("mb-gb")) {
			result = value/1024;
			tipoConversao = "Conversão de megabytes para gigabytes: ";
			
		} else if (option.equals("gb-tb")) {
			result = value/1024;
			tipoConversao = "Conversão de gigabytes para terabytes: ";
		}
		
		request.getSession().setAttribute("tipoConversao", tipoConversao);
		request.getSession().setAttribute("result", result);
		response.sendRedirect("resultado.jsp");
	
	}

}
