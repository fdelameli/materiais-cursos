package br.unisul.exemplo.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConverteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String frase = new String();
		
		frase = request.getParameter("frase");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Letra em maiúsculo: ");
		out.println(frase.toUpperCase());
		out.println("</html></body>");
		
		
		//Inclui string na Sessão
		request.getSession().setAttribute("fraseConvertida", frase.toUpperCase());
		
		
		//Redireciona
//		response.sendRedirect("converte2");
		
		ServletContext context = getServletContext();
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/converte3");
		dispatcher.forward(request, response);
		
	}
	
	
}
