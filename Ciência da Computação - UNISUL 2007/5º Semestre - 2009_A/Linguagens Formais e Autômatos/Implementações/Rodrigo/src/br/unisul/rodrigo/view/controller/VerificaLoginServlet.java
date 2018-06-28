package br.unisul.rodrigo.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.rodrigo.login.VerificaLogin;


/**
 * Servlet que verifica se o login e senha digitados pelo
 * usuário estão corretos de acordo com as configurações.
 * E redirecionar a página para o local apropriado.
 * @author Fabio Dela Bruna.
 * @since 24/06/2009.
 */
public class VerificaLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VerificaLogin vl = new VerificaLogin();
		String user = request.getParameter("login");
		String password = request.getParameter("password");
		
		try {
			if (user.equals(vl.getUserProperties()) && password.equals(vl.getPasswordProperties())) {
				response.sendRedirect("principal.jsp");
				request.getSession().setAttribute("logado", "true");
			} else {
				response.sendRedirect("erro_login.jsp");
			}
		
		} catch (IOException e) {
			response.sendRedirect("error.jsp?erro="+e);
		}
		
	}
	
}
