package br.unisul.conversor.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PesoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String option = (String) request.getSession().getAttribute("option");
		double value = (Double)(request.getSession().getAttribute("value"));
		String tipoConversao = "";
		double result = 0.0;
		
		if (option.equals("g-kg")) {
			result = value/1000;
			tipoConversao = "Conversão de gramas para quilogramas: ";
			
		} else if (option.equals("kg-ton")) {
			result = value/1000;
			tipoConversao = "Conversão de quilogramas para toneladas: ";
			
		} else if (option.equals("ton-g")) {
			result = (value*1000)*1000;
			tipoConversao = "Conversão de toneladas para gramas: ";
		}
		
		request.getSession().setAttribute("tipoConversao", tipoConversao);
		request.getSession().setAttribute("result", result);
		response.sendRedirect("resultado.jsp");
	
	}

}
