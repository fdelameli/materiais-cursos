package br.unisul.exemplo.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Converte3Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String frase = (String)request.getSession().getAttribute("fraseConvertida");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Pagina redirecionada atravéz de forward!!!");
		out.println("<BR><BR>" + frase);
		out.println("</body></html>");
		
	}

}
