package br.unisul.conversor.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirecionadorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String option = request.getParameter("rconversor");
		double value = Double.parseDouble(request.getParameter("value"));
		
		request.getSession().setAttribute("value", value);
		request.getSession().setAttribute("option", option);
		
		if (option.equals("cm-m") || option.equals("m-km") || option.equals("km-m")) {
			response.sendRedirect("comprimento");
			
		} else if (option.equals("g-kg") || option.equals("kg-ton") || option.equals("ton-g")) {
			response.sendRedirect("peso");
			
		} else if (option.equals("seg-min") || option.equals("min-hor") || option.equals("hor-seg")) {
			response.sendRedirect("tempo");
			
		} else if (option.equals("real-dolar") || option.equals("real-euro") || option.equals("real-libra")) {
			response.sendRedirect("moeda");
			
		} else if (option.equals("celcius-fahr") || option.equals("celcius-kelvin")) {
			response.sendRedirect("temperatura");
			
		} else if (option.equals("byte-kb") || option.equals("kb-mb") || option.equals("mb-gb") || option.equals("gb-tb")) {
			response.sendRedirect("tamanhoDados");
		}
		
		
	}
}
