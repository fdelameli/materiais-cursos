package br.unisul.conversor.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TemperaturaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String option = (String) request.getSession().getAttribute("option");
		double value = (Double)(request.getSession().getAttribute("value"));
		String tipoConversao = "";
		double result = 0.0;
		
		if (option.equals("celcius-fahr")) {
			result = value * 1.8 + 32; 
			tipoConversao = "Conversão de celcius para fahrenheit: ";
			
		} else if (option.equals("celcius-kelvin")) {
			result = value + 273.15;
			tipoConversao = "Conversão de celcius para kelvin: ";
		}
		
		request.getSession().setAttribute("tipoConversao", tipoConversao);
		request.getSession().setAttribute("result", result);
		response.sendRedirect("resultado.jsp");

	}

}
