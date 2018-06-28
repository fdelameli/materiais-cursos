package br.unisul.exemplo.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Converte2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Pagina redirecionada com sucesso!!!");
		out.println("</body></html>");
		
	}
}
