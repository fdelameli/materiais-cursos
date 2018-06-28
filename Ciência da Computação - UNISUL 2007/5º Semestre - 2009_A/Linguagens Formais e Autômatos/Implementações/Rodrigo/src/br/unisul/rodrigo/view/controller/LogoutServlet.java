package br.unisul.rodrigo.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Classe responsável por efetuar logout no sistema.
 * @author Fabio Dela Bruna.
 * @since 24/06/2009.
 */
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String logado = "false";
		request.getSession().setAttribute("logado", logado);
		
		response.sendRedirect("index.jsp");
		
	}
}
