package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		request.getSession().setAttribute("logado", null);
		response.sendRedirect("index.jsp");
		
	}
	
}
