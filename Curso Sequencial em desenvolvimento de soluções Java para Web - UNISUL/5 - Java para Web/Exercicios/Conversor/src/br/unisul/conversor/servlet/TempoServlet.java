package br.unisul.conversor.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TempoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String option = (String) request.getSession().getAttribute("option");
		double value = (Double)(request.getSession().getAttribute("value"));
		String tipoConversao = "";
		double result = 0.0;
		
		if (option.equals("seg-min")) {
			result = value/60;
			tipoConversao = "Conversão de segundos para minutos: ";
			
		} else if (option.equals("min-hor")) {
			result = value/60;
			tipoConversao = "Conversão de minutos para horas: ";
			
		} else if (option.equals("hor-seg")) {
			result = (value*60)*60;
			tipoConversao = "Conversão de horas para segundos: ";
		}
		
		request.getSession().setAttribute("tipoConversao", tipoConversao);
		request.getSession().setAttribute("result", result);
		response.sendRedirect("resultado.jsp");

	}

}
