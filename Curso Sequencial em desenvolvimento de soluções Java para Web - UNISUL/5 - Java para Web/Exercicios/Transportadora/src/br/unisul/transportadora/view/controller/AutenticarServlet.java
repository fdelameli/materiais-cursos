package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.bo.UsuarioBo;

public class AutenticarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		UsuarioBo bo = new UsuarioBo();
		UsuarioBean usuario = bo.findByEmailSenha(
				request.getParameter("login"), request.getParameter("senha"));
		
		if (usuario != null && usuario.getTipo().equals(1)) {
			request.getSession().setAttribute("logado", usuario);
			response.sendRedirect("index.jsp?id=home-cliente");
		} else if (usuario != null && usuario.getTipo().equals(2)) {
			request.getSession().setAttribute("logado", usuario);
			response.sendRedirect("index.jsp?id=home-admin");
		} else {
			response.sendRedirect("index.jsp?id=falha-login");
		}
		
		
	}
	
	
}
