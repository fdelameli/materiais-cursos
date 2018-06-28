package br.unisul.conversor.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ComprimentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String option = (String) request.getSession().getAttribute("option");
		double value = (Double)(request.getSession().getAttribute("value"));
		String tipoConversao = "";
		double result = 0.0;
		
		if (option.equals("cm-m")) {
			result = value/1000;
			tipoConversao = "Conversão de centímetros para metros: ";
			
		} else if (option.equals("m-km")) {
			result = value/1000;
			tipoConversao = "Conversão de metros para quilômetros: ";
			
		} else if (option.equals("km-cm")) {
			result = value*1000000;
			tipoConversao = "Conversão de quilômetros para centímetros: ";
		}
		
		request.getSession().setAttribute("tipoConversao", tipoConversao);
		request.getSession().setAttribute("result", result);
		response.sendRedirect("resultado.jsp");
		
	}

}
